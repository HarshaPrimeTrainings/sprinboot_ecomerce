# Sprinboot_Ecomerce

# Flyway repair
mvn flyway:repair -Dflyway.url=jdbc:mysql://localhost:3306/spring_commerce -Dflyway.user=root -Dflyway.password=admin

# Kafka Trouble Shooting
```ERROR:  main ERROR Reconfiguration failed: No configuration found for '764c12b6' at 'null' in 'null'```
solution set KAFKA_LOG4J_OPTS=-Dlog4j.configuration=file:tools-log4j2.yaml