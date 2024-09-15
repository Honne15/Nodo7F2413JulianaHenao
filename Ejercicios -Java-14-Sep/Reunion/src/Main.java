import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Calendario calendario = new Calendario();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
            System.out.println("\nOpciones: ");
            System.out.println("1. Crear reunión");
            System.out.println("2. Editar reunión");
            System.out.println("3. Eliminar reunión");
            System.out.println("4. Ver reuniones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
            case 1:
                System.out.print("Ingrese título: ");
                String titulo = scanner.next();

                System.out.print("Ingrese año de inicio: ");
                int anoInicio = scanner.nextInt();
                System.out.print("Ingrese mes de inicio: ");
                int mesInicio = scanner.nextInt();
                System.out.print("Ingrese día de inicio: ");
                int diaInicio = scanner.nextInt();
                System.out.print("Ingrese hora de inicio (0-23): ");
                int horaInicio = scanner.nextInt();
                System.out.print("Ingrese minuto de inicio: ");
                int minutoInicio = scanner.nextInt();

                LocalDateTime inicio = LocalDateTime.of(anoInicio, mesInicio, diaInicio, horaInicio, minutoInicio);

                System.out.print("Ingrese año de fin: ");
                int anoFin = scanner.nextInt();
                System.out.print("Ingrese mes de fin: ");
                int mesFin = scanner.nextInt();
                System.out.print("Ingrese día de fin: ");
                int diaFin = scanner.nextInt();
                System.out.print("Ingrese hora de fin (0-23): ");
                int horaFin = scanner.nextInt();
                System.out.print("Ingrese minuto de fin: ");
                int minutoFin = scanner.nextInt();

                LocalDateTime fin = LocalDateTime.of(anoFin, mesFin, diaFin, horaFin, minutoFin);
                
                System.out.print("Ingrese el número de participantes: ");
                int numParticipantes = scanner.nextInt();
                List<String> participantes = new ArrayList<>();
                for (int i = 0; i < numParticipantes; i++) {
                    System.out.print("Ingrese el nombre del participante " + (i + 1) + ": ");
                    String participante = scanner.next();
                    participantes.add(participante);
                }

                Reunion nuevaReunion = new Reunion(titulo, inicio, fin, participantes);
                calendario.agregarReunion(nuevaReunion);
                break;

            case 2:
                calendario.mostrarReuniones();
                System.out.print("Ingrese el índice de la reunión a editar: ");
                int indiceEditar = scanner.nextInt();
                break;

            case 3:
                calendario.mostrarReuniones();
                System.out.print("Ingrese el índice de la reunión a eliminar: ");
                int indiceEliminar = scanner.nextInt();
                calendario.eliminarReunion(indiceEliminar);
                break;

            case 4:
                calendario.mostrarReuniones();
                break;

            case 5:
                System.out.println("Saliendo...");
                scanner.close();
                return;

            default:
                System.out.println("Opción no válida.");
                break;
           }
       }
   }
}