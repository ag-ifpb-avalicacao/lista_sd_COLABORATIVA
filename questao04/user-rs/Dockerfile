FROM payara/micro
COPY target/user-rs.war user-rs.war
CMD ["java", "-jar", "user-rs.war", "--deploy", "user-rs.war"]
