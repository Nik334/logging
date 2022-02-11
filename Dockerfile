FROM openjdk:8-slim
ENV TZ="Asia/Kolkata"
EXPOSE 443
ADD target/hireet_app.jar hireet_app.jar
ENTRYPOINT ["java", "-jar", "hireet_app.jar"]