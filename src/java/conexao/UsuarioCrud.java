/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import classes.Usuario;
import classes.Conexao;
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
    
    public static List<Usuario> buscaUsr() throws SQLException{
        ResultSet res = null;
        
        Conexao con = new Conexao();
        res = con.busca("usuario");
        
        while(res.next()){
            Usuario usr = new Usuario();
            usr.setEmail(res.getString("email_usr"));
            usr.setSenha(res.getString("senha_usr"));
            usr.setTipo(res.getInt("adm_usr"));
            
            usuarios.add(usr);
        }
        
        
        return usuarios;
    }
    
}
