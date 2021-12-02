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
	java -jar build/libs/spring-customer-1.0.jar

# Docker

docker-build: jar
	docker build -t spring-customer .
	docker images

docker-run: docker-build
	docker run --name spring-customer -td -p 80:8080 spring-customer	
	docker ps

docker-clean:
	docker stop spring-customer
	docker rm spring-customer
	docker rmi spring-customer

docker-shell:
	docker exec -it spring-customer bash 

docker-push:
	docker login
	docker build -t $(account)/spring-customer:latest -t $(account)/spring-customer:latest .
	docker push $(account)/spring-customer:latest 

# Compose

network-ls:
	docker network ls 

network-create:
	docker network create --driver bridge spring-customer-latest_network

network-prune:
	docker network prune

compose-up:
	docker-compose up --scale customer=2 -d

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
	kubectl describe pods spring-customer

pod-delete:
	kubectl delete -f pod.yaml

pod-shell:
	kubectl exec -it spring-customer -- /bin/bash

pod-logs:
	kubectl logs -f spring-customer

# Deployment

deployment-create:
	kubectl create -f deployment.yaml --save-config 

deployment-get:
	kubectl get deployments

deployment-get-pods:
	kubectl get pods -l name=spring-customer

deployment-pod-shell:
	kubectl exec -it $(pod) -- /bin/bash

deployment-upgrade:
	kubectl apply  -f deployment.yaml

deployment-delete:
	kubectl delete deployment spring-customer-deployment

# Service

service-create:
	kubectl create -f service.yaml

service-get:
	kubectl get services

service-get-ip:
	kubectl get service spring-customer -o wide

service-delete:
	kubectl delete service spring-customer

# Ingress

ingress-apply:
	kubectl apply -f ingress.yaml

ingress-ip:
	kubectl get ingress spring-customer-ingress





