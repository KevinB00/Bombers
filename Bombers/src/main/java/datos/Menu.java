package datos;

import java.sql.SQLException;
import java.util.Scanner;
import datos.Metodos;
public class Menu {
    public static void main(String[] args) throws SQLException {
        Scanner tcl = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("<------------------ BASE DE DATOS BOMBEROS ------------------>");
            System.out.println("1. Listar bomberos por parque");
            System.out.println("2. Insertar Parque de Bomberos-VIP");
            System.out.println("3. Borrar bombero y sus turnos trabajados");
            System.out.println("0. Salir");
            System.out.println("Eliga una opción: ");
            opcion = tcl.nextInt();
            switch (opcion) {
                case 1:
                    Metodos.listarBomber();
                    break;
                case 2:
                    Metodos.insertarParcVIP();
                    break;
                case 3:
                    Metodos.borrarBomber();
                    break;
                case 0:
                    System.out.println("************ FIN DEL PROGRAMA ************");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while (opcion != 0);
    }
}
