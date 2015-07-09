Startup project for webui

[Architecture]
We assume to use spring-boot + AngularJS as our backend/frontend. This uses the most
recent front technique and also cloud ready. (Spring-boot is more entrpeise heavier
than node.js. Nimble mostly based on AngularJS).

[Demo project]
Our demo project is about maintainence of contacts cards.
The demo project currently shows:

(Part -A)  Back-end, Spring-boot
 0. Start a project (Maven & Spring Boot)
 1. Develop the business (Spring Core, JUnit)
 2. Persist data (Spring Data JPA, Hibernate)
 3. Make a REST service (Spring Web MVC, REST services)
    This is important for test automation
 4. Validate the inputs (Bean Validation, Hibernate Validator)

(Part -B)  Integration of AngularJS
 5. View by AngularJS (AngularJS)

(Part -C) front-backend advanced co-dev
 6. Upload a photo (common-fileupload)
 7. More secure (Spring Security)
 8. DB Migration (Flyway)

(Part -D) Advanced topic.
 9. Production-ready (Spring Boot Metrics, Health, Tracing, Remote Shell)
 10. Deploy the application ('fat' JAR file, WAR file)

As the result, the whole back-end and its integrated webui front-end shall be running 
as a separated demo.
When you receive the tar file, you extract and see:
lliu@lliu-VirtualBox:~/jianding$ ls -ltr
total 20
drwxrwxr-x 3 lliu lliu 4096 May 10 09:49 etc
drwxrwxr-x 4 lliu lliu 4096 May 10 09:49 src
-rw-rw-r-- 1 lliu lliu 3241 May 10 09:49 pom.xml
drwxrwxr-x 8 lliu lliu 4096 May 10 09:50 target
-rw-rw-r-- 1 lliu lliu 1142 May 10 09:57 README.md
Do
lliu@lliu-VirtualBox:~/jianding$ java -jar target/contact.jar 
to start the service on port 8080. Assume you start it on host named "localhost"
Note: start the service exactly in the extracted directory as it accesses data from ./etc
Use your web brower access http://localhost:8080 to check the webui.
Use user/password admin/admin123 to log on.
-Note:Assume you shall use the latest Java 1.8.
-Note:the directory "target" is the temporary build directory each time erased and generated,
I assume you could have difficulty to make build as accessing many libraies to fit into one fat war file.
OR takes long to build. So I keep target directory for you. The final build system shall do build,
though these libraries downloading is one-time (how fast dependent on network speed and China firewall),
Shall address later if anything related to build broken. 

[Things not done yet]
a) Wiret Apache Thrift communication module to define protocol and 
thus generate java stub, and c stub modules
honor the same protocol, therefore enable spring-boot backend java code to be able to talk
with native c language libraies and vice verse. For example, listen to event streams
This shall create libraries of java, c, (python, c++, ... if you like) that speak the same
data binary potocol based on tcp/ip.
The Java shall be hooked up into spring-boot.
The C shall be hooked into Storage OS.

[Plan]
Hire: 
As we have UX design to copy we need solid GUI only.

hire a good AngularJS expert to design front-end. This is kind of puzzle to me, as we need
front-end people for one time-as GUI is done, you have no use. Here mostly of time it is
done as consultant service. I would suggest you go this route to issue contract. Though this
could attribute to management difficulty. 

back-end people. As I am expert in cloud/spring-boot, shall train some guy. Will consider.

