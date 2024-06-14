package edu.hit;

import junit.framework.TestCase;
import org.junit.Test;
import picocli.CommandLine;

import java.io.File;

public class Lab1Test extends TestCase {


    @Test
    public void test(){


           String str =  new CommandLine(new Lab1()).execute("-s", "D:\\SElab\\lab1\\code\\testcase\\testcase1.txt",  "--show");

    }

    public  void test1(){
        String processedText = "to explore strange new worlds to seek out new life and new civilizations";
        DirectedGraph graph = GraphConverter.convertTextToGraph(processedText);
        System.out.println(graph.queryBridgeWords("explore","new"));
        //GraphConverter.showDirectedGraph(graph);
        //GenerateImg.generate(graph,new File("D:\\SElab\\lab1\\code\\directed_graph.png"));
    }

    public void generateGraphTest(){

    }
}