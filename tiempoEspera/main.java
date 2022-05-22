package tiempoEspera;

public class main {

	public static void main(String[] args) {    
		int seconds = 5;
		DelayTime tiempo = DelayTime.CreateDelay(seconds);
		
		System.out.println("Tiempo Cuenta Atrás: " + tiempo.getTime() + "segundos");
		System.out.println("Hora de inicio " + tiempo.getStartDate());
		tiempo.countDown();
		System.out.println("Hora fin " + tiempo.getDate());
	}  
}      