FROM openjdk:17-oracle
EXPOSE 8001
ARG JAR_FILE=target/product-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} product-service.jar
ENTRYPOINT ["java", "-jar","/product-service.jar"]