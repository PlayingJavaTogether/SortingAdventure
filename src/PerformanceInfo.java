import java.util.Date;


public class PerformanceInfo {
	
	private final String algorithm;
	private final int totalNumberOfOperations;
	private final int totalNumberOfSwaps;
	private final Date startTime;
	private final Date endTime;
	
	public PerformanceInfo(
			@SuppressWarnings("rawtypes") Class sortingClass,
			int totalNumberOfOperations,
			int totalNumberOfSwaps,
			Date startTime,
			Date endTime) {
		
		this.algorithm = sortingClass.getName();
		this.totalNumberOfOperations = totalNumberOfOperations;
		this.totalNumberOfSwaps = totalNumberOfSwaps;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public int getTotalNumberOfOperations() { return totalNumberOfOperations; }
	public int getTotalNumberOfSwaps() { return totalNumberOfSwaps; }
	
	@Override
	public String toString() {
		return algorithm +
				" ops=" + totalNumberOfOperations +
				" swaps=" + totalNumberOfSwaps +
				" time(ms)=" + (endTime.getTime() - startTime.getTime());
	}
	
}