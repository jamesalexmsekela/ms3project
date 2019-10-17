# ms3project

#### Purpose of repositiry:

The purpose of this repository is to house an application that reads off of a given csv file and proceeds to write relevant information into a database. Information not written to the database is in turn written to a csv file containing data entries that did not satisfy the requirements necessary to be added to the aforementioned database.

### Steps to get the application running

In order to run the application make sure all relevant files are stored within a resonable file hierarchy. The main driver is the csvReader.java file. As such, in order to run the application users must open the csvReader file. There they will find the main function and execution code. If opened on an IDE the user can simply run the program after having specified the csv file from which to read, in which case the program will first create the database file, bad csv file, and finally the log file, after having populated the aforementioned db and csv file. If opened on a source code editor, users must simply compile and run the csvReader file, in which case the same series of event will occur. 
