package myPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Classe myPackage.Biblioteca per gestire il prestito, la ricerca e la disponibilità dei libri
public class Biblioteca {
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

    public void eliminaLibro(Libro libro) {
        libri.remove(libro);
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
    public List<Libro> listaLibriDisponibili() {
        List<Libro> disponibili = new ArrayList<>();
        for (Libro libro : libri) {
            if (libro.isDisponibile()) {
                disponibili.add(libro);
            }
        }
        return disponibili;
    }

    // Elenca tutti i prestiti
    public List<Prestito> listaPrestiti() {
        return prestiti;
    }

    public List<Libro> catalogoLibri() {
        return libri;
    }

    public void visualizzaCatalogo() {
        int puntoElenco = 0;
        List<Libro> catalogo = catalogoLibri();
        if( !catalogo.isEmpty() ) {
            System.out.println("Libri in catalogo:");
            for (Libro libro : catalogo) {
                puntoElenco++;
                System.out.println("\t" + puntoElenco + "\t" + libro.getTitolo());
                System.out.println("\t\t" + libro);
            }
        } else {
            System.out.println("Attualmente, il nostro catalogo è vuoto.");
        }
    }

    public void visualizzaPrestiti() {
        int puntoElenco = 0;
        List<Prestito> prestiti = listaPrestiti();
        if( !prestiti.isEmpty() ) {
            System.out.println("Prestiti attuali:");
            for (Prestito prestito : prestiti) {
                puntoElenco++;
                System.out.println("\t" + puntoElenco + "\t" + prestito);
            }
        } else {
            System.out.println("Non ci sono prestiti in corso.");
        }
    }

    public void visualizzaLibriDisponibili() {
        // Elenco dei libri disponibili
        int puntoElenco = 0;
        if( !this.listaLibriDisponibili().isEmpty() ) {
            System.out.println("Libri disponibili:");
            for (Libro libro : this.listaLibriDisponibili()) {
                puntoElenco++;
                System.out.println("\t" + puntoElenco + "\t" + libro.getTitolo());
                System.out.println("\t\t" + libro);
            }
        } else {
            System.out.println("Attualmente, non ci sono libri disponibili.");
        }
    }
}