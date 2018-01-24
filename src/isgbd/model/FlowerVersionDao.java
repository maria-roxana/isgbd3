package isgbd.model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;

/**
 * Created by Laura on 1/24/2018
 */

public class FlowerVersionDao {
    private Connection conn;

    public FlowerVersionDao() {
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

    public void insertFlowerVersions(Flower flower){
        final String stmtText = "INSERT INTO flowerversion(flower_id, buds) values (?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(stmtText);
            pstmt.setLong(1, flower.getId());
            pstmt.setLong(2, flower.getBuds() + 1);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            System.out.print("Error on updating flowers versions.");
            e.printStackTrace();
        }

    }
}
