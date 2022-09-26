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
}
