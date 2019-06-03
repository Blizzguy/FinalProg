/**
 * @author Jose Perez Hurtado
 */

public class Imprimir {

    /**
     * Este metodo imprime los datos indicados de los equipos de la base de datos
     * @param team_id id del equipo
     * @param eq_nombre nombre del equipo
     * @param estadio estadio del equipo
     * @param poblacion poblacion del equipo
     * @param provincia provincia del equipo
     * @param cod_postal codigo postal de equipo
     */

    public static void imprimirEquipo(int team_id, String eq_nombre, String estadio, String poblacion, String provincia, String cod_postal){

        System.out.println("************************************************");
        System.out.println("NºEquipo: " + team_id);
        System.out.println("Nombre: " + eq_nombre);
        System.out.println("Estadio: " + estadio);
        System.out.println("Población: " + poblacion);
        System.out.println("Provincia: " + provincia);
        System.out.println("Código Postal: " + cod_postal);

        System.out.println("************************************************");
    }

    /**
     * Este metodo imprime los datos indicados de los jugadores de la base de datos
     * @param playerId id del jugador
     * @param teamId id del equipo
     * @param nombre nombre del jugador
     * @param dorsal dorsal del jugador
     * @param edad edad del jugador
     */
    public static void imprimirJugador(int playerId, int teamId, String nombre, String dorsal, String edad){
        System.out.println("************************************************");
        System.out.println("*NºJugador: " + playerId);

        System.out.println("*NºEquipo: " + teamId);

        System.out.println("*Nombre: " + nombre);

        System.out.println("*Dorsal: " + dorsal);

        System.out.println("*Edad: " + edad);
        System.out.println("************************************************");
    }

    public static void imprimirResumen(int nEquipos, int nJugadores){



        System.out.println("\n*************************************************");
        System.out.println("*El número de jugadores creados: "+nJugadores);
        System.out.println("*");
        System.out.println("*El número de equipos creados son: "+nEquipos);
        System.out.println("*************************************************");

    }
}
