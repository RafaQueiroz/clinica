package classes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;  
import java.sql.*;
import classes.Usuario;
  
public class Conexao {  
     
   public Connection con;  
   public Statement stm;  
   public ResultSet res = null;  
  
   public Conexao() {  
  
      try {  
  
         Class.forName("oracle.jdbc.driver.OracleDriver");  
         con =  
            DriverManager.getConnection(  
              "jdbc:oracle:thin:@oracle.inf.poa.ifrs.edu.br:1521:XE", "usr75","usr75");  
         stm = con.createStatement();   
           
      } catch (Exception e) {  
         System.out.println("não foi possível conectar ao banco" + e.getMessage());  
      }  
   }  
     
  
   public void inserirDados(String email, String senha, int tipo){  
     
      try {  
         String query = "insert into usario(emailUsr, senhaUsr, tipoUsr) values('"+email+"','"+senha+"',"+tipo+"')";  
         stm.executeUpdate(query);  
         System.out.println("Registro inserido");
      }catch (SQLException e){System.out.println("Erro na inserção:" + e.getMessage());}  
        
   }  
  
  
     
   public boolean excluirDados(String email){  
     
    boolean testa = false;  
     
      try {  
         String query = "delete from usuario where nomeUsr='" +email+"'";  
         int linhas = stm.executeUpdate(query);  
           
         if (linhas > 0)  
            testa = true;  
         else  
            testa = false;  
  
      }catch (SQLException e){System.out.println("Erro na exclusão:" + e.getMessage());}  
        
      return testa;  
   }  
     
   public ResultSet busca(String tabela){
                  
      try {  
         String query = "select * from "+tabela;  
         res = stm.executeQuery(query);
           
      }catch (SQLException e){System.out.println("Erro na inserção:" + e.getMessage());}  
        
      return res;  
   }     
}  
    
