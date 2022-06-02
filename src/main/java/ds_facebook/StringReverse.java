package ds_facebook;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class StringReverse {


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		String[] iArray = input.split(" ");
		input = iArray[0];
		int k = Integer.parseInt(iArray[1]);

		Set<String> uniqueSet = new CopyOnWriteArraySet<>();
		uniqueSet.add(input);
		for (int i = 0; i < k; i++) {

			for (String s : uniqueSet) {
				uniqueSet.remove(s);
				String reverse = reverse(s);
				String s1 = s + reverse;
				String s2 = reverse + s;
				uniqueSet.add(s1);
				uniqueSet.add(s2);
			}
		}

		System.out.println("Size: " + uniqueSet.size());
	}

	public static String reverse(String s1) {
		String s2 = "";

		for (int i = s1.length() - 1; i >= 0; i--) {
			s2 = s2 + s1.charAt(i);
		}
		return s2;
	}
}
