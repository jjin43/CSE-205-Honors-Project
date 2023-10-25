Justin Jin

CSE 205 @ 11:15 M W F
Honors Contract

29 April 2022
Honors Project Documentations
```
a. Detailed description of your project
This game is a digital version of the Black jack casino game. There is the
player, and there is the dealer (house). The player inputs an amount of chips to bet
for each round, where if the player wins, they get the amount they betted, if they
lose they lose that amount. How many chips the player starts with, and the
number of decks used in each game can be changed by the player in the main
menu. This game default use a total of four decks, and only reshuffles when the
deck runs out, NOT when the player continues a new round, making card
counting (a Black Jack win strategy using math) totally possible and actually quite
simple. This game can be used to practice card counting, and the player can
increase the difficulty by increasing the number of decks.
Game play wise, the goal is to get a card value as close to 21 as possible
without going over. Where the dealer draws 2 cards first, checks if it’s a black
jack, if it is, then unfortunately the player instantly loses. If it isn’t, the dealer
reveals 1 card to the player, and then it’s the player’s turn to draw. The player
draws 2 cards, both revealed, then they can choose to hit or stay. If the player
busts, the player loses. Else, the player’s turn ends. The house then reveals the
2nd card and starts drawing and stops on 17, which mean they draw until the
cards value 17 or more. Then the cards are compared, and who’s ever card is
closer to 21 wins.
```

```
b. List of Java programming language features (see list above) that your project uses.
Encapsulation & Data Hiding
Composition (Class Cards -> Class GameOn)
Big – O (Efficiency Optimizations)
Stack (Creating the shuffled four decks of cards)
Inheritance (DealerCards extends Cards)
Interface (Cards & Dealer Cards both implements InterfaceCards)
```
```
c. List of any third party libraries that you used (if any).

None Used
```
```
d. Basic instructions for users of your program.

Once the program is started, a main menu with all the options are shown, pick the
indicated numbers for each selection. “Quit” quits the program, self-explanatory. “Tutorial”
shows information of how the game is played. “Change Default Chip Amount” changes the
amount of chips the player starts with. “New Game” starts the game.

First the player needs to enter the amount of chips they want to bet this round. Then the
the cards are printed, where unless it’s a 21, where the player instantly loses. The cards printed
includes the dealers 1 shown card and 1 hidden card, and the player’s 2 cards. The player can
then choose to “Hit or Stay” by entering “H” or “S”, this is repeated until the player busts or
stays. if the player busts, the dealer will still draw till 17, to show what the player if they would
win if they didn’t bust. If the house busts when attempting to draw to 17 they instantly loses. If
the player win, they gain the amount of chips betted, where they lose it if they lose.
```
```
e. Basic log of the time you spent working on the project (over the course of the semester) and
what you did during that time (i.e. research, requirements, design, coding, testing & debugging,
etc.)

0.5 hours – checking what features and methods the program needs.
1 - 2 hours, - designing and outlining the program.
8 hours – coding and implementation
1.5 hours – testing special cases
4 hours – debugging / Optimizations
1 hours – additional features, interface design
1 hour – Documentation
Total = 17-18 hours
```
```
f. Two to three paragraphs describing what you feel are the most important things that you
learned from working on this project, and any advice that you would offer to future students
wishing to do an Honors project in this course.

I feel I really learned how to design programs a lot better, as having a good base plan of
what functions and how many classes are needed really makes the later coding a lot smoother. I
also, I learned how to optimize my code using the big-O, like if a code will run 14n times, and if
I add some sort of pre-condition that makes it only run n times, it will make the code faster;
probably irrelevant at this level of coding, but it’s a satisfying process, as least for me. The most
valuable thing about the honors project is it makes me feel a lot more comfortable with coding,
as I’m confident that if someone gives me a random prompt to make a program on, if it’s not that
hard, I know I can make it. So overall, I thought this Honors project was a pretty positive
experience.

For future students who wants to do a Honors Contract, first of all it’s important to start
early. This project took me a lot longer than I expected. Also, make sure that you are including
enough of the course material. I realized I didn’t have that many course material covered halfway

through, and had to rewrite and retest a lot of the code to add more material. Lastly, make sure
you know your abilities. Take on a project that you are interested in, and isn’t too difficult for
you. Try to come up with a general plan of how a program would be implemented before you are
set on a project idea. But that’s about it, just have fun with it, and it’s honestly a pretty
entertaining and educational project.
```
