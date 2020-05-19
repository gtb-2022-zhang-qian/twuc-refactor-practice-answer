twu-refactoring
===============

Refactoring exercises for the TWU

Here are some of the learning we want to drive with the exercises. There are no pre defined solutions for these exercises since they can evolve in many different ways.

### Exercise 1

The key learning here is on clean code and small refactorings like renaming, extract method and move method. Some code code smells here are:
- name of the attributes in all classes (refactoring: Rename)
- the large method inside `OrderReceipt` with code comments (refactoring: extract method)
- the feature envy of `OrderReceipt` against `Order` and `LineItem` (refactoring: move method)
- the for loop inside `OrderReceipt` does more than one thing (refactoring: extract method, split loop)

### Exercise 2
The exercise shows a very large method with repetition and many `try-catch` blocks to parse a date string.
  One possible solution/learning are replacing `try-catch` with guard clauses. 

### Exercise 3

Using `enum` with behavior or replacing `switch-case` with polymorphism are some possible solutions here. There is also the learning from the fact that the Direction class is not properly covered with tests.


### Exercise 4
This is a good opportunity to think outside of the OO box and apply some 
functional thinking. The code duplication in this exercise lies inside the `if` 
statements that evaluate whether a number should be counted or not.
Possible solution steps include: 
- introducing a `switch-case` statement to replace the duplication 
  among the 4 methods. This solution leaves room for further development and 
  discussion about replacing switch-case with polymorphism.
- introducing the extraction of interfaces and the application of the Strategy 
  Pattern with Method objects or superclass and template method.
- introducing lambdas as the implementation of the Strategy pattern. 
  This solution might be slightly harder to explain, since grads might not be 
  familiar with lambdas and 1st order functions, and can also be seen as an 
  evolution of the previous solution.
Depending on how the solution go, a discussion about open/close principle can be held.

### Exercise 5
The problem shows a feature envy `Receipt`. The constants are extracted already so that there' no need to worry about magic numbers. 


### Exercise 6
There are many refactoring opportunities here some are: 
- extract methods
- replace switch-case with polymorphism
- feature envy
- split for loop
