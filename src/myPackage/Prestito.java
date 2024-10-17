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
        return this.libro;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public LocalDate getDataInizio() {
        return this.dataInizio;
    }

    public LocalDate getDataFine() {
        return this.dataFine;
    }

    @Override
    public String toString() {
        return "myPackage.Prestito {" +
                "libro=" + libro.getTitolo() +
                ", persona=" + persona.getNome() + " " + persona.getCognome() +
                ", dataInizio=" + this.dataInizio +
                ", dataFine=" + this.dataFine +
                '}';
    }
}
