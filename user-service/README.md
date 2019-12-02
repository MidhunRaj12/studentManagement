# Deliverables
************************************************************PRE-REQUISITES************************************************************

1. Java 1.8
2. MySQL DB server
3. Apache Kafka
4. Deliverables folder from Gitlab
	a.	https://infygit.ad.infosys.com/librarymanamement/deliverables.git
	b.	git@infygit.ad.infosys.com:librarymanamement/deliverables.git

**************************************************************************************************************************************

**********************************************************Starting  Services**********************************************************

1. Execute the TableCreation_Entry.sql in the mysql DB(Includes Schema creation scripts)

2. Starting apache kafa
	a. Start the zookeeper at port 2181 - Refer zookeeper.properties in deliverables
		-	zookeeper-server-start.bat ../../config/zookeeper.properties
	b. Start the server in 9092 port - Refer server.properties in deliverables
		-	kafka-server-start.bat ../../config/server.properties
	c. Create a topic named LibraryBookTopic
		-	kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic LibraryBookTopic
		
3. Start the Eureka Service (java -jar EurekaServer-0.0.1-SNAPSHOT.jar)

4. Start the OAuth Service (java -jar LibraryOAuthServer-0.0.1-SNAPSHOT.jar)

5. Start the Books Service (java -jar BooksService-0.0.1-SNAPSHOT.jar)

6. Start the Members Service (java -jar MembersService-0.0.1-SNAPSHOT.jar)

7. Start the Zuul Service (java -jar ZuulServer-0.0.1-SNAPSHOT.jar)



**************************************************************************************************************************************
**************************************************************ENDS  HERE**************************************************************
**************************************************************************************************************************************