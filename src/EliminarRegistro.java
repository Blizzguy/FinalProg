import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jose Perez Hurtado
 */
public class EliminarRegistro {

    /**
     * Metodo que permite eliminar un equipo de la base de datos
     * @param con la conexion con la base de datos
     */

    public static void eliminarEquipo(Connection con) {

        SLeer2.limpiar();

        String continuar;
        int team_id;
        String conf;

        do {


            System.out.println("\n---------------------------------");
            do {
                team_id = SLeer2.datoInt("Introduce el ID del equipo: ");

                if(team_id <= 0){
                    System.err.println("El ID debe ser entero positivo.");
                }
                if(!ExisteRegistro.existeEquipo(con,team_id)){
                    System.err.println("El ID introducido no existe en la base de datos.");
                }


                SLeer2.limpiar();
            }while(team_id <=0 || !ExisteRegistro.existeEquipo(con,team_id));

            if(CuantosJugadores.numeroJugadoresEquipo(con,team_id) == 0){
                System.out.println(" \nLos datos del equipo que deseas eliminar son: ");
                ConsultarJugadorEquipo.mostrarEquipo(con,team_id);

                do{
                    conf = SLeer2.datoString("¿Estas seguro de eliminar el equipo? [S]/[N]: ").toUpperCase();

                    if(!conf.equals("S") && !conf.equals("N")){
                        System.err.println("Elección incorrecta");
                    }


                }while(!conf.equals("S") && !conf.equals("N"));

                if(conf.equals("S")){
                    Statement stmt = null;
                    String query = "DELETE FROM "+EquiposBD.BASE_DATOS+".EQUIPOS where TEAM_ID =" +team_id;

                    try{
                        stmt = con.createStatement();
                        stmt.executeUpdate(query);
                        System.out.println("\n\t¡Equipo eliminado con éxito!");
                        Imprimir.imprimirResumen(CuantosEquipos.numeroEquipos(con),CuantosJugadores.numeroJugadores(con));
                        stmt.close();
                    }catch (SQLException e) {
                        EquiposBD.printSQLException(e);
                    }

                }
            }else{
                System.out.println("\n\t No se puede eliminar el equipo mientras tenga jugadores.");
            }

            do{
                continuar = SLeer2.datoString("¿Desea eliminar otro equipo? [S]/[N]: ").toUpperCase();

                if(!continuar.equals("S") && !continuar.equals("N")){
                    System.err.println("Elección incorrecta");
                }


            }while(!continuar.equals("S") && !continuar.equals("N"));

        }while(continuar.equals("S"));
    }

    /**
     * Este metodo permite eliminar un jugador de la base de datos
     * @param con la conexion con la base de datos
     */

    public static void eliminarJugador(Connection con) {

        SLeer2.limpiar();
        String continuar;
        int PLAYER_ID;
        String conf;

        do {


            System.out.println("\n---------------------------------");
            do {
                PLAYER_ID = SLeer2.datoInt("Introduce el ID del jugador: ");

                if(PLAYER_ID <= 0){
                    System.err.println("El ID debe ser entero positivo.");
                }
                if(!ExisteRegistro.existeJugador(con,PLAYER_ID)){
                    System.err.println("El ID introducido no existe en la base de datos.");
                }


                SLeer2.limpiar();
            }while(PLAYER_ID <=0 || !ExisteRegistro.existeJugador(con,PLAYER_ID));

                System.out.println(" \nLos datos del jugador que deseas eliminar son: ");
                ConsultarJugadorEquipo.mostrarJugador(con,PLAYER_ID);

                do{
                    conf = SLeer2.datoString("¿Estas seguro de eliminar el jugador? [S]/[N]: ").toUpperCase();

                    if(!conf.equals("S") && !conf.equals("N")){
                        System.err.println("Elección incorrecta");
                    }


                }while(!conf.equals("S") && !conf.equals("N"));

                if(conf.equals("S")){
                    Statement stmt = null;
                    String query = "DELETE FROM "+EquiposBD.BASE_DATOS+".JUGADORES where PLAYER_ID =" +PLAYER_ID;

                    try{
                        stmt = con.createStatement();
                        stmt.executeUpdate(query);
                        System.out.println("\n\t¡Jugador eliminado con éxito!");
                        Imprimir.imprimirResumen(CuantosEquipos.numeroEquipos(con),CuantosJugadores.numeroJugadores(con));
                        stmt.close();
                    }catch (SQLException e) {
                        EquiposBD.printSQLException(e);
                    }

                }


            do{
                continuar = SLeer2.datoString("¿Desea eliminar otro jugador? [S]/[N]: ").toUpperCase();

                if(!continuar.equals("S") && !continuar.equals("N")){
                    System.err.println("Elección incorrecta");
                }


            }while(!continuar.equals("S") && !continuar.equals("N"));

        }while(continuar.equals("S"));
    }
}
