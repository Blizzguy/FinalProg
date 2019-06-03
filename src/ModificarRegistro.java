import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jose Perez Hurtado
 */

public class ModificarRegistro {

    /**
     * Este metodo permite modificar un jugador existente en la base de datos
     * @param con la conexion realizada con el jugador
     */

    public static void modificarJugador(Connection con) {

        String cont;

        do {

            int player_id;

            do {
                player_id = SLeer2.datoInt("Introduce el ID del jugador: ");

                if (player_id <= 0) {
                    System.err.println("El ID debe ser entero positivo.");
                }
                if (!ExisteRegistro.existeJugador(con, player_id)) {
                    System.err.println("El ID introducido no existe en la base de datos.");
                }


                SLeer2.limpiar();
            } while (player_id <= 0 || !ExisteRegistro.existeJugador(con, player_id));

            System.out.println("\nLos datos del jugador que desea modificar son: ");

            ConsultarJugadorEquipo.mostrarJugador(con, player_id);

            String resp;

            do {
                resp = SLeer2.datoString("¿Qué dato desea modificar?: ").toUpperCase();

            } while (!resp.equals("TEAM_ID") && !resp.equals("NOMBRE") && !resp.equals("DORSAL")
                    && !resp.equals("EDAD"));

            int num = 0;
            String cadena = "";

            switch (resp) {
                case "TEAM_ID":
                    do {
                        num = SLeer2.datoInt("Introduce el ID del equipo: ");

                        if (num <= 0) {
                            System.err.println("El ID debe ser entero positivo.");
                        }
                        if (!ExisteRegistro.existeEquipo(con, num)) {
                            System.err.println("El ID introducido existe en la base de datos.");
                        }

                    } while (num <= 0 || !ExisteRegistro.existeEquipo(con, num));
                    break;

                case "NOMBRE":
                    do {

                        cadena = SLeer2.datoString("Introduce el nombre del jugador: ").toUpperCase();

                        if (cadena.length() < 1 || cadena.length() > 40) {
                            System.err.println("Rango incorrecto");
                        }
                        if (!Character.isLetter(cadena.charAt(0))) {
                            System.err.println("Debes poner una letra primero");
                        }


                    } while (!Character.isLetter(cadena.charAt(0)) || cadena.length() < 1 || cadena.length() > 40);
                    break;

                case "DORSAL":

                    do {
                        num = SLeer2.datoInt("Introduce el dorsal del jugador: ");

                        if (num <= 0) {
                            System.err.println("No existe ese dorsal.");
                        }


                        SLeer2.limpiar();
                    } while (num <= 0);
                    break;

                case "EDAD":

                    do {
                        num = SLeer2.datoInt("Introduce la edad del jugador: ");

                        if (num <= 5) {
                            System.err.println("Demasiado joven para jugar.");
                        }


                        SLeer2.limpiar();
                    } while (num <= 5);
                    break;

                default:
                    break;
            }

            if(resp.equals("TEAM_ID") || resp.equals("DORSAL") || resp.equals("EDAD")){

                cadena = Integer.toString(num);
            }

            Statement stmt = null;
            String query = "UPDATE "+EquiposBD.BASE_DATOS+".JUGADORES SET "+resp+" = '" +cadena+ "' WHERE PLAYER_ID = "+player_id+";";

            try{
                stmt = con.createStatement();
                stmt.executeUpdate(query);
                System.out.println("\n\t¡Jugador modificado con éxito!");
                ConsultarJugadorEquipo.mostrarJugador(con,player_id);
                Imprimir.imprimirResumen(CuantosEquipos.numeroEquipos(con),CuantosJugadores.numeroJugadores(con));

                stmt.close();
            }catch (SQLException e) {
                EquiposBD.printSQLException(e);
            }



            do {
                SLeer2.limpiar();
                cont = SLeer2.datoString("¿Desea modificar otro jugador? [S]/[N]: ").toUpperCase();

                if (!cont.equals("S") && !cont.equals("N")) {
                    System.err.println("Elección incorrecta");
                }


            } while (!cont.equals("S") && !cont.equals("N"));

        } while (cont.equals("S"));
    }

    /**
     * Este metodo permite modificar los datos de un equipo de la base de datos
     * @param con la conexion con la base de datos
     */

