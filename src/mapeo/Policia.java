package mapeo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="departamento_policia")
public class Policia implements Serializable {
    @Id
    @Column(name = "num_placa")
    private Integer numPlaca;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "antiguedad")
    private Integer antiguedad;

    //En el mappedBy se pone el nombre del atributo de la otra clase que tiene el "1 a n"
    @OneToMany(mappedBy = "policia", cascade = CascadeType.ALL)
    private List<Criminal> criminals;

    public Policia(int numPlaca, String nombre, String apellidos, int antiguedad, List<Criminal> criminals){
        this.numPlaca = numPlaca;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.antiguedad = antiguedad;
        this.criminals = criminals;
    }

    public Policia() {
        this.numPlaca=0;
        this.nombre="";
        this.apellidos="";
        this.antiguedad=0;
        this.criminals=null;
    }

    public int getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(int numPlaca) {
        this.numPlaca = numPlaca;
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

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public List<Criminal> getCriminals() {
        return criminals;
    }

    public void setCriminals(List<Criminal> criminals) {
        this.criminals = criminals;
    }

    @Override
    public String toString() {
        return "Policia{" +
                "numPlaca=" + numPlaca +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", antiguedad=" + antiguedad +
                ", criminals=" + criminals +
                '}';
    }
}
