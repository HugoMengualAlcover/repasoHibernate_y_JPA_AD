package mapeo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="criminales_detenidos")
public class Criminal implements Serializable {

    @Id
    @Column (name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "delito")
    private String delito;


    @ManyToOne
    @JoinColumn(name="placa_agente")
    private Policia policia;

    public Criminal(int id, String nombre, String apellidos, String delito, Policia policia){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.delito = delito;
        this.policia = policia;
    }

    public Criminal(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDelito() {
        return delito;
    }

    public void setDelito(String delito) {
        this.delito = delito;
    }

    public Policia getPolicia() {
        return policia;
    }

    public void setPolicia(Policia policia) {
        this.policia = policia;
    }

    @Override
    public String toString() {
        return "Criminal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", delito='" + delito + '\'' +
                ", policia=" + policia +
                '}';
    }
}
