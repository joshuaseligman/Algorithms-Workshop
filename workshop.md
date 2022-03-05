# Introduction

## Importance of Preparing for Coding Tests and Interviews
The interview process for virtually every job or internship will consist of a coding test or interview. In this stage, you will have to solve a few questions using a programming language of your choice. These problems may seem challenging at first, but practicing these problems and being comfortable with different data structures and solving techniques will help make these problems seem less daunting.

## Big O
Big O is a notation that helps describe the worst-case time or space complexity of an algorithm. Questions about Big O usually refer to time complexity. Some of the most common cases are listed below:
1. O(1) - constant time; the algorithm will run in the same amount of time regardless of how large the data are
2. O(n) - the algorithm will run in a time that is proportional to the size of the data; this is commonly seen with a for-loop that iterates through the data
3. O(n<sup>2</sup>) - the algorithm will run in a time that is proportional to the square of the size of the date; this is commonly seen with nested for-loops
4. O(log n) - occurs in divide-and-conquer algorithms where the data gets divided at each step of the algorithm

Complexities can also be added to each other. For instance, let's say we loop through an array of size A and then loop through an array of size B. Since the first loop has a time complexity of O(A) and the second loop has a time complexity of O(B), we can say the overall time complexity is O(A + B).

Big O can get very complicated really quickly as the algorithms get larger. This is why we only keep the highest degree term and drop constants when describing algorithm complexity in Big O.

