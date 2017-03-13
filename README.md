# Nulogy-Apprenticeship-Exercise
This repository contains my project answering for Nulogy Apprenticeship Coding Exercise 

## Exercise Requirements 
Please refer to this link:

[https://docs.google.com/document/d/1Fi_WrkQV6xD3zv8Q-uevjdQgO6-puNB3RR40o6_jREs/edit]

## Achievement
The achievement of the project is a calculation system for the final price of the products need to be repackaged with following features:
 - Validation for the input of a base product(product name, base price, product material), packing service for this product(the number of people on packing job).
 - Calculation for final price base on the entered information and the defined percentages of flat markup, material markup and labor markup.
 - Print out all information of repackaged product(product name, product material, product base price, the number of people on packing job and final product price).
 - The entered base price and final price will be output with the format of the local currency which user defines in "service.properties"
 		* 1. price.currency.country: the country(default is ca: Canada)
 		* 2. price.currency.country.language: the spoken languge in the country(default is en: English)
 
## Installation
### Prerequisites
	- Java Runtime versions: JavaSE-1.7
	- Dependency Management: Maven
	- Unit testing version: junit-4.12

### Running from the command line
	- To get the jar file: 

		[https://github.com/anhit07/Nulogy-Apprenticeship-Exercise/blob/master/jar/Nupack-System.jar]

	- To run from command line:
		Change into the folder where the git clone command will create. Ex: $ cd NupackSystem

		Then run with command: 
		*Option 1: $ NupackSystem> >**java -jar Nupack-System.jar Arguments**
		The Arguments are following the order of productName ProductMaterial BasePrice NumberPeoplePackingJob: 
			- **productName**: the product name
			- **ProductMaterial**: the material of the product which is one of sub types of pharmaceutical, 
			food, electronics or others
			- **BasePrice**: the base price of the product
			- **NumberPeoplePackingJob**: the number of people on the packing job of this product

		*Option 2: 
		If user wishes to change the Markup Percentages or the sub types of Product Material(belongs to 
		the group pharmaceutical, food or electronics), 
		the user can download and change in the file **services.properties**

		To get the properties file: 

			[https://github.com/anhit07/Nulogy-Apprenticeship-Exercise/blob/master/jar/services.properties]
		
		Then run with command specifying the System Property(user.path) is the user's directory path of properties file:
			$ NupackSystem> >**java -Duser.path=dirPath -jar Nupack-System.jar Arguments**
			Ex: $ NupackSystem> >**java -Duser.path=C:\Users\user\Java\resource\ -jar Nupack-System.jar Arguments**
			
## Design 
Please refer to this link:

## Source Code
Please refer and download from this link:
	[https://github.com/anhit07/Nulogy-Apprenticeship-Exercise/tree/master/NuPack-System]

## Built with
	**Eclipse** - Java Integrated Development Environment (IDE)
	**Maven** - Dependency Management
	**JavaSE-1.7** - Java Runtime Environment (JRE)
	**JUnit-4.1** - Unit testing framework 