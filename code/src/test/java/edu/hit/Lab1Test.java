package edu.hit;

import junit.framework.TestCase;
import picocli.CommandLine;

public class Lab1Test extends TestCase {

    public void test(){

        new CommandLine(new Lab1()).execute("-s","D:\\SElab\\lab1\\code\\testcase\\testcase1.txt","-q");
    }

    public  void test1(){
        String processedText = "to explore strange new worlds to seek out new life and new civilizations";
        DirectedGraph graph = GraphConverter.convertTextToGraph(processedText);
        System.out.println(graph.queryBridgeWords("explore","new"));
    }
}