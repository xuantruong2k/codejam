import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TidyNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TidyNumber instance = new TidyNumber();

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();

		// read input & solve the problem
		for (int i = 0; i < t; i++) {
			instance.solveCase(in.next().toCharArray(), i);
		}
	}

	void solveCase(char[] number, int testCase) {
		int output = 0;
		while (true) {
			output = isTidyNumber(number);
			if (output == -1) {
				System.out.println("Case #" + (testCase + 1) + ": " + String.valueOf(number));
				break;
			} else {
				number = nextDecrease(number, output);
			}
		}
	}

	int isTidyNumber(char[] number) {
		for (int i = number.length - 1; i > 0; i--) {
			if (number[i] < number[i - 1])
				return i; // not tidy number
		}

		return -1; // tidy number
	}

	char[] nextDecrease(char[] number, int index) {

		number[index] = '9'; // set the current index to 9

		// set the right from index to 9
		for (int i = index + 1; i < number.length; i++) {
			number[i] = '9';
		}

		// decrease the left of index
		if (index > 0) {
			index--;
			number[index]--;
			if (index == 0 && number[index] == '0') {
				String tmp = new String(number);
				tmp = tmp.substring(0, index) + tmp.substring(index + 1);
				number = tmp.toCharArray();
			}
		}

		return number;
	}
}
