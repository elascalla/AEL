/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wrapper;

import br.com.util.TotemUtil;

/**
 *
 * @author Andre
 */
public class FalhaWrapper {
    
    private TotemInWrapper totemWrapperIn;
    
    private TotemOutWrapper totemWrapperOut;
    
    private String mensagem;
    
    private String stackTrace;
    
    private Exception exception;

    public FalhaWrapper() {
    }

    public FalhaWrapper(TotemInWrapper totemWrapperIn, TotemOutWrapper totemWrapperOut, String mensagem, String stackTrace, Exception exception) {
        this.totemWrapperIn = totemWrapperIn;
        this.totemWrapperOut = totemWrapperOut;
        this.mensagem = mensagem;
        this.stackTrace = stackTrace;
        this.exception = exception;
    }

    public TotemInWrapper getTotemWrapperIn() {
        return totemWrapperIn;
    }

    public void setTotemWrapperIn(TotemInWrapper totemWrapperIn) {
        this.totemWrapperIn = totemWrapperIn;
    }

    public TotemOutWrapper getTotemWrapperOut() {
        return totemWrapperOut;
    }

    public void setTotemWrapperOut(TotemOutWrapper totemWrapperOut) {
        this.totemWrapperOut = totemWrapperOut;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public Exception getException() {
        return exception;
    }
    
    /**
     * 
     * @return 
     */
    public String getChaveIn(){
        
        StringBuilder builder = new StringBuilder("TOTEM IN -> ");
        
        if(totemWrapperIn == null){
            builder.append("Informações obrigatórios inválidas.");
        } else{
            
            builder.append("CPF ");
            builder.append(TotemUtil.ehBrancoOrNulo(totemWrapperIn.getCpfPesquisa()) ? "não preenchido." : totemWrapperIn.getCpfPesquisa());
            builder.append(" ");
            
            builder.append("CNS ");
            builder.append(TotemUtil.ehBrancoOrNulo(totemWrapperIn.getCnsPesquisa()) ? "não preenchido." : totemWrapperIn.getCnsPesquisa());
            builder.append(" ");
            
            builder.append("Nome ");
            builder.append(TotemUtil.ehBrancoOrNulo(totemWrapperIn.getNomePesquisa()) ? "não preenchido." : totemWrapperIn.getNomePesquisa());
            builder.append(" ");
            
            builder.append("Data Nascimento ");
            builder.append(TotemUtil.ehBrancoOrNulo(totemWrapperIn.getDataNascimentoPesquisa()) ? "não preenchido." : totemWrapperIn.getDataNascimentoPesquisa());
            builder.append(" ");
        }
        
        return builder.toString();
    }
    
    /**
     * 
     * @return 
     */
    public String getChaveOut(){
        
        StringBuilder builder = new StringBuilder("TOTEM OUT -> ");
        
        if(totemWrapperOut == null){
            builder.append("Informações obrigatórios inválidas.");
        } 
        
        return builder.toString();
    }
}