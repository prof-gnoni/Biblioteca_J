package myPackage;

import java.time.LocalDate;


// Classe myPackage.mainBiblioteca_J per testare il sistema della biblioteca con ricerca per ISBN
public class mainBiblioteca_J {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Aggiungiamo dei libri alla biblioteca
        Libro libro1 = new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", "1234567890");
        Libro libro2 = new Libro("1984", "George Orwell", "0987654321");
        biblioteca.aggiungiLibro(libro1);
        biblioteca.aggiungiLibro(libro2);

        // Creiamo delle persone
        Persona persona1 = new Persona("Mario", "Rossi", "P001");
        Persona persona2 = new Persona("Luca", "Bianchi", "P002");

        // Prestiamo un libro con data inizio e fine
        LocalDate oggi = LocalDate.now();
        LocalDate finePrestito = oggi.plusDays(14); // myPackage.Prestito di 14 giorni

        if (biblioteca.effettuaPrestito(libro1, persona1, oggi, finePrestito)) {
            System.out.println(persona1.getNome() + " ha preso in prestito " +
                    libro1.getTitolo() + " dal " + oggi + " al " + finePrestito
            );
        } else {
            System.out.println("Il libro non è disponibile.");
        }

        // Elenco dei libri disponibili
        System.out.println("Libri disponibili:");
        for (Libro libro : biblioteca.elencaLibriDisponibili()) {
            System.out.println(libro.getTitolo());
        }

        // Restituiamo un libro
        if (biblioteca.restituisciLibro(libro1)) {
            System.out.println(libro1.getTitolo() + " è stato restituito.");
        } else {
            System.out.println("Errore nella restituzione.");
        }

        // Ricerca di un libro per ISBN
        Libro libroRicercato = biblioteca.cercaLibroPerIsbn("0987654321");
        if (libroRicercato != null) {
            System.out.println("Libro trovato: " + libroRicercato.getTitolo());
        } else {
            System.out.println("Libro non trovato.");
        }

        // Elenco dei prestiti attuali
        System.out.println("Prestiti attuali:");
        for (Prestito prestito : biblioteca.elencaPrestiti()) {
            System.out.println(prestito);
        }
    }
}