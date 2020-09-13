      # on creer image stocker dans MAVEN_IMAGE
FROM maven:3.5-jdk-8 AS MAVEN_IMAGE
      # creer work espace 
WORKDIR /tmp/
      # copy the Project Object Model file
COPY pom.xml /tmp/
      # fetch all dependencies
RUN mvn dependency:go-offline -B
     # copy your other files
COPY src /tmp/src/

# build for release
# NOTE: "date-format-java-" must be replaced with the proper prefix
RUN mvn -Dmaven.test.skip=true package && cp target/devops-*.jar devops-simple.jar




FROM openjdk:8
EXPOSE 8080
    #ADD target/devops-simple.jar devops-simple.jar
    # copy over the built artifact from the maven image
COPY --from=MAVEN_IMAGE /tmp/devops-simple.jar ./devops-simple.jar
#commande pour executé le jar generer 
ENTRYPOINT ["java","-jar","/devops-simple.jar"]