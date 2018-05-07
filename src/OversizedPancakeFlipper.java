import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class OversizedPancakeFlipper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();

		String[] sArr = new String[t];
		int[] iArr = new int[t];

		// read input
		for (int i = 0; i < t; ++i) {
			sArr[i] = in.next();
			iArr[i] = in.nextInt();
		}

		// resolve the problem
		new OversizedPancakeFlipper().solve(sArr, iArr);
	}
	
	public void solve(String[] strArr, int[] intArr) {
		
		// solve the case
		for (int i = 0; i < strArr.length; i++) {
			int output = solveCase(strArr[i].toCharArray(), intArr[i]);
			System.out.println("Case #" + (i+1) + ": " + (output == -1 ? "IMPOSSIBLE" : output));
		}
	}
	
	public int solveCase(char[] charArr, int flipperSize) {
		int output = 0;
		for (int i = 0; i <= charArr.length - flipperSize; i++) {
			if (charArr[i] == '-') {
				output++;
				for (int j = 0; j < flipperSize; j++)
					charArr[i + j] = (charArr[i + j] == '+' ? '-' : '+');
			}
		}
		
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == '-')
				return -1;
		}
		
		return output;
	}

}
