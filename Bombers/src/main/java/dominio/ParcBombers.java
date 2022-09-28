package dominio;

public class ParcBombers {

    private int codParc;
    private String adreca;
    private int categoria;

    public ParcBombers(int codParc) {

        this.codParc = codParc;
    }

    public ParcBombers(int codParc, String adreca, int categoria) {
        this.codParc = codParc;
        this.adreca = adreca;
        this.categoria = categoria;
    }

    public int getCodParc() {
        return codParc;
    }

    public void setCodParc(int codParc) {
        this.codParc = codParc;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ParcBombers{" +
                "codParc=" + codParc +
                ", adreca='" + adreca + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
