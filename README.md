# Team11: Galaxy Fighter
This is the game of our game Galaxy Fighter repository for CPSC 233, Summer 2019.</br>
This game is **based** on the **Space Invaders Original** game and it will be a simple animation game. The game will be written in **Java** as part of our project for CPSC 233 and will be written by a group of four students who are beginning to learn this language.</br>

## System Requirments
To be able to play this game a **Java JDK 8 System** is required. <a href  = "https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html"> Click Here </a> to download a the Java System. </br>

## Game Installation
1) Go to the Code Repository under the <a href = "https://github.com/chadigarzeddine1/SpaceInvadersTeam11">Main branch </a> </br>
2) Download the files under the main branch as a ZIP file </br>
3) Extract files from ZIP file </br>
> Could look like any of this two: </br>
\Users\Username\Downloads\SpaceInvadersTeam11-master </br> 
\Users\Username\Downloads\SpaceInvadersTeam11-demo3  </br>

### Terminal
1) Open the computer's terminal </br>
2) Locate the repository you downloaded inside the terminal </br>
> Terminal: cd Download\SpaceInvadersTeam11-master </br>
3) Compile: javac Launcher.java </br>
4) Run: java Launcher </br>

### Eclipse
1) Download the files from the GitHub **Master** repository</br>
2) Keep the files on Downloads file </br>
3) Enter Eclipse and create a "New Project" under the "File" button </br>
4) Name it as you wish </br>
5) Go to Import --> General --> File System &#8594; Browse --> Downloads --> SpaceInvadersTeam11-master --> src </br>
6) Import every file from the src folder to the game </br>
7) Go to the laucher class left click and go to "Run As" then **click** on Java Aplication </br>

## Test Class
For this game we have decided to create a Test classes for the java classes **Game**,**Data** and **Window** </br>
Download <a href = "https://d2l.ucalgary.ca/d2l/le/content/265995/viewContent/3507819/View"> JUnit 4</a> and <a href = "https://d2l.ucalgary.ca/d2l/le/content/265995/viewContent/3507818/View"> Hamcrest</a> </br>
1) To be able to test any of the classes both **JUnit 4** and **Hamcrest** are needed </br>
2) Put junit-4.12.jar and hamcrest-core-1.3.jar in a folder </br>
3) Make a copy of **one** of test class inside the same folder you inserted JUnit and Hamcrest</br>
4) Add the **class you choose** to the folder with the JUnit 4, Hamcrest and the test class
5) Compile: </br>
> For this we choose to show the class **Game** to be tested </br>
> Mac: javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar * Game.java  </br>
> Windows: javac -cp .;junit-4.12.jar:hamcrest-core-1.3.jar * GameTest.java  </br>

6) Run: </br>
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
- Improvements to the game movement </br>
</br>

**v3.0** </br>
- Score board added </br>
- Different Levels (2 at the moment) </br>
- Slower movement and shooting for both enemy and player </br>
</br>

**Final Version**
- Menu Screen and Game Over Screen added </br>
- Total of 16 levels </br>
- 5 Different Types of Aliens </br>
- Abilitiy to Pause Game: exit game or replay game buttons </br>
- Smoother movement and shooting from both player and alien </br>
- Game Screen Shows: Time, Expected Time, Accuracy, Enemies Killed, Final Score </br>
- Extra Points: if level is beaten in less than time expected or had good Accuracy </br>

## Made By:
William Nguyen </br>
Mohamed Mohamed </br>
Chadi Garzeddine </br>
Marco Arias </br>
