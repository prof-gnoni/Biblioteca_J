package myPackage;

// Classe myPackage.Persona
public class Persona {
    private int id;
    private String nome;
    private String cognome;
    private int eta;

    public Persona() {
        id = -1;
        nome = "";
        cognome = "";
        eta = -1;
    }

    public Persona(int id, String nome, String cognome, int eta ) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    // Getters e Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return this.eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    /*
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
        return id == altraPersona.id; // Confrontiamo le persone in base all'ID
    }
    */

    public void mostraScheda() {
        // Metodo per creare una scheda boxata
        StringBuilder box = new StringBuilder();
        String[] data = {
                "Nome: " + nome,
                "Cognome: " + cognome,
                "Età: " + eta
        };
        int maxLength = getMaxLength(data) + 2; // Spazio per margini laterali

        // Linea superiore della griglia
        box.append("╔").append(repeatChar('═', maxLength)).append("╗\n");

        // Riga per ogni dato con separazioni
        for (int i = 0; i < data.length; i++) {
            // Dato corrente
            String line = data[i];
            box.append("║ ").append(padRight(line, maxLength - 2)).append(" ║\n");

            // Linea di separazione tra le celle (tranne dopo l'ultima)
            if (i < data.length - 1) {
                box.append("╠").append(repeatChar('═', maxLength)).append("╣\n");
            }
        }

        // Linea inferiore della griglia
        box.append("╚").append(repeatChar('═', maxLength)).append("╝");

        // Stampa la scheda boxata
        System.out.println(box.toString());
    }

    // Metodo per calcolare la lunghezza massima delle stringhe
    private int getMaxLength(String[] lines) {
        int maxLength = 0;
        for ( String line : lines ) {
            if ( line.length() > maxLength ) {
                maxLength = line.length();
            }
        }
        return maxLength;
    }

    // Metodo per ripetere un carattere n volte
    private String repeatChar(char ch, int count) {
        return new String(new char[count]).replace('\0', ch);
    }

    // Metodo per allineare una stringa a destra
    private  String padRight(String str, int n) {
        return String.format("%-" + n + "s", str);
    }
}