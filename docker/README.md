## 手元の環境での実行方法

下記を実行する．

```console:console
$ docker-compose -f docker/local/docker-compose.yml up --build
```

以下でも実行可能です．

```console:console
$ gradle composeUp -Penvironment="local"
```

以上で http://localhost:8080/onsen-ikitai にアクセスできれば完了．

