
public class HeapSorting implements SortingAlgorithm {

	@Override
	public String[] sort(String[] listToSort) {
		// First main step Build Heap (ShiftUp) : ok
		String[] auxiliaryArray = new String[listToSort.length];
		int counterOfÀrray = 0;
		while (counterOfÀrray != auxiliaryArray.length) {
			auxiliaryArray[counterOfÀrray] = listToSort[counterOfÀrray];
			shiftUp(auxiliaryArray, counterOfÀrray);
			counterOfÀrray++;
		}
		
		
		String[] resultArray = new String[listToSort.length];
		counterOfÀrray = 0;
		// Second step (RemovingRoot) and Other (ShiftDown) :
		while (counterOfÀrray != resultArray.length) {
			resultArray[counterOfÀrray] = auxiliaryArray[0];
			int rightBoundary = auxiliaryArray.length - (counterOfÀrray + 1);
			auxiliaryArray[0] = auxiliaryArray[rightBoundary];
			shiftDown(auxiliaryArray, 0, rightBoundary);
			counterOfÀrray++;
		}

		return resultArray;
	}

	private void shiftDown(String[] auxiliaryArray, int indexOfStartElement, int rightBoundary) {
		// 1-----condition
		int childIndex1 = 0;
		int childIndex2 = 0;
		if (((2 * indexOfStartElement + 2) > rightBoundary) || ((2 * indexOfStartElement + 1) > rightBoundary)) {
			return;
		} else {
			childIndex1 = 2 * indexOfStartElement + 2;
			childIndex2 = 2 * indexOfStartElement + 1;
			if ((auxiliaryArray[indexOfStartElement].compareTo(auxiliaryArray[childIndex1]) >= 0)
					| (auxiliaryArray[indexOfStartElement].compareTo(auxiliaryArray[childIndex2]) >= 0)) {
				return;
			}
		}
		
		
		// 2-----replacement and repeat
		if ((2 * indexOfStartElement + 2) > rightBoundary) {
			swap(auxiliaryArray, indexOfStartElement, childIndex1);
			shiftDown(auxiliaryArray, childIndex1, rightBoundary);
		} else {
			int max = max(auxiliaryArray, childIndex1, childIndex2);
			swap(auxiliaryArray, indexOfStartElement, max);
			shiftDown(auxiliaryArray, max, rightBoundary);
		}

	}

	private int max(String[] auxiliaryArray, int childIndex1, int childIndex2) {
		if (auxiliaryArray[childIndex1].compareTo(auxiliaryArray[childIndex2]) > 0) {
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
			if (auxiliaryArray[indexOfStartElement].compareTo(auxiliaryArray[parentIndex]) <= 0) {
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

}