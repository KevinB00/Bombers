package datos;
import dominio.Bomber;
import dominio.ParcBombers;

import java.sql.*;
import java.util.List;
import java.util.Scanner;


public class Metodos {
    List<Bomber>bombers;
    boolean repetir = false;

    Scanner tcl = new Scanner(System.in);
    BomberDAO bomberDAO = new BomberDAO();
    ParcBombersDAO parcBombersDAO = new ParcBombersDAO();

    public void menu() throws SQLException {
        int opcion;
        do{
            System.out.println("<------------------ BASE DE DATOS BOMBEROS ------------------>");
            System.out.println("1. Listar bomberos por parque");
            System.out.println("2. Insertar Parque de Bomberos-VIP");
            System.out.println("3. Borrar bombero y sus turnos trabajados");
            System.out.println("0. Salir");
            System.out.println("Eliga una opción: ");
             opcion = tcl.nextInt();
            switch (opcion){
                case 1:
                    listarBomber();
                    break;
                case 2:
                    insertarParcVIP();
                    break;

            }
        }while (opcion != 0);
    }

    public void insertarParcVIP() {
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
                e.printStackTrace();
                System.out.println("Introduzca un valor válido");
            }

        }while (repetir) ;
        ParcBombers parcBombers = new ParcBombers(direccion, categoria);
        parcBombersDAO.insert(parcBombers);
    }
    public void listarBomber() throws SQLException {
        bombers = bomberDAO.seleccionar();
        int numeroParque = 0;
        do {
            try {
                repetir = false;
                System.out.println("Introduzca el código del parque: ");
                numeroParque = tcl.nextInt();
            } catch (Exception e) {
                repetir = true;
                e.printStackTrace();
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
