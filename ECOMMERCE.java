package ECommerce;
import java.sql.*;
import java.util.*;
public class ECOMMERCE {
        public static void main(String[] args) {

                               try{ 
                                   String choice;
                                   String a,b;

                             
                               Class.forName("com.mysql.jdbc.Driver"); 

                               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root",""); 

                               Statement stmt=con.createStatement();
                               Scanner sc=new Scanner(System.in);

                               ResultSet r=stmt.executeQuery("select * from product");
                               while(r.next()) 
                               System.out.println(r.getString(1));
                              do{
                              System.out.println("If You want to Add the Product into a Cart then press 1 else 2 for Deleting from Cart");
                              b=sc.next();
                           if(b.equals("1")){
                             System.out.println("Enter the Product that You want to Add to Cart:");
                             a=sc.next();
                             String q1 = "INSERT INTO CART VALUES('"+a+"')";
                             stmt.executeUpdate(q1);
                             System.out.println("Added");
                             System.out.println("       CART PRODUCTS         ");
                             System.out.println("=============================");
                            ResultSet k=stmt.executeQuery("select * from CART");
                            while(k.next()) 
                            System.out.println(k.getString(1));
                            
                            }
                         else 
                              {System.out.println("           CART DISPLAY          ");
                              System.out.println("==================================");
                               ResultSet m=stmt.executeQuery("select * from CART");
                               while(m.next()) 
                               System.out.println(m.getString(1)); 
                                System.out.println("Enter the Product that You want to delete the Product from cart:");
                               a=sc.next();
                                String q2="Delete from CART where Pname='"+a+"'";
                                stmt.executeUpdate(q2);
                                   }
                           System.out.println("Do you want to repeat the Shopping: yes/no:");

                                    choice=sc.next();
                              }
                               while(choice.equalsIgnoreCase("yes"));
                              
      
                             

                               con.close();

                               }
                               
                               
                               
                   catch(Exception e){ System.out.println(e);} 

                               } 

       }

