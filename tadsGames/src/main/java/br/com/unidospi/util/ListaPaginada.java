/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.util;

/**
 *
 * @author thiago.srocha4
 */
public class ListaPaginada {
    private double quantidadeRegistro;
    private double qtdRegistoPorPagina;
    private int numPagina;

    public ListaPaginada(double quantidadeRegistro, double qtdRegistoPorPagina, int numPagina) {
        this.quantidadeRegistro = quantidadeRegistro;
        this.qtdRegistoPorPagina = qtdRegistoPorPagina;
        this.numPagina = numPagina;
       
    }
    
    
    public int getQtdPaginas(){
        double qtdPaginas = quantidadeRegistro/ qtdRegistoPorPagina;
        return (int) Math.ceil(qtdPaginas);
    }
    
    public int offset(){
        return (int)((numPagina*qtdRegistoPorPagina)-qtdRegistoPorPagina);
    }
    public double getQuantidadeRegistro() {
        return quantidadeRegistro;
    }

    public void setQuantidadeRegistro(double quantidadeRegistro) {
        this.quantidadeRegistro = quantidadeRegistro;
    }

    public double getQtdRegistoPorPagina() {
        return qtdRegistoPorPagina;
    }

    public void setQtdRegistoPorPagina(double qtdRegistoPorPagina) {
        this.qtdRegistoPorPagina = qtdRegistoPorPagina;
    }

    public int getNumPagina() {
        if(this.numPagina>getQtdPaginas()){
            return this.numPagina-=1;
        }
        if(this.numPagina<=0){
            return this.numPagina+=1;
        }
        return this.numPagina;
    }

    public void setNumPagina(int numPaginaStr) {
        this.numPagina = numPaginaStr;
    }
    
    
}
