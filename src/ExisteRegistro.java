import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jose Perez Hurtado
 */
public class ExisteRegistro {

    /**
     * Metodo que permite comprobar si el id del equipo indicado existe en la base de datos
     * @param con la conexion con la base de datos
     * @param TEAM_ID el id del equipo para comprobar
     * @return si existe o no
     */

    static boolean existeEquipo(Connection con, int TEAM_ID) {
        Statement stmt;
        boolean existe = false;
        String query = "select count(*) as cuantos from " + EquiposBD.BASE_DATOS + ".EQUIPOS where TEAM_ID = " + TEAM_ID + ";";

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int cuantos = 0;

            while (rs.next()) {
                cuantos = rs.getInt("cuantos");
            }

            if (cuantos == 1) {
                existe = true;
            }else{
                 existe = false;
            }

            stmt.close();

        } catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }

        return existe;
    }

    /**
     * Metodo que permite comprobar si el id del jugador indicado existe en la base de datos
     * @param con la conexion con la base de datos
     * @param TEAM_ID el id del jugador para comprobar
     * @return si existe o no
     */

    static boolean existeJugador(Connection con, int PLAYER_ID) {
        Statement stmt;
        boolean existe = false;
        String query = "select count(*) as cuantos from " + EquiposBD.BASE_DATOS + ".JUGADORES where PLAYER_ID = " + PLAYER_ID + ";";

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int cuantos = 0;

            while (rs.next()) {
                cuantos = rs.getInt("cuantos");
            }

            if (cuantos == 1) {
                existe = true;
            }else{
                existe = false;
            }

            stmt.close();

        } catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }

        return existe;
    }



}
