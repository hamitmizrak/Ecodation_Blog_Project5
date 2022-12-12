FROM maven:3-jdk-8-slim
RUN mkdir -p /root/.m2 \
    && mkdir /root/.m2/repository
COPY . /app/
COPY pom.xml .
COPY settings.xml /root/.m2/
COPY settings.xml /usr/share/maven/ref/
WORKDIR /app/
ENTRYPOINT \
    mvn clean install -Dmaven.test.skip -DskipTests -s settings.xml && \
    java -jar \
        -Dspring.profiles.active=${active_profile} \
        -Dserver.port=8082 \
        /app/target/demo-1.0.0.jar


# docker build --tag=demo:latest -t demo .
# docker run -d --name demo -p 8080:8082 demo