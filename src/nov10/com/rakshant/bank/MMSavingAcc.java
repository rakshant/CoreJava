package nov10.com.rakshant.bank;

class MMSavingAcc extends SavingAcc{
	
	private static final float MINBAL=100.0f;
	
	public MMSavingAcc(int accNo, String accNm ,float accBal,boolean isSalaried) {
		super(accNo, accNm, accBal, isSalaried);
		this.isSalaried=isSalaried;
	}

	public static float getMinbal() {
		return MINBAL;
	}

	@Override
	public void deposite(float balance) {
		float accBal=this.getAccBal();
		this.setAccBal(accBal+balance);		
	}
	
	public String toString(){
		return this.getAccNm()+" "+this.getAccBal();
	}

}

class MMCurrentAcc extends CurrentAcc{

	public MMCurrentAcc(int accNo, String accNm, float accBal, float creditLimit) {
		super(accNo, accNm, accBal, creditLimit);		
	}

	@Override
	public void deposite(float balance) {
		float accBal=this.getAccBal();
		this.setAccBal(accBal+balance);
	}
	
	public String toString(){
		return this.getAccNm()+" "+this.getAccBal();
	}
}
