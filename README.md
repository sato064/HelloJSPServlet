# HelloJSPServlet

初めてのJSPServletウェブアプリ

## やってもらいたいこと

### 1
ターミナルを起動し，このフォルダが存在する場所までcdコマンドで移動する．<br>
VScodeでターミナルを開くと最初からこのフォルダのところで起動するので楽です．<br>

### 2
ターミナルに以下のコマンドを打ち込む

`docker-compose -f docker/local/docker-compose.yml up --build`

### 3
しばらく待って（Windowsだと結構時間かかります）The Server is running at http://localhost:8080/onsen-ikitai と表示されたら<br>
http://localhost:8080/onsen-ikitai/
にアクセスする

### 4
Hello JSP/Servlet!が表示されればOK！



## ディレクトリ構成

<pre>
.
├── README.md
├── build.gradle
├── docker
│   ├── README.md
│   ├── local
│   │   ├── docker-compose.yml
│   │   ├── java
│   │   ├── mysql
│   │   └── wait-for-it.sh
│   └── production
│       ├── docker-compose.yml
│       ├── java
│       └── mysql
├── docs
│   └── README.md
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── production-deploy.sh
├── setting
│   └── README.md
├── settings.gradle
└── src
    ├── README.md
    └── main
        ├── java
        └── webapp
</pre>
