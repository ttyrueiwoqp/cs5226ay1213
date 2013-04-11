1. Download and install JDK here: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html.
2. Download and install spring tool suite here: http://www.springsource.org/downloads/sts-ggts.
3. Unzip the src code.
4. Create db instance running in the dbtune server and set up a listener using lsnrctl.
5. Launch spring tool suite and import the project unzipped just now: File > Import > Maven > Existing Maven Project > browse and select the project folder > Finish
6. Look for the file ConnectionUtil.java. Amend the database url by replacing the port and id. Change dbtune2 to dbtune if yours in dbtune.
8. Drag and drop the project to the VMware vFabric tc Server at the bottom left, and run the server.
9. Right click on the deployed project > Open home page(http://localhost:8080/cs/). It will open the home page in the Spring Tool Suite.
10. Now the websites are ready to use.