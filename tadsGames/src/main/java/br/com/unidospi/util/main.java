/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unidospi.util;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 *
 * @author HENRIQUE BASTOS
 */
public class main implements ServletContainerInitializer{
       
    public static void main(String[] args) {
        
       
        
    }

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
