# Sprinboot_Ecomerce

# Flyway repair
mvn flyway:repair -Dflyway.url=jdbc:mysql://192.168.176.1:3306/spring_commerce -Dflyway.user=root -Dflyway.password=admin

 
# Kafka Setup on Windows and Testing

## 1. Download Kafka

Download and install Apache Kafka.
https://www.apache.org/dyn/closer.lua/kafka/4.3.1/kafka_2.13-4.3.1.tgz?action=download
- use 7 Zip to extract.
## 2. Extract Kafka

After extracting Kafka, you will find a `bin` folder containing:

* `.sh` files for Linux/Unix
* `windows` folder containing `.bat` files for Windows

The directory structure looks like:

```text
kafka/
├── bin/
│   ├── kafka-server-start.sh
│   ├── kafka-topics.sh
│   └── windows/
│       ├── kafka-server-start.bat
│       ├── kafka-topics.bat
│       ├── kafka-console-producer.bat
│       └── kafka-console-consumer.bat
├── config/
│   └── kraft/
│       └── server.properties
└── libs/
```
---

## 3. Open Command Prompt

Open **Command Prompt** in the:

```text
bin\windows
```

folder.

Alternatively, you can run the commands from the Kafka root folder.

If you run commands from the Kafka root folder, prefix the commands with:

```text
bin\windows\
```

---

## 4. Create Kafka Cluster ID

Run the following command:

```bat
kafka-storage.bat random-uuid
```

Example output:

```text
4F9x8P2aT7KqLmN3V6YzBw
```

Copy the generated Cluster ID.

---

## 5. Format Kafka Storage

Run:

```bat
kafka-storage.bat format -t <KAFKA_CLUSTER_ID> -c ..\..\config\kraft\server.properties
```

Replace:

```text
<KAFKA_CLUSTER_ID>
```

with the Cluster ID generated in the previous step.

For example:

```bat
kafka-storage.bat format -t 4F9x8P2aT7KqLmN3V6YzBw -c ..\..\config\kraft\server.properties
```

> **Note:** If you are running the command from the Kafka root folder, use:
>
> ```bat
> bin\windows\kafka-storage.bat format -t <KAFKA_CLUSTER_ID> -c config\kraft\server.properties
> ```

---

## 6. Configure Kafka Log Directory

Open:

```text
config\kraft\server.properties
```

Configure the `log.dirs` property.

For example:

```properties
log.dirs=E:/kafka-data
```

---

## 7. Start Kafka Server

From the `bin\windows` folder, run:

```bat
kafka-server-start.bat ..\..\config\kraft\server.properties
```

Keep this Command Prompt running.

Kafka should now be running on:

```text
localhost:9092
```

---

# Kafka Topic

## 8. Create a Topic

Open a **new Command Prompt**.

Run:

```bat
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic orders-topic --partitions 1 --replication-factor 1
```

Expected output:

```text
Created topic orders-topic.
```
---
## 9. List Topics

To verify that the topic was created:

```bat
kafka-topics.bat --bootstrap-server localhost:9092 --list
```
Expected output:

```text
orders-topic
```
---

## 10. Describe the Topic
We can check un commited or on unconsumed offset by using below command
![KAFKA_DESCRIBE](https://github.com/HarshaPrimeTrainings/sprinboot_ecomerce/blob/main/kafkadescribe.png)
To view the topic configuration, partitions, leader, and replicas:

```bat
kafka-consumer-groups.bat --bootstrap-server localhost:9092 --group notifications-group --describe
```
---

# Kafka Producer

## 11. Start Kafka Producer

Open another Command Prompt and run:

```bat
kafka-console-producer.bat --bootstrap-server localhost:9092 --topic orders-topic
```
The producer will wait for messages.

Enter:

```text
Hello Iam demo msg
```

Press **Enter**.

Then enter:

```text
Hello Iam demo msg
```
Press **Enter**.
Each line represents a message sent to the Kafka topic.
---

# Kafka Consumer

## 12. Start Kafka Consumer

Open another Command Prompt and run:

```bat
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic orders-topic
```

The consumer will listen for new messages.

Now send a message from the producer:

```text
Hello Iam demo msg
```
The consumer should receive:
```text
Hello Iam demo msg
```
---

## 13. Read Existing Messages

To read all existing messages from the beginning of the topic:

```bat
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic orders-topic --from-beginning
```

If the topic contains:

```text
Hello Iam demo msg
```

the consumer will display:

```text
Hello Iam demo msg
```
---

# Useful Kafka Commands

### List Topics

```bat
kafka-topics.bat --bootstrap-server localhost:9092 --list
```

### Create Topic

```bat
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic orders-topic --partitions 1 --replication-factor 1
```

### Describe Topic

```bat
kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic orders-topic
```

### Start Producer

```bat
kafka-console-producer.bat --bootstrap-server localhost:9092 --topic orders-topic
```

### Start Consumer

```bat
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic orders-topic
```

### Start Consumer from Beginning

```bat
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic orders-topic --from-beginning
```
---
# Kafka Trouble Shooting
```ERROR:  main ERROR Reconfiguration failed: No configuration found for '764c12b6' at 'null' in 'null'```
solution set KAFKA_LOG4J_OPTS=-Dlog4j.configuration=file:tools-log4j2.yaml