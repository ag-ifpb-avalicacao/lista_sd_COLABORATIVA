FROM openjdk:8-jdk-alpine
WORKDIR /home
COPY target/client-jar-with-dependencies.jar client-jar-with-dependencies.jar
CMD ["java", "-jar", "client-jar-with-dependencies.jar"]