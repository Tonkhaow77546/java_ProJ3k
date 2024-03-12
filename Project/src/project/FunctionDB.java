package project;

import java.sql.Connection;
public interface FunctionDB {
    public abstract void connect();
    public abstract void disconnect();
    public abstract void setID(int id);
    public abstract int getID();
    public abstract Connection getConnection();
}
