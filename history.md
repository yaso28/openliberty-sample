<!-- omit in toc -->
# 開発履歴

- [UIプロジェクト新規作成](#uiプロジェクト新規作成)
- [空のトップページを実装](#空のトップページを実装)
- [UIのDockerイメージを縮小](#uiのdockerイメージを縮小)

## UIプロジェクト新規作成

- [こちら](https://openliberty.io/start/)のサイトでプロジェクト生成
  - 入力内容は[こちら](./generate-project.png)
- ダウンロードしたzipファイルを解凍して[ui](./ui/)に移動

## 空のトップページを実装

- 下記ファイルを追加
  - `ui/src/main/webapp/index.html`
  - `ui/src/main/webapp/WEB-INF/web.xml`
- `ui/src/main/liberty/config/server.xml`を編集
    - `ui`アプリケーションのrootを`/`に変更

## UIのDockerイメージを縮小

※[こちら](https://community.ibm.com/community/user/wasdevops/blogs/joseph-mcclure/2021/11/08/creating-a-minimized-liberty-container-image)のサイトを参考に、Dockerイメージのファイルサイズが小さくなるように工夫しています。

- 下記ファイルを追加
  - `ui/jdeps/java_modules.txt`
  - `ui/Dockerfile-base-minimal`
  - `ui/Dockerfile-app-minimal`
  - `ui/build-minimal.sh`
- 下記ファイルを削除
  - `ui/Dockerfile`
