package Exceptions;

class InsufficientBalanceException extends Exception{
	
	String message="";
	public InsufficientBalanceException() {
		// TODO Auto-generated constructor stub
		this.message="";
	}
	public InsufficientBalanceException(String message){		
		this.message=message;
	}
	
	public String toString(){
		return message;
	}
	
}

class Accounts{
	
	int balance=0;
	public Accounts() {
		// TODO Auto-generated constructor stub
	}
	public Accounts(int balance){
		this.balance=balance;
	}
	
	int withdrawn() throws InsufficientBalanceException{
		if(balance <=100){
			throw new InsufficientBalanceException(""+balance);
		}
		
		return balance;
	}
}

public class ExceptionTest {

	public static void main(String[] args) throws InsufficientBalanceException {
		// TODO Auto-generated method stub
		
		Accounts a=new Accounts(50);
		a.withdrawn();
		

	}

}
