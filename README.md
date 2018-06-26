# Dodo rampup BE

## Environment Setup 

**Pre-requisites:**
- Maven installed and configured (Including proxy)
- SAP Maven repository added to settings.xml. Follow this [Documentation](https://nexus.wdf.sap.corp:8443/nexus/index.html#m2-settings-templates;default) or you can copy the file [maven-settings.xml](https://github.wdf.sap.corp/CloudSCAME/DodoRampup/blob/development/maven-settings.xml) and paste on 'C:\Users\I-NUMBER\\.m2' and rename it to 'settings.xml'

**Bootstrap:**
- Clone this repository
- On the console run `mvn clean install`
- Open Eclipse and import the project folder using the option: `Existing projects into workspace`
- Right-Click on the project and choose to run as a server, then select Java Web Tomcat 8
	- **Note**: Use the NEO SDK version 3.56.0.1, available here [neo-java-web-sdk-3.56.0.1.zip](https://tools.hana.ondemand.com/sdk/neo-java-web-sdk-3.56.0.1.zip)
- Create a user on the server
- Access the application at [localhost:8080/api/Users](http://localhost:8080/api/Users)

**Note**: If you want to run your application outside eclipse, you can alternatively check this [wiki page](https://github.wdf.sap.corp/CloudSCAME/DodoRampup-UI/wiki/Running-on-Neo-Console)
