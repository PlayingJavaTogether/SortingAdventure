
public class BubbleSorting implements SortingAlgorithm {

	@Override
	public String[] sort(String[] listToSort) {
		String[] reversedList = listToSort;
		for (int counterOne=0; counterOne<reversedList.length-1; counterOne++){
			
			for (int counterTwo=0; counterTwo < reversedList.length-counterOne-1; counterTwo++){
				
				if (reversedList[counterTwo].compareTo(reversedList[counterTwo+1]) > 0){
					
					String buffer = reversedList[counterTwo];
					reversedList[counterTwo] = reversedList[counterTwo+1];
					reversedList[counterTwo+1] = buffer;
				}
			}
		}
		
		return reversedList;
	}
	
}