![](https://miro.medium.com/max/1200/1*5ZLci3SuR0zM_QlZOADv8Q.jpeg)

## How to Tackle Coding Questions
1. Brute force - when you cannot immediately think of an optimal solution, write an algorithm that will get the job done but is not optimized
2. Analyze your solution - trace through your program, identify inefficiencies, edge cases that you may have missed, and other data structures that may be able to speed up the solution
3. Implement an optimized algorithm - take your new ideas into account to build a more efficient solution to the problem

# Question 1
Reverse a string.<br />
Examples:<br />
"Java" --> "avaJ"<br />
"ababa" --> "ababa"<br />
"c" --> "c"<br />
"" --> ""<br />

We will begin with a method called reverseString. Based on the requirements and examples, it appears that we need to take in a string and output a string as well.
```java
public static String reverseString(String s) {
    
}
```
Next, we need to figure out a way to manage our reversed string. The String data type is immutable, which means it cannot be altered and, therefore, has to be copied every time you want to make changes. This is extremely time-consuming and inefficient. Luckily, the StringBuilder class in Java takes care of this issue for us! The StringBuilder class creates a buffer in memory that stores all of our strings and then puts them together in one operation without constantly copying the strings. Let's add a StringBuilder to the beginning of the method.
```java
public static String reverseString(String s) {
    StringBuilder reversed = new StringBuilder();
}
```
Now, we want to iterate through the inputted string. Since we want to reverse the string, we will start at the end of the string and work our way to the front. Also, at each index, we should add the character in the string to our StringBuilder object.
```java
public static String reverseString(String s) {
    StringBuilder reversed = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
        reversed.append(s.charAt(i));
    }
}
```
Lastly, once we finish with the loop, we want to put all of the strings we added to the StringBuilder together and return them as one big string. This can be done in one easy line.
```java
public static String reverseString(String s) {
    StringBuilder reversed = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
        reversed.append(s.charAt(i));
    }
    return reversed.toString();
}
```
Since we loop through the string once, we have an O(n) algorithm.

# Question 2
Determine if a string is a palindrome. Results should be case insensitive.<br />
Examples:<br />
"racecar" --> true<br />
"computer" --> false<br />
"Tenet" --> true<br />
"x" --> true<br />
"" --> true<br />

Just like the last problem, we will begin with a method definition. We will be taking in a string and outputting a boolean representing if the inputted string is a palindrome or not.
```java
public static boolean isPalindrome(String s) {
    
}
```
Before we begin checking the word, we have to make sure our string is in an appropriate format for the problem. The problem says that the results should be case insensitive, meaning that it should not matter if there is an uppercase or lowercase version of a letter. Thus, to make our lives easier, we will make the entire string lower case for consistency. We will work with this new string for the remainder of the problem.
```java
public static boolean isPalindrome(String s) {
    String lowerString = s.toLowerCase();
}
```
We now want to understand what it means to be a palindrome. A palindrome is a word that is spelled the same way forwards and backward. This means the first letter is the same as the last letter, the second letter is the same as the second to last letter, etc. This understanding of the definition allows us to use a 2-pointer approach to solve the problem. All this means is that we will have 2 variables to go through the data at a time instead of 1 variable. Let's begin with the implementation by creating 2 variables and initializing the first one to 0 and the other one to the index of the last character in the string.
```java
public static boolean isPalindrome(String s) {
    String lowerString = s.toLowerCase();
    int frontIndex = 0;
    int backIndex = lowerString.length() - 1;
}
```
Next, we know want to create a loop, but we do not know what kind of loop yet. However, we do know that we want to stop looping when frontIndex and backIndex cross paths. This is because once they pass each other, we do not have to look further because we would be duplicating our comparisons. Therefore, we should use a while loop that goes as long as `frontIndex < backIndex`.
```java
public static boolean isPalindrome(String s) {
    String lowerString = s.toLowerCase();
    int frontIndex = 0;
    int backIndex = lowerString.length() - 1;

    while (frontIndex < backIndex) {
        
    }
}
```
The body of the loop is pretty straightforward. If the characters at the frontIndex position and the backIndex position are not the same, we know the string is not a palindrome and can just `return false`. Otherwise, we can move frontIndex and backIndex one step closer to each other.
```java
public static boolean isPalindrome(String s) {
    String lowerString = s.toLowerCase();
    int frontIndex = 0;
    int backIndex = lowerString.length() - 1;

    while (frontIndex < backIndex) {
        if (lowerString.charAt(frontIndex) != lowerString.charAt(backIndex)) {
            return false;
        }
        frontIndex++;
        backIndex--;
    }
}
```
Lastly, if we are able to get through the loop without detecting a situation that the string is not a palindrome, we can `return true`.

```java
public static boolean isPalindrome(String s) {
    String lowerString = s.toLowerCase();
    int frontIndex = 0;
    int backIndex = lowerString.length() - 1;

    while (frontIndex < backIndex) {
        if (lowerString.charAt(frontIndex) != lowerString.charAt(backIndex)) {
            return false;
        }
        frontIndex++;
        backIndex--;
    }
    return true;
}
```

Since we loop through half of the string, we have an O(n/2) algorithm, which simplifies to O(n).

# Question 3
Given an array of integers, arr, and a target sum, k, return 2 indices within arr where the values at these positions add up to k. You may not use the same index in your answer. If there is more than one solution, you may return one of the index pairings. If there is no solution, return null.<br />
Examples:<br />
arr = [3, 1, 6, 2, 4], k = 9 --> [0, 2]<br />
arr = [3, 1, 6, 2, 4], k = 7 --> [0, 4] or [1, 2]<br />
arr = [3, 1, 6, 2, 4], k = -5 --> null<br />

As always, let's begin with our method definition. We want to input an array of integers and an integer for our target sum. We also want to return an integer array for the pairing of the indices.
```java
public static int[] pairSum(int[] arr, int k) {

}
```
This problem is a bit more complex than the others in this workshop. Therefore, it would be a good idea to make a brute force solution and reevaluate afterward to find a more efficient way to solve the problem. We will begin by looping through the array. The loop will start with the first index and go through the second to last index. This is because we cannot repeat indices, and if we just have the last index left, we know that the solution does not exist.
```java
public static int[] pairSum(int[] arr, int k) {
    for (int i = 0; i < arr.length - 1; i++) {

    }
}

```
We now want to nest another loop inside of the current loop to compare the remaining possible values against the current value.
```java
public static int[] pairSum(int[] arr, int k) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            
        }
    }
}
```
From here, the rest of the solution is pretty easy. If the two numbers add up to k, then we can return their indices. Otherwise, continue looping. If the loops end with no solution, we can return null.
```java
public static int[] pairSum(int[] arr, int k) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] + arr[j] == k) {
                return new int[]{i, j};
            }
        }
    }
    return null;
}
```
Since we have a nested loop where both loops iterate through the array, we have an O(n<sup>2</sup>) algorithm.

In some cases, O(n<sup>2</sup>) may be the best possible solution. However, we know we can do better. The main problem with our current solution is that we are constantly comparing the same numbers over and over again. We should be able to know the index of every number of the array just by passing through it once. Also, as we iterate through the array, we should keep track of the numbers and their respective indices we have previously seen so we can see if the current number is the complement to a previous number in that the two numbers add up to the target.

To implement this solution, we need to introduce the HashMap data structure. HashMaps store data in a key-value pairing so you can do searches by the key, and it will spit out the value that is associated with the key. For our purposes, the HashMap keys can be the array values that we have seen before, and the HashMap values will be the array indices we have seen the values at.

Let's begin with a new method that takes in the same parameters and returns the same thing as our first solution.
```java
public static int[] pairSumNew(int[] arr, int k) {

}
```
Before we begin looping, we need to create our HashMap. The first data type is the data type of the key, and the second data type is for the value. Also, don't forget to import the java.util package to get access to the HashMap class.
```java
public static int[] pairSumNew(int[] arr, int k) {
    HashMap<Integer, Integer> history = new HashMap<Integer, Integer>();
}
```
Now that we have our HashMap set up, we can loop through the array. However, since we are going to use the HashMap for comparisons, we do not need to have a nested loop.
```java
public static int[] pairSumNew(int[] arr, int k) {
    HashMap<Integer, Integer> history = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
        
    }
}
```
We should begin the loop by checking to see if the current value's complement exists in the HashMap. If the desired value doesn't exist, we want to get a -1 back from the retrieval.
```java
public static int[] pairSumNew(int[] arr, int k) {
    HashMap<Integer, Integer> history = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
        int complement = history.getOrDefault(k - arr[i], -1);
    }
}
```
If the value we are looking for does not exist in the HashMap, we want to add the current value and index to the HashMap for future reference. However, if the complement does exist, we have found our pair and can return the pair of indices. Lastly, if we go through the array with no pairs, we can return null because there is no solution.
```java
public static int[] pairSumNew(int[] arr, int k) {
    HashMap<Integer, Integer> history = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
        int complement = history.getOrDefault(k - arr[i], -1);
        if (complement == -1) {
            history.put(arr[i], i);
        } else {
            return new int[]{complement, i};
        }
    }
    return null;
}
```
Since we are only iterating through the array once, we now have a time complexity of O(n)! To put a quantitative measure on the differences between these two algorithms, I ran a small simulation to compare their performances. After performing both algorithms 10,000 times on a randomly generated array of 50,000 elements between 0 and 100,000 and a random target between 0 and 100,000, the average completion time for the first algorithm was 292,773.9773 nanoseconds compared to 43,808.8816 nanoseconds for the second method. That is a massive difference and will continue to increase as the size of the array increases! Although the HashMap requires more space and memory, the time difference is huge, and the benefits definitely outweigh the drawbacks.

# Conclusion
Coding questions for interviews are hard and can be extremely difficult to prepare for. This workshop was meant to expose you to a few different data structures and methods for solving these coding problems. However, there is still a lot of unexplored material outside of this workshop that is imperative to be able to be confident in solving these questions. Below are my final tips to become more comfortable with coding interview questions.
1. Practice. As with anything, practicing solving coding questions will help you get used to the format of the questions, the common data structures to use, and the different techniques that can be used to solve the same problem. I strongly recommend you check out <i>Cracking the Coding Interview: 189 Programming Questions and Solutions 6th Edition</i> by Gayle Laakmann McDowell. It is a fantastic resource with clear descriptions of the different types of problems and provides a ton of questions and their solutions.
2. Don't stress if you can't solve the problem during an interview. Although it is a plus if you can solve the problem, interviewers evaluate your train of thought and how you problem-solve. Even if you are just taking a test, write comments throughout your code to explain your thought process for each problem.