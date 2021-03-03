# Deployment
Deployment using replicaset

## 예제

### 기본 예제

guide-03/task-04/whoami-deploy.yml

```yml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: whoami-deploy
spec:
  replicas: 3
  selector:
    matchLabels:
      type: app
      service: whoami
  template:
    metadata:
      labels:
        type: app
        service: whoami
    spec:
      containers:
      - name: whoami
        image: subicura/whoami:1
        livenessProbe:
          httpGet:
            path: /
            port: 4567
```

```
kubectl set image deploy/whoami-deploy whoami=subicura/whoami:2
kubectl apply -f whoami-deploy.yml
kubectl get rs -w #실시간 변경사항 확인
kubectl describe deploy/whoami-deploy
kubectl rollout history deployment/whoami-deploy #히스토리 확인
kubectl set image deploy/whoami-deploy whoami=subicura/whoami:1 --record=true
kubectl rollout history -f whoami-deploy.yml
kubectl rollout history deployment/whoami-deploy --revision=2 #특정 revision상세 확인
kubectl rollout status deploy/whoami-deploy
kubectl rollout undo deploy/whoami-deploy #이전 버전으로 롤백함. 이전 버전을 새로운 revision으로 만들어서 변경
kubectl rollout undo deploy/whoami-deploy --to-revision=3
```
- deployment는 yml에서 이미지의 버전이 변경되면 기존 레플리카셋 3개에서 하나를 삭제하고, 새로운 pod을 띄우는 것을
반복해 신규 pod 3개를 띄움
- replicaSet이 두개가 떠있는 것을 확인할 수 있는데, 기존 이미지의 replicaSet과 신규 이미지의 replicatSet이 둘다 있기 때문임
- 쿠버네티스는 이미지가 동일한 경우, 히스토리에서 동일한 버전을 삭제함

### 추가 예제

guide-03/task-04/whoami-deploy-strategy.yml

```yml
apiVersion: apps/v1beta2
kind: Deployment
metadata:
  name: whoami-deploy
spec:
  replicas: 3
  selector:
    matchLabels:
      type: app
      service: whoami
  minReadySeconds: 5
  strategy: #기본 하나씩 띄우고 하나씩 내리는데, 이것을 50개씩 띄우고 50개씩 내리고싶을 경우 strategy사용
    type: RollingUpdate
    rollingUpdate:
      maxSurge: 1
      maxUnavailable: 1
  template:
    metadata:
      labels:
        type: app
        service: whoami
    spec:
      containers:
      - name: whoami
        image: subicura/whoami:1
        livenessProbe:
          httpGet:
            path: /
            port: 4567
```

```
kubectl describe deploy/whoami-deploy
kubectl set image deploy/whoami-deploy whoami=subicura/whoami:2
kubectl get rs -w
```

## Exam 1. 다음 조건을 만족하는 deployment를 만들어 보세요.

guide-03/task-04/exam-1.yml

- Name: nginx
- Labels: app => nginx
- Container Name: nginx
- Image: nginx
- Replicas: 3

## 정리

```
kubectl delete -f ./
```
