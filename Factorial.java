package week1.day1Assignment;

public class Factorial {
	/*
	 * Goal: Find the Factorial of a given number
	 * 
	 * input: 5 output: 5*4*3*2*1 = 120
	 * 
	 * Shortcuts: 1) Print : type: syso, followed by: ctrl + space + enter 2) To
	 * create a 'for' loop: type 'for', followed by ctrl + space + down arrow +
	 * enter
	 * 
	 * What are my learnings from this code? 1) 2) 3)
	 * 
	 */
	public static void main(String[] args) {
		int input = 5, sum = 1;
		for (int i = 1; i <= input; i++) {
			sum = i * sum;
		}
		System.out.println("Factorial number is: " + sum);
	}
}
