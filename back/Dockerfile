FROM openjdk:11-jre-slim
ARG NEWS_TOKEN
ARG DB_USER
ARG DB_PASSWORD
ARG DB_SOURCE
ARG DB_PLATFORM
ADD target/*.jar /app.jar
CMD ["java","-jar","/app.jar","--newsToken=${NEWS_TOKEN}","spring.datasource.url=${DB_SOURCE}", "spring.datasource.username=${DB_USER}", "spring.datasource.password=${DB_PASSWORD}", "spring.datasource.platform=${DB_PLATFORM}"]