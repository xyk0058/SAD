package cn.edu.bjtu.sad.util;

import java.sql.Connection;

public abstract class DBUtilAbstractFactory {
    public abstract Connection getMysqlConn();
    public abstract Connection getOracleConn();
    public abstract Connection getDB2Conn();
}
