package edu.hit;

import junit.framework.TestCase;
import picocli.CommandLine;

public class Lab1Test extends TestCase {

    public void test(){

        new CommandLine(new Lab1()).execute("-s","D:\\SElab\\lab1\\code\\testcase\\testcase1.txt","-d",".");
    }
}