#!/bin/bash

java -jar service-discovery/target/service-discovery-1.0-SNAPSHOT.jar --server.port=9999 &
sleep 20

java -jar web-application/target/web-application-1.0-SNAPSHOT.jar --server.port=8001 &
sleep 20

java -jar web-application/target/web-application-1.0-SNAPSHOT.jar --server.port=8002 &
sleep 20

java -jar web-application-backup/target/web-application-backup-1.0-SNAPSHOT.jar --server.port=8111 &
sleep 20

java -jar ribbon-consumer/target/ribbon-consumer-1.0-SNAPSHOT.jar --server.port=8003 &
sleep 20

java -jar hystrix-dashboard/target/hystrix-dashboard-1.0-SNAPSHOT.jar --server.port=8004 &
sleep 20

