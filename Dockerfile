FROM openjdk:8-slim
ENV TZ="Asia/Kolkata"
WORKDIR /hireet
VOLUME /hireet
ADD target/hireet_app.jar hireet_app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "hireet_app.jar"]