FROM openjdk:11
ADD /target/speproject-0.0.1-SNAPSHOT.jar ngo-nexus.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "ngo-nexus.jar"]