FROM eclipse-temurin:25-jre
ADD target/notification-service-0.0.1-SNAPSHOT.jar notification-service.jar
ENTRYPOINT [ "java","-jar","notification-service.jar" ]
EXPOSE 8084