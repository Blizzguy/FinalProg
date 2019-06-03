import java.sql.*;

/**
 * @author Jose Perez Hurtado
 */

public class ConectarBD {

    /**
     * Metodo que permite conectar a nuestra base de datos y crearla
     * @param con la conexion con nuestra base de datos
     */
    static void conectarBD(Connection con) {

        try {
            ResultSet rs = con.getMetaData().getCatalogs();
            boolean noexistebd = true;
            while(rs.next()){
                if(rs.getString("TABLE_CAT").equals(EquiposBD.BASE_DATOS)){
                    noexistebd = false;
                }
            }

            if(noexistebd){
                CrearBD.crearBaseDatos(con);
                System.out.println("\n\t--> Base de Datos " + EquiposBD.BASE_DATOS+" creada");
            }

        } catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }
    }
}
