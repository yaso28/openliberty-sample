<!-- omit in toc -->
# 開発履歴

- [UIプロジェクト新規作成](#uiプロジェクト新規作成)
- [空のトップページを実装](#空のトップページを実装)

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
