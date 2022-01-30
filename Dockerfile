FROM adoptopenjdk/openjdk11
ARG JAR_FILE=./api/build/libs/api-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]