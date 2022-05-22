package tiempoEspera;

public interface iDelay {
	
	double getTime();
	
	double getTimeLeft(double timeago);
	
	String getStartDate();
	
	void increase(double amount);
	
	void decrease(double amount);
}
