FROM openjdk:17-oracle
EXPOSE 8003
ARG JAR_FILE=target/order-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} order-service.jar
ENTRYPOINT ["java", "-jar","/order-service.jar"]