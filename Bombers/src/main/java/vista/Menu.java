package vista;

import java.sql.SQLException;
import java.util.Scanner;
import datos.Metodos;
public class Menu {
    public static void main(String[] args) throws SQLException {
        Scanner tcl = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("<------------------ BASE DE DATOS BOMBEROS ------------------>");
            System.out.println("1. Insertar");
            System.out.println("2. Actualizar");
            System.out.println("3. Borrar");
            System.out.println("4. Listar bomberos por parque");
            System.out.println("5. Insertar Parque de Bomberos-VIP");
            System.out.println("6. Borrar bombero y sus turnos trabajados");
            System.out.println("7. Listar bomberos y liquido final de nómina de septiembre 2022 (turno noche)");
            System.out.println("0. Salir");
            System.out.println("Eliga una opción: ");
            opcion = tcl.nextInt();
            switch (opcion) {
                case 1:
                    do {
                        System.out.println("------ INSERTAR ------");
                        System.out.println("1. Bombero");
                        System.out.println("2. Parque");
                        System.out.println("3. Equipo");
                        System.out.println("0. Salir");
                        System.out.println("Eliga una opción: ");
                        opcion = tcl.nextInt();
                        switch (opcion){
                            case 1:
                                Metodos.insertarBombero();
                                break;
                            case 2:
                                Metodos.insertarParc();
                                break;
                            case 3:
                                Metodos.insertarEquipo();
                                break;
                            case 0:
                                System.out.println("Saliendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción incorrecta");
                                break;
                        }
                    }while(opcion != 0);
                    opcion = 1;
                    break;
                case 2:
                    do {
                        System.out.println("------ ACTUALIZAR ------");
                        System.out.println("1. Bombero");
                        System.out.println("2. Parque");
                        System.out.println("3. Equipo");
                        System.out.println("0. Salir");
                        System.out.println("Eliga una opción: ");
                        opcion = tcl.nextInt();
                        switch (opcion){
                            case 1:
                                Metodos.actualizarBombero();
                                break;
                            case 2:
                                Metodos.updateParcBombers();
                                break;
                            case 3:
                                Metodos.actualizarEquipo();
                                break;
                            case 0:
                                System.out.println("Saliendo al menú principal...");
                                tcl.nextLine();
                                break;
                            default:
                                System.out.println("Opción incorrecta");
                                break;
                        }
                    }while(opcion != 0);
                    opcion = 2;
                    break;
                case 3:
                    do {
                        System.out.println("------ ELIMINAR ------");
                        System.out.println("1. Bombero");
                        System.out.println("2. Parque");
                        System.out.println("3. Equipo");
                        System.out.println("0. Salir");
                        System.out.println("Eliga una opción: ");
                        opcion = tcl.nextInt();
                        switch (opcion){
                            case 1:
                                Metodos.borrarBomber();
                                break;
                            case 2:
                                Metodos.eliminarParcBombers();
                                break;
                            case 3:
                                Metodos.eliminarEquipo();
                                break;
                            case 0:
                                System.out.println("Saliendo al menú principal...");
                                tcl.nextLine();
                                break;
                            default:
                                System.out.println("Opción incorrecta");
                                break;
                        }
                    }while(opcion != 0);
                    opcion = 3;
                    break;
                case 4:
                    Metodos.listarBomber();
                    break;
                case 5:
                    Metodos.insertarParcVIP();
                    break;
                case 6:
                    Metodos.borrarBomber();
                    break;
                case 7:
                    Metodos.listarBomberoLiquidosFinales();
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
