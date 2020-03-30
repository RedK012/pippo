package Login;

public class Users {

    private String username;
    private String password;
    private String tipo;

    public Users(String username, String password, String tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Users{" + "username=" + username + ", password=" + password + ", tipo=" + tipo + '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
