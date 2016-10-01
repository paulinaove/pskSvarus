# Java EE starter project
Project is based on *Maven*, thus import project to IntelliJ IDEA by:
* File -> Open... -> pick `pom.xml` file.

## Application Server configuration

### Apache TomEE
1. Download WebProfile, ZIP from: [http://tomee.apache.org/downloads.html](http://tomee.apache.org/downloads.html)
2. Unzip
3. Copy file `JavaEEstarter/system.properties` to `[tomee-install-directory]/conf`

### IBM WAS Liberty
1. Download and unzip: [WAS Liberty](https://developer.ibm.com/wasdev/downloads/#asset/runtimes-wlp-webProfile7)
2. Run: `wlp/bin/server create`
3. Register "WebSphere Server" application server in IntelliJ IDEA:
    * Press "Fix" to enable JMX
    * Press "Fix" again, choose "exploded war" as artifact
    * In tab "Deployment", For "Use custom context root" enter: **JavaEEstarter**
4. Run the server for the first time (it will fail - that is OK), then stop the server.
5. Open this file with text editor: `wlp/usr/servers/defaultServer/server.xml`, 
   add `classloader` and `library` tags:
```
    ...
    <application id="JavaEEstarter_war_exploded" ...>
        <classloader commonLibraryRef="h2" />
    </application>
    <library id="h2">
        <fileset dir="${shared.resource.dir}/h2" includes="*.jar" />
    </library>
</server>
```
6. Copy file `JavaEEstarter/target/JavaEEstarter-1.0-SNAPSHOT/WEB-INF/lib/h2-1.4.192.jar`
   to directory `wlp/usr/shared/resources/h2`
7. Start the server again: project should work fine now.