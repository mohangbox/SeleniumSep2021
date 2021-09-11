package week2.day1Assignment;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 12321, rev = 0, rem;
		int original = num;
		while (num != 0) {
			rem = num % 10;
			rev = rev * 10 + rem;
			num = num / 10;
		}
		if (original == rev) {
			System.out.println("The given number is palindrome number");
		} else {
			System.out.println("The given number is not a palindrome");
		}
	}
}