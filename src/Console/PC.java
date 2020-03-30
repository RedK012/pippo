package Console;

public class PC extends Gioco {

    private int quantita;
    private double prezzo;

    public PC(int quantita, double prezzo, String genere, String piattaforma, int age, String dataUscita, String descrizione, String nome) {
        super(genere, piattaforma, age, dataUscita, descrizione, nome);
        this.quantita = quantita;
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    protected int disponibile(int disponibile) {
      return super.disponibile(disponibile);
    }


}
