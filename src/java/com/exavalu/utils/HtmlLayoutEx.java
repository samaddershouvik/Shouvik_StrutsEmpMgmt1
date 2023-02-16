package com.exavalu.utils;


import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class HtmlLayoutEx{
    /* Get actual class name to be printed on */
   static Logger log = Logger.getLogger(HtmlLayoutEx.class.getName());
   
   public static void main(String[] args)throws IOException,SQLException{
      log.debug("Hello this is an debug message");
      log.error("Hello this is an info message");
   }
}