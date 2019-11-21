/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;

/**
 *
 * @author Thiago
 */
public class RelatorioGeral {
    
    private int idEmpresa;
    private String nome;
    private float valorFaturaA;
    private float valorFaturaB;
    private double variacao;

    public RelatorioGeral(int idEmpresa, String nome, float valorFaturaA, float valorFaturaB, double variacao) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.valorFaturaA = valorFaturaA;
        this.valorFaturaB = valorFaturaB;
        this.variacao = variacao;
    }

    public RelatorioGeral(int idEmpresa, String nome, float total) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.valorFaturaB = total;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorFaturaA() {
        return valorFaturaA;
    }

    public void setValorFaturaA(float valorFaturaA) {
        this.valorFaturaA = valorFaturaA;
    }

    public float getValorFaturaB() {
        return valorFaturaB;
    }

    public void setValorFaturaB(float valorFaturaB) {
        this.valorFaturaB = valorFaturaB;
    }

    public double getVariacao() {
        return variacao;
    }

    public void setVariacao(double variacao) {
        this.variacao = variacao;
    }
    
    
    
}
