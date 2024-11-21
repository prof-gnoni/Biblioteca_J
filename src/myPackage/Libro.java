package myPackage;

// class myPackage.Libro
public class Libro {
    private String isbn;
    private String titolo;
    private String autore;
    private boolean disponibile;

    public Libro() {
        this.titolo = "";
        this.autore = "";
        this.isbn = "";
        this.disponibile = false;
    }

    public Libro(String titolo, String autore, String isbn) {
        this.titolo = titolo;
        this.autore = autore;
        this.isbn = isbn;
        this.disponibile = true;
    }

    // Getter e Setter
    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "Libro {" +
                "isbn='" + isbn + '\'' +
                ", titolo='" + titolo + "'" +
                ", autore='" + autore + '\'' +
                ", disponibile=" + ( disponibile ? "Sì" : "No" ) +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Se è lo stesso oggetto, sono uguali
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Se l'oggetto è nullo o non è della stessa classe, non sono uguali
        }
        Libro altroLibro = (Libro) obj;
        return isbn.equals(altroLibro.isbn); // Confrontiamo i libri in base all'ISBN
    }
    @Override
    public int hashCode() {
        return isbn.hashCode(); // Usiamo l'hashCode dell'ISBN, poiché è unico per ogni libro
    }

}