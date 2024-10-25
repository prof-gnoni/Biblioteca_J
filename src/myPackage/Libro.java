package myPackage;

// class myPackage.Libro
class Libro {
    private String titolo;
    private String autore;
    private String isbn;
    private boolean disponibile;

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

    @Override
    public String toString() {
        return "{" +
                "titolo: '" + titolo + '\'' +
                ", autore: '" + autore + '\'' +
                ", isbn: '" + isbn + '\'' +
                ", disponibile: " + (disponibile ? "Sì" : "No") +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Se è lo stesso oggetto, sono uguali
        }
        if ( ( obj == null ) || ( this.getClass() != obj.getClass() ) ) {
            return false; // Se l'oggetto è nullo o non è della stessa classe, non sono uguali
        }
        Libro altroLibro = (Libro) obj; // Notare
        return isbn.equals(altroLibro.isbn); // Confrontiamo i libri in base all'ISBN
    }

    @Override
    public int hashCode() {
        return isbn.hashCode(); // Usiamo l'hashCode dell'ISBN, poiché è unico per ogni libro
    }
}