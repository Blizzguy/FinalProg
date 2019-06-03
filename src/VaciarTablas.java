import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jose Perez Hurtado
 */
public class VaciarTablas {


    /**
     * Este metodo permite vaciar todos los datos de las tablas de la base de datos
     * @param con la conexion con la base de datos
     */
    public static void vaciarTablas(Connection con) {

        SLeer2.limpiar();
        String respuesta;

        do{
            respuesta = SLeer2.datoString("¿Desea vaciar la tabla equipos y jugadores? [S]/[N]: ").toUpperCase();

            if(!respuesta.equals("S") && !respuesta.equals("N")){
                System.err.println("Elección incorrecta");
            }


        }while(!respuesta.equals("S") && !respuesta.equals("N"));


        if (respuesta.equals("S")) {

            vaciarJugadores(con);
            vaciarEquipos(con);

        } else {
            System.out.println("\nPues nos vamos a freír monas");
        }

    }

    /**
     * Este metodo permite vaciar los datos de la tabla jugadores
     * @param con la conexion con la base de datos
     */
    public static void vaciarJugadores(Connection con) {

        String createString = "delete from " + EquiposBD.BASE_DATOS + ".JUGADORES;";

        Statement stmt;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
            System.out.println("\nSe ha vaciado la tabla jugadores.");
            stmt.close();
        } catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }


    }

    /**
     * Este metodo permite vaciar los equipos de la base de datos
     * @param con la conexion con la base de datos
     */
    public static void vaciarEquipos(Connection con) {

        String createString = "delete from " + EquiposBD.BASE_DATOS + ".EQUIPOS;";

        Statement stmt;


        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
            System.out.println("\nSe ha vaciado la tabla equipos.");
            stmt.close();
        } catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }
    }


}
