# Printing Neatly
Introduction to Algorithm Page 405-406

### Problem Description

Consider the problem of neatly printing a paragraph with a monospaced font (all characters having the same width) on a printer. The input text is a sequence of n words of length l1, l2, ..., ln, measured in characters. We want to print this paragraph neatly on a number of lines that hold a maximum of M characters each. 

Our criterion of **“neatness”** is as follows. If a given line contains words i through j , where i <= j, and we leave exactly one space between words, the number of extra space characters at the end of the line is
![Equation](http://i.imgur.com/af2N82v.png)

which must be nonnegative so that the words fit on the line. We wish to minimize the sum, over all lines except the last, of the cubes of the numbers of extra space characters at the ends of lines. 

Give a dynamic-programming algorithm to print a paragraph of n words neatly on a printer. Analyze the running time and space requirements of your algorithm.

### Input Format

Write your program to accept its input from a file if the name of the file is given in the command line, or read its input from the console. The default value of M is 80.  If the command line has a second parameter, then use it as the value of M. Sample program fragment to do the above in Java:

```java
public static void main(String[] args) throws FileNotFoundException {
	Scanner in;
	int M = 80;
	if (args.length > 0) {
	    File inputFile = new File(args[0]);
	    in = new Scanner(inputFile);
	    if (args.length > 1) { M = Integer.parseInt(args[1]); }
	} else {
	    in = new Scanner(System.in);
	}
}
```

Read the input file and break it into words (separated by spaces or new lines).

### Output Format:

Your program should print its output to the console. In the first line of output, print the total penalty (sum of cubes of the number of spaces added in each line).  The second line of output is blank. Starting from the third line of the output, print the input words, formatted according to your algorithm.  Try to distribute the spaces within a line to make the output be left and right justified.
