
public class QuickSorting implements SortingAlgorithm {

	@Override
	public String[] sort(String[] listToSort) {
		String[] resultList = listToSort;
		int wall = 0;
		String lastElement = resultList[resultList.length-1];
		while (wall != resultList.length-1) {

			for (int index = wall; index <= resultList.length-1; index++) {
				
				
				if (resultList[index].compareTo(lastElement) <= 0) {

					String buffer = resultList[index];
					resultList[index] = lastElement;
					lastElement = buffer;
					wall++;
				}
				if (resultList[index].equals(lastElement)) {

					String buffer = resultList[wall];
					resultList[wall] = lastElement;
					lastElement = buffer;
					wall++;
				}
			}
		}

		return resultList;
	}

}
