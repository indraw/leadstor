# leadstor
This is the source code repository and the architectural design document repository.
Web Server Sketch Design.

# Architecture

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

# Source Code

A skeleten for us to implement features here.
A .thrift file defines only one API the wev server can call into storage system

# Restful API 设计
Front-end sends JSON objects to backend to do CRUD (creating, reading, updating, deleting) of objects. 

For AngularJS, the javascript function to call backend API is $http
For JQUERY, the javascrit function is $ajax
There are other things in other tool suites. 
The front-end calls backend specifying JSON in JSON out, checks HTTP status code and parse the JSON content it returned if any. 
The front-end could also set up some synchronous/asynchronous mode with callbacks to wait for backend to return.

1. 卷操作

1.1 产生卷

URL:   /v0.1/volume/{volname}

HTTP header cookie: user

Verb: post

Body: 
{ "volname": "name", 
"size":"size-MB", 
"description":"", 
"policyid":"id",
"accessControl":"initiator-group|chap",  // optional
"shapshotSchedule":"string-id",   // optional
} 
// policy: combination of block size, compress, caching etc. performance policy ID.

Return http status: 200 if ok
       non-200 with error/exception codes if errors. 

Return Body: always empty

1.2 读卷

URL:   /v0.1/volume/{volname}

HTTP header cookie: user

Verb: get

Body: not allow, must be empty

Return http status: 200 if ok
        non-200 with error codes if errors. 

return HTTP body if 200: 
{"volname":"name", "size":"size-MB", "description":"",
"usage":"usage-MB", "policyid":"id", "cacheMetaSize":"size-MB", "cacheDataSize":"size-MB",
"cacheHitRate":"percentage", "snapUsage":"size-MB", 
"PerfPeriod":"seconds", "PerfSamples:"how many data points",
"throughput":[{"readKBPS":"int", "WriteKBPS":"int"},...],
"iops":[{"readIOPS":"int", "writeIOPS":"int"},...],
"latency":[{"readLatency":"microseconds","WriteLatency":"microSeconds"},...],
"stauts":"online|offline",
"accessControl":"iscsi-group-id",
"shapshotSchedule":"string-id"
}

1.3 删除卷

URL:   /v0.1/volume/{volname}

HTTP header cookie: user

Verb: delete

Body: not allow, must be empty

Return http status: 200 if ok
        non-200 with error codes if errors. 

return HTTP body if 200: {"volname":"name", "size":"size-MB", "description":"",
"usage":"usage-MB", "policyid":"id", [{},{},{}]}

1.4 改变卷

URL:   /v0.1/volume/{volname}

HTTP header cookie: user

Verb: put

Body: { "volname": "name", "size":"size-MB", "description":"", "policyid":""} 
// policy: combination of block size, compress, caching etc. 

Return http status: 200 if ok
       non-200 with error/exception codes if errors. 

Return Body: always empty

