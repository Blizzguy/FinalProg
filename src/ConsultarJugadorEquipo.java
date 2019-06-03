import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jose Perez Hurtado
 */

public class ConsultarJugadorEquipo {

    /**
     * Este metodo permite buscar un equipo en la base de datos
     * @param con la conexion realizada con la base de datos
     * @param team_id el id del equipo que permitira buscar en la base de datos
     */

    public static void mostrarEquipo(Connection con, int team_id) {

        Statement stmt = null;
        String query = "select TEAM_ID, EQ_NOMBRE, ESTADIO, POBLACION, PROVINCIA, COD_POSTAL from " + EquiposBD.BASE_DATOS + ".equipos where team_id =" + team_id;

        if (ExisteRegistro.existeEquipo(con, team_id)) {
            try {
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while ((rs.next())) {
                    Imprimir.imprimirEquipo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6));
                }

                stmt.close();
            } catch (SQLException e) {
                EquiposBD.printSQLException(e);
            }
        } else {
            System.out.println("No existe el equipo que has indicado");
        }

    }

    /**
     * Este metodo permite buscar un jugador en la base de datos
     * @param con la conexion con la base de datos
     * @param player_id el id del jugador que permitira buscar en la base de datos
     */

    public static void mostrarJugador(Connection con, int player_id) {

        Statement stmt = null;
        String query = "select PLAYER_ID, TEAM_ID, NOMBRE, DORSAL, EDAD from " + EquiposBD.BASE_DATOS + ".JUGADORES where PLAYER_ID =" + player_id;

        if (ExisteRegistro.existeJugador(con, player_id)) {
            try {
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()) {
                    Imprimir.imprimirJugador(rs.getInt("PLAYER_ID"), rs.getInt("TEAM_ID"),
                            rs.getString("NOMBRE"), rs.getString("DORSAL"), rs.getString("EDAD"));

                }
                stmt.close();
            } catch (SQLException e) {
                EquiposBD.printSQLException(e);
            }
        } else {
            System.out.println("\nNo existe el jugador que has indicado");
        }

    }
}
