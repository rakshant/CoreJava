package dateDifference;

import java.util.ArrayList;

public class DateTest {

	public static void main(String[] args) {
		
		ArrayList<TestData> dates=new ArrayList<TestData>();
		dates.add(new TestData(new MyDate(6,5,2011),new MyDate(6,5,2011) ,(long)0 ));	//case 1
		dates.add(new TestData(new MyDate(6,5,2011),new MyDate(8,5,2011) ,(long)2 ));	//case 2		
		dates.add(new TestData(new MyDate(6,4,2011),new MyDate(18,5,2011),(long)42 ));	//case 3
		dates.add(new TestData(new MyDate(6,4,2011),new MyDate(18,6,2011) ,(long)73 ));	//case 4
		dates.add(new TestData(new MyDate(6,4,2011),new MyDate(18,12,2011) ,(long)256 ));	//case 5
		dates.add(new TestData(new MyDate(6,4,2011),new MyDate(18,12,2012) ,(long)622 ));	//case 6
		dates.add(new TestData(new MyDate(6,4,2011),new MyDate(18,12,2013) ,(long)987 ));	//case 7
		dates.add(new TestData(new MyDate(6,4,2011),new MyDate(18,12,2113),(long)37511 ));	//case 8
		dates.add(new TestData(new MyDate(6,4,2011),new MyDate(18,12,2413) ,(long)147084 ));	//case 9
		dates.add(new TestData(new MyDate(6,4,2011),new MyDate(18,12,2813) ,(long)293181 ));	//case 10
		dates.add(new TestData(new MyDate(6,1,2011),new MyDate(6,3,2011) ,(long)59 ));	//case 11
		dates.add(new TestData(new MyDate(6,1,2012),new MyDate(6,3,2012) ,(long)60 ));	//case 12
		dates.add(new TestData(new MyDate(6,2,2012),new MyDate(6,3,2012) ,(long)29 ));	//case 13
		dates.add(new TestData(new MyDate(22,1,2012),new MyDate(15,11,2012) ,(long)298 ));	//case 14
		dates.add(new TestData(new MyDate(6,2,2012),new MyDate(6,12,2012) ,(long)304 ));	//case 15
		
		
		long outcome=0;
		int j=0;
		for(TestData td:dates){			
			outcome=DateDifferenceProvider.getDateDifference(td.startDate,td.endDate);
			
			if(outcome==td.expectedResult){
				System.out.println("Test case "+j+"passed , Outcome-"+outcome+" Expected-"+td.expectedResult);				
			}	
			else{
				System.err.println("Test case "+j+"failed , Outcome-"+outcome+" Expected"+td.expectedResult);	
			}
			j++;			
		}	
	}
}
