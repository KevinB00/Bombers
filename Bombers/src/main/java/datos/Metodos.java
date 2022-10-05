package datos;
import dominio.Bomber;
import dominio.ParcBombers;

import java.sql.*;
import java.util.List;
import java.util.Scanner;


public class Metodos {
    private static List<Bomber>bombers;
    private static boolean repetir = false;
    private static Scanner tcl = new Scanner(System.in);
    private static BomberDAO bomberDAO = new BomberDAO();
    private static ParcBombersDAO parcBombersDAO = new ParcBombersDAO();

    public static void borrarBomber() throws SQLException{
        tcl.nextLine();
        int cod = 0;
        do {
            try {
                repetir = false;
                System.out.println("Borrar bombero");
                System.out.println("Introduzca el código del bombero a borrar");
                cod = tcl.nextInt();
            } catch (Exception e) {
                repetir = true;
                tcl.nextLine();
                System.out.println("Introduzca un valor válido");
            }
        }while (repetir);
        for (int i = 0; i <bombers.size(); i++) {
            if(bombers.get(i).getCodBomber() == cod) {
                bomberDAO.delete(bombers.get(i));
                System.out.println("Bombero borrado");
            }
        }
    }

    public static void insertarParcVIP() throws SQLException{
        tcl.nextLine();
        String direccion = null;
        int categoria = 0;
        do {
            try {
                repetir = false;
                System.out.println("Insertar PARQUE VIP");
                System.out.println("Introduzca la dirección del parque: ");
                direccion = tcl.nextLine();
                do {
                    System.out.println("Introduzca la categoría del parque (VIP>4):");
                    categoria = tcl.nextInt();
                }while (categoria < 4);

            }catch(Exception e){
                repetir = true;
                tcl.nextLine();
                System.out.println("Introduzca un valor válido");
            }

        }while (repetir) ;
        ParcBombers parcBombers = new ParcBombers(direccion, categoria);
        parcBombersDAO.insert(parcBombers);
    }
    public static void listarBomber() throws SQLException {
        tcl.nextLine();
        bombers = bomberDAO.seleccionar();
        int numeroParque = 0;
        do {
            repetir = false;
            try {

                System.out.println("Introduzca el código del parque: ");
                numeroParque = tcl.nextInt();
            } catch (Exception e) {
                repetir = true;
                tcl.nextLine();
                System.out.println("Introduzca un valor válido");

            }
        }while(repetir);
        for (int i=0; i < bombers.size();i++){
            if(bombers.get(i).getCodEquip() == numeroParque){
                System.out.println(bombers.get(i).toString());
            }
        }

    }
}
