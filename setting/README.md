# テンプレートからリポジトリを準備する手順

## リポジトリの作成

Hazeyamalab の GitHub から新しくレポジトリを作成する．
その時に下記の画像のように，Repository template で`Hazeyamalab/SpringWork2000G0`を選択し作成する．

<img width="1149" alt="スクリーンショット 2021-03-02 11 15 44" src="https://user-images.githubusercontent.com/38200453/109586532-b89b9d80-7b48-11eb-812e-25d5b6ec605e.png">

## プロジェクトのパスを変更

下記に示すファイルにおいて，テンプレートで設定してある「SpringWork2000G0」の部分をそれぞれのグループ名(SpringWork20XXGX)で変更する．

- SpringWork20XXGX/README.md
- SpringWork20XXGX/build.gradle
- SpringWork20XXGX/settings.gradle
- SpringWork20XXGX/docker/README.md
- SpringWork20XXGX/docker/local/docker-compose.yml
- SpringWork20XXGX/docker/production/docker-compose.yml
- SpringWork20XXGX/src/main/webapp/index.jsp
- SpringWork20XXGX/.github/workflows/ci.yml
- SpringWork20XXGX/.github/workflows/cd.yml

## デプロイの準備

### 手動で行う場合

[デプロイ方法](https://github.com/HazeyamaLab/SpringWork2000G0/tree/master/docker)を参考にしてデプロイをする．

### Portainer で行う場合
