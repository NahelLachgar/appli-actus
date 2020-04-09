FROM openjdk:11-jre-slim
ADD target/*.jar /app.jar
CMD ["java","-jar","/app.jar","--newsToken=f929f100a402420f8da869041e811a7e","spring.datasource.url=jdbc:postgresql://ec2-35-180-30-108.eu-west-3.compute.amazonaws.com:5432/actus", "spring.datasource.username=postgres", "spring.datasource.password=password", "spring.datasource.platform=postgres"]