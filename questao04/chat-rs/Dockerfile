FROM payara/micro
COPY target/chat-rs.war chat-rs.war
CMD ["java", "-jar", "chat-rs.war", "--deploy", "chat-rs.war"]
