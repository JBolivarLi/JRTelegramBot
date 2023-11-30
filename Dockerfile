FROM adoptopenjdk/openjdk11:ubi

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-Dbot.username=${BOT_USERNAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]
