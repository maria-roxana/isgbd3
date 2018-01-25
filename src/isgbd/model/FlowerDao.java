package isgbd.model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;
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

    public Flower getFlower(long id) {
        final String stmtText = "select name, buds from flower where id =" + id;
        Flower flower = new Flower();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(stmtText);

            if(rs.next()) {
                String name = rs.getString("name");
                Long buds = rs.getLong("buds");
                flower = new Flower(id, name, buds);
            }

            return flower;
        } catch (SQLException e) {
            System.out.print("Error on updating flowers versions.");
            e.printStackTrace();
        }
        return flower;

    }




}
