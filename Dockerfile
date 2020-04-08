FROM openjdk:11-jre-slim
WORKDIR /src
COPY ["/target/*.jar","."]
ADD target/*.jar /app.jar
CMD ["java","-jar","/app.jar"]