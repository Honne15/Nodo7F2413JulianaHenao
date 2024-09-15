import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Notificacion implements Runnable {
	private List<Reunion> reuniones;

    public Notificacion(List<Reunion> reuniones) {
        this.reuniones = reuniones;
    }
    
    @Override
    public void run() {
    	while (true) {
    		LocalDateTime ahora = LocalDateTime.now();
    		for (Reunion reunion : reuniones) {
    			Duration duracion = Duration.between(ahora, reunion.getInicio());
    			long minutos = duracion.toMinutes();
    			
    			if (minutos > 0 && minutos <= 5) {
    				System.out.println("Notificación: La reunión \" " + reunion.getTitulo() + "\"empieza en " + minutos +  " minutos.");
    			}
    		}
    		
    		try {
    			Thread.sleep(60000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }
}
