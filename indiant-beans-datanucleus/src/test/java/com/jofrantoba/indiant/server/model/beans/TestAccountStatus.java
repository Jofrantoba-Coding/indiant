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
public class TestAccountStatus {
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
        AccountStatus bean = context.getBean(AccountStatus.class);        
        bean.set_id("A");
        AccountStatus bean1 = context.getBean(AccountStatus.class);
        bean.set_id("B");
        System.out.println(bean.get_id());
        System.out.println(bean1.get_id());
        context.close();
    }
    
}
