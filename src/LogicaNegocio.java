import mapeo.Criminal;
import mapeo.Policia;
import org.hibernate.Session;

import java.util.Scanner;

public class LogicaNegocio {

    private HibernateUtil utilitario;
    private Session session;
    private Scanner sc;

    public LogicaNegocio(){
        utilitario = new HibernateUtil();
        session = utilitario.getSessionFactory().openSession();
        sc = new Scanner(System.in);
    }

    public void ejecutarAccionesPrototipo(){

    }

    private int menu(){
        System.out.println("Escoge una Opcion");
        System.out.println("1-Alta Cliente");
        System.out.println("2-Consulta Cliente");
        System.out.println("3-Consulta de todos los Clientes");
        System.out.println("4-Actualización de un Cliente");
        System.out.println("5-Borrado de un Cliente");
        System.out.println("6-Salir");
        return sc.nextInt();
    }

    public void insertarAgente(){
        System.out.println("Dime la placa del agente");
        int placa = sc.nextInt();
        sc.nextLine();
        System.out.println("Dime el nombre");
        String nombre = sc.nextLine();
        System.out.println("Dime los apellidos");
        String apellidos = sc.nextLine();
        System.out.println("Dime la antigüedad");
        int antiguedad = sc.nextInt();
        sc.nextLine();

        session.beginTransaction();
        Policia policia = new Policia();
        policia.setNumPlaca(placa);
        policia.setAntiguedad(antiguedad);
        policia.setApellidos(apellidos);
        policia.setNombre(nombre);


        session.save(policia);
        session.getTransaction().commit();
    }

    public void borrarAgente(){
        System.out.println("Dime el policia a borrar");
        int idBorar = sc.nextInt();
        sc.nextLine();
        session.beginTransaction();
        Policia policia = session.get(Policia.class, idBorar);
        session.getTransaction().commit();

        if(policia != null){
            session.delete(policia);
        }else{
            System.out.println("No esiste ese policia");
        }
        session.getTransaction().commit();
    }

    public void insertarCriminal(){
        System.out.println("Dime la id del criminal");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Dime el nombre del criminal");
        String nombre = sc.nextLine();

        System.out.println("Dime los apellidos del criminal");
        String apellidos = sc.nextLine();

        System.out.println("Dime el delito del criminal");
        String delito = sc.nextLine();

        System.out.println("Dime el policia que detuvo al criminal");
        int placa = sc.nextInt();
        sc.nextLine();

        session.beginTransaction();
        Criminal criminal = new Criminal(id,nombre,apellidos,delito,session.get(Policia.class, placa));
        session.save(criminal);
        session.getTransaction().commit();
    }


}
