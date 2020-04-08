FROM openjdk:11-jre-slim
RUN ls -la
COPY back/target/*.jar ./app.jar
RUN ls -la
ADD back/target/*.jar /app.jar
RUN ls -la
CMD ["java","-jar","/app.jar"]