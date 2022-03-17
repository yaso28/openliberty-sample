# Open Liberty サンプルWebアプリケーション

- [開発履歴](./history.md)
- [UIソースコード](./ui/)

## 開発環境

- Java 11
- Docker

## ローカルで実行

```bash
cd ui
./mvnw liberty:run
```

上記コマンド実行後、ブラウザで `http://localhost:9080` にアクセスします。

## Dockerイメージ作成

[こちら](https://community.ibm.com/community/user/wasdevops/blogs/joseph-mcclure/2021/11/08/creating-a-minimized-liberty-container-image)のサイトを参考に、Dockerイメージのファイルサイズが小さくなるように工夫しています。

関係するファイル一覧

- 必要なJava依存モジュール一覧
  - `ui/jdeps/java_modules.txt`
- Dockerfile
  - `ui/Dockerfile-base-minimal`
  - `ui/Dockerfile-app-minimal`
- ビルドスクリプト
  - `ui/build-minimal.sh`

なお「必要なJavaの依存モジュールの一覧を取得」に関して、「warファイルを解析して動的に取得する方法」と「`ui/jdeps/java_modules.txt`にベタ書きする方法」の2つがあるのですが、前者があまりに時間がかかる（40分経過しても終わらない）ため、後者の方法を採用しています。（Javaのモジュールが足りないとエラーが出たら都度`ui/jdeps/java_modules.txt`に追記して再ビルドします。）

作成コマンド

```bash
cd ui
./build-minimal.sh
```

## Dockerコンテナ実行

> 例：ローカルポート`8080`で実行する場合

```bash
docker container run -d -p 8080:9080 --name openliberty-sample-ui openliberty-sample-ui
```

上記コマンド実行後、ブラウザで `http://localhost:8080` にアクセスします。

コンテナ削除

```bash
docker container rm -f openliberty-sample-ui
```

## Dockerイメージpush/pull

DockerHubのyaso28リポジトリ([こちら](https://hub.docker.com/r/yaso28/openliberty-sample-ui))にpushしています。

push

```bash
docker image tag openliberty-sample-ui yaso28/openliberty-sample-ui:[tag]
docker image push yaso28/openliberty-sample-ui:[tag]
```

pull

```bash
docker image pull yaso28/openliberty-sample-ui:[tag]
```

## Kubernetesにデプロイ

詳細は[こちら](./kubernetes/)
