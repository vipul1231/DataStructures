package ds_general;

import java.util.ArrayList;
import java.util.List;

public class DiffTest {

	public static int computingPower(int maximumPower, int sumOfProcessignPower, int numberOfClusterChosen) {
		return maximumPower + sumOfProcessignPower * numberOfClusterChosen;
	}

	public static void main(String[] args) {

		int powerMax = 25;
		List<Integer> processingPower = new ArrayList<>();
		processingPower.add(2);
		processingPower.add(1);
		processingPower.add(3);
		processingPower.add(4);
		processingPower.add(5);

		List<Integer> bootingPower = new ArrayList<>();
		bootingPower.add(3);
		bootingPower.add(6);
		bootingPower.add(1);
		bootingPower.add(3);
		bootingPower.add(4);

		int start = 0, end = 0;
		int numberOfClusterChosen = 0;
		int maxBootPower = 0;
		int sumOfProcessingPower = 0;


		int len = processingPower.size();

		if (len == 0) {
			System.exit(0);
		} else {
			int result = 0;

			for (int i = 0; i < len; i++) {

				int count = 1, maxCount = 1, sum = 0, multiply;
				int max = Integer.MIN_VALUE;

				for (int j = i; j < len; j++) {
					sum += processingPower.get(j);
					multiply = sum * count;
					count++;

					max = Math.max(max, bootingPower.get(j));
					long totalPower = multiply + max;

					if (totalPower <= powerMax) {
						System.out.println(totalPower);
						System.out.println("MAX_COUNT" + maxCount);
						result = Math.max(maxCount, result);
					} else {
						maxCount = 1;
					}

				}
			}

			System.out.println(result);
		}
	}
}
