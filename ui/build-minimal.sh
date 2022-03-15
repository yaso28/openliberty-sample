#!/bin/bash
cd `dirname $0`
./mvnw package
docker build -t openliberty-sample-ui-base -f Dockerfile-base-minimal --build-arg CONFIG_DIRECTORY=src/main/liberty/config .
docker build -t openliberty-sample-ui -f Dockerfile-app-minimal --build-arg CONFIG_DIRECTORY=src/main/liberty/config --build-arg WAR_FILE=target/ui.war .
