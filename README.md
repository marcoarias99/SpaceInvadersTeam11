# Team11: Galaxy Fighter
This is the game of our game Galaxy Fighter repository for CPSC 233, Summer 2019.</br>
This game is based on the Space Invaders Original game and it will be a simple animation game. The game will be written in **Java** as part of our project for CPSC 233 and will be written by a group of four students who are beggining to learn this language.</br>

## System Requirments
To be able to play this game a **Java JDK 8 System** is required. <a href  = "https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html"> Click Here </a> to download a the Java System. </br>

## Game Installation
1) Go to the Code Repository under the <a href = "https://github.com/chadigarzeddine1/Team11">Main branch </a> </br>
2) Download the files under the main branch as a ZIP file </br>
3) Extract files from ZIP file </br>
> Could look like any of this two: </br>
\Users\Username\Downloads\Team11-master </br> 
\Users\Username\Downloads\Team11-demo3  </br>

### Terminal
1) Open the computer's terminal </br>
2) Locate the repository you downloaded inside the terminal </br>
> Terminal: cd Download\Team11-master </br>
3) Compile: ./gradlew build </br>
4) Run: ./gradlew run </br>

## Test Class
For this game we have decided to create a Test class for the java class **Library** </br>
Download <a href = "https://d2l.ucalgary.ca/d2l/le/content/265995/viewContent/3507818/View"> JUnit 4</a> and <a href = "https://d2l.ucalgary.ca/d2l/le/content/265995/viewContent/3507818/View"> Hamcrest</a> </br>
1) To be able to test this class both **JUnit 4** and **Hamcrest** are needed </br>
2) Put junit-4.12.jar and hamcrest-core-1.3.jar in a folder </br>
3) Copy test code inside the folder </br>
4) Compile: </br>
> Mac: javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *Library.java  </br>
> Windows: javac -cp .;junit-4.12.jar:hamcrest-core-1.3.jar * Library.java  </br>

4) Run: </br>
> Mac: java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore Library  </br>
> Windows:  java -cp .;junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore Library  </br>
  
### Controls
- Press **"left"** or **"right"** arrows on the keyboard for **movement**  </br>
- Press the spacebar to **"shoot"**  </br>

## Versions
**v1.0** </br>
- Text Based Version of the game</br>
</br>

**v2.0** </br>
- Incorporation of the GUI </br>
- Imporvements to the game movement </br>
</br>

**v3.0** </br>
- Score board added </br>
- Different Levels (2 at the moment) </br>
- Slower movement and shooting for both enemy and player </br>
</br>

**Final Version**
- NOT SUMBITTED YET

## Made By:
William Nguyen </br>
Mohamed Mohamed </br>
Chadi Garzeddine </br>
Marco Arias </br>

