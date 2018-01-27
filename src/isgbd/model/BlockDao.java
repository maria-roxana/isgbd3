package isgbd.model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;


/**
 * Created by maria-roxana on 27.01.2018.
 */
public class BlockDao {
    private Connection conn;

    public BlockDao() {
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

    public int addBlock(Block block) {
        int blockId = -1;
        final String stmtText = "INSERT INTO block(flower_id,transaction_id,type) values (?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(stmtText,Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, block.getFlowerId());
            pstmt.setLong(2, block.getTransactionId());
            pstmt.setString(3, block.getType());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                blockId = rs.getInt(1);
            }
            pstmt.close();

        } catch (SQLException e) {
            System.out.print("Error on updating flowers versions.");
            e.printStackTrace();
        }
        return blockId;
    }
}
