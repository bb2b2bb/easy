package com.ethink.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Yule_Liu
 * @version V 1.0.0
 * @description
 * @date 2020/2/19 10:50
 */
public class DbUtil {

    private String dbUrl = "jdbc:mysql://localhost:3306/easyui";

    private String dbUserName = "root";

    private String dbPassword = "123456";

    private String jdbcName = "com.mysql.jdbc.Driver";

    public Connection getCon() throws Exception {
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return con;
    }

    public void closeCon(Connection con) throws Exception {

        if (con != null) {

            con.close();
        }
    }

}
