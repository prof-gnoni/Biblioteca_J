package myPackage;

// class myPackage.Libro
class Libro {
    private String isbn;
    private String titolo;
    private String autore;
    private boolean disponibile;

    public Libro() {
        this.isbn = "";
        this.titolo = "";
        this.autore = "";
        this.disponibile = false;
    }

    public Libro(String titolo, String autore, String isbn) {
        this.titolo = titolo;
        this.autore = autore;
        this.isbn = isbn;
        this.disponibile = true;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return this.autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public boolean isDisponibile() {
        return this.disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    @Override
    public String toString() {
        return "Libro {" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", isbn='" + isbn + '\'' +
                ", disponibile=" + disponibile +
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
