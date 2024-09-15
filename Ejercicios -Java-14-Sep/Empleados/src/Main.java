import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        ArrayList<Empleados> empleados = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("1. Agregar nuevo empleado");
            System.out.println("2. Registrar evaluación de desempeño");
            System.out.println("3. Calcular bonificación");
            System.out.println("4. Mostrar detalles del empleado");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            
            switch (opcion) {
              case 1:
            	  System.out.println("Nombre del empleado: ");
            	  String nombre = sc.next();
            	  System.out.println("ID del empleado: ");
            	  String id = sc.next();
            	  System.out.println("Salario base: ");
            	  double salarioBase = sc.nextDouble();
            	  empleados.add(new Empleados(nombre, id, salarioBase));
                  System.out.println("Empleado agregado correctamente.");
                  break;
              case 2:
            	  System.out.println("ID del empleado para evaluar: ");
            	  String idEval = sc.next();
                  Empleados empEval = buscarEmpleado(empleados, idEval);
                  if (empEval != null) {
                      System.out.print("Evaluación del desempeño (0-10): ");
                      double evaluacion = sc.nextDouble();
                      empEval.registrarEvaluacion(evaluacion);
                  } else {
                      System.out.println("Empleado no encontrado.");
                  }
                  break;
              case 3:
            	  System.out.print("ID del empleado para calcular bonificación: ");
                  String idBonif = sc.next();
                  Empleados empBonif = buscarEmpleado(empleados, idBonif);
                  if (empBonif != null) {
                      empBonif.calcularBonificacion();
                      System.out.println("Bonificación calculada.");
                  } else {
                      System.out.println("Empleado no encontrado.");
                  }
                  break;
              case 4:
                  System.out.println("ID del empleado para mostrar detalles: ");
                  String idDetalles = sc.next();
                  Empleados empDetalles = buscarEmpleado(empleados, idDetalles);
                  if (empDetalles != null) {
                      empDetalles.mostrarDetalles();
                  } else {
                      System.out.println("Empleado no encontrado.");
                  }
                  break;
              case 5:
                  System.out.println("Saliendo del sistema...");
                  break;
              default:
                  System.out.println("Opción no válida.");
                  break;
            }
            
        } while (opcion != 5);

        sc.close();
        }
        public static Empleados buscarEmpleado(ArrayList<Empleados> empleados, String id) {
            for (Empleados emp : empleados) {
                if (emp.getId().equals(id)) {
                    return emp;
                }
            }
            return null;
        }
    }
