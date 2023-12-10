package fullstackjava.proyectointegrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/oradores";
    private static final String user = "root";

    //Usando phpMyAdmin no necesito password:
//    private static final String password = "";

    //Usando MySQL necesito password:
    private static final String password = "A single root crossing the street";


    static {
        try {
            Class.forName(CONTROLADOR);
            System.out.println("Se cargó el controlador");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador");
            e.printStackTrace();
        }
    }
    public Connection conectar(){

        Connection conexion = null;

        try{
            conexion = DriverManager.getConnection(URL, user, password);
            System.out.println("Se generó la conexión en " + URL);
        } catch (SQLException e){
            System.err.println("Error al establecer la conexión");
            e.printStackTrace();
        }

        return conexion;
    }
}
