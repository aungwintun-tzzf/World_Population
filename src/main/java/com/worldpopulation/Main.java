package com.worldpopulation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    protected ArrayList<Country> read_DB(Connection con) {
        ArrayList<Country> countrylist = new ArrayList<>();
        try {
            PreparedStatement stat = con.prepareStatement("SELECT country_name, capital_name, " +
                    "region_name, subregion_name FROM population");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                countrylist.add(new Country(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            rs.close();
            stat.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return countrylist;
    }



    public static void main(String[] args) {
        Main m = new Main();
        Connection con = m.getConnection("localhost", 3306,"devops","root", "");
        ArrayList<Country> countrylist = m.read_DB(con);
        System.out.println(countrylist.getLast());

        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
