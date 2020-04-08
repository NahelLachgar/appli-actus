FROM openjdk:11-jre-slim
WORKDIR /back
COPY ["./back/target/*.jar","/app.jar"]
RUN ls -la
CMD ["java","-jar","/*.jar"]