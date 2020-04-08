FROM openjdk:11-jre-slim
ADD back/target/*.jar /app.jar
CMD ["java","-jar","/app.jar"]