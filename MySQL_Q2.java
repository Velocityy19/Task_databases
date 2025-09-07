package JDBC;
import java.util.*;
import java.sql.*; 
public class jdbc_Connection {


	    public static void main(String[] args) {
	        
	    	// Database details
	        String url = "jdbc:mysql://localhost:3306/task"; // task= DB name
	        String user = "root"; 
	        String password = "Vasanth19!@#"; 

	        // SQL query for inserting data
	        String sql = "INSERT INTO Emp (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url, user, password);
	            PreparedStatement ps = con.prepareStatement(sql);

	            Scanner sc = new Scanner(System.in);
	            System.out.print("How many records do you want to insert? ");
	            int n = sc.nextInt();
	            sc.nextLine();  

	            for (int i = 0; i < n; i++) {
	                System.out.println("\nEnter details for employee " + (i+1) +":");

	                System.out.print("Emp Code (int): ");
	                int empcode = sc.nextInt();
	                sc.nextLine(); 

	                System.out.print("Emp Name (String): ");
	                String empname = sc.nextLine();

	                System.out.print("Emp Age (int): ");
	                int empage = sc.nextInt();

	                System.out.print("Emp Salary (int): ");
	                int esalary = sc.nextInt();
	                sc.nextLine(); 

	                ps.setInt(1, empcode);
	                ps.setString(2, empname);
	                ps.setInt(3, empage);
	                ps.setInt(4, esalary);

	                ps.addBatch();  
	            }

	            int[] results = ps.executeBatch();
	            System.out.println("\n" + results.length + " rows inserted successfully!");

	            ps.close();
	            con.close();
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


