package com.mycompany.app.repository;

import com.mycompany.app.domain.Account;
import com.mycompany.app.config.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {

    private final DatabaseConfig databaseConfig;

    public AccountRepository(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    public Account getAccountById(int uniqueId) {
        String sql = "SELECT * FROM accounts WHERE id = ?";
        try (
            Connection conn = databaseConfig.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)
        ) {
        st.setInt(1, uniqueId);
        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                Account account = new Account();
                account.setUniqueId(rs.getInt("id"));
                account.setName(rs.getString("name"));
                account.setBalance(rs.getInt("balance"));
                return account;
            }
        }
            return null;
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldn't fetch account from database", e);
        }
    }
}
