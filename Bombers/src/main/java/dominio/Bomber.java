package dominio;

/*
* Se crea la clase Bomber con sus respectivas variables, constructores, getters, setters
*/
public class Bomber {

    private int codBomber;
    private String nom;
    private String adreca;
    private int codParc;
    private int codCarrec;
    private int codEquip;



    public Bomber(int cod) {
        this.codBomber = cod;
    }

    public Bomber(String nom, String adreca, int codParc, int codCarrec,int codEquip) {
        this.nom = nom;
        this.adreca = adreca;
        this.codParc = codParc;
        this.codCarrec = codCarrec;
        this.codEquip = codEquip;
    }

    public Bomber(int codBomber, String nom, String adreca, int codParc, int codCarrec, int codEquip) {
        this.codBomber = codBomber;
        this.nom = nom;
        this.adreca = adreca;
        this.codParc = codParc;
        this.codCarrec = codCarrec;
        this.codEquip = codEquip;
    }

    public int getCodBomber() {

        return codBomber;
    }

    public void setCodBomber(int codBomber) {

        codBomber = codBomber;
    }

    public String getNom() {

        return nom;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public String getAdreca() {

        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public int getCodParc() {

        return codParc;
    }

    public void setCodParc(int codParc) {

        this.codParc = codParc;
    }

    public int getCodCarrec() {

        return codCarrec;
    }

    public void setCodCarrec(int codCarrec) {

        this.codCarrec = codCarrec;
    }

    public int getCodEquip() {

        return codEquip;
    }

    public void setCodEquip(int codEquip) {

        this.codEquip = codEquip;
    }

    @Override
    public String toString() {
        return "Bomber{" +
                "CodBomber=" + codBomber +
                ", Nom='" + nom + '\'' +
                ", Adreca='" + adreca + '\'' +
                ", CodParc=" + codParc +
                ", CodCarrec=" + codCarrec +
                ", CodEquip=" + codEquip +
                '}';
    }
}
