package myPackage;

import java.time.LocalDate;
// https://www.digitalocean.com/community/tutorials/java-simpledateformat-java-date-format

// Classe myPackage.mainBiblioteca_J per testare il sistema della biblioteca con ricerca per ISBN
public class mainBiblioteca_J {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        int puntoElenco;

        // Aggiungiamo dei libri alla biblioteca
        Libro libro1 = new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", "1234567890");
        Libro libro2 = new Libro("1984", "George Orwell", "0987654321");
        biblioteca.aggiungiLibro(libro1);
        biblioteca.aggiungiLibro(libro2);

        // Creiamo delle persone
        Persona persona1 = new Persona(1,"Mario", "Rossi", 49);
        Persona persona2 = new Persona(2,"Luca", "Bianchi", 39);

        biblioteca.visualizzaCatalogo();
        System.out.println();

        // Prestiamo un libro con data inizio e fine
        LocalDate oggi = LocalDate.now();
        LocalDate finePrestito = oggi.plusDays(14); // myPackage.Prestito di 14 giorni

        if (biblioteca.effettuaPrestito(libro1, persona1, oggi, finePrestito)) {
            System.out.println(persona1.getNome() + " ha preso in prestito " +
                    libro1.getTitolo() + " dal " + oggi.format(Settings.dataItaliana) + " al " +
                    finePrestito.format(Settings.dataItaliana)
            );
        } else {
            System.out.println("Il libro non è disponibile.");
        }
        System.out.println();
        biblioteca.visualizzaCatalogo();
        System.out.println();
        biblioteca.visualizzaLibriDisponibili();
        System.out.println();
        biblioteca.visualizzaPrestiti();
        System.out.println();

        // Restituiamo un libro
        if (biblioteca.restituisciLibro(libro1)) {
            System.out.println(libro1.getTitolo() + " è stato restituito.");
        } else {
            System.out.println("Errore nella restituzione.");
        }
        System.out.println();

        biblioteca.visualizzaCatalogo();
        System.out.println();
        biblioteca.visualizzaLibriDisponibili();
        System.out.println();
        biblioteca.visualizzaPrestiti();
        System.out.println();

        // Ricerca di un libro per ISBN
        Libro libroRicercato = biblioteca.cercaLibroPerIsbn("0987654321");
        if ( libroRicercato != null ) {
            System.out.println("Libro trovato: " + libroRicercato.getTitolo());
        } else {
            System.out.println("Libro non trovato.");
        }
        System.out.println();
    }
}