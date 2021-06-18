# ビルドコンテナ
FROM adoptopenjdk/openjdk11:alpine as builder
WORKDIR /app

# プロジェクトの配置とビルド
ADD . ./
RUN ./gradlew war

# プロダクション用のコンテナ
FROM tomcat:jdk11-adoptopenjdk-hotspot

EXPOSE 8080
ENV JAVA_ENV production

COPY --from=builder ./app/build/libs/springwork2000g0.war /usr/local/tomcat/webapps
