
public class BubbleSorting implements SortingAlgorithm {

	@Override
	public String[] sort(String[] listToSort) {
		String[] resultList = listToSort;
		for (int indexOne = 0; indexOne < resultList.length - 1; indexOne++) {

			for (int indexTwo = 0; indexTwo < resultList.length - indexOne - 1; indexTwo++) {

				if (resultList[indexTwo].compareTo(resultList[indexTwo + 1]) > 0) {

					String buffer = resultList[indexTwo];
					resultList[indexTwo] = resultList[indexTwo + 1];
					resultList[indexTwo + 1] = buffer;
				}
			}
		}

		return resultList;
	}

}
