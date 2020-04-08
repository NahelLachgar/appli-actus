FROM openjdk:11-jre-slim
WORKDIR /back
COPY ["/back/target/*.jar","./"]
CMD ["java","-jar","/app.jar"]