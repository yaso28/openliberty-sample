<!-- omit in toc -->
# 開発履歴

- [UIプロジェクト新規作成](#uiプロジェクト新規作成)
- [空のトップページを実装](#空のトップページを実装)
- [UIのDockerイメージを縮小](#uiのdockerイメージを縮小)
- [UIをKubernetesにデプロイ](#uiをkubernetesにデプロイ)
- [SAML2.0設定をUIに追加](#saml20設定をuiに追加)
- [UIにページとAPIを追加](#uiにページとapiを追加)
- [UIを改変](#uiを改変)
- [EJBプロジェクト新規作成](#ejbプロジェクト新規作成)

## UIプロジェクト新規作成

- [こちら](https://openliberty.io/start/)のサイトでプロジェクト生成
  - 入力内容は[こちら](./generate-project-ui.png)
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

## UIをKubernetesにデプロイ

- `kubernetes/ui.yaml`を追加

## SAML2.0設定をUIに追加

- `ui/pom.xml`を編集
- `ui/src/main/liberty/config/server.xml`を編集
- `ui/src/main/webapp/WEB-INF/web.xml`を編集
- ADFS2019の`https://<FQDN>/FederationMetadata/2007-06/FederationMetadata.xml`をダウンロードして` ui/src/main/liberty/config/resources/security/idpMetadata.xml`に移動
- `https://localhost:9443/ibm/saml20/defaultSP/samlmetadata`にアクセスして`spMetadata.xml`をダウンロード
- ダウンロードした`spMetadata.xml`をADFSの証明書利用者信頼にインポート
- インポートしたADFSの証明書利用者信頼に要求規則を追加（MSIS7070エラー対応）
  - UPNをNameIDに変換
  - NameIDのフォーマットとして`urn:oasis:names:tc:SAML:1.1:nameid-format:emailAddress`を指定

## UIにページとAPIを追加

- JSONライブラリをインストール
  - `ui/pom.xml`を編集
- 情報提供クラスを実装
  - `ui/src/main/java/com/yaso/sample/InfoBase.java`を追加
  - `ui/src/main/java/com/yaso/sample/UiInfo.java`を追加
  - `ui/src/main/java/com/yaso/sample/UserInfo.java`を追加
- ページを追加
  - `ui/src/main/webapp/index.jsp`を追加
  - `ui/src/main/webapp/user.jsp`を追加
  - `ui/src/main/webapp/index.html`を削除
- APIを追加
  - `ui/src/main/java/com/yaso/sample/rest/RestInfo.java`を追加
- `ui/src/main/webapp/WEB-INF/web.xml`を編集
  - ページのURLを設定
  - SAML認証が必要なURLを変更

## UIを改変

- microprofileとjsonライブラリを削除（warファイルのサイズ縮小のため）
  - `ui/pom.xml`を編集
- ページを改変（下記ファイルを編集）
  - `ui/src/main/java/com/yaso/sample/InfoBase.java`
  - `ui/src/main/java/com/yaso/sample/UiInfo.java`
  - `ui/src/main/java/com/yaso/sample/UserInfo.java`
  - `ui/src/main/webapp/index.jsp`
  - `ui/src/main/webapp/user.jsp`

## EJBプロジェクト新規作成

- [こちら](https://openliberty.io/start/)のサイトでプロジェクト生成
  - 入力内容は[こちら](./generate-project-ejb.png)
- ダウンロードしたzipファイルを解凍して[ejb](./ejb/)に移動
