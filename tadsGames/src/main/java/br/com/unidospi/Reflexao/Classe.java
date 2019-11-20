/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.Reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago.srocha4
 */
public class Classe {
    private Class<?> classe;
    private Object construtor;
    private Method metodo;
    
    public Class<?> criarClasse(String nomePacote, String nomeClasse) {
        try {
            Class<?> c = Class.forName(nomePacote + nomeClasse);
            return this.classe = c;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public Class<?> getClasse() {
        return classe;
    }

    public Object instanciarConstrutor(Class<?> classe) {
        try {
            return this.construtor=classe.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | SecurityException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Erro no Construtor", e);
        }
    }
    public Method recuperarMetodo(String nomeMetodo){
        try {
            Method metodo = this.classe.getDeclaredMethod(nomeMetodo, HttpServletRequest.class,HttpServletResponse.class);
            return this.metodo=metodo;
        } catch (SecurityException|NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } 
        
    }
    public Object invocaMetodo(HttpServletRequest req,HttpServletResponse resp){
        try {
            return this.metodo.invoke(this.construtor, req,resp);
        } catch (IllegalArgumentException|InvocationTargetException|IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } 
    }
}
