/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

import java.util.Date;

/**
 *
 * @author thiago.srocha4
 */
public class RelatorioTop10 {
    private float VALOR;
    private String PRODUTO; 
    private String EMPRESA; 
    private int QUANTIDADE;

    public RelatorioTop10(String PRODUTO, String EMPRESA, int QUANTIDADE,float VALOR) {
        this.VALOR = VALOR;
        this.PRODUTO = PRODUTO;
        this.EMPRESA = EMPRESA;
        this.QUANTIDADE = QUANTIDADE;
    }
    public RelatorioTop10(String PRODUTO, int QUANTIDADE,float VALOR) {
        this.VALOR = VALOR;
        this.PRODUTO = PRODUTO;
        
        this.QUANTIDADE = QUANTIDADE;
    }

    public float getVALOR() {
        return  VALOR ;
    }

    public String getPRODUTO() {
        return PRODUTO;
    }

    public String getEMPRESA() {
        return EMPRESA;
    }

    public int getQUANTIDADE() {
        return QUANTIDADE;
    }
    
    
}
