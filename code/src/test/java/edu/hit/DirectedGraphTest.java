package edu.hit;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;


public class DirectedGraphTest extends TestCase {

    @Test
    public void test(){
        String inputText = "Seek to explore new and exciting synergies";
        String processedText = "to explore strange new worlds to seek out new life and new";
        DirectedGraph graph = GraphConverter.convertTextToGraph(processedText);
        //System.out.println(graph.generateNewText(inputText));
        System.out.println(graph.calcShortestPath("to","and"));
    }





}