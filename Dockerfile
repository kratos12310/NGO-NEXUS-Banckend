FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD /target/speproject-0.0.1-SNAPSHOT.jar ngo-nexus.jar
ENTRYPOINT ["java", "-jar", "ngo-nexus.jar"]