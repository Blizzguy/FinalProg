import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jose Perez Hurtado
 */
public class AñadirRegistro {

    /**
     * Metodo que permite insertar equipos a nuestra base de datos
     * @param con la conexion con la base de datos
     */

    public static void insertarEquipo(Connection con){
        int team_id;
        String cont;
        String eq_nombre;
        String estadio;
        String poblacion;
        String provincia;
        int cod_postal;

        do{
            SLeer2.limpiar();

            do {
                team_id = SLeer2.datoInt("Introduce el ID del equipo: ");

                if(team_id <= 0){
                    System.err.println("El ID debe ser entero positivo.");
                }
                if(ExisteRegistro.existeEquipo(con,team_id)){
                    System.err.println("El ID introducido existe en la base de datos.");
                }


                SLeer2.limpiar();
            }while(team_id <=0 || ExisteRegistro.existeEquipo(con,team_id));

            do{

                eq_nombre = SLeer2.datoString("Introduce el nombre del equipo: ").toUpperCase();

                if(eq_nombre.length() < 1 || eq_nombre.length() > 40){
                    System.err.println("Rango incorrecto");
                }


            }while(eq_nombre.length() < 1 || eq_nombre.length() > 40);

            do{

                estadio = SLeer2.datoString("Introduce el nombre del estadio del equipo: ").toUpperCase();

                if(estadio.length() < 1 || estadio.length() > 40){
                    System.err.println("Rango incorrecto");
                }

            }while(estadio.length() < 1 || estadio.length() > 40);

            do{

                poblacion = SLeer2.datoString("Introduce el nombre de la población del equipo: ").toUpperCase();

                if(poblacion.length() < 1 || poblacion.length() > 40){
                    System.err.println("Rango incorrecto");
                }

            }while(poblacion.length() < 1 || poblacion.length() > 20);

            do{

                provincia = SLeer2.datoString("Introduce el nombre de la provincia del equipo: ").toUpperCase();

                if(provincia.length() < 1 || provincia.length() > 20){
                    System.err.println("Rango incorrecto");
                }

            }while(provincia.length() < 1 || provincia.length() > 20);

            do{

                cod_postal = SLeer2.datoInt("Introduce el codigo postal del equipo: ");

                if(Integer.toString(cod_postal).length() != 5){
                    System.err.println("Tiene que ser 5 digitos.");
                }

                SLeer2.limpiar();

            }while(Integer.toString(cod_postal).length() != 5);

            Statement stmt = null;
            String query = "SELECT * FROM " + EquiposBD.BASE_DATOS + ".EQUIPOS;";

            try{
                stmt = con.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery(query) ;
                rs.moveToInsertRow();
                rs.updateInt("TEAM_ID", team_id) ;
                rs.updateString ("EQ_NOMBRE", eq_nombre);
                rs.updateString ("ESTADIO", estadio);
                rs.updateString ("POBLACION", poblacion);
                rs.updateString ("PROVINCIA", provincia);
                rs.updateInt("COD_POSTAL", cod_postal);
                rs.insertRow();
                rs.beforeFirst();

                System.out.println("\n\tEquipo creado con exito.");
                Imprimir.imprimirResumen(CuantosEquipos.numeroEquipos(con),CuantosJugadores.numeroJugadores(con));

                stmt.close();
            }catch (SQLException e) {
                EquiposBD.printSQLException(e);
            }



            do{
                cont = SLeer2.datoString("¿Desea añadir otro equipo? [S]/[N]: ").toUpperCase();

                if(!cont.equals("S") && !cont.equals("N")){
                    System.err.println("Elección incorrecta");
                }


            }while(!cont.equals("S") && !cont.equals("N"));

        }while(cont.equals("S"));
    }

    /**
     * Metodo que permite insertar jugadores a nuestra base de datos
     * @param con la conexion con la base de datos
     */

    public static void insertarJugador(Connection con){

        int team_id;
        int player_id;
        String nombre;
        int edad;
        int dorsal;
        String cont;


        do{
            SLeer2.limpiar();

            do {
                player_id = SLeer2.datoInt("Introduce el ID del jugador: ");

                if(player_id <= 0){
                    System.err.println("El ID debe ser entero positivo.");
                }
                if(ExisteRegistro.existeEquipo(con,player_id)){
                    System.err.println("El ID introducido existe en la base de datos.");
                }


                SLeer2.limpiar();
            }while(player_id <=0 || ExisteRegistro.existeEquipo(con,player_id));

            do {
                team_id = SLeer2.datoInt("Introduce el ID del equipo. ");

                if(team_id <= 0){
                    System.err.println("El ID debe ser entero positivo.");
                }
                if(!ExisteRegistro.existeEquipo(con,team_id)){
                    System.err.println("El ID introducido existe en la base de datos.");
                }


                SLeer2.limpiar();
            }while(team_id <=0 || !ExisteRegistro.existeEquipo(con,team_id));

            do{

                nombre = SLeer2.datoString("Introduce el nombre del jugador: ").toUpperCase();

                if(nombre.length() < 1 || nombre.length() > 40){
                    System.err.println("Rango incorrecto");
                }


            }while(nombre.length() < 1 || nombre.length() > 40);

            do {
                edad = SLeer2.datoInt("Introduce la edad del jugador: ");

                if(edad <= 5){
                    System.err.println("Demasiado joven para jugar.");
                }


                SLeer2.limpiar();
            }while(edad <=5);

            do {
                dorsal = SLeer2.datoInt("Introduce el dorsal del jugador: ");

                if(dorsal <= 0){
                    System.err.println("No existe ese dorsal.");
                }


                SLeer2.limpiar();
            }while(dorsal <=0);

            Statement stmt = null;
            String query = "INSERT INTO " + EquiposBD.BASE_DATOS + ".JUGADORES(PLAYER_ID, TEAM_ID, NOMBRE, DORSAL, EDAD) "+
                    "VALUES ("+ player_id +", "+ team_id+","+"\""+nombre+"\", "+ dorsal +", "+ edad +");";

            try{
                stmt = con.createStatement();
                stmt.executeUpdate(query);
                System.out.println("\n\t¡Jugador creado con éxito!\n");
                Imprimir.imprimirResumen(CuantosEquipos.numeroEquipos(con),CuantosJugadores.numeroJugadores(con));

                stmt.close();
            }catch (SQLException e) {
                EquiposBD.printSQLException(e);
            }



            do{
                cont = SLeer2.datoString("¿Desea añadir otro jugador? [S]/[N]: ").toUpperCase();

                if(!cont.equals("S") && !cont.equals("N")){
                    System.err.println("Elección incorrecta");
                }


            }while(!cont.equals("S") && !cont.equals("N"));

        }while(cont.equals("S"));

    }
}
