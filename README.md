# SOAP Web Service showcase

This is a Java 11 and Maven-based project that provides a SOAP client for fetching data using an injected SOAP web service.

## Installation

To install the project, run the following command:

`mvn clean install`

This will compile the project and create a JAR file that you can use to run the SOAP client.

## Usage

To run the SOAP client, use the following command:

`mvn exec:java -Dexec.mainClass="schrodlm.cz.App"`

This will start the SOAP client and fetch the data from the endpoint provided inside `SoapClient` class.
You can modify the code to use your own SOAP web service by injecting the appropriate endpoint URL and SOAP message.

## Dependencies

This project depends on the following libraries:

-     Java 11
-    Maven
-    **javax.xml.soap-api** (version 1.4.0)
-    **com.sun.xml.messaging.saaj.saaj-impl** (version 1.5.2)

These dependencies are automatically downloaded and managed by Maven during the installation process.

## License

This project is licensed under the MIT License. See the LICENSE file for details.