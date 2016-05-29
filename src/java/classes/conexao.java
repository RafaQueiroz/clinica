package conexao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;  
import java.sql.*;
  
public class conexao {  
     
   public Connection con;  
   public Statement stm;  
   public ResultSet res = null;  
   private String cargo = null;  
   private double min_sal = 0;  
   private double max_sal=0;  
   private int id_cargo=0;
  
   public conexao() {  
  
      try {  
  
         Class.forName("oracle.jdbc.driver.OracleDriver");  
         con =  
            DriverManager.getConnection(  
              "jdbc:oracle:thin:@oracle.inf.poa.ifrs.edu.br:1521:XE", "usr01","banco2");  
         stm = con.createStatement();   
           
      } catch (Exception e) {  
         System.out.println("não foi possível conectar ao banco" + e.getMessage());  
      }  
   }  
     
   public void setNome(String cargo){  
      this.cargo = cargo;  
   }  
        
   public void setMin_sal(double min_sal){  
      this.min_sal = min_sal;  
   }  
  
   public void setMax_sal(double max_sal){  
      this.max_sal = max_sal;  
   } 
   
    public void setId_cargo(int id_cargo){  
      this.id_cargo = id_cargo;  
   } 
  
   public String getCargo(){  
      return cargo;  
   }  
  
   public double getMin_sal(){  
      return min_sal;  
   }  
        
   public double getMax_sal(){  
      return max_sal;  
   }  
  
     public int getId_cargo(){  
      return id_cargo;  
   }  
   public void inserirDados(){  
     
      try {  
         String query = "insert into cargo(id_cargo,nome_cargo,min_sal,max_sal) values(100,'"+cargo+"',"+min_sal+","+max_sal+")";  
         stm.executeUpdate(query);  
         System.out.println("Registro inserido");
      }catch (SQLException e){System.out.println("Erro na inserção:" + e.getMessage());}  
        
   }  
  
  
     
   public boolean excluirDados(){  
     
    boolean testa = false;  
     
      try {  
         String query = "delete from cargo where nome_cargo='" + cargo+"'";  
         int linhas = stm.executeUpdate(query);  
           
         if (linhas > 0)  
            testa = true;  
         else  
            testa = false;  
  
      }catch (SQLException e){System.out.println("Erro na exclusão:" + e.getMessage());}  
        
      return testa;  
   }  
     
   public boolean consultarDados(){  
        
      boolean testa = false;  
           
      try {  
         String query = "select * from pessoa where nome='" + cargo+"'";  
         res = stm.executeQuery(query);  
           
         if (res.next()){testa = true;}  
         else{testa = false;}  
           
      }catch (SQLException e){System.out.println("Erro na inserção:" + e.getMessage());}  
        
      return testa;  
   }     
  
   public void setConsulta() {  
        
      try {  
         res = stm.executeQuery("select * from cargo");  
      }   
      catch (SQLException e){  
      }  
  
   }  
  
   public ResultSet getResultado() {  
      return res;  
   } 
   
       public void insertCargo() throws SQLException, ClassNotFoundException, IOException {
        CallableStatement clst = con.prepareCall("{call insert_cargo(?, ?, ?)}");
        clst.setString(1, cargo);
        clst.setDouble(2, min_sal);
        clst.setDouble(3, max_sal);
        clst.execute();
        
        clst.close();
    }
       
         public  void getCodigo() throws SQLException, ClassNotFoundException, IOException {
        CallableStatement clst = con.prepareCall("{? = call get_id_cargo(?)}");
        clst.registerOutParameter(1, Types.INTEGER);
        clst.setString(2,cargo);
       // clst.setString(2,"xx");
        clst.execute();
       setId_cargo(clst.getInt(1));
        clst.close();
    }
}  

