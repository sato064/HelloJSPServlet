## 手元の環境での実行方法

下記を実行する．

```console:console
$ docker-compose -f docker/local/docker-compose.yml up --build
```

以下でも実行可能です．

```console:console
$ gradle composeUp -Penvironment="local"
```

以上で http://localhost:8080/springwork2000g0 にアクセスできれば完了．

## 本番環境へのデプロイ方法（1 回目）

### 1. docker image のビルド

ローカル環境で本番用の`docker-compose.yml`を使って docker image を build する．

```console:console
$ docker-compose -f docker/production/docker-compose.yml build
```

以下でも実行可能です．

```console:console
$ gradle composeUp -Penvironment="production"
```

以上で`diamond.u-gakugei.ac.jp/springwork2000g0_db`と`diamond.u-gakugei.ac.jp/springwork2000g0_app`の 2 つの docker image がビルドされる．

`docker image ls`でイメージ一覧を確認した際に以下のような出力がされていれば成功です 🙆‍♂️

```console:console
$ docker image ls
REPOSITORY                                                        TAG                          IMAGE ID            CREATED             SIZE
diamond.u-gakugei.ac.jp/springwork2000g0_db                                    latest                       0d7bc01e233e        4 minutes ago       581MB
diamond.u-gakugei.ac.jp/springwork2000g0_app                                   latest                       ecf65aee74c0        4 minutes ago       447MB
```

### 2. diamond に push

1.でビルドした docker image を diamond に push する．

はじめに`docker login`で diamond の docker registry に認証を通す．

```console:console
$ docker login diamond.u-gakugei.ac.jp
```

ユーザー名とパスワードを聞かれるので入力する．

認証ができたら以下のコマンドで push する．

```console:console
$ docker image push diamond.u-gakugei.ac.jp/springwork2000g0_app:latest
$ docker image push diamond.u-gakugei.ac.jp/springwork2000g0_db:latest
```

### 3. diamond に アクセス

ここからの操作は diamond にアクセスしてから行う．

2.で push したイメージを pull する．

```console:console
$ docker image pull diamond.u-gakugei.ac.jp/springwork2000g0_app:latest
$ docker image pull diamond.u-gakugei.ac.jp/springwork2000g0_db:latest
```

pull したイメージを元にコンテナを生成する ✨

```console:console
$ docker container run -d --net=springwork2000g0 --name=springwork2000g0_app diamond.u-gakugei.ac.jp/springwork2000g0_app
$ docker container run -d --net=springwork2000g0 --name=springwork2000g0_db diamond.u-gakugei.ac.jp/springwork2000g0_db
```

### 4. nginx のリバースプロキシの設定

nginx のリバースプロキシを設定しアプリケーションにアクセスできるようにする．

そのためにまずアプリケーションが動作している IP アドレスを調べる．

`docker container inspect`コマンドを使う．

```console:console
$ docker container inspect springwork2000g0_app | grep IPAddress
            "SecondaryIPAddresses": null,
            "IPAddress": "",
                    "IPAddress": "172.18.0.2",
```

この設定を nginx に加える．

```console:console
$ sudo vi /etc/nginx/nginx.conf
```

tomcat は 8080 ポートで動いてるので注意

```conf
location /springwork2000g0 {
  proxy_pass http://172.18.0.2:8080;
}
```

設定したあとは nginx を再起動する．

```console:console
$ sudo systemctl restart nginx
```

以上で https://diamond.u-gakugei.ac.jp/springwork2000g0 にアクセスできれば完了です．

## 本番環境へのデプロイ

開発時に本番環境にデプロイしたい時はこちらから

### 1. docker login & image のビルド & push

1. GitHub の master ブランチに反映  
   GitHub の master ブランチに反映させると自動的で GitHubActions によって docker login & image のビルド & push を行う．

2. 手動で行う．

以下のコマンドを実行する．

```console:console
$ sh production-deploy.sh
```

`production-deploy.sh`の中身は以下になっており，`login`, `build`, `push` を行っている．

```sh:production-deploy.sh
# 手動でdiamondのdocker registryにpush
# docker login
docker login diamond.u-gakugei.ac.jp

# build
docker image build -t diamond.u-gakugei.ac.jp/springwork2000g0_app:latest -f docker/production/java/Dockerfile .
docker image build -t diamond.u-gakugei.ac.jp/springwork2000g0_db:latest -f docker/production/mysql/Dockerfile .

# push
docker image push diamond.u-gakugei.ac.jp/springwork2000g0_app:latest
docker image push diamond.u-gakugei.ac.jp/springwork2000g0_db:latest
```

### 2. docker pull & container run

diamond のコンテナは portainer で管理しているため．アクセスし diamond のコンテナ一覧からデプロイしたいコンテナを選択（springwork2000g0_app）．

<img width="1483" alt="スクリーンショット 2021-03-03 8 27 59" src="https://user-images.githubusercontent.com/38200453/109728892-67e47d00-7bfa-11eb-9898-479b0d37a7ce.png">

コンテナを recreate する．以下のように 最新の image を pull しながら作成し直す．

<img width="750" alt="スクリーンショット 2021-03-03 8 29 33" src="https://user-images.githubusercontent.com/38200453/109729022-9e21fc80-7bfa-11eb-885c-b91655e50741.png">

以上で https://diamond.u-gakugei.ac.jp/springwork2000g0 にアクセスし反映がされていれば完了です．
