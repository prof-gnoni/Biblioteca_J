package myPackage;

import java.time.LocalDate;

// Classe myPackage.Prestito con gestione delle date
class Prestito {
    private Libro libro;
    private Persona persona;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    public Prestito(Libro libro, Persona persona, LocalDate dataInizio, LocalDate dataFine) {
        this.libro = libro;
        this.persona = persona;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    // Getter
    public Libro getLibro() {
        return libro;
    }

    public Persona getPersona() {
        return persona;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    @Override
    public String toString() {
        return "myPackage.Prestito{" +
                "libro=" + libro.getTitolo() +
                ", persona=" + persona.getNome() + " " + persona.getCognome() +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                '}';
    }
}
