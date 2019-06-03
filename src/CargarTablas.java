import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jose Perez Hurtado
 */

public class CargarTablas {

    /**
     * Este metodo carga equipos preestablecios a nuestra base de datos
     * @param con la conexion a nuestra base de datos
     */

    public static void cargaEQUIPOS(Connection con){
        Statement stmt = null;
        try {
            stmt = con.createStatement();

            if(!ExisteRegistro.existeEquipo(con,1)) {
                stmt.executeUpdate("INSERT INTO " + EquiposBD.BASE_DATOS + ".EQUIPOS VALUES ("
                        + "1,'ESTEPONA','MONTERROSO','ESTEPONA','MALAGA','29680')");
            }

            if(!ExisteRegistro.existeEquipo(con,2)) {
                stmt.executeUpdate("INSERT INTO " + EquiposBD.BASE_DATOS + ".EQUIPOS VALUES ("
                        + "2,'ALCORCON','SANTO DOMINGO','ALCORCON','MADRID','28924')");
            }

            if(!ExisteRegistro.existeEquipo(con,3)) {
                stmt.executeUpdate("INSERT INTO " + EquiposBD.BASE_DATOS + ".EQUIPOS VALUES ("
                        + "3,'PORCUNA','SAN CRISTOBAL','PORCUNA','JAEN','23790')");
            }

                System.out.println("La tabla de EQUIPOS ha sido cargada.\n");

            stmt.close();
        } catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }
    }

    /**
     * Este metodo carga jugadores preestablecios a nuestra base de datos
     * @param con la conexion a nuestra base de datos
     */

    public static void cargaJUGADORES(Connection con){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            if(!ExisteRegistro.existeJugador(con,1)) {
                stmt.executeUpdate("INSERT INTO " + EquiposBD.BASE_DATOS + ".JUGADORES VALUES ("
                        + "1,1,'JOSE ANTONIO',1,42)");
            }

            if(!ExisteRegistro.existeJugador(con,2)) {
                stmt.executeUpdate("INSERT INTO " + EquiposBD.BASE_DATOS + ".JUGADORES VALUES ("
                        + "2,1,'IGNACIO',2,62)");
            }

            if(!ExisteRegistro.existeJugador(con,3)) {
                stmt.executeUpdate("INSERT INTO " + EquiposBD.BASE_DATOS + ".JUGADORES VALUES ("
                        + "3,1,'DIEGO',3,20)");
            }

            if(!ExisteRegistro.existeJugador(con,4)) {
                stmt.executeUpdate("INSERT INTO " + EquiposBD.BASE_DATOS + ".JUGADORES VALUES ("
                        + "4,2,'TURRION',1,37)");
            }

            if(!ExisteRegistro.existeJugador(con,5)) {
                stmt.executeUpdate("INSERT INTO " + EquiposBD.BASE_DATOS + ".JUGADORES VALUES ("
                        + "5,2,'LUIS ABEL',2,37)");
            }

            if(!ExisteRegistro.existeJugador(con,6)) {
                stmt.executeUpdate("INSERT INTO " + EquiposBD.BASE_DATOS + ".JUGADORES VALUES ("
                        + "6,2,'ISAAC',3,40)");
            }

            if(!ExisteRegistro.existeJugador(con,7)) {
                stmt.executeUpdate("INSERT INTO " + EquiposBD.BASE_DATOS + ".JUGADORES VALUES ("
                        + "7,3,'JUAN FRANCISCO',1,33)");
            }

            if(!ExisteRegistro.existeJugador(con,8)) {
                stmt.executeUpdate("INSERT INTO " + EquiposBD.BASE_DATOS + ".JUGADORES VALUES ("
                        + "8,3,'PARRA',2,37)");
            }

            if(!ExisteRegistro.existeJugador(con,9)) {
                stmt.executeUpdate("INSERT INTO " + EquiposBD.BASE_DATOS + ".JUGADORES VALUES ("
                        + "9,3,'RAUL',3,19)");
            }

            System.out.println("La tabla de JUGADORES ha sido cargada.\n");

            Imprimir.imprimirResumen(CuantosEquipos.numeroEquipos(con),CuantosJugadores.numeroJugadores(con));

            SLeer2.limpiar();

            stmt.close();

        } catch (SQLException e) {
            EquiposBD.printSQLException(e);
        }
    }
}
