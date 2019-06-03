import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jose Perez Hurtado
 */
public class EliminarBD {

    /**
     * Este metodo elimina la base de datos
     * @param con la conexion con la base de datos
     */

    static void eliminarBaseDatos(Connection con) {

        SLeer2.limpiar();

        String conf;

        do {
            conf = SLeer2.datoString("¿Estas seguro de eliminar la base de datos? [S]/[N]: ").toUpperCase();

            if (!conf.equals("S") && !conf.equals("N")) {
                System.err.println("Elección incorrecta");
            }
        }while(!conf.equals("S") && !conf.equals("N"));

        if(conf.equals("S")) {

            String createBD = "DROP DATABASE IF EXISTS " + EquiposBD.BASE_DATOS;

            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate(createBD);

                System.out.println("\n\tBase de datos eliminada.");

                stmt.close();
            } catch (SQLException e) {
                EquiposBD.printSQLException(e);
            }
        }else{
            System.out.println("\n Pues nos vamos a freir monas.");
        }

    }

}
