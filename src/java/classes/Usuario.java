/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;
import classes.Conexao;

/**
 *
 * @author rafael
 */
public class Usuario {
    public String email;
    public String senha;
    public int tipo;

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipo() {
        return tipo;
    }

    
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    public Usuario(){
        
    }    
    
}
