import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jose Perez Hurtado
 */
public class VerTablas {

    /**
     * Este metodo permite ver todos los equipos de la tabla equipos
     * @param con la conexion con la base de datos
     */
    public static void verEquipos(Connection con) {
        SLeer2.limpiar();

        Statement stmt = null;
        String query = "select team_id, eq_nombre, estadio, poblacion, provincia, cod_postal from " + EquiposBD.BASE_DATOS + ".equipos;";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Imprimir.imprimirEquipo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
            }

            stmt.close();
        } catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }

    }

    /**
     * Este metodo permite ver todos los jugadores de la tabla jugadores
     * @param con la conexion con la base de datos
     */
    public static void verJugadores(Connection con) {
        SLeer2.limpiar();

        Statement stmt = null;
        String query = "select PLAYER_ID, TEAM_ID, NOMBRE, DORSAL, EDAD from " + EquiposBD.BASE_DATOS + ".JUGADORES;";

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Imprimir.imprimirJugador(rs.getInt("PLAYER_ID"), rs.getInt("TEAM_ID"),
                        rs.getString("NOMBRE"), rs.getString("DORSAL"), rs.getString("EDAD"));
            }

            stmt.close();


        } catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }


    }

    /**
     * Este metodo permite ver los jugadores de la tabla jugadores asignados a un equipo en concreto
     * @param con la conexion con la base de datos
     */

    public static void verJugadoresEquipo(Connection con){

        SLeer2.limpiar();
        int respuesta;

        do {
            respuesta = SLeer2.datoInt("Indique el id del equipo: ");

            if (!ExisteRegistro.existeEquipo(con, respuesta)) {
                System.out.println("¡ID del equipo inexistente!");
            }

        } while (!ExisteRegistro.existeEquipo(con, respuesta));
        Statement stmt = null;
        String query = "select PLAYER_ID, TEAM_ID, NOMBRE, DORSAL, EDAD from " + EquiposBD.BASE_DATOS + ".JUGADORES where TEAM_ID = "
        +respuesta+";";

        SLeer2.limpiar();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Imprimir.imprimirJugador(rs.getInt("PLAYER_ID"), rs.getInt("TEAM_ID"),
                        rs.getString("NOMBRE"), rs.getString("DORSAL"), rs.getString("EDAD"));
            }

            stmt.close();


        } catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }


    }
}
