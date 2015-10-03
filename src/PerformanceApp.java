import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;


public class PerformanceApp {
	
	private static final int TOTAL_NUMBER_OF_TESTS = 5;

	public static void main(String[] args) {
		SortingAlgorithm[] sortingAlgorithms = new SortingAlgorithm[] {
				new BubbleSorting(),
				new HeapSorting(),
				new QuickSorting()
		};
		
		int size = 1; 
		for (int testSample = 1; testSample <= TOTAL_NUMBER_OF_TESTS; testSample++) {
			String[] testData = generateTestDataOfLength(size);
			System.out.println("========================== Test #" + testSample + " for " + size + " elements ================================");
			size *= 10;
			
			for (SortingAlgorithm sorting : sortingAlgorithms) {
				String[] dataCopy = Arrays.copyOf(testData, testData.length);
				
				@SuppressWarnings("unused")
				String[] ignoredResultOfSorting = sorting.sort(dataCopy);
				
				PerformanceInfo performanceInfo = sorting.getPerformanceOfLastSort();
				
				System.out.println(performanceInfo);
			}
		}
	}

	private static String[] generateTestDataOfLength(int arrayLength) {
		String[] array = new String[arrayLength];
		for (int counter = 1; counter <= arrayLength; counter++) {
			int index = counter - 1;
			array[index] = generateRandomString();
		}
		return array;
	}
	
	private static SecureRandom random = new SecureRandom();
	private static String generateRandomString() {
		return new BigInteger(130, random).toString(32);
	}
}
