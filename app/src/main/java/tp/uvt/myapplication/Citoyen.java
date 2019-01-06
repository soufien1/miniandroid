package tp.uvt.myapplication;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Citoyen {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("prenom")
    @Expose
    private String prenom;
    @SerializedName("datenaissance")
    @Expose
    private String datenaissance;
    @SerializedName("cin")
    @Expose
    private String cin;
    @SerializedName("revenuannuel")
    @Expose
    private String revenuannuel;
    @SerializedName("adressmail")
    @Expose
    private String adressmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getRevenuannuel() {
        return revenuannuel;
    }

    public void setRevenuannuel(String revenuannuel) {
        this.revenuannuel = revenuannuel;
    }

    public String getAdressmail() {
        return adressmail;
    }

    public void setAdressmail(String adressmail) {
        this.adressmail = adressmail;
    }

}


