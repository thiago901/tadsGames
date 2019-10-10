/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Teste;

import br.com.unidospi.model.Empresa;

/**
 *
 * @author thiago.srocha4
 */
public class teste {
    
    public static void main(String[] args) {
        Empresa e = new Empresa("", "", null, "br", "sp", true,true);
        e.salvar();
    }
    
}
