package dominio;

public class Nomina {
    private int categoriaNomina;
    private int codBomber;
    private String fechaini;
    private String fechafin;
    private double liquidFinal;

    public Nomina(int categoriaNomina, int codBomber) {
        this.categoriaNomina = categoriaNomina;
        this.codBomber = codBomber;
    }

    public Nomina(int categoriaNomina, int codBomber, String fechaini, String fechafin, double liquidFinal) {
        this.categoriaNomina = categoriaNomina;
        this.codBomber = codBomber;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
        this.liquidFinal = liquidFinal;
    }

    public Nomina(int categoriaNomina, int codBomber, String fechaini, String fechafin) {
        this.categoriaNomina = categoriaNomina;
        this.codBomber = codBomber;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
    }

    public int getCategoriaNomina() {
        return categoriaNomina;
    }

    public void setCategoriaNomina(int categoriaNomina) {
        this.categoriaNomina = categoriaNomina;
    }

    public int getCodBomber() {
        return codBomber;
    }

    public void setCodBomber(int codBomber) {
        this.codBomber = codBomber;
    }

    public String getFechaini() {
        return fechaini;
    }

    public void setFechaini(String fechaini) {
        this.fechaini = fechaini;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public double getLiquidFinal() {
        return liquidFinal;
    }

    public void setLiquidFinal(double liquidFinal) {
        this.liquidFinal = liquidFinal;
    }
}
