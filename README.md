### Part 1
You work for a bank, which has recently purchased an ingenious machine to assist in reading letters and faxes sent in by branch offices. 
The machine scans the paper documents, and produces a file with a number of entries which each look like this:

```
  _  _    
| _| _||_|
||_  _|  | 

```

Each entry is 3 lines long, and each line has 12 characters. The lines of each entry represent an account number written using spaces, pipes and underscores. Each account number should have exactly 4 digits, all of which should be in the range 1-4.

Assume that you have already read the file and you have the input stored in a `String` like so:

```java
class Test {
    private static final String test =
        "    _  _    \n" +
        "  | _| _||_|\n" +
        "  ||_  _|  |";
}
```

Also assume that your input will always be correctly formatted.


### Part 2

As an addition to part 1, how would you adapt your solution so that it can read entries with a variable number of digits? Also how would modify your solution if 
the digits could be any number (0-9)?
```
 _     _  _     _  _  _  _  _ 
| |  | _| _||_||_ |_   ||_||_|
|_|  ||_  _|  | _||_|  ||_| _|
``` 

```java
class Test {
    private static final String test =
        " _     _  _     _  _  _  _  _ \n" +
        "| |  | _| _||_||_ |_   ||_||_|\n" +
        "|_|  ||_  _|  | _||_|  ||_| _|";
}
```