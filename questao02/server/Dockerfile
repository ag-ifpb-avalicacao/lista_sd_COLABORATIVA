FROM payara/micro
COPY target/server.war server.war
CMD ["java", "-jar", "server.war", "--deploy", "server.war"]
