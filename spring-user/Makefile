all: clean

clean:
	gradle clean

compile:
	gradle build

test:
	gradle test

jar: 
	gradle build -x test
	gradle bootJar

run: jar
	echo Starting Spring at:  http://localhost:8080
	java -jar build/libs/spring-user-1.0.jar

# Docker

docker-build: jar
	docker build -t spring-user .
	docker images

docker-run: docker-build
	docker run --name spring-user -td -p 80:8081 spring-user	
	docker ps

docker-clean:
	docker stop spring-user
	docker rm spring-user
	docker rmi spring-user

docker-shell:
	docker exec -it spring-user bash 

docker-push:
	docker login
	docker build -t $(account)/spring-user -t $(account)/spring-user .
	docker push $(account)/spring-user 

# Compose

network-ls:
	docker network ls 

network-create:
	docker network create --driver bridge spring-user-network

network-prune:
	docker network prune

compose-up:
	docker-compose up --scale user=2 -d

compose-down:
	docker-compose down 	

lb-stats:
	echo "user = admin | password = admin"
	open http://localhost:1936

lb-test:
	open http://localhost


# Pod

pod-run:
	kubectl apply -f pod.yaml

pod-list:
	kubectl get pods

pod-desc:
	kubectl describe pods spring-user

pod-delete:
	kubectl delete -f pod.yaml

pod-shell:
	kubectl exec -it spring-user -- /bin/bash

pod-logs:
	kubectl logs -f spring-user

# Deployment

deployment-create:
	kubectl create -f deployment.yaml --save-config 

deployment-get:
	kubectl get deployments

deployment-get-pods:
	kubectl get pods -l name=spring-user

deployment-pod-shell:
	kubectl exec -it $(pod) -- /bin/bash

deployment-upgrade:
	kubectl apply  -f deployment.yaml

deployment-delete:
	kubectl delete deployment spring-user-deployment

# Service

service-create:
	kubectl create -f service.yaml

service-get:
	kubectl get services

service-get-ip:
	kubectl get service spring-user -o wide

service-delete:
	kubectl delete service spring-user

# Ingress

ingress-apply:
	kubectl apply -f ingress.yaml

ingress-ip:
	kubectl get ingress spring-user-ingress





