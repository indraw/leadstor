==Web Server Sketch Design=====
# leadstor
This is the source code repository and the architectural design document repository.

[Architecture]

We assume to use spring-boot as backend technique.

We use AngularJS as our frontend example right now.
Note: for non-AngularJS front-end tech such as PageMaker, Dojo etc ,there 
is no essential difference to backend viewpoint as we put the webui
as resources into our web server. We use AngujarJS as example only. 

-----note to front-end developer-----
We shall put our working web front-end code into $(backend)/src/main/webapp for the webserver to
map "/" from there. We shall work together to make sure your front-end be fitting here.

We use Apache Thrift as the interface between Java based Web server and our Storage OS (assume C++
based right now).  Please refer to subdirectory "/stos-intf" for further information.

-----note to storage OS developer-----
We use .Thrift file to define the contracting interface between Web Server and the whole Storage
system. We shall work together.

[Source Code]

A skeleten for us to implement features here.
A .thrift file defines only one API the wev server can call into storage system
