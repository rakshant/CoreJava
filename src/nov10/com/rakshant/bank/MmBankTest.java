package nov10.com.rakshant.bank;

public class MmBankTest {

	public static void main(String[] args) {
		
		BankFactory bankfactory=new MMBankFactory();
		bankfactory.getNewSavingAccount(1, "Rakshant" , 5000.0f, true);
		bankfactory.getNewCurrentAccount(2, "harshal", 6000.0f,500 );
		

	}

}
