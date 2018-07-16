package dateDifference;

public class TestData {
	MyDate startDate;
	MyDate endDate;
	long expectedResult;
	
	public TestData(MyDate startDate, MyDate endDate, long expectedResult) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.expectedResult = expectedResult;
	}


}
