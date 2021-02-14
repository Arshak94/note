FROM openjdk:11
COPY /target/note-0.0.1-SNAPSHOT.jar note-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","note-0.0.1-SNAPSHOT.jar"]