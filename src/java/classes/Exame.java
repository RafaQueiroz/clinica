/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Date;

/**
 *
 * @author rafaelqueiroz
 */
public class Exame {
    
    public String nomeExame;
    public String examePrep;
    public String nomeMed;
    public int idUsr;
    public int prioridade;
    public Date dataExame;

    public int getIdUsr() {
        return idUsr;
    }

    public int getPrioridadeExame() {
        return prioridade;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public String getExamePrep() {
        return examePrep;
    }

    public String getNomeMed() {
        return nomeMed;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setIdUsr(int id_usr) {
        this.idUsr = id_usr;
    }

    public void setPrioridade(int prioridade_exame) {
        this.prioridade = prioridade_exame;
    }
    

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public void setExamePrep(String examePrep) {
        this.examePrep = examePrep;
    }

    public void setNomeMed(String nomeMed) {
        this.nomeMed = nomeMed;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public Exame(String nomeExame, String examePrep, String nomeMed, Date dataExame) {
        this.nomeExame = nomeExame;
        this.examePrep = examePrep;
        this.nomeMed = nomeMed;
        this.dataExame = dataExame;
    }
    public Exame() {
        
    }
    
    
    
    
}
