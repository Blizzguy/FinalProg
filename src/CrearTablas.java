import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jose Perez Hurtado
 */

public class CrearTablas {


    /**
     * Este metodo crea la tabla jugadores que usaremos en la base de datos
     * @param con la conexion con la base de datos
     */
    public static void createJUGADORES(Connection con){
        String createString = "create table if not exists " + EquiposBD.BASE_DATOS + ".JUGADORES" +
                "(PLAYER_ID integer NOT NULL," +
                "TEAM_ID integer NOT NULL," +
                "NOMBRE varchar(40) NOT NULL," +
                "DORSAL integer NOT NULL," +
                "EDAD integer NOT NULL," +
                "PRIMARY KEY (PLAYER_ID)," +
                "FOREIGN KEY (TEAM_ID) REFERENCES EQUIPOS (TEAM_ID))";
        Statement stmt;

        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
            System.out.println("La tabla de JUGADORES ha sido creada.\n");

            SLeer2.limpiar();
            stmt.close();
        } catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }
    }

    /**
     * Este metodo permite crear la tabla de equipos que usaremos en la base de datos
     * @param con la conexion con la base de datos
     */
    public static void createEQUIPOS(Connection con){
        String createString = "create table if not exists " + EquiposBD.BASE_DATOS + ".EQUIPOS " +
                "(TEAM_ID integer NOT NULL," +
                "EQ_NOMBRE varchar(40) NOT NULL," +
                "ESTADIO varchar(40) NOT NULL," +
                "POBLACION varchar(20) NOT NULL," +
                "PROVINCIA varchar(20) NOT NULL," +
                "COD_POSTAL char(5)," +
                "PRIMARY KEY (TEAM_ID))";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
            System.out.println("La tabla de EQUIPOS ha sido creada.\n");
            stmt.close();
        } catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }
    }

}
