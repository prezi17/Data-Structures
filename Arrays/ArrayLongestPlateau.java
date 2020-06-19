
/**********************************************************
 * EECS2011ON: Fundamentals of Data Structures,  Winter 2020
 * Assignment 1, Problem 2: ArrayLongestPlateau.java
 * Student Name:   Rajwinder kaur Rajwinder kaur
 * Student EECS account:  rkaur3	
 * Student ID number:  216907602
 **********************************************************/

package A1;

/**
 * The purpose of this class is to find the longest plateau of an array of ints.
 * 
 * The main method runs some tests.
 * 
 * @author andy
 * 
 */

public class ArrayLongestPlateau {

	/**
	 * longestPlateau() returns the longest plateau of an array of ints.
	 * 
	 * @return an array int[3] of the form {value, start, len} representing the
	 *         longest plateau of ints[] as a length len contiguous subarray
	 *         starting at index start with common element values value.
	 * 
	 *         For example, on the input array [2, 3, 3, 3, 3, 6, 6, 1, 1, 1], it
	 *         returns [6, 5, 2], indicating the longest plateau of this array is
	 *         the subarray [6, 6]; it starts at index 5 and has length 2.
	 * 
	 * @param ints the input array.
	 */

	public static int[] longestPlateau(int[] ints) {

		int plateauStartPos = 0; // starting index of the plateau
		int maxLength = 0; // variable for length of longest plateau
		int currentLength = 0; // records how many times the value repeats itself consecutively. Hence, forming
								// the length of pleateau provided the conditions are met
		if (ints.length == 0) {
			throw new IllegalArgumentException();
		}
		if (ints.length == 1) {
			return new int[] { ints[0], 0, 1 };
		}

		for (int k = 0, j = 1; j < ints.length; k++, j++) {
			if (ints[k] <= ints[j]) {

				if (ints[k] == ints[j]) {

					currentLength++; // if two values are equal increase currentLength by 1

					/*
					 * if ints[j] is the the last element in array and its current length is greater
					 * than maxLength of plateau recorded till that point and value before the start
					 * position of plateau is less than the value of the element which is forming a
					 * plateau then it satifies all the condition of the plateau in case the plateau
					 * formation is at the end of the array then set that start position of the
					 * plateau to plaeateauStartPos , MAXIMUM LENGTH of the plateau to be set equal
					 * to currentLength
					 * 
					 */

					if (j == ints.length - 1 && currentLength > maxLength
							&& ints[j - currentLength] > ints[j - currentLength - 1]) {

						plateauStartPos = j - currentLength;
						maxLength = currentLength;

					}
					/*
					 * once two consecutive values get different ; reset the currenLength to zero to
					 * count the length of the new repeating variable in the program if it appears.
					 */
				} else if (ints[k] != ints[j]) {

					currentLength = 0;
				}
			}

			/*
			 * this covers the scenario where where the value at the end of plateau is
			 * larger than the value that comes after it 'j' is the last index of the
			 * plateau forming value; 'currentLength' is the number of times the number is
			 * being repeated if the maximun Length of the recorded pleateu is less than the
			 * current length recorded then we assugn new value tot he pleateauStartPos,
			 * maxLength is set to the current Length as according to the condition 
			 * 'ints[k] > ints[j]' means ints[k] != ints[j] ; we reset the value of the current
			 * length to record new repeating value length in the array
			 */
			else if (ints[k] > ints[j]) {

				if (currentLength > maxLength) {
					plateauStartPos = j - currentLength - 1;
					maxLength = currentLength;
					currentLength = 0;

				}
			}
		}
		return new int[] { ints[plateauStartPos], plateauStartPos, maxLength + 1 };
	}

	/**
	 * main() runs test cases on your longestPlateau() method. Prints summary
	 * information on basic operations and halts with an error (and a stack trace)
	 * if any of the tests fail.
	 */

	public static void main(String[] args) {
		String result;

		System.out.println("Let's find longest plateaus of arrays!\n");

		int[] test1 = { 4, 1, 1, 6, 6, 6, 6, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test1) + ":");
		result = TestHelper.stringInts(longestPlateau(test1));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 6 , 3 , 4 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test2 = { 3, 3, 1, 2, 4, 2, 1, 1, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test2) + ":");
		result = TestHelper.stringInts(longestPlateau(test2));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 3 , 0 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test3 = { 3, 3, 1, 2, 4, 0, 1, 1, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test3) + ":");
		result = TestHelper.stringInts(longestPlateau(test3));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 1 , 6 , 4 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test4 = { 3, 3, 3, 4, 1, 2, 4, 4, 0, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test4) + ":");
		result = TestHelper.stringInts(longestPlateau(test4));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 4 , 6 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test5 = { 7, 7, 7, 7, 9, 8, 2, 5, 5, 5, 0, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test5) + ":");
		result = TestHelper.stringInts(longestPlateau(test5));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 5 , 7 , 3 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test6 = { 4 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test6) + ":");
		result = TestHelper.stringInts(longestPlateau(test6));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 4 , 0 , 1 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test7 = { 4, 4, 4, 5, 5, 5, 6, 6 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test7) + ":");
		result = TestHelper.stringInts(longestPlateau(test7));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 6 , 6 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		System.out.println("\nAdditional tests done by the student or TA:\n");

		// Insert your additional test cases here.

		int[] test8 = { 1, 4, 4, 4, 0, 5, 5, 5, 6, 6 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test8) + ":");
		result = TestHelper.stringInts(longestPlateau(test8));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 4 , 1 , 3 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test9 = { 1, 4, 4, 4, 5, 5, 5, 5, 4, 6, 6 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test9) + ":");
		result = TestHelper.stringInts(longestPlateau(test9));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 5 , 4 , 4 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test10 = { 1, 2, 4, 5, 6, 5, 6, 6, 4, 5, 5, 5, 5, 5 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test10) + ":");
		result = TestHelper.stringInts(longestPlateau(test10));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 5 , 9 , 5 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

	}
}