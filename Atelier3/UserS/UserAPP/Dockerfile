FROM openjdk:8
RUN mkdir -p /app/SP
WORKDIR /app/SP
COPY ./target/UserAPP-0.0.1-SNAPSHOT.jar UserAPP-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "UserAPP-0.0.1-SNAPSHOT.jar"]
