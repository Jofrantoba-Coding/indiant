/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.model.beans;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author jona
 */
@Log4j2
public class TestEstadoAmistad {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    
    @Test
    void callContextSpring(){   
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigEntity.class);
        EstadoAmistad bean = context.getBean(EstadoAmistad.class);
        bean.setId("A");        
        EstadoAmistad bean1 = context.getBean(EstadoAmistad.class);
        bean1.setId("B");    
        System.out.println(bean.getId());
        System.out.println(bean1.getId());
        context.close();
    }
    
}
