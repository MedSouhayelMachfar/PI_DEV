package entity;

public class Jeu {
    private int ID;
    private String Title;
    private String Categorie;
    private String url;

    public Jeu() {
    }

    @Override
    public String toString() {
        return "jeux{" + "ID=" + ID + ", Title=" + Title + ", Categorie=" + Categorie + ", url=" + url + '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String Categorie) {
        this.Categorie = Categorie;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Jeu(int ID, String Title, String Categorie, String url) {
        this.ID = ID;
        this.Title = Title;
        this.Categorie = Categorie;
        this.url = url;
    }

}