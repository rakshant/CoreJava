package dateDifference;

public class MyDate {

	int dd;
	int mm;
	int yyyy;
	
	public MyDate() {
		this.dd=0;
		this.mm=0;
		this.yyyy=0;
	}
	public MyDate(int dd,int mm,int yyyy){
		this.dd=dd;
		this.mm=mm;
		this.yyyy=yyyy;
				
	}
	public int getDd() {
		return dd;
	}
	public int getMm() {
		return mm;
	}
	public int getYyyy() {
		return yyyy;
	}

}
