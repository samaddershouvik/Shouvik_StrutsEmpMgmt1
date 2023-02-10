/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.exavalu.services;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ServiceTestTest {
    
    public ServiceTestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getA method, of class ServiceTest.
     */
    @Test
    public void testGetA() {
        System.out.println("getA");
        ServiceTest instance = new ServiceTest();
        int expResult = 0;
        int result = instance.getA();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setA method, of class ServiceTest.
     */
    @Test
    public void testSetA() {
        System.out.println("setA");
        int a = 0;
        ServiceTest instance = new ServiceTest();
        instance.setA(a);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getB method, of class ServiceTest.
     */
    @Test
    public void testGetB() {
        System.out.println("getB");
        ServiceTest instance = new ServiceTest();
        int expResult = 0;
        int result = instance.getB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setB method, of class ServiceTest.
     */
    @Test
    public void testSetB() {
        System.out.println("setB");
        int b = 0;
        ServiceTest instance = new ServiceTest();
        instance.setB(b);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of check method, of class ServiceTest.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int a = 0;
        int b = 0;
        int expResult = 0;
        int result = ServiceTest.check(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
