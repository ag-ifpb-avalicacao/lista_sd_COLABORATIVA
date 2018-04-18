FROM payara/micro
COPY target/message-rs.war message-rs.war
CMD ["java", "-jar", "message-rs.war", "--deploy", "message-rs.war"]
