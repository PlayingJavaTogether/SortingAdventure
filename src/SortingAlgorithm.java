
public interface SortingAlgorithm {
	
	void resetPerformanceCounters();
	
	String[] sort(String[] listToSort);
	
	PerformanceInfo getPerformanceOfLastSort();
}