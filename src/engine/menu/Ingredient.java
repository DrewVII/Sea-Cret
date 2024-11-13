package engine.menu;

import java.util.Objects;

public class Ingredient {
    private String nom;
    private int prix;

    // Constructeur
    public Ingredient(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    // Getters et setters si nécessaire

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ingredient that = (Ingredient) obj;
        return Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
