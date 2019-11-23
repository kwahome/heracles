# image 1 - compilation
FROM openjdk:11-jdk as builder

MAINTAINER "Kelvin Wahome<kevowahome@gmail.com>"

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY . .

# Download and setup gradle

RUN ./gradlew --version

RUN ./gradlew clean assemble
