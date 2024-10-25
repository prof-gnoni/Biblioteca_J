package myPackage;

// Classe myPackage.Persona
class Persona {
    private String nome;
    private String cognome;
    private String id;

    public Persona(String nome, String cognome, String id) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
                "nome: '" + nome + '\'' +
                ", cognome: '" + cognome + '\'' +
                ", id: '" + id + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) {
            return true; // Se è lo stesso oggetto, sono uguali
        }
        if ( obj == null || ( this.getClass() != obj.getClass() ) ) {
            return false; // Se l'oggetto è nullo o non è della stessa classe, non sono uguali
        }
        Persona altraPersona = (Persona) obj;
        return id.equals(altraPersona.id); // Confrontiamo le persone in base all'ID
    }
    @Override
    public int hashCode() {
        return id.hashCode(); // Usiamo l'hashCode dell'ID, poiché è unico per ogni persona
    }
}