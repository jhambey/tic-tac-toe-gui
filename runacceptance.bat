cd acceptance
javac -cp .;..\build\classes\main TicTacToeKeywords.java
java -cp .;..\build\classes\main;C:\Users\Jake\Documents\CS310\swinglibrary-1.9.5.jar org.robotframework.RobotFramework TicTacToeGUITests.txt
cd ..

