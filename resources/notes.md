# Notes

## Testing

#### Basics:
* Each method with @Test is a new test, it can test different functions/execution paths in the same src/method
* Check test coverage using Run | Run with coverage
* use expect(exception)/ignore(msg)/timeout(ms) annotations
* use Before/After (exec before every method) or BeforeClass/AfterClass for singleton tasks  
Source:
[Video by Brian Fraser on JUnit4](https://www.youtube.com/watch?v=Bld3644bIAo&t=32s)

#### Tips:
* use framework like `TestNG, JUnit`
* use TDD judiciously. It is a practice to write all tests before starting with any code.
* Measure code coverage using `Clover, Corbetura, JaCoCo, Sonar`, 
  * whenever you write a new functionality, immediately write test to cover it. 
* Externalize test data/inputs to a separate file (say testing.xml) 
  * annotate the method that generates/reads data as `@Parametrized.Parameters` in your test code
  * this allows you to change test data without modifying the code
  * [Different ways of writing parameterized tests](https://blog.parasoft.com/how-to-create-junit-parameterized-tests-faster)
* Use Assertions, no print statements
* Build tests that have deterministic results
* To cover functionality we write tests for positive scenarios only, include negative scenarios as well.  
Source: 
[Article](https://dzone.com/articles/7-tips-for-writing-better-unit-tests-in-java)

#### Naming conventions
* format for naming test method: `[the name of the tested method]_[expected input / tested state]_[expected behavior]`.
```java
class MyTestClass {
    public void Sum_NegativeNumberAs1stParam_ExceptionThrown();
    
    public void Sum_NegativeNumberAs2ndParam_ExceptionThrown ();
    
    public void Sum_simpleValues_Calculated ();
    
    public void registerNewUserAccount_ExistingEmailAddressGiven_ShouldThrowException();
}
```
  
* format for naming inp variables:  `[what the variables contents represent]` 
  * example: badData, emptyArray, nonInitializedPerson.
  * try to get tips from your assert statement: 
  * `Assert.AreEqual(BAD_INITIALIZATION_CODE, ReturnCode, "Method should have returned a bad initialization code")`
  
## Streams

#### Basics
- It was introduced in Java 8
- Imperative programming is where we write exact steps we want the program to perform
- Declarative programming(functional programming) is where we just write what we want to do without giving the exact steps
- Example: Loop through an array and get some selected records in declarative can be done as:
```java
class Main {
    List<Person> females = people.stream()
                                 .filter( person -> person.getGender().equals(Gender.FEMALE) )
                                 .collect( Collectors.toList() );    
    
    
}
```
- Stream operations can be pipelined(ex. filter-map-sum pipeline). 
- Types of operations: 
  - Intermediate: lazy processing, a filter operation will not traverse the whole stream, it will create a new stream
  - Terminal: may need to traverse the stream to get a result. Ex. Stream.forEach / Stream.sum 
- Some operations are Stateless(filter,map) / stateful(sort).
- A stream is diff from collection:
  - no storage, is not a data structure
  - produces result, a new stream, does not modify source
  - lazy processing, all intermediate operations
  - unbounded, can handle infinite streams, short-circuiting output possible
  - consumable, the elements of the collection are visited only once in the life of a stream.
- obtain a Stream from:
  - Collection.stream() / Collection.parallelStream()
  - Arrays.stream()  : public static <T> Stream<T> stream(T[] array)
  - BufferedReader.lines() : public Stream<String> lines()
  - Random.ints()
  - Stream.of() :  static <T> Stream<T> of(T... values)    // the ... is for varargs(any num of arguments of type T)
- Reduction operations: take a stream and reduce it to a single summary result. 
  - Ex. reduce() / collect() are general reduction operations and sum, min, max, avg are specialized reduction forms
  - int sum = numbers.stream().reduce(0, Integer::sum), numbers.stream().reduce(0, (a,b)->a+b);
  - collect(): take a stream and return a mutable container like arraylist as result.
    - Collectors class has some utility methods for using with collect(). 
    - Ex. Collectors.toList(), Collectors.toCollection(Treeset::new) , Collectors.froupingBy(Emp::getSalary)

## Java core

#### Basics
- Generics
  - There are many restrictions with Generics in Java
  - Refer: https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html#createArrays
- forEach vs iterator: 
  - In for-each loop, we can’t modify collection, it will throw a ConcurrentModificationException 
  - on the other hand with iterator we can modify collection.
  - https://www.geeksforgeeks.org/iterator-vs-foreach-in-java/
- listIterator vs Iterator
  - https://stackoverflow.com/questions/12772443/how-to-change-value-of-arraylist-element-in-java
  - Iterator can be used to modify elements, but to replace while iterating, use ListIterator
  