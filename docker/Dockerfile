FROM adoptopenjdk:11-jre-hotspot
LABEL André Eduardo Pacheco Dias

ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]