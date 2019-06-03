public class Cosas {

    //primero tenemos que crear la conexion de base de datos y crear bd y eliminar bd, ExisteRegistro(existeEquipo,existeJugador),
    // crear tablas de equipos (if not exist) y jugadores
    //cargar datos y luego ver equipos y jugadores
    //añadir equipos, hay dos maneras, forzando la instruccion y de la otra manera con el result set
    //añadir jugador
    // eliminar, tienes que comprar si ese equipo tiene jugadores, podemos restringirlo o eliminarlo todo

    /*
    static final String CONNECTION = "jdbc:mysql://localhost:3306/";

    static final String USER = "root";
    static final String PASSWORD = "";

    static final String BASE_DATOS = "EquiposBD";

    static void printlSQLException(SQLException ex);



    Connection con = null;

    try{
        con = Driver.Manager.getConnection(EquiposBD.CONNECTION,EquiposBD.USER,EquiposBD,PASSWORD);

        ConectarBD.ConectarBD(con);

        int opcion = Menu.menuBD();
     */


    //EN IMPRIMIR TENEMOS IMPRIMIR JUGADORES, IMPRIMIR EQUIPO Y IMPRIMIR RESUMEN

    //PRIMERO TENEMOS QUE IMPRIMIR PARA LUEGO HACER EL VER (VERJUGADORES(CONNECTION CON), VEREQUPOS(CONNECTIONCON) Y VERJUGADORESEQUIPO(CONNECTION CON))

    //while(rs.next()){ imprimir.imprimirEquipos(rs.getInt(1),rs.getInt(2)) }

    //CuantosEquipos tiene un metodo que se llama numeroEquipos (hacer count(*) from equipos y devolverlo en un int), lo mismo para jugadores


    public static int prueba(){

        int nombre;
        boolean espacio = true;

        do{

            nombre = SLeer2.datoInt("\nIntroduce el codigo postal del equipo: ");

            if (Integer.toString(nombre).length() != 5) {
                System.err.println("plablalba");
            }



            SLeer2.limpiar();

        }while( Integer.toString(nombre).length() != 5);



        return nombre;
    }

    public static void main(String[] args) {

        int resultado = prueba();

        System.out.println(resultado);
    }
}

