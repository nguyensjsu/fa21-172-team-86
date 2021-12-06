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
	java -jar build/libs/spring-main-1.0.jar

# Docker

docker-build: jar
	docker build -t spring-main .
	docker images

docker-run: docker-build
	docker run --name spring-main -td -p 80:8080 spring-main	
	docker ps

docker-clean:
	docker stop spring-main
	docker rm spring-main
	docker rmi spring-main

docker-shell:
	docker exec -it spring-main bash 

docker-push:
	docker login
	docker build -t $(account)/spring-main -t $(account)/spring-main .
	docker push $(account)/spring-main 

# Compose

network-ls:
	docker network ls 

network-create:
	docker network create --driver bridge spring-main-network

network-prune:
	docker network prune

compose-up:
	docker-compose up --scale main=2 -d

compose-down:
	docker-compose down 	

lb-stats:
	echo "main = admin | password = admin"
	open http://localhost:1936

lb-test:
	open http://localhost


# Pod

pod-run:
	kubectl apply -f pod.yaml

pod-list:
	kubectl get pods

pod-desc:
	kubectl describe pods spring-main

pod-delete:
	kubectl delete -f pod.yaml

pod-shell:
	kubectl exec -it spring-main -- /bin/bash

pod-logs:
	kubectl logs -f spring-main

# Deployment

deployment-create:
	kubectl create -f deployment.yaml --save-config 

deployment-get:
	kubectl get deployments

deployment-get-pods:
	kubectl get pods -l name=spring-main

deployment-pod-shell:
	kubectl exec -it $(pod) -- /bin/bash

deployment-upgrade:
	kubectl apply  -f deployment.yaml

deployment-delete:
	kubectl delete deployment spring-main-deployment

# Service

service-create:
	kubectl create -f service.yaml

service-get:
	kubectl get services

service-get-ip:
	kubectl get service spring-main -o wide

service-delete:
	kubectl delete service spring-main

# Ingress

ingress-apply:
	kubectl apply -f ingress.yaml

ingress-ip:
	kubectl get ingress spring-main-ingress





