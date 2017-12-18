# Distributed-File-System


4 Implemetation for Distributed System:
## Distributed Transparent File Access
## Directory Service
## Replication
## Lock Service

: Distributed Transparent File Access:
Its REST based system in java that provides access to files on the Server and perform download and upload operation. 


: Directory Service:
Directory service is responsible to pull and push and maintain data from MySQL: machine IP, file identifier, file read status and location. It helps to keep track of files status i.e. weather read or right state.


: Lock Service:
Maintains the state of operation on file state, based on the action requested on any particular file by retrieving current status from the Directory service which maintains the status by 0 or 1 depending on whether file is in read or write state respectively.


Replication:
Replicate and maitains the file structure upon the servers.




