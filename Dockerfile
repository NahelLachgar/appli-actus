FROM openjdk:11-jre-slim
COPY . .
ADD target/*.jar /app.jar
CMD ["java","-jar","/app.jar"]