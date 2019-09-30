
public class MyInteger {

	private int value;

	public MyInteger(int value) {

		this.value = value;

	}

	public int getValue() {

		return value;

	}

	public boolean isEven() {

		// even is a number that after being divided by 2 is a whole number.
		return isEven(value);

	}

	public boolean isOdd() {
		// if its not even then its odd!
		return !isEven();

	}

	public boolean isPrime() {

		return isPrime(value);
	}

	public static boolean isEven(int n) {
 //a prime number will only have two factors. So if it hits 3 factors, return false
		if ((n % 2) == 0) {
			return true;

		} else {

			return false;
		}

	}

	public static boolean isOdd(int n) {

		return !isEven(n);
	}

	public static boolean isPrime(int n) {

		int Factor = 0;

		for (int i = 1; i <= n; i++) {

			if (n % i == 0) {
				Factor++;
			}

		}

		if (Factor > 2) {
			return false;

		} else {
			return true;
		}

	}

	public static boolean isEven(MyInteger n) {

		return n.isEven();

	}

	public static boolean isPrime(MyInteger o) {

		return o.isPrime();

	}

	public static boolean isOdd(MyInteger o) {

		return o.isOdd();

	}

	public boolean equals(int anotherNum) {

		if(value == anotherNum) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean equals(MyInteger o) {
		
		return equals(o.getValue());

	}
}