    public static void modificarEquipo(Connection con){

        String cont;

        do {

            int team_id;

            do {
                team_id = SLeer2.datoInt("Introduce el ID del equipo: ");

                if (team_id <= 0) {
                    System.err.println("El ID debe ser entero positivo.");
                }
                if (!ExisteRegistro.existeEquipo(con, team_id)) {
                    System.err.println("El ID introducido no existe en la base de datos.");
                }


                SLeer2.limpiar();
            } while (team_id <= 0 || !ExisteRegistro.existeEquipo(con, team_id));

            System.out.println("\nLos datos del Equipo que desea modificar son: ");
            ConsultarJugadorEquipo.mostrarEquipo(con, team_id);

            String resp;

            do {
                resp = SLeer2.datoString("¿Qué dato desea modificar?: ").toUpperCase();

                if(!resp.equals("EQ_NOMBRE") && !resp.equals("ESTADIO") && !resp.equals("POBLACION")
                        && !resp.equals("PROVINCIA") && !resp.equals("COD_POSTAL")){
                    System.err.println("Campo no existente.");
                }

            } while (!resp.equals("EQ_NOMBRE") && !resp.equals("ESTADIO") && !resp.equals("POBLACION")
                    && !resp.equals("PROVINCIA") && !resp.equals("COD_POSTAL"));


            String cadena = "";
            int num = 0;

            switch (resp) {
                case "EQ_NOMBRE":
                    do{

                        cadena = SLeer2.datoString("Introduce el nombre del equipo").toUpperCase();

                        if(cadena.length() < 1 || cadena.length() > 40){
                            System.err.println("Rango incorrecto");
                        }


                    }while(cadena.length() < 1 || cadena.length() > 40);
                    break;

                case "ESTADIO":
                    do{

                        cadena = SLeer2.datoString("Introduce el nombre del estadio del equipo: ").toUpperCase();

                        if(cadena.length() < 1 || cadena.length() > 40){
                            System.err.println("Rango incorrecto");
                        }

                    }while(cadena.length() < 1 || cadena.length() > 40);
                    break;

                case "POBLACION":

                    do{

                        cadena = SLeer2.datoString("Introduce el nombre de la población del equipo: ").toUpperCase();

                        if(cadena.length() < 1 || cadena.length() > 40){
                            System.err.println("Rango incorrecto");
                        }


                    }while( cadena.length() < 1 || cadena.length() > 20);
                    break;

                case "PROVINCIA":

                    do{

                        cadena = SLeer2.datoString("Introduce el nombre de la provincia del equipo: ").toUpperCase();

                        if(cadena.length() < 1 || cadena.length() > 20){
                            System.err.println("Rango incorrecto");
                        }


                        SLeer2.limpiar();

                    }while(cadena.length() < 1 || cadena.length() > 20);
                    break;

                case "COD_POSTAL":

                    do{

                        num = SLeer2.datoInt("Introduce el codigo postal del equipo: ");

                        if(Integer.toString(num).length() != 5){
                            System.err.println("Tiene que ser 5 digitos.");
                        }

                        SLeer2.limpiar();

                    }while(Integer.toString(num).length() != 5);

                default:
                    break;
            }

            if(resp.equals("COD_POSTAL")){

                cadena = Integer.toString(num);
            }



            Statement stmt = null;
            String query = "SELECT * FROM " + EquiposBD.BASE_DATOS + ".EQUIPOS;";

            try {
                stmt = con.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    rs.updateString(resp,cadena);
                    rs.updateRow();
                }

                System.out.println("\n\tEquipo actualizado con éxito.");

                ConsultarJugadorEquipo.mostrarEquipo(con,team_id);
                Imprimir.imprimirResumen(CuantosEquipos.numeroEquipos(con),CuantosJugadores.numeroJugadores(con));
                stmt.close();

            }catch (SQLException e) {
                EquiposBD.printSQLException(e);
            }



            do {
                cont = SLeer2.datoString("¿Desea modificar otro equipo? [S]/[N]: ").toUpperCase();

                if (!cont.equals("S") && !cont.equals("N")) {
                    System.err.println("Elección incorrecta");
                }


            } while (!cont.equals("S") && !cont.equals("N"));

        } while (cont.equals("S"));

    }
}
