/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.model;


import br.com.unidospi.Controller.EmpresaController;
import br.com.unidospi.DAO.EmpresaDao;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author thiago.srocha4
 */
public class Empresa {

    int cod;
    String nome;
    String cnpj;
    Date dataCriacao;
    int estado;
    int cidade;
    boolean status;
    boolean matriz;

    public Empresa(int cod, String nome, String cnpj, Date dataCriacao, int estado, int cidade, boolean status, boolean matriz) {
        this.cod = cod;
        this.nome = nome;
        this.cnpj = cnpj;
        this.dataCriacao = dataCriacao;
        this.estado = estado;
        this.cidade = cidade;
        this.status = status;
        this.matriz = matriz;
    }

    public Empresa(String nome, String cnpj, Date dataCriacao, int estado, int cidade, boolean status, boolean matriz) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.dataCriacao = dataCriacao;
        this.estado = estado;
        this.cidade = cidade;
        this.status = status;
        this.matriz = matriz;
    }

    
    
    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getMatriz() {
        return matriz;
    }

    public void setMatriz(boolean matriz) {
        this.matriz = matriz;
    }

    public void listarProdutos() {

    }

    public void listarServicos() {

    }

    public void bloquearCadastro() {

    }

    public void desbloquearCadastro() {

    }
    public boolean salvar(){
        return EmpresaDao.salvar(this);
    }

    public ArrayList listarEmpresas(){
        return EmpresaController.listarEmpresas();
    }

    public boolean alterar() {
        return EmpresaController.alterar(this);
    }
    
}
