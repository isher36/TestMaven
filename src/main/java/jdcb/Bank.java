package jdcb;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by isher on 30/05/2016.
 */


public class Bank {

    String url = "jdbc:postgresql://localhost:5432/hb_cours";
    String login = "admin";
    String passwd = "300181";


    /**
     * Add money to an anncout
     * @param iban
     * @param solde money to add
     */
    public void transferMoney(String iban, double solde) {
        JdbcManager jdbcManager = null;
        try {
            String request = "SELECT * FROM bank WHERE iban = ?";
            String[] param = {iban};
            jdbcManager = new JdbcManager();

            ResultSet resultSet = jdbcManager.getStatement(request, param);

            while (resultSet.next()) {
                // on recup le solde actuel
                double actualSolde = resultSet.getDouble("solde");
                double newSolde = actualSolde + solde;
                // on le met à jour
                resultSet.updateDouble("solde", newSolde);
                resultSet.updateRow();
            }


        } catch (SQLException e) {
            e.toString();
        } finally {
            if (jdbcManager != null)
                jdbcManager.closeConnection();
        }
    }

    /**
     * return true if iban is valid
     * @param iban
     * @return
     */
    public boolean isValidIban(String iban) {
        return iban.matches("^(\\d{3}-?\\d+)$");
    }

    /**
     * return solde of account
     * @param iban
     * @return
     * @throws Exception
     */
    public double getSolde(String iban) throws Exception {
        if (!isValidIban(iban))
            throw new Exception("Erreur, iban invalide ");

        String request = "SELECT * FROM bank WHERE iban = ?";
        String[] param = {iban};

        JdbcManager jdbcManager = new JdbcManager();
        ResultSet resultSet = jdbcManager.getStatement(request, param);

        resultSet.last();
        if (resultSet.getRow() == 1) {
            return resultSet.getDouble("solde");
        } else if (resultSet.getRow() == 0) {
            throw new Exception("Erreur, compte introuvable");
        } else
            throw new Exception("Erreur, on es pas senser avoir 2 lignes !");
    }


}
