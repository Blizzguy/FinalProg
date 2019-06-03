import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CuantosJugadores {

    public static int numeroJugadores(Connection con){

    Statement stmt = null;
        String query = "SELECT COUNT(PLAYER_ID) FROM "+EquiposBD.BASE_DATOS+".JUGADORES;";

        int conJug = 0;


        try{
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                conJug = rs.getInt(1);

            }

            stmt.close();
        }catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }

        return conJug;

    }

    public static int numeroJugadoresEquipo(Connection con, int team_id) {

        Statement stmt = null;
        String query = "SELECT COUNT(PLAYER_ID) from "+EquiposBD.BASE_DATOS+".JUGADORES WHERE TEAM_ID =" +team_id;

        int conJug = 0;


        try{
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                conJug = rs.getInt(1);

            }

            stmt.close();
        }catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }

        return conJug;

    }


}
