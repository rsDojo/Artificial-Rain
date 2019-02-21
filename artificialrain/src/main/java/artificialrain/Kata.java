package artificialrain;

public class Kata {

	public static int artificialRain(int[] numbers) {

		int[] flowRight = Kata.computeRightFlow(numbers);
		int[] flowLeft = Kata.computeLeftFlow(numbers);

		int maxWateredPlains = 0;

		for (int i = 0; i < flowLeft.length; i++) {
			maxWateredPlains = Math.max(flowLeft[i] + flowRight[i] + 1, maxWateredPlains);
		}
		return maxWateredPlains;
	}

	static boolean canFlowLeft(int[] numbers, int i) {
		if (i == 0)
			return false;
		return numbers[i - 1] <= numbers[i];
	}

	static boolean canFlowRight(int[] numbers, int i) {
		if (numbers.length - 1 == i)
			return false;
		return numbers[i + 1] <= numbers[i];
	}


	static int[] computeLeftFlow(int[] numbers) {
		int[] result = new int[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			if (canFlowLeft(numbers, i)) {
				result[i] = result[i - 1] + 1;
			} else {
				result[i] = 0;
			}
		}
		return result;
	}

	static int[] computeRightFlow(int[] numbers) {
		int[] result = new int[numbers.length];

		for (int i = numbers.length - 1; i >= 0; i--) {
			if (canFlowRight(numbers, i)) {
				result[i] = result[i + 1] + 1;
			} else {
				result[i] = 0;
			}
		}
		return result;
	}
}