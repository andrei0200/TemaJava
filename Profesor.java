package ro.mta.ip.TemaJava2.serverClient;

public class Profesor implements Human {

    private String nume;
    private String prenume;
    private String acronim;
    private int varsta;
    private String materie;

    public Profesor(String nume, String prenume, String acronim, int varsta, String materie) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronim = acronim;
        this.varsta = varsta;
        this.materie = materie;
    }

    @Override
    public String toString() {
        return "[Prof. " + nume + " " +
                prenume + ", Fac. " +
                acronim + ", Varsta " +
                varsta + ", Materie predata - " +
                materie + "]";
    }

    @Override
    public void greeting() {

    }

    @Override
    public void doWork() {

    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAcronim() {
        return acronim;
    }

    public void setAcronim(String acronim) {
        this.acronim = acronim;
    }

    @Override
    public int getVarsta() {
        return varsta;
    }



    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getMaterie() {
        return materie;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }



}
