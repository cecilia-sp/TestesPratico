package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries extends ConnectionOne {

    public String returnInformationBankMasses(String fieldSearch, String product) {
        String returnSearch = null;
        try {
            PreparedStatement stmt = openConnection().prepareStatement("SELECT " + fieldSearch
                    + " FROM banco_teste_automacao.massas WHERE NAME_PRODUCT = '" + product + "'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                returnSearch = rs.getString(fieldSearch);
            }
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro de select no banco massas");
            System.err.println(e.getMessage());
        }
        return (returnSearch);
    }

    public void updateInformation(String field, String fieldChange, String product) {
        try {
            PreparedStatement stmt = openConnection().prepareStatement("UPDATE banco_teste_automacao.massas SET "
                    + field + " = '" + fieldChange + "' WHERE (NAME_PRODUCT = '" + product + "')");
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro de update no banco massas");
            System.err.println(e.getMessage());
        }
    }

    public String returnProdutdBankMasses() {
        String returnProduct = null;
        try {
            PreparedStatement stmt = openConnection().prepareStatement("SELECT NAME_PRODUCT FROM banco_teste_automacao.massas");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                returnProduct = rs.getString("NAME_PRODUCT");
            }
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro de select no banco massas");
            System.err.println(e.getMessage());
        }
        return (returnProduct);
    }

}
