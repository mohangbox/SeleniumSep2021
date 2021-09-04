package week1.day1Assignment;

public class FibonacciSeries {
	/*
	 * Goal: To find Fibonacci Series for a given range
	 * 
	 * input(range): 8 output: 0, 1, 1, 2, 3, 5, 8, 13
	 * 
	 * Shortcuts: 1) Print : type: syso, followed by: ctrl + space + enter 2) To
	 * create a 'for' loop: type 'for', followed by ctrl + space + down arrow +
	 * enter
	 * 
	 * What are my learnings from this code? 1) 2) 3)
	 * 
	 */
	public static void main(String[] args) {
		int a = 0, b = 1, sum, range = 8;
		System.out.println(a);
		System.out.println(b);

		for (int i = 2; i < range; i++) {
			sum = a + b;
			System.out.println(sum);
			a = b;
			b = sum;
		}
	}
}
