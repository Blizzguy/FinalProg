import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EquiposBD {

    static String CONNECTION = "jdbc:mysql://localhost:3306/";
    static String USER = "root";
    static String PASSWORD = "";
    static String BASE_DATOS = "bdequipos";

    /**
     * Metodo que al terminar una operacion, pausa el programa
     */

    public static void pausa() {
        System.out.println("\n\tPulsa enter para ir al menu...");
        SLeer2.limpiar();
        cls();
    }

    /**
     * Metodo que genera espacios al terminar la pausa
     */

    public static void cls() {
        for (int cls = 0; cls <= 10; cls++) {
            System.out.println();
        }
    }

    /**
     * Metodo que permite las excepciones de sql
     *
     * @param ex la excepcion sql
     */

    static void printSQLException(SQLException ex) {

        ex.printStackTrace(System.err);
        System.err.println("SQLState: " + ex.getSQLState());
        System.err.println("Error Code: " + ex.getErrorCode());
        System.err.println("Message: " + ex.getMessage());
        Throwable t = ex.getCause();
        while (t != null) {
            System.out.println("Causa: " + t);
            t = t.getCause();
        }
        ;
    }

    /**
     * Este programa permite crear y eliminar una base de datos y crear,modificar y eliminar el contenido de ella
     *
     * @param args Main del programa
     */

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(CONNECTION, USER, PASSWORD);


            int opcion = Menu.menuBD();

            while (opcion != 16) {

                switch (opcion) {
                    case 1:
                        ConectarBD.conectarBD(con);
                        pausa();
                        break;

                    case 2:
                        EliminarBD.eliminarBaseDatos(con);
                        pausa();
                        break;

                    case 3:
                        CrearTablas.createEQUIPOS(con);
                        CrearTablas.createJUGADORES(con);
                        pausa();
                        break;

                    case 4:
                        EliminarTablas.eliminarTablas(con);
                        pausa();
                        break;

                    case 5:
                        CargarTablas.cargaEQUIPOS(con);
                        CargarTablas.cargaJUGADORES(con);
                        pausa();
                        break;

                    case 6:
                        VaciarTablas.vaciarTablas(con);
                        pausa();
                        break;

                    case 7:
                        AñadirRegistro.insertarJugador(con);
                        pausa();
                        break;

                    case 8:
                        ModificarRegistro.modificarJugador(con);
                        pausa();
                        break;

                    case 9:
                        EliminarRegistro.eliminarJugador(con);
                        pausa();
                        break;

                    case 10:
                        VerTablas.verJugadores(con);
                        pausa();
                        break;

                    case 11:
                        VerTablas.verJugadoresEquipo(con);
                        pausa();
                        break;

                    case 12:
                        AñadirRegistro.insertarEquipo(con);
                        pausa();
                        break;

                    case 13:
                        ModificarRegistro.modificarEquipo(con);
                        pausa();
                        break;


                    case 14:
                        EliminarRegistro.eliminarEquipo(con);
                        pausa();
                        break;


                    case 15:
                        VerTablas.verEquipos(con);
                        pausa();
                        break;


                }

                opcion = Menu.menuBD();


            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        System.out.println("\n\tHasta luego Lucas.");
    }


}
