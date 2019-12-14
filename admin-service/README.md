# studentManagement
Aplication to manage student details
************PRE-REQUISITES************
1.Java 1.8
2.MySQL DB server
3.Apache Kafka
https://github.com/MidhunRaj12/studentManagement/

************Starting Services************
1.Execute the TableCreation_Entry.sql in the mysql DB(Includes Schema creation scripts)
2.Starting apache kafaa. Start the zookeeper at port 2181 - Refer zookeeper.properties in deliverables- zookeeper-server-start.bat ../../config/zookeeper.propertiesb. Start the server in 9092 port - Refer server.properties in deliverables- kafka-server-start.bat ../../config/server.propertiesc. Create a topic named AttendanceTopic- kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic AttendanceTopic
3.Start the Eureka Service 
4.Start the OAuth Service 
5.Start the Admin Service 
6.Start the User Service 
7.Start the Zuul Service


************ENDS HERE************
