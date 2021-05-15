package VS.Model;

import java.util.Objects;

public class Produs {

    private String nume;
    private String pret;
    private String categorieprodus;

    public Produs(){}

    public Produs(String nume, String pret, String categorieprodus) {
        this.nume = nume;
        this.pret = pret;
        this.categorieprodus = categorieprodus;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public String getCategorieprodus() {
        return categorieprodus;
    }

    public void setCategorieprodus(String categorieprodus) {
        this.categorieprodus = categorieprodus;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "nume='" + nume + '\'' +
                ", pret=" + pret +
                ", categorieprodus='" + categorieprodus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produs produs = (Produs) o;
        return pret == produs.pret && nume.equals(produs.nume) && categorieprodus.equals(produs.categorieprodus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, pret, categorieprodus);
    }
}

