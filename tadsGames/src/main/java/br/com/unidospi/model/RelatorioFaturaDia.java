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
public class RelatorioFaturaDia {

    private Date DATA_VENDA;
    private String EMPRESA;
    private double TOTAL;

    public RelatorioFaturaDia(Date DATA_VENDA, String EMPRESA, double TOTAL) {
        this.DATA_VENDA = DATA_VENDA;
        this.EMPRESA = EMPRESA;
        this.TOTAL = TOTAL;
    }

    public Date getDATA_VENDA() {
        return DATA_VENDA;
    }

    public String getEMPRESA() {
        return EMPRESA;
    }

    public double getTOTAL() {
        return TOTAL;
    }
    
    

}
