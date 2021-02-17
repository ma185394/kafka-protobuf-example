# Kafka Protobuf Service

The following service provides as a POC to the order-tracking service

## Services
The kafka-protbuf service allows a user to send messages via REST API to a kafka topic. It also allows
you to send an employee object structured using protbuf to a kafka topic.

### Build

For building the code, you will need:

- Java 8 JDK
- Maven 3.3.9 or higher

### Start docker containers

To start docker container for kafka and zookeeper
```
cd docker
docker-compose up -d
 ```
