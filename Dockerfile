FROM openjdk:8-jre-alpine
COPY ./target/places-service.jar /usr/src/places-service/
WORKDIR /usr/src/places-service
EXPOSE 8080
CMD ["java", "-jar", "places-service.jar"]
