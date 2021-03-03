# Pod

## 빠른 예제
kubernetes 시 pod이 안뜬다면 `kubectl describe`의 event를 확인하면 됨

```sh
kubectl run whoami --image subicura/whoami:1 # deprecated soon..보통 yml로 만듦
kubectl get po
kubectl get pod
kubectl get pods
kubectl get pods -o wide #어느 노드에 떠있는지를 포함한 상세 내용 확인 가능
kubectl get pods -o yaml
kubectl get pods -o json
kubectl logs whoami-<xxxx> #어느 서버에 있던 api서버가 로그를 모아주기 때문에 확인 가능
kubectl logs -f whoami-<xxxx>
kubectl exec -it whoami-<xxxx> sh
kubectl describe pods whoami-<xxxx>
kubectl delete pods whoami-<xxxx>
kubectl get pods
kubectl get all
kubectl delete deployment/whoami
```

## YAML 파일 예제

```
kubectl apply -f <filename>
kubectl delete -f <filename>
```

### 기본 예제

guide-03/whoami-pod.yml

```yml
apiVersion: v1
kind: Pod
metadata:
  name: whoami
  labels:
    type: app
spec:
  containers:
  - name: app
    image: subicura/whoami:1
```
api version과 kind, metadata의 name은 필수값

### Pod Ready

![Ready](./imgs/pod-ready.png)
kubernetes는 pod이 프로세스가 기동되었을 때와 실제 pod이 기동되었는지의 gap을 확인해 해당하는 값을 돌려줌
또한 기동 후에도 컨테이너의 상태값을 주기적으로 확인해서 가지고 있음

### livenessProbe 예제 (살아 있는지 조사)
- app이 정상적으로 뜨고 나서 실제 컨테이너가 정상인지 확인하는 것
guide-03/whoami-pod-lp.yml

```yml
apiVersion: v1
kind: Pod
metadata:
  name: whoami-lp
  labels:
    type: app
spec:
  containers:
  - name: app
    image: subicura/whoami:1
    livenessProbe:
      httpGet:
        path: /not/exist #존재하지 않는 path에 접속해 200,300이 떨어지면 성공이라고 보는 것. 일부러 에러발생
        port: 8080
      initialDelaySeconds: 5
      timeoutSeconds: 2 # Default 1
      periodSeconds: 5 # Defaults 10
      failureThreshold: 1 # Defaults 3
```

### readinessProbe 예제 (준비가 되었는지 조사)
- pod가 기동할 준비가 되었는지 체크
guide-03/task-02/whoami-pod-rp.yml

```yml
apiVersion: v1
kind: Pod
metadata:
  name: whoami-rp
  labels:
    type: app
spec:
  containers:
  - name: app
    image: subicura/whoami:1
    readinessProbe:
      httpGet:
        path: /not/exist
        port: 8080
      initialDelaySeconds: 5
      timeoutSeconds: 2 # Default 1
      periodSeconds: 5 # Defaults 10
      failureThreshold: 1 # Defaults 3
```

### 컨테이너 상태
```bash
kubectl get pod
```
|NAME|READY|STATUS|RESTARTS|AGE|
|----|-----|------|--------|---|
|whoami|1/1|Running|0|10m|
|whoami-lp|1/1|Running|2|2m59s|
|whoami-rp|0/1|ContainerCreating|0|45s|
- livenessProbe는 Running중이지만, readinessProbe는 아예 Running도 되지 못함
- whoami-rp는 시작하는 명령어를 통과하지 못했기 때문이며, whoami-lp는 기동 후에 계속 확인 실패중인 것

### health check 예제

guide-03/task-02/whoami-pod-health.yml

```yml
apiVersion: v1
kind: Pod
metadata:
  name: whoami-health
  labels:
    type: app
spec:
  containers:
  - name: app
    image: subicura/whoami:1
    livenessProbe:
      httpGet:
        path: /
        port: 4567
    readinessProbe:
      httpGet:
        path: /
        port: 4567
```

### multi container 예제
- pod안에 두개의 컨테이너를 넣음
- 동일한 pod의 컨테이너는 동일한 ip를 사용하고, 서로 다른 port를 사용해 통신을 함

guide-03/task-02/whoami-pod-redis.yml

```yml
apiVersion: v1
kind: Pod
metadata:
  name: whoami-redis
  labels:
    type: stack
spec:
  containers:
  - name: app
    image: subicura/whoami-redis:1
    env:
    - name: REDIS_HOST
      value: "localhost"
  - name: db
    image: redis
```


```
kubectl get all
kubectl logs whoami-redis
kubectl logs whoami-redis app
kubectl logs whoami-redis db
kubectl exec -it whoami-redis
kubectl exec -it whoami-redis -c db sh
kubectl exec -it whoami-redis -c app sh
  apk add curl busybox-extras # install telnet
  curl localhost:4567
  telnet localhost 6379
    dbsize
    KEYS *
    GET count
    quit
kubectl get pod/whoami-redis
kubectl get pod/whoami-redis -o yaml
kubectl get pod/whoami-redis -o jsonpath="{.spec.containers[0].name}"
kubectl get pod/whoami-redis -o jsonpath="{.spec.containers[*].name}"
kubectl describe pod/whoami-redis
```

## Exam 1. 다음 조건을 만족하는 pod을 만들어 보세요.

guide-03/task-02/exam-1.yml

- Name: mongodb
- Labels: app => mongo
- Container Name: mongodb
- Image: mongo:4

## Exam 2. 다음 조건을 만족하는 pod을 만들어 보세요.

guide-03/task-02/exam-2.yml

- Name: mysql
- Labels: app => mysql
- Container Name: mysql
- Image: mysql:5.6
- Env
  - MYSQL_ROOT_PASSWORD: 123456

POD에 접속해서 mysql -uroot -p123456 으로 테스트

## 정리

```
kubectl delete -f ./
```
