package isgbd.model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import isgbd.util.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laura on 1/24/2018
 */

public class TransactionDao {

    private Connection conn;

    private Utils utils;

    public TransactionDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("isgbd3");
        dataSource.setPortNumber(3306);
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.print("Mysql connection error!");
        }
    }

    public void updateTransactionsTable(Transaction transaction) {
        final String stmtText = "INSERT INTO transactions VALUES(?,?,?,?)";
        final Statement stmt;
        try {
            PreparedStatement pstmt = conn.prepareStatement(stmtText);
            pstmt.setInt(1, transaction.getId());
            pstmt.setTimestamp(2, utils.getCurrentTimeStamp());
            pstmt.setString(3, transaction.getDetails());
            pstmt.setBoolean(4, transaction.is_active());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            //System.out.print("Error on updating transactions.");
            e.printStackTrace();
        }
    }

    public int getNextId(){
        final String stmtText = "SELECT COUNT(*) as total from transactions";
        final Statement stmt;
        int id = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(stmtText);

            while (rs.next())
                id = rs.getInt("total");

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println("Error on getting the ID.");
        }

        return id + 1;
    }

    public void endTransaction(int id){
        final String stmtText = "UPDATE transactions SET active = false where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(stmtText);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            //System.out.print("Error on updating transactions.");
            e.printStackTrace();
        }
    }
}
