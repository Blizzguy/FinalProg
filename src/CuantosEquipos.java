import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jose Perez Hurtado
 */
public class CuantosEquipos {

    /**
     * Este metodo permite saber cuantos equipos hay en la base de datos
     * @param con la conexion con la base de datos
     * @return un entero que indica la cantidad de equipos que hay
     */

    public static int numeroEquipos(Connection con) {
        Statement stmt = null;
        String query = "SELECT COUNT(TEAM_ID) FROM "+EquiposBD.BASE_DATOS+".EQUIPOS;";

        int conEqu = 0;


        try{
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                conEqu = rs.getInt(1);

            }

            stmt.close();
        }catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }

        return conEqu;
    }
}
