
all: clean compile 

clean:
	rm -rf build/*
	rm -f dist/app.jar
	find . -name "*.class" -exec rm -rf {} \;

app: compile
	cd build ; jar -cvfe ../dist/app.jar GraphServer .

test: compile app
	java -cp dist/restlet.jar:dist/restlet-json.jar:dist/json.jar:dist/app.jar api.GraphServer

compile: 
	javac -cp \
	dist/MainMenu.jar:\
	dist/greenfoot.jar:\
	dist/json.jar:\
	dist/restlet.jar:\
	dist/restlet-json.jar:\
	dist/restlet-jackson.jar:\
	dist/jackson-core-2.8.3.jar:\
	dist/jackson-annotations-2.8.3.jar \
	-d build \
	MainMenu/*.java \
	api/*.java

run:
	echo Starting Service at:  http://localhost:8080
	java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json.jar:dist/restlet-jackson.jar:dist/jackson-core-2.8.3.jar:dist/jackson-annotations-2.8.3.jar:dist/jackson-dataformat-smile-2.8.3.jar:dist/jackson-databind-2.8.3.jar:dist/jackson-dataformat-xml-2.8.3.jar:dist/jackson-dataformat-yaml-2.8.3.jar:dist/jackson-dataformat-csv-2.8.3.jar api.GraphServer

loadtest:
	echo Starting Load Test on localhost
	java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json.jar RunLoadTest 5

docker-build: app
	docker build -t gumball .
	docker images

docker-clean:
	docker stop gumball
	docker rm gumball
	docker rmi gumball

docker-run:
	docker run --name gumball -td gumball
	docker ps

docker-run-host:
	docker run --name gumball -td --net=host gumball
	docker ps

docker-run-bridge:
	docker run --name gumball -td -p 80:8080 gumball
	docker ps

docker-network:
	docker network inspect host
	docker network inspect bridge

docker-stop:
	docker stop gumball
	docker rm gumball

docker-shell:
	docker exec -it gumball bash 
	
