/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Controller;

import br.com.unidospi.DAO.CidadeDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class CidadeController {
    public static ArrayList listarCidade(){
        return CidadeDAO.listaCidade();
        
    }
    public static ArrayList listarCidade(int uf){
        return CidadeDAO.listaCidade(uf);
        
    }
}