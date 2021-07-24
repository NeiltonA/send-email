FROM openjdk:11
EXPOSE 8080
COPY target/ms-send-email-0.0.1.jar send-email-0.0.1.jar
ENTRYPOINT ["java","-jar","/send-email-0.0.1.jar"]



