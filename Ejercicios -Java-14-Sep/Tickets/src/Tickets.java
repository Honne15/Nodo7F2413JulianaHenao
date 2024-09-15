import java.util.Scanner;

class Pelicula {
	private String  nombre;
	private String horario;
	
	public Pelicula(String nombre, String horario) {
		this.nombre = nombre;
		this.horario = horario;
	}
	
	public String getNombre() {
        return nombre;
    }

    public String getHorario() {
        return horario;
    }
}

class Asiento {
	private boolean disponible;
	
	public Asiento () {
		this.disponible = true;
	}
	
	public boolean isDisponible() {
		return disponible;
	}
	
	public void reservar() {
		this.disponible = false;
	}
}

class Cine {
	private Pelicula[] peliculas;
	private Asiento[][] asientos;
	private final int filas = 5;
	private final int columnas = 5;
	
	public Cine() {
		peliculas = new Pelicula[] {
			new Pelicula("Pelicula Infantil", "15:00"),
	        new Pelicula("Pelicula Juvenil", "18:00"),
	        new Pelicula("Pelicula Adultez", "20:00")
		};
		
		asientos = new Asiento[filas][columnas];
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
			    asientos[i][j] = new Asiento();
		}
	}	
}


	public void mostrarPeliculas() {
        System.out.println("Películas disponibles:");
        for (int i = 0; i < peliculas.length; i++) {
            System.out.println((i + 1) + ". " + peliculas[i].getNombre() + " - " + peliculas[i].getHorario());
        }
    }
	
	public Pelicula seleccionarPelicula(int indice) {
        if (indice >= 1 && indice <= peliculas.length) {
            return peliculas[indice - 1];
        } else {
            System.out.println("Selección no válida.");
            return null;
        }
    }
	
	public void mostrarAsientos() {
        System.out.println("Estado de los asientos (D = Disponible, X = Reservado):");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (asientos[i][j].isDisponible()) {
                    System.out.print("D ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

	public boolean reservarAsiento(int fila, int columna) {
		if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            System.out.println("Asiento no válido.");
            return false;
        }
		
		if (asientos[fila][columna].isDisponible()) {
            asientos[fila][columna].reservar(); 
            System.out.println("Asiento reservado con éxito.");
            return true;
        } else {
            System.out.println("El asiento ya está reservado.");
            return false;
        }
    }
}

class Reserva {
	private Cine cine;
	private Scanner scanner;
	
	public Reserva(Cine cine) {
        this.cine = cine;
        scanner = new Scanner(System.in);
}

	public void iniciar() {
		boolean continuar = true;

        while (continuar) {
            cine.mostrarPeliculas();
            System.out.println("Seleccione una película (número): ");
            int seleccionPelicula = scanner.nextInt();

            Pelicula peliculaSeleccionada = cine.seleccionarPelicula(seleccionPelicula);
            if (peliculaSeleccionada == null) {
                continue; 
            }

            System.out.println("Has seleccionado: " + peliculaSeleccionada.getNombre());
            System.out.println("Horario: " + peliculaSeleccionada.getHorario());

          
            cine.mostrarAsientos();
            System.out.println("Seleccione una fila (1-5): ");
            int fila = scanner.nextInt();
            System.out.println("Seleccione una columna (1-5): ");
            int columna = scanner.nextInt();

            if (cine.reservarAsiento(fila, columna)) {
                procesarPago();
            }

            System.out.println("¿Desea hacer otra reserva? (Si/No)");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("No")) {
                continuar = false; 
            }
        }
    }
	

	private void procesarPago() { 
		System.out.println("Procesando pago...");
		System.out.println("Pago procesado exitosamente.");
		
	}
}

public class Tickets {
	public static void main(String[] args) {
		Cine cine = new Cine();
		Reserva reserva = new Reserva(cine);
		reserva.iniciar();
	}
}
