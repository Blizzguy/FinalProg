import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jose Perez Hurtado
 */
public class EliminarTablas {

    /**
     * Metodo que sirve para eliminar las tablas de la base de datos
     * @param con conexion con la base de datos
     */

    public static void eliminarTablas(Connection con){

        SLeer2.limpiar();

        String conf;

        do {
            conf = SLeer2.datoString("¿Estas seguro de eliminar las tablas jugadores y equipos? [S]/[N]: ").toUpperCase();

            if (!conf.equals("S") && !conf.equals("N")) {
                System.err.println("Elección incorrecta");
            }
        }while(!conf.equals("S") && !conf.equals("N"));

        if(conf.equals("S")) {

            String query = "DROP TABLE IF EXISTS "+EquiposBD.BASE_DATOS +".JUGADORES,"+EquiposBD.BASE_DATOS +".EQUIPOS;";

            Statement stmt;

            try {
                stmt = con.createStatement();
                stmt.executeUpdate(query);
                System.out.println("Las tablas han sido eliminadas.\n");
                stmt.close();
            } catch (SQLException e) {
                EquiposBD.printSQLException(e);
            }
        }else{
            System.out.println("\nPues nos vamos a freir monas.");
        }

    }
}
