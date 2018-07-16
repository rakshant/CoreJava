abstract class Account{	
	public abstract int getSavings();	
}


class Saving extends Account{

	private int fixedDeposit;
	
	public Saving() {
		// TODO Auto-generated constructor stub
	}
	public Saving(int fixed){
		this.fixedDeposit=fixed;
	}
	@Override
	public int getSavings() {
		// TODO Auto-generated method stub
		return fixedDeposit;
		
	}
	
}

class Current extends Account{
	
	private int cashCredit;
	public Current() {
		// TODO Auto-generated constructor stub
	}
	public Current(int credit){
		this.cashCredit=credit;
	}

	@Override
	public int getSavings() {
		return cashCredit;
		// TODO Auto-generated method stub
		
	}
	
}



public class AccountTest {
	
	private static void getTotalSavings(Account[] e) {
		// TODO Auto-generated method stub
		int totalCash=0;
		for(int i=0;i<e.length;i++){
			totalCash+=e[i].getSavings();
		}
		
		System.out.println("Total cash is-"+totalCash);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a[]=new Account[4];
		a[0]=new Current(1000);
		a[1]=new Current(2000);
		a[2]=new Saving(500);
		a[3]=new Saving(300);
		AccountTest.getTotalSavings(a);

	}


}
