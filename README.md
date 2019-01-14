# MKS21X-FinalProject
Welcome! This is our final project for AP Computer Science Fall Semester!

# What do I do with these amazing Java files besides read them? (Instructions)

# Development Log
01-03-2019: Creation of the Repository                                                                                                      
Victoria: I created the Board and Tile classes. I also added the variables(fields) that we will be using to both classes, along with the accessor methods in the Tile class.

Jionghao: I created the rest of the methods in the tile class.

01-04-2019:                                                                                                                                
Victoria: I worked on the constructor in Board.java, specifically on what to do during Normal Mode and the easy level.

01-05-2019:                                                                                                                                
Victoria: I finished working on the Normal and Crazy mode parts for the easy level in the constructor. I also added the code for the toString method that Jionghao and I worked on in class on 1/04.

Jionghao: i added the ascii art for the welcome and gameover page.

01-06-2019:                                                                                                                                
Victoria: I corrected the Ascii art to be printed out correctly, added the hard levels in the constructor, and added 3 new variables: level, numberOfChances, and numberOfBombsClicked.

Jionghao: I added number of bombs and bombsaround method.

01-07-2019:                                                                                                                                
Victoria: I incorporated the lanterna imports by using Mr. K's TerminalDemo from class. I added the characters that we will be using as unicode characters and what happens when the enter key is hit (the tile may or may not be revealed, depending on whether it was revealed before). I also created a new branch to experiment with and comment on the TerminalDemo code from class.

Jionghao:I added the menu demo and a victory ascii art. i also added the flag and pause button.

01-08-2019:                                                                                                                                
Victoria: I added more comments to the TerminalDemo, which is now called Main. I corrected the backslashes in the victory message and debugged Main so that it would compile because it compiled yesterday but not today in class. Jionghao and I had some difficulty pushing his files from the school's computer and that took a few commits, but then we successfully got it pushed to GitHub.

Jionghao: I added branch bombaround to develop the method numberofbombsaround, found two different ways to go but unsure which to use yet, might need to use a 2d array instead to save the locations of bombs.

01-09-2019:                                                                                                                                
Victoria: I moved numberOfBombsAround to the Board class in order to use layout.length. I also created a new variable in the Tile class to help me with finding the number of bombs around a specific tile by using division and %.

Jionghao: I added printouts in the terminals for the different modes of the game, But the cursor is teleporting around.

01-10-2019:                                                                                                                           
Victoria: I finished numberOfBombsAround by splitting it up based on where the tile was located (first row, last row, first column, last column, in a corner, etc.). My version of Main.java does not leave a character behind when the arrow keys are clicked but in the CS Lab Jionghao's version did and we tried to figure out why. We started comparing our versions in class.

Jionghao: my version of Main.java still prints out a white character trail, i tried to instantiate a Board with different modes to test printouts.

01-11-2019:                                                                                                                                                                                                                                              
Victoria: I created a new branch to test the cursor movement. Currently, when the f key is pressed, the flag character only appears in the corner of the board. I also added some more comments to Main.java to make our commands/actions clearer.


01-12-2019

Jionghao: I worked on the printout of the board and a way to add a number on the tile to show the number of bombs.

Victoria: I created a new file called Test.java to test out the Console as a way to let the user type the mode and level they want to play. I tried experimenting with opening Main.java and running it based on the results of the user's input but then I couldn't type anything into the terminal. However, I did change the toString in Board so that I can see whether the correct Board is getting printed out.



01-13-2019

Jionghao: I created a new file with a simpler version of Minesweeper that doesn't use lanterna. Maybe we don't need it?

Victoria: I extended on Jionghao's idea and created 2 more files to do the board methods and to run the board. SUCCESS! I used the scanner because originally I wanted to call another java file from a different java file, but then realized that I was overcomplicating it.
