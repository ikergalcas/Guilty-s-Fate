package tiempoEspera;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.time.LocalDateTime;    

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DelayTime implements iDelay{
	
	private double time;
	
	private static String startDate;
	final static double MAX=15;
	final static double min2sec=60;
	final static double hr2sec=3600;
	final static double day2sec=24*3600;
	
	
// Factories and constructors
	
	public static DelayTime CreateDelayDay(double day) {
		return new DelayTime(day*day2sec);
	}
	
	public static DelayTime CreateDelayHour(double hour) {
		return new DelayTime(hour*hr2sec);
	}
	
	public static DelayTime CreateDelayMinut(double minut) {
		return new DelayTime(minut*min2sec);
	}
	
	public static DelayTime CreateDelay(double seconds) {
		return new DelayTime(seconds);
	}

	private DelayTime(double seconds) {	
		time = Math.max(0, seconds);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		startDate=dtf.format(now);
	}

//Main operations
	
	public void countDown() {
	
   	 while (time>0 && time<=MAX){
   		 System.out.println("Tiempo restante: "+ time +"/s");
   		 try {
   			 time--;
   			 Thread.sleep(1000L);    // 1000L = 1000ms = 1 segundo
   		 }
   		 catch (InterruptedException e) {  
   			 //
   		 } 
   	 }//end while
   	 		System.out.println("Time over");
	        
	}
	
	public void setTime(int n) {
		if(n>0) {
			time=n;
		}
		
	}
	
	public double getTime() {
		return time;
	}
	
	public double getTimeLeft(double timeago) {
		return time-timeago;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	public void increase(double amount) {
		if (amount < 0) {
            throw new NegativeTimeException("negative time: " + amount);
        } else {
        	time += amount;
        }
	}
	// 
	public void decrease(double amount) {
		amount = Math.abs(amount);
		if (amount>time) {
            throw new NegativeTimeException("Invalid time: " + amount);
        }
       time -= amount;
       
	}
	
}
