FROM openjdk:8
EXPOSE 8080
ADD target/devops-simple.jar devops-simple.jar

#commande pour executé le jar generer 
ENTRYPOINT ["java","-jar","/devops-simple.jar"]