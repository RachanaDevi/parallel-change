## Parallel Change Kata
There is a class known as Shopping Cart
The class should handle multiple int items instead of a single one
Tests have already been written

CODE SMELLS:
- There is a restriction in the signature, it does not provide extensibility?
- Did not change the signature of the already existing method

## Signature discussions:
```java
list.add(1,2,3)
```
#### Advantages
 - only one line of code and doesn't clutter the code a lot of if there are 2-3 insertions
 - the user can put one time and may result in creating an array which can be initialized only once

#### Disadvantages   
 - if you want to add more, then the number of parameters may be too much
 - if you forgot to add something, you cannot add it again in the existing array, it will replace it   

```java
list.add(1)
list.add(2)
```

```java
list.add(List.of(12))
```
#### Advantages
- You can add as many as you want and if you want to add it later let's say in a loop, that will also work

#### Disadvantages
- Number of lines may be more


### Questions
- Is it better to initialize the List in the constructor or during initialization itself
  - Usually initialization invokes at declaration and then the constructor, if you have another method which uses 
    the collection it may result in NullPointerException


