/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;
import Console.*;
import form.Guiainframe;

import javax.xml.transform.Result;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {

    private String nomeDb;
    private String driver;
    private String urlDb;
    private ResultSet rs;
    private Connection conn;
    private String query;
    private ResultSetMetaData rsmd;
    public List<Gioco> listGiochi = new ArrayList<>();
    public Connection startConnection() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String connectionUrl = "jdbc:sqlite:src/dbconnection/DbApp.db";
            conn = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
        return conn;
    }

    public void insertGame(String genere, String piattaforma, int age, String descrizione, String datauscita,int quantita, String nome, double prezzo) throws SQLException {
        conn = startConnection();
        query = "INSERT INTO giochi (genere, piattaforma,age,descrizione,datauscita,quantita,nome, prezzo) VALUES ('" + genere + "','" + piattaforma + "','" + age + "','" + descrizione + "','" + datauscita + "','"  + quantita + "','" + nome + "', '" + prezzo + "')";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
        conn.close();
    }

    public String select(String nome, String piattaforma) throws SQLException {
        String nonloso="";
        conn = startConnection();
        query = "SELECT * FROM giochi WHERE nome ='" + nome + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()){
            
            System.out.println(rs.getString("nome"));
            System.out.println(rs.getString ("piattaforma"));
            System.out.println(rs.getInt ("age"));
            System.out.println(rs.getString ("descrizione"));
           
           nonloso+=rs.getString("nome")+" "+rs.getString ("piattaforma")+" "+rs.getInt ("age")+" "+rs.getString ("descrizione");
        }
        stmt.close();
        conn.close();
       return nonloso;
    
    }

    public <T extends Gioco> String  select2(String nome, String piattaforma) throws SQLException {
        String nonloso="";
        conn = startConnection();
        query = "SELECT * FROM giochi WHERE nome ='" + nome + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            switch(Guiainframe.scelta)
            {
                case "xbox":
                    listGiochi.add(new Xbox(rs.getInt("quantita"), rs.getDouble("prezzo"), rs.getString("genere"), rs.getString("piattaforma"),
                            rs.getInt("age"), rs.getString("dataUscita"), rs.getString("descrizione"), rs.getString("nome")));
                    break;
                case "pc":
                    listGiochi.add(new PC(rs.getInt("quantita"), rs.getDouble("prezzo"), rs.getString("genere"), rs.getString("piattaforma"),
                            rs.getInt("age"), rs.getString("dataUscita"), rs.getString("descrizione"), rs.getString("nome")));
                    break;
                case "ps4":
                    listGiochi.add(new PS4(rs.getInt("quantita"), rs.getDouble("prezzo"), rs.getString("genere"), rs.getString("piattaforma"),
                            rs.getInt("age"), rs.getString("dataUscita"), rs.getString("descrizione"), rs.getString("nome")));
                    break;
                case "nintendo":
                    listGiochi.add(new Nintendo(rs.getInt("quantita"), rs.getDouble("prezzo"), rs.getString("genere"), rs.getString("piattaforma"),
                            rs.getInt("age"), rs.getString("dataUscita"), rs.getString("descrizione"), rs.getString("nome")));
                    break;
            }
        }
        stmt.close();
        conn.close();
        return nonloso;
    }

    public void inserimentoUser(String username, String password, String tipo) throws SQLException {
        query = "INSERT INTO users(username,password,tipo) VALUES ('" + username + "' ,'" + password + "','" + tipo + "')";
        Statement stmt = startConnection().createStatement();
        stmt.executeUpdate(query);
        System.out.println("dati aggiunti");
        stmt.close();

    }

    public void selectUser() throws SQLException {
        try ( Connection connection = this.startConnection()) {

            query = "SELECT * FROM users";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("username") + " " + rs.getString("password") + " " + rs.getString("tipo"));

            }

        } catch (Exception ex) {
        }

    }

    public void delete(String query) {
        query = "";
    }
    
    public void update (int ID,String nome, double prezzo) throws SQLException{
        conn = startConnection();
        query = "UPDATE giochi SET nome ='"+nome+"',prezzo = '"+prezzo+"' WHERE ID = '"+ID+"'";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
        conn.close();
    }

    public String getNomeDb() {
        return nomeDb;
    }

    public void setNomeDb(String nomeDb) {
        this.nomeDb = nomeDb;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrlDb() {
        return urlDb;
    }

    public void setUrlDb(String urlDb) {
        this.urlDb = urlDb;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ResultSetMetaData getRsmd() {
        return rsmd;
    }

    public void setRsmd(ResultSetMetaData rsmd) {
        this.rsmd = rsmd;
    }

    public static void main(String[] args) {

        try {
            DbConnection dbConn = new DbConnection();
            dbConn.update(1,"darksouls",10.90);
            dbConn.select("darksouls2", "xbox");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



