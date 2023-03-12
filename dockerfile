FROM openjdk:20-ea-9-jdk-bullseye
ADD target/WeatherServiceForWindSurfers-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar WeatherServiceForWindSurfers-0.0.1-SNAPSHOT.jar

