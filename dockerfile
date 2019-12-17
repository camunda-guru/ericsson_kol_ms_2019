FROM java:8
EXPOSE 6060
ADD /target/insuranceappdocker-0.0.1-SNAPSHOT.jar insuranceappdocker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","insuranceappdocker-0.0.1-SNAPSHOT.jar"]
