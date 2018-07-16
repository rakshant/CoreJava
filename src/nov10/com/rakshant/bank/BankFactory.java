package nov10.com.rakshant.bank;

abstract class BankFactory {

	public abstract SavingAcc getNewSavingAccount(int accNo, String accNm, float accBal, boolean isSalaried);
	public abstract CurrentAcc getNewCurrentAccount(int accNo, String accNm, float accBal, float creditLimit);

}

class MMBankFactory extends BankFactory{

	@Override
	public SavingAcc getNewSavingAccount(int accNo, String accNm, float accBal,
			boolean isSalaried) {
		SavingAcc savingAcc=new MMSavingAcc(accNo, accNm, accBal, isSalaried);
		return savingAcc;
	}

	@Override
	public CurrentAcc getNewCurrentAccount(int accNo, String accNm,
			float accBal, float creditLimit) {
		CurrentAcc currentAcc=new MMCurrentAcc(accNo,accNm,accBal,creditLimit);
		return currentAcc;
	}
	
}