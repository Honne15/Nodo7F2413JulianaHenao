import java.time.LocalDateTime;
import java.util.List;

public class Reunion {
	private String titulo;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private List<String> participantes;

    public Reunion(String titulo, LocalDateTime inicio, LocalDateTime fin, List<String> participantes) {
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
        this.participantes = participantes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    public boolean solapaCon(Reunion otraReunion) {
        return inicio.isBefore(otraReunion.getFin()) && fin.isAfter(otraReunion.getInicio());
    }
}
