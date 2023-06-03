package bdclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import com.mysql.jdbc.Connection;
/**

*Esta clase se encarga de establecer una conexión con la base de datos.
*@author Ismael
*@version 1.0
*/
public class ConexionBD {
	/**
	Este método devuelve una conexión con la base de datos.
	@return la conexión con la base de datos.
	@throws SQLException si no se puede conectar con la base de datos.
	*/
	public static Connection getConnection() {
        Properties props = new Properties();
        FileInputStream fis = null;
        Connection con = null;
        try {
            fis = new FileInputStream("D:/Uni/Proyectos/Java/giin_21/src/bdclass/config.properties");
            props.load(fis);

            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            
            con = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database.");

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return con;
    }
}