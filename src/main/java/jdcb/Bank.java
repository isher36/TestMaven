package jdcb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

/**
 * Created by isher on 30/05/2016.
 */


public class Bank {


    private String iban;
    private double solde;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }


    public void transferMoney() {
        String url = "jdbc:postgresql://localhost:5432/hb_cours";
        String login = "admin";
        String passwd = "300181";


//        try (Connection c = DriverManager.getConnection(url, login, passwd))
//        {
//            // Code using the connection
//
//        }
    }

}
