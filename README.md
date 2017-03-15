# Nulogy-Apprenticeship-Exercise
This repository contains my project, the solution for the NuPack System - A markup Calculation System for the products need to be repackaged

## Exercise Requirements 
Please refer to this [link](https://docs.google.com/document/d/1Fi_WrkQV6xD3zv8Q-uevjdQgO6-puNB3RR40o6_jREs/edit)

## Achievement
The achievement of the project is a calculation system for the final price of the products need to be repackaged with following features:
 - Validation for the input of a product(product name, base price, product material), packing service for this product (the number of people on packing job).
 - Calculation for final price base on the entered information and the predefined percentages of flat markup, material markup and labor markup.
 - Print out all information of repackaged product (product name, product material, product base price, the number of people on packing job and calculated final product price).
 - The base price and final price will be output with the format of the local currency which user defines in "service.properties"
 	- __price.currency.country__: the country(default is ca: Canada)
 	- __price.currency.country.language__: the spoken languge in the country(default is en: English)
 
## Installation
### Prerequisites
- __Java Runtime versions__: [JavaSE-1.7](http://www.oracle.com/technetwork/java/javase/downloads/java-archive-downloads-javase7-521261.html)

### Running from the command line
- Please get the jar file from the [link](https://github.com/anhit07/Nulogy-Apprenticeship-Exercise/blob/master/jar/Nupack-System.jar):
- Run from command line:
Change into the folder where the git clone command will create. Ex: $ cd NupackSystem
    - Then run with command: 
	- __Option 1__: Without specifying the System Property(user.path)
	$ NupackSystem>__java -jar Nupack-System.jar Arguments__
        - The Arguments are following the order of (ProductName ProductMaterial BasePrice NumberPeoplePackingJob): 
		- __ProductName__: the product name
		- __ProductMaterial__: the material of the product which is one of sub types of pharmaceutical, food, electronics or others
		- __BasePrice__: the base price of the product
		- __NumberPeoplePackingJob__: the number of people on the packing job of this product
		
		Ex: $ NupackSystem>__java -jar Nupack-System.jar productA food $1,299.99 3__

	- __Option 2__: With specifying the System Property(__user.path__)
		If the user wishes to change the Markup Percentages or the sub types of Product Material (belongs to the group pharmaceutical, food or electronics), 
		The user can download and change in the file __[services.properties](https://github.com/anhit07/Nulogy-Apprenticeship-Exercise/blob/master/jar/services.properties)__

		Then run with the following command with __dirPath__ is user's directory path of properties file:
		
			$ NupackSystem>java -Duser.path=dirPath -jar Nupack-System.jar Arguments
			Ex: $ NupackSystem>java -Duser.path=C:\Users\user\Java\resource\ -jar Nupack-System.jar productA food $1,299.99 3
			
## Design 
Please refer to and download from this [link](https://github.com/anhit07/Nulogy-Apprenticeship-Exercise/blob/master/Design%20Documents/Feature%20Specification.doc)

## Source Code and Unit Testing
### Built with
- __Eclipse__ - [Java Integrated Development Environment (IDE)](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/keplerr)
- __Maven__ - [Dependency Management](https://maven.apache.org/)
- __JUnit-4.1__ - [Unit testing framework](http://junit.org/junit4/)

### Running and Testing from the Eclipse
- Please download __[source code](https://github.com/anhit07/Nulogy-Apprenticeship-Exercise/tree/master/NuPack-System)__ to the Eclipse Workspace
- Then import the source code to Eclipse with Maven project type (File-> Import-> Maven-> Existing Maven Projects) and browse to folder of source code
