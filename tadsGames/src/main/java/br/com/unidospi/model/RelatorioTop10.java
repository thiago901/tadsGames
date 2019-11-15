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
    private Date DATA_VENDA;
    private String PRODUTO; 
    private String EMPRESA; 
    private int QUANTIDADE;

    public RelatorioTop10(Date DATA_VENDA, String PRODUTO, String EMPRESA, int QUANTIDADE) {
        this.DATA_VENDA = DATA_VENDA;
        this.PRODUTO = PRODUTO;
        this.EMPRESA = EMPRESA;
        this.QUANTIDADE = QUANTIDADE;
    }

    public Date getDATA_VENDA() {
        return DATA_VENDA;
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
