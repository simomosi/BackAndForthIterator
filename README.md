# BackAndForthIterator

### A positional iterator for lists that allows the programmer to traverse a list in either direction. 

With this kind of iterator, changing the iteration direction does not duplicate the last element returned (unlike
[ListIterator](https://docs.oracle.com/javase/8/docs/api/java/util/ListIterator.html)). 
This is ideal for iterating collections which require user interaction through a GUI, like a menu or an interface with next/prev buttons.

A BackAndForthIterator, unlike ListIterator, has a current element.

This repository contains:
- The **BackAndForthIterator** interface
- Its implementation, **BackAndForthListIterator**
- Unit Testing
