import java.sql.*;

/**
 * @author Jose Perez Hurtado
 */

public class CrearBD {

    /**
     * Este metodo permite crear la base de datos que vamos a utilizar
     * @param con la conexion con la base de datos
     */

    static void crearBaseDatos(Connection con){

        String createBD = "create database if not exists "+ EquiposBD.BASE_DATOS;



        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(createBD);

            SLeer2.limpiar();
            stmt.close();
        }catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }
    }
}
