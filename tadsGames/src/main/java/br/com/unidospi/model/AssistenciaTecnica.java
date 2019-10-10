/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

/**
 *
 * @author lucas
 */
public class AssistenciaTecnica extends Servicos{
    private String equipamento;
    private String dataFinalizacao;
    private String statusReparo;

    public AssistenciaTecnica(String equipamento, String dataFinalizacao, String statusReparo, int codProdServ, String categoria, String nome, double valorCompra, String descricao, String regiao, boolean status) {
        super(codProdServ, categoria, nome, valorCompra, descricao, regiao, status);
        this.equipamento = equipamento;
        this.dataFinalizacao = dataFinalizacao;
        this.statusReparo = statusReparo;
    }



    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(String dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public String getStatusReparo() {
        return statusReparo;
    }

    public void setStatusReparo(String statusReparo) {
        this.statusReparo = statusReparo;
    }

    
    
    
    
}
