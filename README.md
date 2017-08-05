# Solution

The solution has basically 3 components:
* A parser: `AsciiArtToCharacterArrayParser`
* An binary character recognizer: `AsciiArtCharacter3x3`
* A simple character array based character recognizer: `SimpleAsciiArtCharacter`

`AsciiArtToCharacterArrayParser` validates the input string and then can use any implementation of `ICharacterRepresenter` to transform the string into a `Character` array.

Both `AsciiArtChracter3x3` and `SimpleAsciiArtCharacter`  implement the `ICharacterRepresenter` interface and you can use either one for parsing. They represent different approaches to solve the same problem.

## AsciiArtCharacter3x3

`AsciiArtCharacter3x3` uses a binary approach for recognizing strings and it should be the fastest one. 

The disadvantage is that it can only recognize 3x3 characters (like the ones asked for).

The dimensions can be modified in theory, but the binary method has its limitation when it comes to more complicated character recognition techniques.
The binary approach used here does not make any distinction between '_' and '|' characters, but if more characters are used and with a more complicated signification, then
this approach will show its weaknesses. 

## SimpleAsciiArtCharacter

`SimpleAsciiArtCharacter` uses an _array of arrays of char_ to represent a character. Thus it should be slower as the operations involved in recognition require more time.

The advantage on using this class is that it is very customizable.

You can pass it a new representation of the characters and even a new function that will recognize the characters. The default function for character recognition is however capable of
recognizing most if not all of the character representation passed.
  
  
## Observations

One could easily implement the functionality of `AsciiArtCharacter3x3` by using the `SimpleAsciiArtCharacter` as the base. The key point here would be to change the character recognition function. 

----

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