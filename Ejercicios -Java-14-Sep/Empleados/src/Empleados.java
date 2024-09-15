
public class Empleados {
	private String nombre;
	private String id;
	private double salarioBase;
	private double evaluacionDesempeno;
	private double bonificacion;
	
	public Empleados(String nombre, String id, double salarioBase) {
		this.nombre = nombre;
		this.id = id;
		this.salarioBase = salarioBase;
		this.evaluacionDesempeno = 0.0;
		this.bonificacion = 0.0;
	}
	
	public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getEvaluacionDesempeno() {
        return evaluacionDesempeno;
    }
    
    public void registrarEvaluacion(double evaluacion) {
        if (evaluacion >= 0 && evaluacion <= 10) {
            this.evaluacionDesempeno = evaluacion;
        } else {
            System.out.println("Evaluación fuera de rango (0-10)");
        }
    }
    
    public void calcularBonificacion() {
    	if(evaluacionDesempeno >= 9) {
    		bonificacion = salarioBase * 0.20;
    	}else if (evaluacionDesempeno >= 7) {
    		bonificacion = salarioBase * 0.10;
    	}else if (evaluacionDesempeno >= 5) {
    		bonificacion = salarioBase * 0.05;
    	}else {
    		bonificacion = 0;
    	}
    }
    
    public void mostrarDetalles() {
    	System.out.println("Nombre: " + nombre);
    	System.out.println("ID: " + id);
    	System.out.println("Salario base: " + salarioBase);
    	System.out.println("Evaluación desempeño: " + evaluacionDesempeno);
    	System.out.println("Bonificación: " + bonificacion);
    }
	
}
