# Docker

## Message broker 
### Rabbit MQ
Rabbit MQ is a message broker that can be installed with a docker image 

```
docker run -d --hostname docker-rabbit --name docker-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```
open http://localhost:15672, which will show the management console login form.

The default username is: ‘guest’; password: ‘guest’.

RabbitMQ will also listen on port 5672. (but the web port is 15672) 

### Model for the config server
Git repository will contains the configuration property files related to the application services that have been deployed.

Spring Cloud Config Server is responsible for retrieving the latest configurations from Git repository and maintaining them as a centralized service for client applications.

Services will retrieve the configurations from the Config Server when they start up. They are connected to each other through a Spring Cloud Bus. 

Spring Cloud uses a lightweight message broker (RabbitMQ ) to broadcast events across all connected clients.

The user can change the properties and push the change to the Git repository. But the Config Clients does not aware about the property changes. Therefore they do not try to refresh (re-fetch) their configurations with Spring Cloud Config Server.

Once the user triggers the refresh event for any service, the Spring Cloud Bus will receive the event and broadcast it across all the connected clients through the underlying message broker.

The refresh event is triggered by invoking the endpoint  /actuator/bus-refresh of the department-service.

Every service has the Spring Boot Actuator in its classpath. Therefore the refresh event will be handled property and all the beans annotated with @RefreshScope will be refreshed

Then the Config Server pulls the latest configurations from the Git repository and updates the Config Sever itself.  After the Config Client requests for getting the properties will be served with latest updated properties.

Finally the Config Client will receive the latest and updated properties through the Config Server.