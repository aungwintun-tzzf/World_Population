package com.worldpopulation;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class name: Main
 * Author: Aung Win Tun
 * Date: 19/8/2025
 * Description: Collection Test
 */

public class Main {

    //Connection
    //Statement/PrepareStatement->More Secure
    //ResultSet->ဆွဲထုတ်လိုက်တဲ့ဒေတာတွေကိုဒေတာဘေ့စ်ကပုံစံအတိုင်းမှတ်ပေးတာ

    private Connection getConnection(String ipaddress, int portno, String dbname,  String username, String password) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + ipaddress + ":" + portno + "/" + dbname, username, password);
            System.out.println("Successful Connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }



    public static void main(String[] args) {
        Main m = new Main();
        Connection c = m.getConnection("localhost", 3306,"devops","root", "");
    }
}
