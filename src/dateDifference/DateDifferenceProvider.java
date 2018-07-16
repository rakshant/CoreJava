package dateDifference;

public class DateDifferenceProvider {
	
	public static final int JAN=31;
	public static final int FEB=28;
	public static final int MAR=31;
	public static final int APR=30;
	public static final int MAY=31;
	public static final int JUN=30;
	public static final int JUL=31;
	public static final int AUG=31;
	public static final int SEP=30;
	public static final int OCT=31;
	public static final int NOV=30;
	public static final int DEC=31;
	
	public static int[] months={JAN, FEB,MAR,APR,MAY,JUN, JUL,AUG,SEP, OCT, NOV,DEC};
	static int startMonth;
	static int endMonth;
	static int totalDays=0;
	static int startYear;
	static int endYear;

	
	static long getDateDifference(MyDate startDate,MyDate endDate){
		
		if(sameMonth(startDate, endDate)==0 && sameDay(startDate, endDate)==0 && sameYear(startDate, endDate)==0){
			return 0;
		}
		else if(sameMonth(startDate, endDate)==0 && sameYear(startDate, endDate)==0 && sameDay(startDate, endDate)!=0){
			return endDate.getDd()-startDate.getDd();
		}
		else if(sameMonth(startDate, endDate)!=0 && sameYear(startDate, endDate)==0){
			
			return (long)sameMonth(startDate, endDate);
		}
		else if(sameYear(startDate, endDate)!=0){			
			return sameYear(startDate, endDate);
		}		
		return 1;	
	}
	


	public static int sameMonth(MyDate startDate, MyDate endDate){
		if(startDate.getMm()==endDate.getMm()){			
			return 0;
		}
		
		else{
			startMonth=startDate.getMm();
			endMonth=endDate.getMm();	
			
					if(startMonth==2){
						if(isleapYear(startDate.getYyyy())){
							totalDays=(months[startMonth-1]-startDate.getDd())+endDate.getDd();
							totalDays+=1;
						}
					}
					else{
						totalDays=(months[startMonth-1]-startDate.getDd())+endDate.getDd();
					}
				
				
				for(int i=startMonth;i<(endMonth-1);i++){		
					
					if(i==1){
						if(isleapYear(startDate.getYyyy())){
							totalDays+=months[i];
							totalDays+=1;
						}
						else{
							totalDays+=months[i];
						}
					}
					else{
						totalDays+=months[i];
					}					
						
				}						
				return totalDays;
		
		}
			
			
	}

	
	
	public static long sameYear(MyDate startDate, MyDate endDate){
		if(startDate.getYyyy()==endDate.getYyyy()){

			return 0;
		}
		else{
			startYear=startDate.getYyyy();
			endYear=endDate.getYyyy();
			if(endYear-startYear==1){
				return leadingDay(startDate, endDate)+remainingDays(startDate, endDate);
			}
			else{
				totalDays=leadingDay(startDate, endDate)+remainingDays(startDate, endDate);
				for(int i=(startYear+1);i<(endYear);i++){
					if(isleapYear(i)){
						totalDays+=366;
					}
					else{
						totalDays+=365;
					}
					
				}
				return totalDays;
			}
			
		}
		
	}
	
	
	public static int sameDay(MyDate startDate, MyDate endDate){
		if(startDate.getDd()==endDate.getDd()){
			return 0;
		}
		else{
			return 1;
		}
		
	}
	
	
	
	public static boolean isleapYear(int year){	
		if((year%4==0 &&year%100!=0) ||year%400==0){
			return true;		
		}
		else{
			return false;
		}		
	}

	public static int remainingDays(MyDate startDate, MyDate endDate){
		startMonth=startDate.getMm();
		
		if(startMonth==2){
			if(isleapYear(startDate.getYyyy())){
				totalDays=(months[startMonth-1]-startDate.getDd());
				totalDays+=1;
			}
			
		}
		totalDays=(months[startMonth-1]-startDate.getDd());
		
		for(int i=startMonth ; i<12 ; i++){
			totalDays+=months[i];	
		}
		return totalDays;
		
	}
	
	public static int leadingDay(MyDate startDate, MyDate endDate){
		endMonth=endDate.getMm();		
		totalDays=endDate.getDd();
		for(int i=0;i<endMonth-1;i++){
			if(i==1){
				if(isleapYear(endDate.getYyyy())){
					totalDays+=months[i];
					totalDays++;
				}
				else{
					totalDays+=months[i];
				}
			}
			else{
					totalDays+=months[i];	
			}		
		}
		return totalDays;			
	}		
}
