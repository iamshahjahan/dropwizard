# HelloWorld

#How to set it up?

`mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=1.3.17`

![image](https://user-images.githubusercontent.com/7349720/159159892-e3b3c36f-582d-45df-b8d9-ba12d852e130.png)
![image](https://user-images.githubusercontent.com/7349720/159159896-62ab6cb0-d8d4-4467-a8d3-af5d35c50f29.png)

#How to start:

<img width="1029" alt="image" src="https://user-images.githubusercontent.com/7349720/159159928-ff91862c-5a2c-4dd0-b805-f7a0c3815809.png">



How to start the HelloWorld application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/test-1.0.0.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
