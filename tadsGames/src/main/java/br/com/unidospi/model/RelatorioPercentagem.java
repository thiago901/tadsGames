/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

/**
 *
 * @author thiago.srocha4
 */
public class RelatorioPercentagem {
    private String EMPRESA;
    private Double TOTAL_FATURADO;
    private Double PORCENTAGEM;

    public RelatorioPercentagem(String EMPRESA, Double TOTAL_FATURADO, Double PORCENTAGEM) {
        this.EMPRESA = EMPRESA;
        this.TOTAL_FATURADO = TOTAL_FATURADO;
        this.PORCENTAGEM = PORCENTAGEM;
    }

    public String getEMPRESA() {
        return EMPRESA;
    }

    public Double getTOTAL_FATURADO() {
        return TOTAL_FATURADO;
    }

    public Double getPORCENTAGEM() {
        return PORCENTAGEM;
    }
    
    
}
