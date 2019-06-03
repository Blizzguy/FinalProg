/**
 * @author Jose Perez Hurtado
 */

public class Menu {

    /**
     * Este metodo mostrara el menu en el que indicaremos la accion a realizar
     * @return el entero que indicara que accion hara el programa
     */
    static int menuBD(){
        int op;

        System.out.println("·················EQUIPOS Y JUGADORES·················");
        System.out.println("·                                                   ·");
        System.out.println("·              [ 1] Crear y conectar BD             ·");
        System.out.println("·              [ 2] Eliminar BD                     ·");
        System.out.println("·              [ 3] Crear tablas                    ·");
        System.out.println("·              [ 4] Eliminar tablas                 ·");
        System.out.println("·              [ 5] Cargar datos en tablas          ·");
        System.out.println("·              [ 6] Vaciar datos en tablas          ·");
        System.out.println("·              [ 7] Añadir jugador                  ·");
        System.out.println("·              [ 8] Modificar jugador               ·");
        System.out.println("·              [ 9] Eliminar jugador                ·");
        System.out.println("·              [10] Ver todos los jugadores         ·");
        System.out.println("·              [11] Ver jugadores de un equipo      ·");
        System.out.println("·              [12] Añadir equipo                   ·");
        System.out.println("·              [13] Modificar equipo                ·");
        System.out.println("·              [14] Eliminar equipo                 ·");
        System.out.println("·              [15] Ver equipos                     ·");
        System.out.println("·              [16] Salir del programa              ·");
        System.out.println("·                                                   ·");
        System.out.println("·····················································");



        do{

            op = SLeer2.datoInt("Por favor, introduzca una opción: ");
            if(op < 1 || op > 16){
                System.err.println("\t¡Rango equivocado!");
            }



        }while(op < 1 || op > 16);

        return op;
    }
}
