# Refactoring Brief

I have 3 solutions for this refactoring.

## Refactoring steps

1. Extract countEven(numbers) to make it independently
2. Create a new EvenCounter class and move countEven(numbers) in
3. Same operations for other countX methods
4. Change all methods to count in Counters
5. Extract the if conditions to another methods so that the count methods in Counters are same
6. Extract abstract class with count - Template Pattern done
7. Move count back to NumberCruncher and change Counter to interface - Strategy Pattern done

### Author 

Heaton
tcai@thoughtworks.com

You can see the git history [here](https://git.thoughtworks.net/tcai/refactoring-4)