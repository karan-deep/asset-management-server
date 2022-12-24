FROM openjdk:15-jdk-alpine

COPY target/asset-management-server-0.0.1-SNAPSHOT.jar asset-management-server-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/asset-management-server-0.0.1-SNAPSHOT.jar"]
