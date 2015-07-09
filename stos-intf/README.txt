This is the Apache Thrift Interface between web back-end server(java) 
and the Storage OS (C++) side. 

[Apache Thrift 0.9.2]
Assume you have installed Apache Thrift 0.9.2 the newest version.
You can download the source from its website and install necessary dependences
and do 
./configure
make install
to make thrift tool. You may have to do "sudo" for make install.

[Protocol file]
The protocol is defined as file "CreateVolume.thrift".
There is only one data structure holding arguments of creation of volume
There is only one service named "CreateVolume"

[Generate java and C++ code]
do "thrift --gen java" to generate java code.
after doing this the directory "gen-java" is created with couple of files.
do "thrift --gen cpp" to generate cpp code.
after doing this the directory "gne-cpp" is created with couple of files. 

[Thrift server side]
Go to "gen-cpp" directory, and do "g++ *.c -lthrift" you get a.out file.
You see the server_skeleton file and realize it carries a server.
run your a.out file----it may ask you for some libthrift.so--you can set
proper LD_LIBRARY_PATH to satisfy it. Like me:
Now you have the thrift server listening to port 9090.

[Spring Source, web backend Java client Side]
You copy the directory of files into $backend/src/main/java.
I also added a simple clien called ThriftClient.java
That file is a service for autowiring. Thus when from GUI
as end user clicke "create volume", it shall call create/update
function to backend and further call create volume service,
thus reaches to the a.out backend.
