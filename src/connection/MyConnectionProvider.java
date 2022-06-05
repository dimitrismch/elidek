package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnectionProvider implements Interfaces.Provider {

    static Connection connection = null;

    public static Connection getCon(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(_cs,_user,_pwd);
        }catch (Exception e){
            e.getStackTrace();
        }

        return connection;
    }
}
