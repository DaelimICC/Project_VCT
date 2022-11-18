FROM openjdk:17-jdk
VOLUME /tmp
ARG JAR_FILE=./build/libs/VCTServer-0.0.1-SNAPSHOT.jar
EXPOSE 8080
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "-Duser.timezone=Asia/Seoul" ,"/app.jar"]