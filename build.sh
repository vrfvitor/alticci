#!/usr/bin/env bash

echo '--------------building image for api--------------'
cd alticci-api
mvn clean package -DskipTests
docker build -t vrfvitor/alticci-api:latest -f Dockerfile .

echo '--------------building image for gui--------------'
cd ../alticci-gui
docker build -t vrfvitor/alticci-gui:latest -f Dockerfile .
