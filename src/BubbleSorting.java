import java.util.Date;



public class BubbleSorting implements SortingAlgorithm {

	@Override
	public String[] sort(String[] listToSort) {
		resetPerformanceCounters();
		
		startTime = new Date();
		
		String[] resultList = listToSort;
		totalNumberOfOperations += 1;
		
		for (int indexOne = 0; indexOne < resultList.length - 1; indexOne++) {
			totalNumberOfOperations += 2;
			
			for (int indexTwo = 0; indexTwo < resultList.length - indexOne - 1; indexTwo++) {
				totalNumberOfOperations += 2;
				
				String string1 = resultList[indexTwo];
				totalNumberOfOperations += 1;
				
				String string2 = resultList[indexTwo + 1];
				totalNumberOfOperations += 1;
				
				if (string1.compareTo(string2) > 0) {
					totalNumberOfOperations += 1;
					
					swap(resultList, indexTwo, indexTwo + 1);
				}
			}
		}

		endTime = new Date();

		return resultList;
	}
	
	private void swap(String[] array, int index1, int index2) {
		String buffer = array[index1];
		array[index1] = array[index2];
		array[index2] = buffer;
		
		totalNumberOfOperations += 3;
		totalNumberOfSwaps += 1;
	}


	

	int totalNumberOfOperations;
	int totalNumberOfSwaps;
	Date startTime;
	Date endTime;
	
	@Override
	public void resetPerformanceCounters() {
		totalNumberOfOperations = 0;
		totalNumberOfSwaps = 0;
	}

	@Override
	public PerformanceInfo getPerformanceOfLastSort() {
		return new PerformanceInfo(BubbleSorting.class, totalNumberOfOperations, totalNumberOfSwaps, startTime, endTime);
	}

}
