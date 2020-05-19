# Refactoring Brief

One of the main purposes of this dojo is to eliminate feature envies which means to eliminate at least all getting methods for practicing.

Ways to refactor
1. rename
2. eliminate feature envies
3. split for loop because 3 things doing together (after split into 3 for loops and put them into different methods, you can find the chance to remove duplication and see the benefits on this refactor)
4. value objects

## First round for trainers

Trainers can do a demo in the first round which can be paired by two trainers so that the key learning we can drive:
1. Rename - rename o -> order in OrderReceipt
2. Remove feature envy - merge o.getCustomerName() and o.getCustomerAddress() into one method and remove the gettings.
3. Simplify the for loop - extract totalSalesTax logic to another for loop and move it to a new method in order class.

The key thing here is to do these in baby steps so that the grads can follow

Try run this and make sure it could be finished in 5 mins

### Author 

Heaton
tcai@thoughtworks.com

You can see the git history [here](https://git.thoughtworks.net/tcai/refactoring-1/tree/solution)