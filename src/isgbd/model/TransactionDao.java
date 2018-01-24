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

    public int insertTransaction(Transaction transaction) {
        final String stmtText = "INSERT INTO transactions (timestamp, details, active) VALUES(?,?,?)";
        int id = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(stmtText);
            pstmt.setTimestamp(1, utils.getCurrentTimeStamp());
            pstmt.setString(2, transaction.getDetails());
            pstmt.setBoolean(3, transaction.is_active());
            id = pstmt.executeUpdate();

        } catch (SQLException e) {
            //System.out.print("Error on updating transactions.");
            e.printStackTrace();
        }
        return id;
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
