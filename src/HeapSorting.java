

public class HeapSorting implements SortingAlgorithm {

	@Override
	public String[] sort(String[] listToSort) {
		// First main step Build Heap (ShiftUp) : ok
		String[] auxiliaryArray = new String[listToSort.length];
		int counterOf�rray = 0;
		while (counterOf�rray != auxiliaryArray.length) {
			auxiliaryArray[counterOf�rray] = listToSort[counterOf�rray];
			shiftUp(auxiliaryArray, counterOf�rray);
			counterOf�rray++;
		}

		String[] resultArray = new String[listToSort.length];
		counterOf�rray = 0;
		// Second step (RemovingRoot) and Other (ShiftDown) :
		while (counterOf�rray != resultArray.length) {
			resultArray[counterOf�rray] = auxiliaryArray[0];
			int rightBoundary = auxiliaryArray.length - (counterOf�rray + 1);
			auxiliaryArray[0] = auxiliaryArray[rightBoundary];
			shiftDown(auxiliaryArray, 0, rightBoundary);
			counterOf�rray++;
		}
		return resultArray;
	}

	private void shiftDown(String[] auxiliaryArray, int indexOfStartElement, int rightBoundary) {
		// 1-----condition
		int childIndex1 = 2 * indexOfStartElement + 2;
		int childIndex2 = 2 * indexOfStartElement + 1;
		if ((childIndex1 > rightBoundary) || (childIndex2 > rightBoundary)) {
			return;
		} else {
			if ((auxiliaryArray[indexOfStartElement].compareTo(auxiliaryArray[childIndex1]) <= 0)
					&& (auxiliaryArray[indexOfStartElement].compareTo(auxiliaryArray[childIndex2]) <= 0)) {
				return;
			}
			int min = min(auxiliaryArray, childIndex1, childIndex2);
			swap(auxiliaryArray, indexOfStartElement, min);
			shiftDown(auxiliaryArray, min, rightBoundary);
		}
	}

	private int min(String[] auxiliaryArray, int childIndex1, int childIndex2) {
		if (auxiliaryArray[childIndex1].compareTo(auxiliaryArray[childIndex2]) < 0) {
			return childIndex1;
		} else {
			return childIndex2;
		}
	}

	private void shiftUp(String[] auxiliaryArray, int indexOfStartElement) {
		// 1-----condition
		int parentIndex = 0;
		if (indexOfStartElement == 0) {
			return;
		} else {
			parentIndex = (int) (indexOfStartElement - 1) / 2;
			if (auxiliaryArray[indexOfStartElement].compareTo(auxiliaryArray[parentIndex]) > 0) {
				return;
			}
		}
		// 2-----replacement
		swap(auxiliaryArray, indexOfStartElement, parentIndex);

		// 3-----repeat
		shiftUp(auxiliaryArray, parentIndex);
	}

	private void swap(String[] auxiliaryArray, int index1, int index2) {
		String buffer = auxiliaryArray[index1];
		auxiliaryArray[index1] = auxiliaryArray[index2];
		auxiliaryArray[index2] = buffer;
	}


	
	@Override
	public void resetPerformanceCounters() {
	}

	@Override
	public PerformanceInfo getPerformanceOfLastSort() {
		return null;
	}

}