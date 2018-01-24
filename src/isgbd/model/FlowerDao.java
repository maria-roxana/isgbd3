package isgbd.model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 22.01.2018.
 */
public class FlowerDao {
    private Connection conn;

    public FlowerDao() {
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

    public List<Flower> getFlowers() {
        List<Flower> flowers = new ArrayList<>();
        final String stmtText = "SELECT id, name, buds from flower";
        final Statement stmt;
        try {
            stmt = conn.createStatement();
            final ResultSet rs = stmt.executeQuery(stmtText);

            while (rs.next()) {
                final Long id = rs.getLong(1);
                final String name = rs.getString(2);
                final Long buds = rs.getLong(3);

                flowers.add(new Flower(id, name, buds));
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.print("Error when select flowers");
        }

        return flowers;
    }
}
