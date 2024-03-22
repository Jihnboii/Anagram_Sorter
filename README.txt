# AnagramSorter
This project is a Java program designed to sort a list of words into anagram groups using sorting algorithms and hashmaps. 

## Usage
- Ensure that you have Java Development Kit (JDK) installed on your system to
  compile and run the program.
- Windows User: Open Command Prompt
- Linux User: Open Terminal
- Mac User: Open Terminal
- Navigate to the directory containing the source code files and run the following command to compile:

```bash
javac AnagramSorter.java
```

Running the program
- After compiling, you can run it using the following command: 

```bash
java AnagramSorter.java [name of your file].txt
```

- Just replace '[name of your file]' with the name of the file containing the words you want sorted
- If no input file is provided, the program will use a default file named 'SampleWords.txt'
- For example, to run the program with a file named input.txt, you would execute:

```bash
java AnagramSorter.java input.txt
```

## Input
- Ensure that your .txt has only one word per line
- Here is an example of how it should be formatted
```txt
	tea
	ate
	debit
	bidet
```

## Output
- The program will output a .txt file name AnagramGroups.txt to the directory the .java file is in
- Here is an example of how it will output
```txt
	[tea, ate]
	[debit, bidet]
```

## Algorithms

The AnagramSorter program employs the following algorithms and data structures:

1. **Anagram Grouping Algorithm**: 
   - Purpose: Groups words into anagram groups.
   - Description: Utilizes a hashmap data structure to efficiently group words by their sorted letters. Each word is sorted alphabetically, and the sorted word serves as a key in the hashmap. An ArrayList is used to store words belonging to each anagram group.

2. **Word Sorting Algorithm**:
   - Purpose: Sorts a word alphabetically.
   - Description: Implements a sorting algorithm internally to sort each word alphabetically. The program uses character arrays and the Arrays.sort() method to perform the sorting operation efficiently.

These algorithms leverage hashmap and ArrayList data structures to organize and process the input words effectively, resulting in the generation of sorted anagram groups.

## Author
Jonathan Rodriguez
	