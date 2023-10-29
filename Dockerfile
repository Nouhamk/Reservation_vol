FROM openjdk:11
WORKDIR /Reservation_vol
CMD ["./gradlew", "clean", "bootJar"]
COPY build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
