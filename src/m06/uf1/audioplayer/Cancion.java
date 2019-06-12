package m06.uf1.audioplayer;

public class Cancion {
    String nom;
    String autor;
    String album;
    String durada;
    String rutaArxiu;

    public Cancion(String nom, String autor, String album, String durada, String rutaArxiu) {
        this.nom = nom;
        this.autor = autor;
        this.album = album;
        this.durada = durada;
        this.rutaArxiu = rutaArxiu;
    }

    public Cancion() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDurada() {
        return durada;
    }

    public void setDurada(String durada) {
        this.durada = durada;
    }

    public String getRutaArxiu() {
        return rutaArxiu;
    }

    public void setRutaArxiu(String rutaArxiu) {
        this.rutaArxiu = rutaArxiu;
    }

    @Override
    public String toString() {
        return "Cancion{" + "nom=" + nom + ", autor=" + autor + ", album=" + album + ", durada=" + durada + ", rutaArxiu=" + rutaArxiu + '}';
    }
}
