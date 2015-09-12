
// TODO : http://me.dt.in.th/page/Quicksort/

public class QuickSorting implements SortingAlgorithm {

	@Override
	public String[] sort(String[] listToSort) {
		if (listToSort.length <= 1)
			return listToSort;
		
		return sort(listToSort, 0, listToSort.length - 1);
	}
	
	private String[] sort(String[] listToSort, int leftBoundary, int rightBoundary) {
		// 1. choose pivot
		int pivotIndex = (leftBoundary + rightBoundary) / 2;
		
		// 2.a define subarray boundaries
		// 2.b swap with first elem within sorting subarray
		swap(listToSort, pivotIndex, leftBoundary);
		
		int tempIndexOfPivot = leftBoundary;
		int indexOfLastClosed = tempIndexOfPivot;
		
		int indexOfLeftMostOpen = tempIndexOfPivot + 1;
		int indexOfOpening = tempIndexOfPivot + 1;
		
		// 3. do partitioning <--
		for ( ; indexOfOpening <= rightBoundary; indexOfOpening++) { // or rightBoundary - 1 ????
			
			String valueOfPivot = listToSort[tempIndexOfPivot];
			String currentElement = listToSort[indexOfOpening];
			boolean isSwapRequired = valueOfPivot.compareTo(currentElement) > 0;
			
			if (isSwapRequired) {
				swap(listToSort, indexOfOpening, indexOfLeftMostOpen);
				indexOfLeftMostOpen++;
				indexOfLastClosed = indexOfOpening; // ?????????????????????????????????????
			}
		}
		
		swap(listToSort, tempIndexOfPivot, indexOfLastClosed);
		
		int newIndexOfPivot = indexOfLastClosed;
		
		
		if (newIndexOfPivot > leftBoundary) {
			// 4.a sort (left) first partion
			sort(listToSort, leftBoundary, newIndexOfPivot - 1);
		}
		if (newIndexOfPivot < rightBoundary) {
			// 4.b sort (right) third partition
			sort(listToSort, newIndexOfPivot + 1, rightBoundary);
		}
		
		return listToSort;
	}
	
	private void swap(String[] listToSort, int index1, int index2) {
		String buffer = listToSort[index1];
		listToSort[index1] = listToSort[index2];
		listToSort[index2] = buffer;
	}

	// @Override
	public String[] sortOriginal(String[] listToSort) {
		String[] resultList = listToSort;
		int wallIndex = 0;
		int indexOfLastElement = resultList.length - 1;

		while (wallIndex != indexOfLastElement) {
			for (int index = wallIndex; index <= indexOfLastElement; index++) {
				
				if (resultList[index].compareTo(resultList[indexOfLastElement]) > 0) {
					String buffer = resultList[index];
					resultList[index] = resultList[indexOfLastElement];
					resultList[indexOfLastElement] = buffer;
					wallIndex++;
				}

				if (resultList[index].equals(resultList[indexOfLastElement])) {
					String buffer = resultList[wallIndex];
					resultList[wallIndex] = resultList[indexOfLastElement];
					resultList[indexOfLastElement] = buffer;
					wallIndex++;
				}
			}
		}

		return resultList;
	}

}
