FROM amazoncorretto:11

MAINTAINER Vitor Ferreira <vrfvitor@hotmail.com>

RUN mkdir /opt/alticci

COPY target/alticci-api.jar /opt/alticci/alticci-api.jar

EXPOSE 8080

CMD ["sh", "-c", "java -jar /opt/alticci/alticci-api.jar"]
