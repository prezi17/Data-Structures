/**********************************************************
 * EECS2011ON: Fundamentals of Data Structures,  Winter 2020
 * Assignment 1, Problem 1: ArraySqueeze.java
 * Student Name:   Rajwinder kaur Rajwinder kaur 
 * Student EECS account:  rkaur3
 * Student ID number:  216907602
 **********************************************************/

package A1;


/**
 * The purpose of this class is to squeeze an array of ints.
 * 
 * The main method runs some tests.
 * 
 * @author andy
 * 
 */

public class ArraySqueeze {

  	/**
	 * squeeze() takes an array of ints. On completion the array contains the
	 * same numbers, but wherever the array had two or more consecutive
	 * duplicate numbers, they are replaced by one copy of the number. Hence,
	 * after squeeze() is done, no two consecutive numbers in the array are the
	 * same.
	 * 
	 * Any unused elements at the end of the array are set to -1.
	 * 
	 * For example, if the input array is [ 4 , 1 , 1 , 3 , 3 , 3 , 1 , 1 ], it
	 * reads [ 4 , 1 , 3 , 1 , -1 , -1 , -1 , -1 ] after squeeze() completes.
	 * 
	 * @param ints
	 *            the input array.
	 */

	public static void squeeze(int[] ints) {
		
		// TODO: Fill in your solution here. Ours takes linear time and is less than 10 lines long,
		// not counting blank/comment lines or lines already present in this file.
		 
		//at begining i indicates to the second element and j indicates to the first element ; if both are different i.e not repitative then move j to the next character so does i but if they are equal j`s value doesnt change and next time there are two different value we pick those and put them at the next position j indicates and increments it
		int j = 0;
	 for(int i=1 ;i < ints.length; i++) {
			if (ints[i] != ints[j]) {
				j++;
				ints[j] = ints[i];
			}
		}
	 
		for(int k = ints.length-1; k > j; k-- )
		{
			ints[k] = -1;
		}		
	}
	
  	/**
	 * main() runs test cases on your squeeze() method. Prints summary
	 * information on basic operations and halts with an error (and a stack
	 * trace) if any of the tests fail.
	 */


	public static void main(String[] args) {
		String result;

		System.out.println("Let's squeeze arrays!\n");

		int[] test1 = {3, 7, 7, 7, 4, 5, 5, 2, 0, 8, 8, 8, 8, 5};
		System.out.println("squeezing " + TestHelper.stringInts(test1) + ":");
		squeeze(test1);
		result = TestHelper.stringInts(test1);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals(
		  "[ 3 , 7 , 4 , 5 , 2 , 0 , 8 , 5 , -1 , -1 , -1 , -1 , -1 , -1 ]"),
						"BAD SQEEZE!!!  No cookie.");

		int[] test2 = {6, 6, 6, 6, 6, 3, 6, 3, 6, 3, 3, 3, 3, 3, 3};
		System.out.println("squeezing " + TestHelper.stringInts(test2) + ":");
		squeeze(test2);
		result = TestHelper.stringInts(test2);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals(
            	   "[ 6 , 3 , 6 , 3 , 6 , 3 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 ]"),
						"BAD SQEEZE!!!  No cookie.");

		int[] test3 = {4, 4, 4, 4, 4};
		System.out.println("squeezing " + TestHelper.stringInts(test3) + ":");
		squeeze(test3);
		result = TestHelper.stringInts(test3);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ 4 , -1 , -1 , -1 , -1 ]"),
				"BAD SQEEZE!!!  No cookie.");

		int[] test4 = {0, 1, 2, 3, 4, 5, 6};
		System.out.println("squeezing " + TestHelper.stringInts(test4) + ":");
		squeeze(test4);
		result = TestHelper.stringInts(test4);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ 0 , 1 , 2 , 3 , 4 , 5 , 6 ]"),
				"BAD SQEEZE!!!  No cookie.");

		System.out.println("\nAdditional tests done by the student or TA:\n");

		// Insert your additional test cases here.
		
		int[] test5 = {9,8,7,6,5,4,3};
		System.out.println("squeezing " + TestHelper.stringInts(test5) + ":");
		squeeze(test5);
		result = TestHelper.stringInts(test5);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ 9 , 8 , 7 , 6 , 5 , 4 , 3 ]"),
				"BAD SQEEZE!!!  No cookie.");

		int[] test6 = {5,6,3,4,6,7,4,3,6,4,4,6,7};
		System.out.println("squeezing " + TestHelper.stringInts(test6) + ":");
		squeeze(test6);
		result = TestHelper.stringInts(test6);
		System.out.println(result + "\n");
		TestHelper.verify(result.equals("[ 5 , 6 , 3 , 4 , 6 , 7 , 4 , 3 , 6 , 4 , 6 , 7 , -1 ]"),
				"BAD SQEEZE!!!  No cookie.");
		//5,6,3,4,6,7,4,3,6,4,4,6,7
	}
}