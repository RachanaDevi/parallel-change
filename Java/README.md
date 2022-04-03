# Parallel Change Kata

- Java version-8
- Gradle version 6.7
- [Parallel Change Kata Question Statement](https://kata-log.rocks/parallel-change-kata)

There is a class known as Shopping Cart The class should handle multiple int items instead of a single one Tests have
already been written

## CODE SMELLS:

- There is a restriction in the signature, it does not provide extensibility?
- Did not change the signature of the already existing method
- The 100 for discount is a magic number

```java
    public boolean hasDiscount(){
        return prices.stream().anyMatch(item->item>=100);
        }
```

- ShoppingCart putting prices does not make sense, maybe an abstraction such as item is missing
- Even though calculation of `hasDiscount` is a one liner it has a concept of item and it knows about item and its
  comparison
    - Should it be the responsibility of hasDiscount to compare every item and see if it is greater than 100?
- Price can also be Float or Double, it does not make sense for it to be an integer

--- 

## ShoppingCart

### Signature discussions:

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
list.add(1);
list.add(2);
```

#### Advantages

- You can add as many as you want and if you want to add it later let's say in a loop, that will also work

#### Disadvantages

- Number of lines may be more

```java
list.add(List.of(1,2,3))
```

#### Advantages:

- Only One line which adds a list of items
- The user can choose to put as many items in the list argument, can be one or more, so user has that flexibility
- the argument is sugar-coated and can seem like only one argument i.e a list argument

#### Disadvantages:

- Is it too much if the user wants to add less items i.e 1 or 2, is making a list an overkill?

### Questions

- Is it better to initialize the List in the constructor or during initialization itself
    - Usually initialization invokes at declaration and then the constructor, if you have another method which uses the
      collection it may result in NullPointerException

---

## Price

- Price is a value object which has got the value in double
- The reason why it is a value object is because the value of 2 Price objects are equal if their value is equal
- Price provides a method to check if it is greater than 99
- It provides a method to add another item which returns a new item

--- 

### Questions

- Is it better to name a method as greaterThanEqualToHundred() or greaterThanNinetyNine(), question statement that time
  had mentioned >=100
  ##### greaterThanNinetyNine() method
  ###### Advantages of greaterThanNinetyNine()
    - smaller method name

  ###### Disadvantages of greaterThanNinetyNine()
    - the business use case had said >=100, so will it take more time for the user to read it and is it not evident at
      first glance?

  ##### greaterThanEqualToHundred()
  ###### Advantages:
    - it is as it is given by the business use case

  ###### Disadvantages:
    - a longer method name, takes more time to read
  
## Conclusion
- both names are not valid for Item. Because no one says Item is greaterThanNinetyNine or greaterThanEqualToHundreded
- if such a case does occur, the better name would be the one the client uses in the conversation a lot. When they talk about discounts, 
  do they talk about price being greater than ninety nine, or do they say greater than equal to hundred

- what should the constant LEAST_PRICE_ELIGIBLE_FOR_DISCOUNT be named as such in Price class? or should it just be 100?

### Notes:

- Depending on what the user wants or what you are making, you can build the api for add. It can be
    - list.add(1,2,3) :  if the user puts things all at one
    - list.add(1); list.add(2): if user puts one thing at a time
    - list.add(List.of(1,2)) : if user puts a list in the cart

- The reason the Price has a method named `greaterThanNinetyNine` instead of `hasDiscount` is because why should a item
  know whether its value is eligible for discount. Your 10 rupees note does not have the knowledge whether it will get
  discount in Amazon or not

- As another client `ImagineThisIsAClientInADifferentRepository` is using the method calculateTotalPrice() we can't
  alter return type to return Price
  
#### Points Regarding Validation
- There can be use-cases when an invalid input is put to make an Object
   - Throw Exception and stop the flow
   - Have a Null check

#### Different scenarios for validation
- Let's consider the use-case where the client has said that it wants to throw an exception
  - So in the constructor do we provide the check, with if condition of
      Objects.requireNonNull
      Assert.checkNonNull ( you have to enable assertion )
  - If there is a lot of behaviour regarding null checks, for eg:
     - We have an employee which is not associated with a department
       - So, we will have to put null check and see if the employee belongs to a dept, and the default use-case can be 
         staffing-department
       - If so many behaviours are associated then we may to create a NullObject which will have the default behaviour 
         [Null Object Pattern](https://en.wikipedia.org/wiki/Null_object_pattern)
         - This class is a singelton as all the objects created from it will be the same
         
- The method `Item.zeroPrice()` is a value which can be made into a static field and it is not necessary for us to create
  the object all the time
   - Removed Item having zeroPrice as real-life scenarios don't have items having price as zero
   - Exposed a method in Price class to give zero but the user cannot create price as zero.
   
  
- It does not make sense for two items to add together. You don't add 2 soaps together to make one soap with the combined price
  - We add the behaviour in Items to combine all the prices of the items and don't let Item have the responsibility of adding prices
    - If needed this may require another encapsulation Price later on, for now it is fine.

### Price class
- Price class was later introduced because we saw a lot of behaviour in Item class which was related to Prices
   - checking if it is null
   - checking if it was zero
   - checking if it has the least price eligible for discount
   - logic of adding 2 prices
   - price exposes its price to Item but does not expose the value it has.
   - Price cannot be created having null and less than equal to zero but Price has a method which gives Price as zero
      - This zero is used if the total Price is zero and no items are there
   - User cannot create an item having zero price
     - Then should it be the responsibility of the Item to check if price is zero or null
     - Should Price only have the concept which can either be zero or non-zero ?
    