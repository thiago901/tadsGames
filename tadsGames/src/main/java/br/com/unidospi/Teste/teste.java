/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Teste;

import br.com.unidospi.Controller.CidadeController;

import br.com.unidospi.Controller.EmpresaController;
import br.com.unidospi.model.Cidade;
import br.com.unidospi.model.Empresa;
import br.com.unidospi.model.EmpresaLista;
import java.util.List;

/**
 *
 * @author thiago.srocha4
 */
public class teste {
    
    public static void main(String[] args) {
        List <EmpresaLista> le =EmpresaController.listarEmpresas();
        
        for(EmpresaLista e : le){
            System.out.println(e.toString());
            
        }
    }
    
}
