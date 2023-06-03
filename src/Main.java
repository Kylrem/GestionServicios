import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import bdclass.UsuariosDAO;
import bdclass.ConexionBD;

public class Main {

	
	public static void main(String[] args) throws SQLException  
	{
		/*Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_Giin21?useSSL=false","freedb_vecinologer","@R@g!KgDfeVk34$");
		try{
		
			PreparedStatement prestat = con.prepareStatement("select * from user where DNI = '42697823K' and Password = 'salu2'");
			ResultSet res = prestat.executeQuery();
			if(res.next()) {
				
 
				if(res.getBoolean("isAdmin")==true) 
				{
					System.out.println( "Bienvenido Administrador "+ res.getString("Nombre") + res.getString("PrimerApellido") + res.getString("SegundoApellido"));
				}else {
					System.out.println( "Bienvenido Vecino"+ res.getString("Nombre") + res.getString("PrimerApellido") + res.getString("SegundoApellido"));
				}
			}
			else {
				System.out.println("Usuario o contraseña equivocados");
			}
		}catch(Exception e) {
			System.out.println( "Error al conectar");
		}*/
		/*Connection con = ConexionBD.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("Nombre");
                String password = rs.getString("PrimerApellido");
                System.out.println("ID: " + id + ", Nombre: " + username + ", PrimerApellido: " + password);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
	}
}
