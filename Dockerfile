FROM openjdk:11-jre-slim
COPY ["back/target/*.jar","."]
ADD back/target/*.jar /app.jar
CMD ["java","-jar","/app.jar"]