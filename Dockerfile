FROM openjdk:11-jre-slim
WORKDIR /back
COPY ["target","."]
ADD target/*.jar /app.jar
CMD ["java","-jar","/app.jar"]