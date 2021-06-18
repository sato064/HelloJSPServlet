# 手動でdiamondのdocker registryにpush
# docker login
docker login diamond.u-gakugei.ac.jp

# build
docker image build -t diamond.u-gakugei.ac.jp/springwork2000g0_app:latest -f docker/production/java/Dockerfile .
docker image build -t diamond.u-gakugei.ac.jp/springwork2000g0_db:latest -f docker/production/mysql/Dockerfile .

# push
docker image push diamond.u-gakugei.ac.jp/springwork2000g0_app:latest
docker image push diamond.u-gakugei.ac.jp/springwork2000g0_db:latest
