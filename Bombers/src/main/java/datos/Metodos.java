package datos;
import conexion.Conexion;
import dominio.Bomber;
import dominio.Equip;
import dominio.ParcBombers;

import java.sql.*;
import java.util.List;
import java.util.Scanner;


public class Metodos {
    private static Connection conexion = null;
    private static boolean repetir = false;
    private static Scanner tcl = new Scanner(System.in);
    private static BomberDAO bomberDAO = new BomberDAO(conexion);
    private static ParcBombersDAO parcBombersDAO = new ParcBombersDAO(conexion);
    private static EquipDAO equipDAO = new EquipDAO(conexion);


    public static void borrarBomber() throws SQLException {
        System.out.println();
        tcl.nextLine();
        Bomber bomberBorrar;
        int cod = 0;
        do {
            try {
                conexion = Conexion.getConnection();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                repetir = false;
                System.out.println("Borrar bombero");
                System.out.println("Introduzca el código del bombero a borrar");
                cod = tcl.nextInt();
                bomberBorrar = new Bomber(cod);
                bomberDAO.delete(bomberBorrar);
                System.out.println("Bombero borrado");
                conexion.commit();
                System.out.println("Se ha hecho commit");
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                System.out.println("Fallo en la operacion de inserción. Se ejecuta rollback");
                try{
                    conexion.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }catch (Exception ex) {
                repetir = true;
                tcl.nextLine();
                System.out.println("Introduzca un valor válido");
            }
        } while (repetir);
        List<Bomber> bombers = bomberDAO.seleccionar();
        bombers.forEach(bomber -> {
            System.out.println("bomber = " + bomber);
        });

    }
    public static void insertarBombero() throws SQLException {
        System.out.println();
        tcl.nextLine();
        String nombre = null;
        String adreca = null;
        int codParc = 0;
        int codCarrec = 0;
        int codEquip = 0;
        int categoriaNomina = 0;
        do{
            try {
                conexion = Conexion.getConnection();
                if(conexion.getAutoCommit()){
                    conexion.setAutoCommit(false);
                }
                repetir = false;
                System.out.println("Insertar Bombero");
                System.out.println("Nombre del bombero: ");
                nombre = tcl.nextLine();
                System.out.println("Inserte dirección del bombero: ");
                adreca = tcl.nextLine();
                System.out.println("Código del parque: ");
                codParc = tcl.nextInt();
                System.out.println("Código del cargo: ");
                codCarrec = tcl.nextInt();
                System.out.println("Código del equipo: ");
                codEquip = tcl.nextInt();
                System.out.println("Categoria de la nomina: ");
                categoriaNomina = tcl.nextInt();
                Bomber bomber = new Bomber(nombre, adreca, codParc, codCarrec, codEquip, categoriaNomina);
                bomberDAO.insert(bomber);
                conexion.commit();
                System.out.println("Se ha hecho commit");
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                System.out.println("Fallo en la operacion de inserción. Se ejecuta rollback");
                try{
                conexion.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                }catch (Exception ex) {
                repetir = true;
                tcl.nextLine();
                System.out.println("Introduzca un valor válido");
            }
        }while (repetir);
        List<Bomber> bombers = bomberDAO.seleccionar();
        bombers.forEach(bomber -> {
            System.out.println("Bomber = " + bomber);
        });
    }
public static void actualizarBombero() throws SQLException {
    System.out.println();
    tcl.nextLine();
    String nombre = null;
    String adreca = null;
    int codParc = 0;
    int codCarrec = 0;
    int codEquip = 0;
    int codBombero = 0;
    int catNomina = 0;

    do{
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            repetir = false;
            System.out.println("Actualizar Bombero");
            System.out.println("Nombre del bombero: ");
            nombre = tcl.nextLine();
            System.out.println("Inserte dirección del bombero: ");
            adreca = tcl.nextLine();
            System.out.println("Código del parque: ");
            codParc = tcl.nextInt();
            System.out.println("Código del cargo: ");
            codCarrec = tcl.nextInt();
            System.out.println("Código del equipo: ");
            codEquip = tcl.nextInt();
            System.out.println("Categoria de la nómina");
            catNomina = tcl.nextInt();
            System.out.println("Código del Bombero a actualizar: ");
            codBombero = tcl.nextInt();
            Bomber bomber = new Bomber(codBombero, nombre, adreca, codParc, codCarrec, codEquip, catNomina);
            bomberDAO.update(bomber);
            conexion.commit();
            System.out.println("Se ha hecho commit");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Fallo en la operacion de inserción. Se ejecuta rollback");
            try{
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }catch (Exception ex) {
            repetir = true;
            tcl.nextLine();
            System.out.println("Introduzca un valor válido");
        }
    }while (repetir);
    List<Bomber> bombers = bomberDAO.seleccionar();
    bombers.forEach(bomber -> {
        System.out.println("Bomber = " + bomber);
    });
}
    public static void insertarParc() throws SQLException {
        System.out.println();
        tcl.nextLine();
        String direccion = null;
        int categoria = 0;
        do{
            try {
                conexion = Conexion.getConnection();
                if(conexion.getAutoCommit()){
                    conexion.setAutoCommit(false);
                }
                repetir = false;
                System.out.println("Insertar Parc: ");
                System.out.println("Inserta dirección del parque: ");
                direccion = tcl.nextLine();
                System.out.println("Inserta categoría: ");
                categoria = tcl.nextInt();
                ParcBombers parcBombers = new ParcBombers(direccion, categoria);
                parcBombersDAO.insert(parcBombers);
                conexion.commit();
                System.out.println("Se ha hecho commit");
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                System.out.println("Fallo en la operacion de inserción. Se ejecuta rollback");
                try{
                    conexion.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }catch (Exception ex) {
                repetir = true;
                tcl.nextLine();
                System.out.println("Introduzca un valor válido");
            }
        }while (repetir);
        List<ParcBombers> parcBombers = parcBombersDAO.seleccionar();
        parcBombers.forEach(parcBomber -> {
            System.out.println("parcBombers = " + parcBomber);
        });
    }
    public static void updateParcBombers() throws SQLException {
        System.out.println();
        tcl.nextLine();
        String direccion = null;
        int categoria = 0;
        int codParc = 0;
        do{
            try {
                conexion = Conexion.getConnection();
                if(conexion.getAutoCommit()){
                    conexion.setAutoCommit(false);
                }
                repetir = false;
                System.out.println("Actualizar Parc: ");
                System.out.println("Inserta dirección del parque: ");
                direccion = tcl.nextLine();
                System.out.println("Inserta categoría: ");
                categoria = tcl.nextInt();
                System.out.println("Código del parque a actualizar: ");
                codParc = tcl.nextInt();
                ParcBombers parcBombers = new ParcBombers(codParc, direccion, categoria);
                parcBombersDAO.update(parcBombers);
                conexion.commit();
                System.out.println("Se ha hecho commit");
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                System.out.println("Fallo en la operacion de inserción. Se ejecuta rollback");
                try{
                    conexion.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }catch (Exception ex) {
                repetir = true;
                tcl.nextLine();
                System.out.println("Introduzca un valor válido");
            }
        }while (repetir);
        List<ParcBombers> parcBombers = parcBombersDAO.seleccionar();
        parcBombers.forEach(parcBomber -> {
            System.out.println("parcBombers = " + parcBomber);
        });
    }

    public static void eliminarParcBombers() throws SQLException {
        Connection conexion = Conexion.getConnection();
        System.out.println();
        tcl.nextLine();
        int cod = 0;
        do {
            try {
                conexion = Conexion.getConnection();
                if (conexion.getAutoCommit()){
                    conexion.setAutoCommit(false);
                }
                repetir = false;
                System.out.println("Borrar Parque: ");
                System.out.println("Inserta el código del parque");
                cod = tcl.nextInt();
                ParcBombers parcBombers = new ParcBombers(cod);
                parcBombersDAO.delete(parcBombers);
                System.out.println("Parque borrado");
                conexion.commit();
                System.out.println("Se ha hecho commit");
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                System.out.println("Fallo en la operacion de inserción. Se ejecuta rollback");
                try{
                    conexion.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }catch (Exception ex) {
                repetir = true;
                tcl.nextLine();
                System.out.println("Introduzca un valor válido");
            }
        }while (repetir);
        List<ParcBombers> parcBombers = parcBombersDAO.seleccionar();
        parcBombers.forEach(parcBomber -> {
            System.out.println("parcBombers = " + parcBomber);
        });
    }
    public static void insertarParcVIP() throws SQLException {
        System.out.println();
        tcl.nextLine();
        String direccion = null;
        int categoria = 0;
        do {
            try {
                conexion = Conexion.getConnection();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                repetir = false;
                System.out.println("Insertar PARQUE VIP");
                System.out.println("Introduzca la dirección del parque: ");
                direccion = tcl.nextLine();
                do {
                    System.out.println("Introduzca la categoría del parque (VIP>4):");
                    categoria = tcl.nextInt();
                } while (categoria < 5);
                ParcBombers parcBombers = new ParcBombers(direccion, categoria);
                parcBombersDAO.insert(parcBombers);
                conexion.commit();
                System.out.println("Se ha hecho commit");
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                System.out.println("Fallo en la operacion de inserción. Se ejecuta rollback");
                try{
                    conexion.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }catch (Exception ex) {
                repetir = true;
                tcl.nextLine();
                System.out.println("Introduzca un valor válido");
            }
        } while (repetir);
        List<ParcBombers> parcBombers = parcBombersDAO.seleccionar();
        parcBombers.forEach(parcBomber -> {
            System.out.println("parcBombers = " + parcBomber);
        });
    }
    public static void insertarEquipo() throws SQLException {
        System.out.println();
        tcl.nextLine();
        String nombre = null;
        do{
            try {
                conexion = Conexion.getConnection();
                if(conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                repetir = false;
                System.out.println("Insertar Equipo: ");
                System.out.println("Introduzca el nombre: ");
                nombre = tcl.nextLine();
                Equip equip = new Equip(nombre);
                equipDAO.insert(equip);
                conexion.commit();
                System.out.println("Se ha hecho commit");
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                System.out.println("Fallo en la operacion de inserción. Se ejecuta rollback");
                try{
                    conexion.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }catch (Exception ex) {
                repetir = true;
                tcl.nextLine();
                System.out.println("Introduzca un valor válido");
            }
        }while (repetir);
        List<Equip>equips = equipDAO.seleccionar();
        equips.forEach(equip -> {
            System.out.println("Equip = " + equip);
        });
    }
    public static void actualizarEquipo() throws SQLException {
        System.out.println();
        tcl.nextLine();
        String nombre = null;
        int codEquip = 0;
        do{
            try{
                conexion = Conexion.getConnection();
                if(conexion.getAutoCommit()){
                    conexion.setAutoCommit(false);
                }
                repetir = false;
                System.out.println("Actualizar Equipo");
                System.out.println("Introduzca nombre: ");
                nombre = tcl.nextLine();
                System.out.println("Introduzca el código del equipo a actualizar: ");
                codEquip = tcl.nextInt();
                Equip equip = new Equip(codEquip, nombre);
                equipDAO.update(equip);
                conexion.commit();
                System.out.println("Se ha hecho commit");
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                System.out.println("Fallo en la operacion de inserción. Se ejecuta rollback");
                try{
                    conexion.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }catch (Exception ex) {
                repetir = true;
                tcl.nextLine();
                System.out.println("Introduzca un valor válido");
            }
        } while (repetir);
        List<Equip>equips = equipDAO.seleccionar();
        equips.forEach(equip -> {
            System.out.println("Equip = " + equip);
        });
    }
    public static void eliminarEquipo () throws SQLException {
        System.out.println();
        tcl.nextLine();
        int cod = 0;
        do{
            try{
                conexion = Conexion.getConnection();
                if(conexion.getAutoCommit()){
                    conexion.setAutoCommit(false);
                }
                repetir = false;
                System.out.println("Eliminar Equipo: ");
                System.out.println("Introduzca el codigo del equipo a borrar: ");
                cod = tcl.nextInt();
                Equip equip = new Equip(cod);
                equipDAO.delete(equip);
                System.out.println("Equipo borrado");
                conexion.commit();
                System.out.println("Se ha hecho commit");
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                System.out.println("Fallo en la operacion de inserción. Se ejecuta rollback");
                try{
                    conexion.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }catch (Exception ex) {
                repetir = true;
                tcl.nextLine();
                System.out.println("Introduzca un valor válido");
            }
        }while (repetir);
        List<Equip>equips = equipDAO.seleccionar();
        equips.forEach(equip -> {
            System.out.println("Equip = " + equip);
        });
    }
    public static void listarBomber() throws SQLException {
        System.out.println();
        tcl.nextLine();
        try {
            List<Bomber> bombers = bomberDAO.seleccionar();
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
            } while (repetir);
            for (int i = 0; i < bombers.size(); i++) {
                if (bombers.get(i).getCodEquip() == numeroParque) {
                    System.out.println(bombers.get(i).toString());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
