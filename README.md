# ms3project

#### Purpose of repositiry:

The purpose of this repository is to house an application that reads off of a given csv file and proceeds to write relevant information into a database. Information not written to the database is in turn written to a csv file containing data entries that did not satisfy the requirements necessary to be added to the aforementioned database.

#### Steps to get the application running

In order to run the application make sure all relevant files are stored within a resonable file hierarchy. The main driver is the csvReader.java file. As such, in order to run the application users must open the csvReader file. There they will find the main function and execution code. If opened on an IDE the user can simply run the program after having specified the csv file from which to read, in which case the program will first create the database file, bad csv file, and finally the log file, after having populated the aforementioned db and csv file. Mind you, witihin the csvReader.java class file is a funciton that actively prints the first 2 elements of every entry made into our database. If opened on a source code editor, users must simply compile and run the csvReader file, in which case the same series of event will occur. 

#### Overview & approach

For the application I decided to work on the eclipse IDE. I figured this would be the best decision due to the ease of connection between the IDE and the relevant sqlite jdbc API. I created a total of 2 class file; csvReader, and sqliteFuncs. Within the sqliteFuncs class file I created all the relevant database functions including; startConnection, a function in charge of establishing a connection to our database, displayContents, a function mostly for debugging purposes that queries into our database and returns the specified information, initialize, a function in which the database’s table is created and prepared, and addUser, a function in which users are added to our database as specified by given parameters. Within the csvReader class file I read in the contents of some specified csv file. I then proceed to parse this information and enter it into either our database, or a csv file containing “bad” records/entries (entries are “bad” when they do not have the “right” number of elements). After having populated the database and our csv file, I then create a log file in which it prints relevant statistics.

##### Sources utilized 

https://www.tutlane.com/tutorial/sqlite/sqlite-java-tutorial

https://www.youtube.com/watch?v=h1rYlMrvNyE

https://stackoverflow.com/questions/18093928/what-does-could-not-find-or-load-main-class-mean

https://www.sqlitetutorial.net/sqlite-java/create-database/

https://www.youtube.com/watch?v=JPsWaI5Z3gs
