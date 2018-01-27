package isgbd.model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void insertFlowerVersions(FlowerVersion flowerVersion) {
        final String stmtText = "INSERT INTO flowerVersion( flower_id, buds,block_id) values (?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(stmtText);
            pstmt.setLong(1, flowerVersion.getFlowerId());
            pstmt.setLong(2, flowerVersion.getBuds());
            pstmt.setLong(3, flowerVersion.getBlockId());
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            System.out.print("Error on updating flowers versions.");
            e.printStackTrace();
        }

    }


}
