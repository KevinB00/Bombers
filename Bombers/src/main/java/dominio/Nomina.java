package dominio;

public class Nomina {
    private int categoriaNomina;
    private int sou_base;
    private int complements;
    private int percentatgeRetencio;
    private int liquid_final;

    public Nomina(int categoriaNomina){
            this.categoriaNomina = comprobarCategoriaNomina(categoriaNomina);

    }
    public Nomina(int categoriaNomina, int sou_base, int complements, int percentatgeRetencio, int liquid_final){
        this.categoriaNomina = comprobarCategoriaNomina(categoriaNomina);

        this.sou_base = sou_base;
        this.complements = complements;
        this.percentatgeRetencio = percentatgeRetencio;
        this.liquid_final = liquid_final;
    }

    public int getCategoriaNomina() {
        return categoriaNomina;
    }

    public void setCategoriaNomina(int categoriaNomina) {
        this.categoriaNomina = categoriaNomina;
    }

    public int getSou_base() {
        return sou_base;
    }

    public void setSou_base(int sou_base) {
        this.sou_base = sou_base;
    }

    public int getComplements() {
        return complements;
    }

    public void setComplements(int complements) {
        this.complements = complements;
    }

    public int getPercentatgeRetencio() {
        return percentatgeRetencio;
    }

    public void setPercentatgeRetencio(int percentatgeRetencio) {
        this.percentatgeRetencio = percentatgeRetencio;
    }

    public int getLiquid_final() {
        return liquid_final;
    }

    public void setLiquid_final(int liquid_final) {
        this.liquid_final = liquid_final;
    }

    public int comprobarCategoriaNomina(int categoriaNomina) {
        int[] categorias = new int[]{1,2,3};
        int resultado = 0;
        for (int i = 0; i < categorias.length; i++){
            if (categoriaNomina == categorias[i]) resultado = categoriaNomina;
            else resultado = 0;
        }
        return resultado;
    }
}
