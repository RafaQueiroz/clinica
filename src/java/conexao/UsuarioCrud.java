/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import classes.Usuario;
import classes.Conexao;
import classes.Exame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael
 */
public class UsuarioCrud {
    public static List<Usuario> usuarios = new ArrayList<Usuario>();
    public static List<Exame> exames = new ArrayList<Exame>();
     
    public static List<Usuario> buscaUsr() throws SQLException{
        ResultSet res = null;
        
        Conexao con = new Conexao();
        res = con.busca("usuario");
        
        while(res.next()){
            Usuario usr = new Usuario();
            usr.setNome(res.getString("nome_usr"));
            usr.setEmail(res.getString("email_usr"));
            usr.setSenha(res.getString("senha_usr"));
            usr.setTipo(res.getInt("adm_usr"));
            
            usuarios.add(usr);
        }
        return usuarios;
    }
    
    public static List<Exame> buscaExame(String nomeMed) throws SQLException{
        ResultSet res = null;
        
        Conexao con = new Conexao();
        res = con.buscaExame(nomeMed);
        
        while(res.next()){
            Exame exame = new Exame();
            System.out.println("Buscando");
            exame.setNomeExame(res.getString("nome_exame"));
            exame.setNomeMed(res.getString("nome_med"));
            exame.setExamePrep(res.getString("prep_exame"));
            exame.setIdUsr(res.getInt("id_user"));
            exame.setDataExame(res.getDate("data_exame"));
            exame.setPrioridade(res.getInt( "prioridade_exame"));
            
            
            exames.add(exame);
        }
        return exames;
    }
    
    public static void insereUsrAdm(String nome, String email, String senha, int tipo){
        
        Conexao con = new Conexao();        
        
        try{   
         con.inserirDados(nome, email, senha, tipo);
        }
        catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
    
}
