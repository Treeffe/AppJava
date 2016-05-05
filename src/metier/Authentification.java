/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Scanner;


/**
 *
 * @author cornado thaibaut
 */
public class Authentification {
    private String login;
    private String motPasse;

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the motPasse
     */
    public String getMotPasse() {
        return motPasse;
    }

    /**
     * @param motPasse the motPasse to set
     */
    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }
    public Authentification()
    {
        Scanner sc = new Scanner(System.in);
        String login = sc.nextLine();
        String password = sc.nextLine();
        setLogin(login);
        setMotPasse(password);
    }
    
    public Authentification(String login, String password)
    {
        setLogin(login);
        setMotPasse(password);
    }
    
    public String RajoutAuthent(String login, String mp)
    {
        return "INSERT INTO authent(LOGINAUTH, MDPAUTH) values ("+"'"+login+"'"+","+"'"+mp+"'"+");";
    }
    
    /*public boolean ModifAuthent(String login, String mp)
    {
        String q1 = "INSERT into test values ('AAA', 'BBB', 'CCC', 'DDD')";
        String q2 = "SELECT * from test";
        return false;
    }*/
    
    public String RechAuthent(String login)
    {    
        return "SELECT * from Authent where LOGINAUTH ="+"'"+login+"'";
    }
}
/*

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;
    public class Main {
       
        public static void main(String[] args) {
        String url = "localhost";
        String user = "admin";
        String password = "admin1";
       
        String q1 = "INSERT into test values ('AAA', 'BBB', 'CCC', 'DDD')";
        String q2 = "SELECT * from test";
       
        try {
        Connection con = DriverManager.getConnection( url, user, password);
        Statement stmt = con.createStatement();
       
        stmt.executeUpdate(q1);
        stmt.executeQuery(q2);
       
        } catch (SQLException ex) {
            System.out.println("Echec connection!!" );
        }
       
        }
    }

*/
