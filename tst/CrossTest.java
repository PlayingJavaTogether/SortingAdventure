import java.util.Arrays;

import org.junit.Test;


public class CrossTest {
	private final SortingAlgorithm bubbleSort = new BubbleSorting();
	private final SortingAlgorithm quickSort = new QuickSorting();
	
	@Test
	public void runBunchOfTests() {
		int successfulTestsCount = 0;
		int failedTestsCount = 0;
		
		final int totalNumberOfTests = 1000;
		for (int testCounter = 1; testCounter <= totalNumberOfTests; testCounter++) {
			if (runSingleTest())
				successfulTestsCount++;
			else
				failedTestsCount++;
		}
		System.out.println("Successful vs failed: " + successfulTestsCount + "/" + failedTestsCount);
	}

	private boolean runSingleTest() {
		String[] randomArray = generateRandomArray();
		String[] copyOfRandomArray = copy(randomArray);
		
		String[] sortedRandom = bubbleSort.sort(randomArray);
		String[] sortedCopyOfRandom = quickSort.sort(copyOfRandomArray);
		
		boolean resultsAreEqual = Arrays.equals(sortedRandom, sortedCopyOfRandom);
		
		if (!resultsAreEqual) {
			System.out.println("Test failed for\t\t" + Arrays.toString(randomArray) + "\n" +
					"result1\t\t=\t" + Arrays.toString(sortedRandom) + "\n" +
					"result2\t\t=\t" + Arrays.toString(sortedCopyOfRandom) + "\n" +
					"------------------------------------------");
		}
		return resultsAreEqual;
	}

	private String[] generateRandomArray() {
		final double MAX_LENGTH = 15d;
		int randomLength = (int) (Math.random() * MAX_LENGTH);
		
		String[] randomArray = new String[randomLength];
		for (int index = 0; index < randomLength; index++) {
			Integer randomElement = (int) ((Math.random() - 0.5d) * 10d);
			randomArray[index] = randomElement.toString();
		}
		
		return randomArray;
	}

	private String[] copy(String[] randomArray) {
		return Arrays.copyOf(randomArray, randomArray.length);
	}
}
