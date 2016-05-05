/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applimp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import metier.Authentification;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author cornado thaibaut
 */
public class AppliMP {
    public static void main(String[] args) throws ClassNotFoundException {
        
        int menu =0;
        
        /*String url = "jdbc:mysql://localhost/app";*/
        String url = "jdbc:mysql://localhost:3306/app";
        String user = "app_user";
        String password = "Tibo2612";
        
        try {
            String pilote = "com.mysql.jdbc.Driver";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection( url, user, password);
            Statement stmt = con.createStatement();
            Authentification auth = new Authentification();
            /*String q1 = auth.RajoutAuthent(auth.getLogin() , auth.getMotPasse());
            System.out.println(q1);
            int ind = stmt.executeUpdate(q1);
            System.out.println("l'insertion s'est passé correctement et le nombre de ligne insérée est : " + ind);
            */
            
            String q2 = auth.RechAuthent("cornado@hotmail.fr");
            System.out.println(q2);
            ResultSet rs = stmt.executeQuery(q2) ;
            // exploitation du resultat
            while (rs.next()) {
                Authentification a = new Authentification(rs.getString("LOGINAUTH"), rs.getString("MDPAUTH"));
                System.out.println("login : " + a.getLogin()+ " mode de passe = "+ a.getMotPasse());
            }
            
/*
        while(true){
            Scanner sc = new Scanner(System.in);
            menu = Integer.parseInt(sc.nextLine());
            if(menu == 1){
                Map<String, Authentification> hm = new HashMap<>();
                Authentification auth = new Authentification();
                String q1 = auth.RajoutAuthent(auth.getLogin() , auth.getMotPasse());
                stmt.executeUpdate(q1);
                System.out.println(q1);
            }
            if(menu == 2)
            {
                Authentification auth = new Authentification();
                String login = sc.nextLine();
                String q2 = auth.RechAuthent(login);
                stmt.executeQuery(q2);
                System.out.println(q2);
            }
            if(menu == 0)
            {
                menu = 1;
            }
        }*/
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}