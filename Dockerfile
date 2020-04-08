FROM openjdk:11-jre-slim
RUN ls -la
COPY target/*.jar ./app.jar
ADD target/*.jar /app.jar
CMD ["java","-jar","/app.jar"]