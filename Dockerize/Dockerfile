# FROM adoptopenjdk/openjdk11
FROM eclipse-temurin:11 as build
ARG JAR_FILE=EcodationBlogProject5-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} blog.jar
EXPOSE 4444
ENTRYPOINT ["java","-jar","/blog.jar"]