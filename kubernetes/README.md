# Kubernetes デプロイ手順

## Ingress Controller

クラスター作成後初回のみ、Ingress Controllerをデプロイします。

> コマンドは[こちら](https://kubernetes.github.io/ingress-nginx/deploy/#azure)から取得

```bash
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.1.1/deploy/static/provider/cloud/deploy.yaml
```

## UI

デプロイ

```bash
kubectl apply -f ui.yaml
```

Pod再作成（Dockerイメージ更新後に実行）

```bash
kubectl rollout restart deployment/openliberty-sample-ui
```
