FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} lit_server_jar.jar
ENTRYPOINT ["java","-jar","/lit_server_jar.jar"]