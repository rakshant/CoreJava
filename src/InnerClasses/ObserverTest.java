package InnerClasses;

import java.util.ArrayList;
import java.util.List;

class Patient
{
	private List<Hospital> hosps=new ArrayList<Hospital>();
	private int bp;
	
	public int getBP()
	{
		return bp;
	}
	
	public void setBP(int bp)
	{
		this.bp=bp;
		if(bp>140)
			notifyAllObservers();
	}
	
	public void attach(Hospital hosp)
	{
		hosps.add(hosp);
	}
	
	public void notifyAllObservers()
	{
		for(Hospital itr:hosps)
		{
			itr.update();
		}
	}
}

abstract class Hospital
{
	protected Patient patient;
	public abstract void update();
}

class Patient1 extends Hospital
{
	public Patient1(Patient patient )
	{
		this.patient=patient;
		this.patient.attach(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Blood Pressure "+ patient.getBP());
	}
}

public class ObserverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Patient pat=new Patient();
		new Patient1(pat);
		//new Patient2(pat);
		
		System.out.println("Blood Pressure ");
		pat.setBP(139);
		pat.setBP(141);

	}

}
