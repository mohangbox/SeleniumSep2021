package week2.day1Assignment;

import java.util.Arrays;

public class Anagram {

//	Pseudo Code 
//	 	Declare a String String text1 = "stops"; 
//		Declare another String String text2 = "potss"; 
//	 	a) Check length of the strings are same then (Use A Condition) 
//		b) Convert both Strings in to characters 
//		c) Sort Both the arrays 
//		d) Check both the arrays has same value

	public static void main(String[] args) {
		String text1 = "stops", text2 = "potss";
		boolean compare = false;

		if (text1.length() == text2.length()) {
			char[] charArray1 = text1.toCharArray();
			char[] charArray2 = text2.toCharArray();
			Arrays.sort(charArray1);
			Arrays.sort(charArray2);
			compare = Arrays.equals(charArray1, charArray2);
		}
		if (compare)
			System.out.println("The String is a Anagram");
		else
			System.out.println("The String is not a Anagram");
	}
}
