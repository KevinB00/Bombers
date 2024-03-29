package dominio;
/*
 * Se crea la clase Equip con sus respectivas variables, constructores, getters, setters
 */
public class Equip {

    private int codEquip;
    private String nom;

    public Equip(int codEquip){
        this.codEquip = codEquip;
    }
    public Equip(String nom) {
        this.nom = nom;
    }
    public Equip(int codEquip, String nom) {
        this.codEquip = codEquip;
        this.nom = nom;
    }

    public int getCodEquip() {

        return codEquip;
    }

    public void setCodEquip(int codEquip) {

        this.codEquip = codEquip;
    }

    public String getNom() {

        return nom;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Equip{" +
                "codEquip=" + codEquip +
                ", nom='" + nom + '\'' +
                '}';
    }
}
