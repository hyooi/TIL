# Replicaset

ReplicaSet -> Find pod by labels -> Create pod from template
실제로는 많이 사용하지 않고, deployment를 주로 사용함

## 예제

### 기본 예제

guide-03/task-03/whoami-rs.yml

```yml
apiVersion: apps/v1
kind: ReplicaSet
metadata:
  name: whoami-rs
spec:
  replicas: 1 #리플리카셋의 갯수는 1개
  selector: #리플리카셋 입장에서 type이 app이면서 whoami라는 service가 1개가 있는지 체크한다는 의미
    matchLabels:
      type: app
      service: whoami
  template: #만약 1개가 없는 경우 해당 template에 맞는 pod을 만들겠다는 의미
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
kubectl get pods --show-labels
kubectl label pod/whoami-rs-<xxxx> service-
kubectl label pod/whoami-rs-<xxxx> service=whoami
kubectl label pod/whoami-rs-<xxxx> type-pod/whoami-rs-<xxxx> labeled #라벨 삭제

# 리플리카셋 갯수 변경하고 싶을 때
kubectl apply -f whoami-rs.yml #이전과 차이점만 찾아 다시 apply해줌
kubectl scale --replicas=3 -f whoami.yml
```
임의로 라벨을 제거하게 되면 해당하는 pod이 사라지므로, replicaSet이 템플릿에 맞는 pod을 하나 더 생성하게 됨
replicatSet은 주기적으로 match label만 체크하는 것

### 스케일 아웃 예제

guide-03/task-03/whoami-rs-scaled.yml

```yml
apiVersion: apps/v1
kind: ReplicaSet
metadata:
  name: whoami-rs
spec:
  replicas: 4
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

## Exam 1. 다음 조건을 만족하는 replicaset을 만들어 보세요.

guide-03/task-03/exam-1.yml

- Name: nginx
- Labels: app => nginx
- Container Name: nginx
- Image: nginx
- Replicas: 3

## 정리

```
kubectl delete -f ./
```
