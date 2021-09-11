package week1.day2Assignment;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int no = 153, calculated = 0, remainder, original;
		original = no;
		while (no > 0) {
			remainder = no % 10;
			System.out.println("Remainder: " + remainder);
			calculated = calculated + (remainder * remainder * remainder);
			System.out.println("calculated:" + calculated);
			no = no / 10;
			System.out.println("Quotient: " + no);
		}
		if (calculated == original) {
			System.out.println("Given number " + original + " is amstrong number");
		} else {
			System.out.println("Given number " + original + " is not amstrong number");
		}

	}

}