package grt.mssqltest16;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MssqlConnectTest16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		String url =null;
		String user = null;
		String pwd = null;
//		String url ="jdbc:sqlserver://14.40.50.19:1433;databaseName=BTL";
//		String user = "di";
//		String pwd = "di1234";
		
//        if (args.length < 3) {
//			System.out.println("args.length : "+ args.length);
//			System.out.println("!!!==Input the Parameter Information==[jdbcurl] [user] [pwd] , ex)jdbcurl : jdbc:sqlserver://127.0.0.1:1433");
//            return;
//        }

		BufferedReader reader = new BufferedReader(
				new java.io.InputStreamReader(System.in));
		
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		try {
			System.out.println("접속 DB의 url정보를 입력하세요. jdbc:sqlserver://[ip]:[port];databaseName=[databasename];기타옵션");
			System.out.println("예)jdbc:sqlserver://192.168.1.10:1433;databaseName=btl;EncryptionMethod=ssl;integratedSecurity=false;trustServerCertificate=true");
			System.out.print(">");
			url = reader.readLine();

			System.out.print("접속 DB의 user ");
			System.out.print(">");
			user = reader.readLine();

			System.out.print("접속 DB의 user의 password ");
			System.out.print(">");
			pwd = reader.readLine();
			
			System.out.println("입력한 url : "+url);
			System.out.println("입력한 user : "+user);
			System.out.println("입력한 user의 password : "+pwd);
			Date date1 = new Date();
			System.out.println("Before Connection : " + date1);

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			url = "jdbc:sqlserver://"+args[0]+":"+args[1]+";databaseName="+args[2]+";integratedSecurity=false;encrypt=false;trustServerCertificate=true";
//			url = "jdbc:sqlserver://"+args[0]+":"+args[1]+";databaseName="+args[2];
//			user = args[3];
//			pwd = args[4];
//			String etc = "databaseName=BTL;integratedSecurity=false;"+"encrypt=false;trustServerCertificate=true";
//			String etc = "";
			conn = DriverManager.getConnection(url, user, pwd);
//			conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433", "di", "di1234");
			System.out.println("Connect Sucess !!! ===[" +url+ "]["+user+"]["+pwd+"]");


			DatabaseMetaData data = conn.getMetaData();
			System.out.println( "DatabaseProductName===>" +data.getDatabaseProductName());
			System.out.println( "DatabaseProductVersion===>" +data.getDatabaseProductVersion());
			System.out.println( "DatabaseMajorVersion===>" +data.getDatabaseMajorVersion());
			System.out.println( "DatabaseMinorVersion===>" +data.getDatabaseMinorVersion());
			System.out.println( "DatabaseDriverName===>" +data.getDriverName());
			System.out.println( "DatabaseDriverVersion===>" +data.getDriverVersion());
			System.out.println( "DatabaseDriverMajorVersion===>" +data.getDriverMajorVersion());
			System.out.println( "DatabaseDriverMinorVersion===>" +data.getDriverMinorVersion());
			System.out.println( "DatabaseExtraNameCharacters===>" +data.getExtraNameCharacters());
			System.out.println( "DatabaseIdentifierQuoteString===>" +data.getIdentifierQuoteString());
			System.out.println( "DatabaseCatalogTerm===>" +data.getCatalogTerm());

			ResultSet rs = data.getCatalogs();
			System.out.println( "====Catalogs Infomation===" );
			while ( rs.next( ) ) {
				System.out.println( rs.getString(1)+"\t" );
			}

//			rs = data.getSchemas();
//			System.out.println( "====Schemas Infomation===" );
//			while ( rs.next( ) ) {
//				System.out.println( rs.getString(1)+"\t" );
//			}
			
			
			
			date1 = new Date();
			System.out.println("After Connection : " + date1); 

			conn.close();

		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
