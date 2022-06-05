package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSQL implements Interfaces.Provider{

    private static Connection _connection = null;

    public static Connection get_connection(){
        System.out.println("test");
        try {
            Class.forName("org.postgresql.Driver");
            _connection = DriverManager.getConnection(_cs, _user, _pwd);
            System.out.println("Connected!");
       }catch (SQLException | ClassNotFoundException e){

            System.out.println("error");
            e.getStackTrace();
        }
       // _connection = DriverManager.getConnection(_cs, _user, _pwd);
        //System.out.println("Connected!");
        return _connection;
    }
}
