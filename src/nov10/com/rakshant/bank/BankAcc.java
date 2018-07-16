package nov10.com.rakshant.bank;

abstract class BankAcc {
	
	private int accNo;
	private float accBal;
	private String accNm;
	
	public abstract  void withdraw(float balance);
	public abstract void deposite(float balance);
	
	
	public BankAcc(int accNo, String accNm, float accBal) {		
		this.accNo = accNo;
		this.accBal = accBal;
		this.accNm = accNm;
	}
	
	public String toString(){	
		return accNo+" "+accNm+" "+accBal;
	}
	public int getAccNo() {
		return accNo;
	}
	public float getAccBal() {
		return accBal;
	}
	protected void setAccBal(float accBal) {
		this.accBal = accBal;
	}
	public String getAccNm() {
		return accNm;
	}

}

abstract class SavingAcc extends BankAcc{

	boolean isSalaried;
	private static final float MINBAL=100.0f;
	
	
	public SavingAcc(int accNo, String accNm ,float accBal,boolean isSalaried) {
		super(accNo, accNm, accBal);
		this.isSalaried=isSalaried;
	}
	
	public void withdraw(float balance){
		if(balance<MINBAL)
			System.out.println("Can't withdrawn, not sufficient balance");
		else{
			float accBal=this.getAccBal();
			accBal-=balance;
			this.setAccBal(accBal);
			System.out.println("Balance withdrawn");
		}			
	}
	
	public String toString(){	
		return isSalaried+"";
	}

	public boolean isSalaried() {
		return isSalaried;
	}

	public static float getMinbal() {
		return MINBAL;
	}
	 
}


abstract class CurrentAcc extends BankAcc{
	
	private final float creditLimit;
	
	public CurrentAcc(int accNo, String accNm, float accBal,float creditLimit) {
		super(accNo, accNm, accBal);
		this.creditLimit=creditLimit;
	}
	
	public void withdraw(float balance){
		if(getAccBal()+getCreditLimit()>balance){
			float accBal=this.getAccBal();
			accBal-=balance;
			this.setAccBal(accBal);
			System.out.println("Balance withdrawn");
		}
		else{
			System.out.println("Overreached your limit");
		}
	}

	public float getCreditLimit() {
		return creditLimit;
	}
	
}



