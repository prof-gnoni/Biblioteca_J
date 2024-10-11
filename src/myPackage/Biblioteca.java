package myPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Classe myPackage.Biblioteca per gestire il prestito, la ricerca e la disponibilità dei libri
class Biblioteca {
    private List<Libro> libri;
    private List<Prestito> prestiti;

    public Biblioteca() {
        libri = new ArrayList<>();
        prestiti = new ArrayList<>();
    }

    // Aggiunge un libro alla biblioteca
    public void aggiungiLibro(Libro libro) {
        libri.add(libro);
    }

    // Cerca un libro per titolo
    public Libro cercaLibroPerTitolo(String titolo) {
        for (Libro libro : libri) {
            if (libro.getTitolo().equalsIgnoreCase(titolo)) {
                return libro;
            }
        }
        return null; // Libro non trovato
    }

    // Cerca un libro per ISBN
    public Libro cercaLibroPerIsbn(String isbn) {
        for (Libro libro : libri) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null; // Libro non trovato
    }

    // Effettua un prestito con gestione delle date
    public boolean effettuaPrestito(Libro libro, Persona persona, LocalDate dataInizio, LocalDate dataFine) {
        if (libro.isDisponibile()) {
            libro.setDisponibile(false);
            prestiti.add(new Prestito(libro, persona, dataInizio, dataFine));
            return true; // myPackage.Prestito avvenuto con successo
        }
        return false; // Libro non disponibile
    }

    // Restituisce un libro
    public boolean restituisciLibro(Libro libro) {
        for (Prestito prestito : prestiti) {
            if (prestito.getLibro().equals(libro)) {
                libro.setDisponibile(true);
                prestiti.remove(prestito);
                return true; // Restituzione avvenuta
            }
        }
        return false; // Libro non in prestito
    }

    // Elenca i libri disponibili
    public List<Libro> elencaLibriDisponibili() {
        List<Libro> disponibili = new ArrayList<>();
        for (Libro libro : libri) {
            if (libro.isDisponibile()) {
                disponibili.add(libro);
            }
        }
        return disponibili;
    }

    // Elenca tutti i prestiti
    public List<Prestito> elencaPrestiti() {
        return prestiti;
    }
}
