# Inventory Management System
I am required to design and create an application using the Programming fundamentals module, this will be able to interact with a managed database. The application should utilise of supporting tools, methodologies and techniques that encapsulate all modules which have been covered during the 5 weeks of training.
## Getting Started 
### Prerequisites

```
Java 1.8 +	
Maven
MySql

```

### Installing
A step by step of the examples listed above, which will let others how to get a development environment running.
Java install
To build and run this project, Java version 8 is needed for this project.
Once you have installed Java, you will need toad JAVA_HOME (exactly like this) to the system variables. Where “%JAVA_HOME%/bin”, needs to be added to the system PATH.

### Maven install
To install maven, you need the latest version of maven. 
[Maven](https://maven.apache.org/) - A link to down it from

```
M2_HOME
```

The example aboive will show you the install location of maven that needs to be added to the system variables, to insure that you will need to add %M2_HOME%bin; is needed to be added to the system PATH.
After this step, you are able to install the IMS on your computer system.
Mvn install
The command line above will install a jar file of the IMS into the .M2 file onto the computer you are using, here it can be used from the command line.

## Running the test
### Unit tests
When doing unit testing, it is used to perform on methods that will need to be called by another function. This is so that each method that is created within your application can be tested independently without having possible issues being forwarded from another method.
The user will need to open the command line, when opened they will need to find there way to the project folder. Here they will need to run the following command.
```
Mvm test
```
This command will run all the unit test in the project within the project. Jococo would have produced tests and also store them within your project folder. The reports that are produced by Jacoco can be used to confirm that everything has been set up correctly, it will assume to be working if the test pass for the unit functionality.
### Integration tests
Integration testing is uses a plug-in called Mockito which can ‘Stub’ connections to other methods. Mockito will basically mock what will need to be returned, this allows for the user to have full functionality testing by having values which are known over multiple methods.
Mvn interation-test 
###Coding style tests

## Deployment

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning
We use [SemVer](http://semver.org/) for versioning

## Authors
* **Harjeevan Jagpal** – Initial Work – [HJagpal1](https://https://github.com/HJagpal1/IMS-Project) 
## License
This project is licensed under the MIT license – see the LICENSE.md fil for details.
## Acknowledgements
* **Chris Perrins** - [christophperrins](https://github.com/christophperrins) - Provided template and Helped with code 
* **James Williams** – [jawilliams24](https://github.com/jawilliams24) - Helped with code
* **Samuel White** – [SamWhite745](https://github.com/SamWhite745) - Helped with code
* **Daniel Waughman** – [dannywaughman](https://github.com/dannywaughman) - Helped with code

