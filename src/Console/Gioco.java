package Console;

public abstract class Gioco {

    private String genere;
    private String piattaforma;
    private int age;
    private String dataUscita;
    private String descrizione;
    private int disponibile;
    
    private String nome;
    

    public Gioco(String genere, String piattaforma, int age, String dataUscita, String descrizione, String nome) {
        this.genere = genere;
        this.piattaforma = piattaforma;
        this.age = age;
        this.dataUscita = dataUscita;
        this.descrizione = descrizione;
        this.nome = nome;
      
    }

    protected int disponibile(int disponibile){
        if (disponibile == 1  )
         return 1;
         
        
        return 0;
    }

      protected boolean age(int age){
          if(age>=18)
              return true;
          return false;
      }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDataUscita() {
        return dataUscita;
    }

    public void setDataUscita(String dataUscita) {
        this.dataUscita = dataUscita;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getDisponibile() {
        return disponibile;
    }

    public void setDisponibile(int disponibile) {
        this.disponibile = disponibile;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}


