FROM openjdk:11-jre-slim
RUN ls -la
COPY back/target/*.jar ./app.jar
ADD back/target/*.jar /app.jar
CMD ["java","-jar","/app.jar"]