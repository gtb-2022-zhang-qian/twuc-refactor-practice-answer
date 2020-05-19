# Refactoring Brief

Refactoring list

1. fixing test before any refactoring
2. rename names of methods and some parameters
3. clear up codes such as format and optimize imports
4. inline methods and remove useless getting methods
5. use enum instead of constants
6. use polymorphism instead of switch
7. move logic around to remove feature envy so that eliminating more getting methods
8. use steam.map to remove for loop
9. extract methods instead of having variables
10. remove += for strings
11. immutable some fields such as customer name and movie title

Couple things for tests
1. remove unused tests
2. use new io
3. rename test names to be more meaningful

PS: movie.setPriceCode(REGULAR) could be changed to theatersPassed() with no parameter. But did not change here since it is a public method 

### Author 

Heaton
tcai@thoughtworks.com

You can see the git history [here](https://git.thoughtworks.net/tcai/refactoring-6)