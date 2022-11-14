package ro.mta.ip.TemaJava2.serverClient;

public class Student implements Human {

    private String nume;
    private String prenume;
    private String acronim;
    private int varsta;
    private int anStudiu;

    public Student(String nume, String prenume, String acronim, int varsta, int anStudiu) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronim = acronim;
        this.varsta = varsta;
        this.anStudiu = anStudiu;
    }

    @Override
    public String toString() {
        return "[Sd. " + nume + " " +
                prenume + ", Anul " +
                anStudiu + ", Fac. " +
                acronim + ", Varsta " +
                varsta + "]";
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

    public int getAnStudiu() {
        return anStudiu;
    }

    public void setAnStudiu(int anStudiu) {
        this.anStudiu = anStudiu;
    }



}
