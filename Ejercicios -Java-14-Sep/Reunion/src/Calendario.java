import java.util.ArrayList;
import java.util.List;

public class Calendario {
	private List<Reunion> reuniones;
    private Thread notificador;

    public Calendario() {
        reuniones = new ArrayList<>();
        iniciarNotificador();
    }
    
    private void iniciarNotificador() {
    	notificador = new Thread(new Notificacion(reuniones));
    	notificador.start();
    }
    
    public boolean agregarReunion(Reunion nuevaReunion) {
    	for (Reunion reunion : reuniones) {
    		if(reunion.solapaCon(nuevaReunion)) {
    			System.out.println("Error: La reunión se sobrepone con otra existente.");
    			return false;
    		}
    	}
    	reuniones.add(nuevaReunion);
    	System.out.println("Reunión agregada exitosamente.");
    	return true;
    }
    
    public void editarReunion(int indice, Reunion reunionEditada) {
    	if (indice >= 0 && indice < reuniones.size()) {
    		reuniones.set(indice,  reunionEditada);
    		System.out.println("Reunión editada exitosamente.");
    	} else {
    		System.out.println("Error: el indicador de reunión no es válido.");
    	}
    }
    
    public void eliminarReunion(int indice) {
        if (indice >= 0 && indice < reuniones.size()) {
            reuniones.remove(indice);
            System.out.println("Reunión eliminada exitosamente.");
        } else {
            System.out.println("Error: no se pudo eliminar la reunión.");
        }
    }
    
    public void mostrarReuniones() {
        for (int i = 0; i < reuniones.size(); i++) {
            Reunion r = reuniones.get(i);
            System.out.println(i + ": " + r.getTitulo() + " | Desde: " + r.getInicio() + " Hasta: " + r.getFin());
        }
    }
}
