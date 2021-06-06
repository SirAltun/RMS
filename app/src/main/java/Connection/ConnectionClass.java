package Connection;

import android.database.SQLException;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    public static String server = "DESKTOP-8NRA054";
    public static String database = "RESTAURANT_MANAGEMENT_SYSTEM";
    public static String user_name = "RMS";
    public static String password = "RMS2021";

    public static Connection connectionClass(String user_name, String password, String database, String server){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection= null;
        String connectionURL = null;
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURL = "jdbc:jtds:sqlserver://" + server +";databaseName="+ database + ";user=" + user_name+ ";password=" + password + ";";
            connection = DriverManager.getConnection(connectionURL);
        }catch (SQLException se)
        {
            Log.e("error here 1 : ", se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("error here 2 : ", e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("error here 3 : ", e.getMessage());
        }
        return connection;
    }
}
