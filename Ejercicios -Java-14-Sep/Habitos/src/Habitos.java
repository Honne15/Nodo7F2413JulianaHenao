import java.util.ArrayList;
import java.util.Scanner;

class Habito{
	private String nombre;
	private int progreso;
	
	public Habito(String nombre) {
		this.nombre = nombre;
		this.progreso = 0;
	}
	
	public String getNombre() {
        return nombre;
    }

    public int getProgreso() {
        return progreso;
    }
	
    public void actualizarProgreso (int progreso){
    	if (progreso >= 0 && progreso <= 100) {
    		this.progreso = progreso;
    	} else {
    		System.out.println("El progreso debe ser de 0% a 100%");
    	}
    }
}

class RastreadorHabito {
	private ArrayList<Habito> habitos = new ArrayList <>();
	
	public void agregarHabito(String nombre){
		habitos.add(new Habito (nombre));
	}
	
	public void actualizarProgreso(String nombre, int progreso) {
		for (Habito habito : habitos) {
			if(habito.getNombre().equalsIgnoreCase(nombre)) {
				habito.actualizarProgreso(progreso);
				return;
			}
		}
		System.out.println("Hábito no encontrado.");
	}
	
	public void mostrarResumen() {
		System.out.println("\nResumen diario de hábitos:");
		for(Habito habito : habitos) {
			System.out.println(habito.getNombre() + ": " + habito.getProgreso() + "% completado");
		}
	}
}

public class Habitos {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RastreadorHabito rastreador = new RastreadorHabito();
        
        System.out.println("Ingrese la cantidad de hábitos que desea agregar:");
        int cantidadHabitos = scanner.nextInt();
        scanner.nextLine();	
        
        for(int i = 0; i < cantidadHabitos; i++) {
        	System.out.println("Ingrese el nombre del hábito " + (i + 1) + ":");
        	String nombre = scanner.nextLine();
        	rastreador.agregarHabito(nombre);
        }
        
        for(int i = 0; i < cantidadHabitos; i++) {
        	System.out.println("Ingrese el progreso (0-100%)  para el hábito " + (i + 1) + ":");
        	int progreso = scanner.nextInt();
        	scanner.nextLine();
        	System.out.println("Ingrese el nombre del hábito:");
        	String nombre = scanner.nextLine();
        	rastreador.actualizarProgreso(nombre, progreso);
        }
        
        rastreador.mostrarResumen();
        
        scanner.close(); 
	}
}
        
