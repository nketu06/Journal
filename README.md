# Journal
running my mongodb in docker 
- to start the shell-> docker exec -it <container_name_or_id> mongosh

to run redis on docker
- docker start -p 6379:6379 -d --name myredis redis:alpine3.16
- docker exec -it myredis2 redis-cli
- docker start/stop <container id or name>

running on atlas
- whitelist your Ip

Important command
- ./mvnw clean        
- ./mvnw package  
- .java -jar ./target/journal-0.0.1-SNAPSHOT.jar --server.port=8080
- ./mvnw test

add this document to mongodb to run weather api
- db name: config_journal_app
- document: {"key":"WEATHER_API","value":"https://api.weatherstack.com/current?access_key=<api_key>&query=<location>"}
- go to above website get a free api key for you and replace api key in application.yml file

To activate mail service
- uncomment mail service config in application.yml 
- add you own gmail app password
