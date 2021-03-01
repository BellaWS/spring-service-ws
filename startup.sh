#!/bin/bash
echo "Starting spring-service-ws ......"
nohup java -jar spring-service-ws-1.0-SNAPSHOT.jar & >> spring-service-ws.log &

while true
do
    sleep 2
done