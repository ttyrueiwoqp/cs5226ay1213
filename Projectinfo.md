How to change the time to take statics:
http://orabackus.wordpress.com/2008/01/25/modifying-awr-automatic-snapshot-settings/

http://docs.oracle.com/cd/B19306_01/server.102/b14211/autostat.htm#i26958



Other info:

Also check the "Shared Pool Statistics", if the "End" value is in the high 95%-100% range ,this is a indication that the shared pool needs to be increased (especially if the "Begin" value is much smaller)

http://www.pafumi.net/AWR%20Reports.html


Login as sysdba:

http://www.idevelopment.info/data/Programming/java/jdbc/ConnectionOptions.java

How to change system password:

1 use ssh open sqlplus: sqlplus / as sysdba
2 type:  passw system
3 follow the step to modify the password