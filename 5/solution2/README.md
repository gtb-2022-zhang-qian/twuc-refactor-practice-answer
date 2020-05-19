# Refactoring Brief

The logic for the total cost is clear.

FIXED_CHARGE + (preRate() + postRate()) * peakTimeMultiplier()

## Refactoring steps

Change if to ternary and extract like doing math 

### Author 

Heaton
tcai@thoughtworks.com

You can see the git history [here](https://git.thoughtworks.net/tcai/refactoring-5)