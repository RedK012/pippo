package Console;

public class PS4 extends Gioco {

    private int quantita;

    public PS4(int quantita, double prezzo, String genere, String piattaforma, int age, String dataUscita, String descrizione, String nome) {
        super(genere, piattaforma, age, dataUscita, descrizione, nome,prezzo);
        this.quantita = quantita;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    protected int disponibile(int disponibile) {
      return super.disponibile(disponibile);
    }


}
