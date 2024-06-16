package edu.hit;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TextProcessorTest {

    DirectedGraph graph;


    @Test
    public void processTextFileTest() {
        System.out.println(1);
    }

    @Test
    public void testConvertTextToGraph1() {
        graph = new DirectedGraph();
        String filePath = "D:/JAVAcode/lab1/code/testcase/testcase0.txt";
        File file = new File(filePath);
        graph = GraphConverter.convertTextToGraph(TextProcessor.processTextFile(file));
        String expected = "错误：文件不存在";
        assertEquals(expected, TextProcessor.processTextFile(file));
    }

    @Test
    public void testConvertTextToGraph2() {
        graph = new DirectedGraph();
        String filePath = "D:/JAVAcode/lab1/code/testcase/testcase0.zip";
        File file = new File(filePath);
        graph = GraphConverter.convertTextToGraph(TextProcessor.processTextFile(file));
        String expected = "错误：文件类型不符";
        assertEquals(expected, TextProcessor.processTextFile(file));
    }

    @Test
    public void testConvertTextToGraph3() {
        graph = new DirectedGraph();
        String expected = "错误：输入文件数量不符";
        assertEquals(expected, TextProcessor.processTextFile());
    }

    @Test
    public void testConvertTextToGraph4() {
        graph = new DirectedGraph();
        String filePath1 = "D:/JAVAcode/lab1/code/testcase/testcase1.txt";
        File file1 = new File(filePath1);
        String filePath2 = "D:/JAVAcode/lab1/code/testcase/testcase1.txt";
        File file2 = new File(filePath2);
        graph = GraphConverter.convertTextToGraph(TextProcessor.processTextFile(file1, file2));
        String expected = "错误：输入文件数量不符";
        assertEquals(expected, TextProcessor.processTextFile(file1,file2));
    }

    @Test
    public void testConvertTextToGraph5() {
        graph = new DirectedGraph();
        String filePath = "D:/JAVAcode/lab1/code/testcase/testcase2.txt";
        File file = new File(filePath);
        graph = GraphConverter.convertTextToGraph(TextProcessor.processTextFile(file));
        String expected = "{a={test=2}, world={this=1}, test={this=1}, this={is=2}, only={a=1}, is={a=1, only=1}, hello={world=1}}";
        assertEquals(expected, graph.toString());
    }
    @Test
    public void testConvertTextToGraph6() {
        graph = new DirectedGraph();
        String filePath = "D:/JAVAcode/lab1/code/testcase/testcase3.txt";
        File file = new File(filePath);
        graph = GraphConverter.convertTextToGraph(TextProcessor.processTextFile(file));
        String expected = "{apple={apple=3}}";
        assertEquals(expected, graph.toString());
    }
    @Test
    public void testConvertTextToGraph7() {
        graph = new DirectedGraph();
        String filePath = "D:/JAVAcode/lab1/code/testcase/testcase4.txt";
        File file = new File(filePath);
        graph = GraphConverter.convertTextToGraph(TextProcessor.processTextFile(file));
        String expected = "{cat={dog=3}, dog={cat=2}}";
        assertEquals(expected, graph.toString());
    }
    @Test
    public void testConvertTextToGraph8() {
        graph = new DirectedGraph();
        String filePath = "D:/JAVAcode/lab1/code/testcase/testcase5.txt";
        File file = new File(filePath);
        graph = GraphConverter.convertTextToGraph(TextProcessor.processTextFile(file));
//        System.out.println(graph.toString());
        String expected = "{okay={}, how={are=1}, world={how=1}, are={you=2}, hello={world=1}, you={okay=1, are=1}}";
        assertEquals(expected, graph.toString());
    }
    @Test
    public void testConvertTextToGraph9() {
        graph = new DirectedGraph();
        String filePath = "D:/JAVAcode/lab1/code/testcase/testcase6.txt";
        File file = new File(filePath);
        graph = GraphConverter.convertTextToGraph(TextProcessor.processTextFile(file));
//        System.out.println(graph.toString());
        String expected = "{one={two=1}, nfour={}, two={tthree=1}, tthree={nfour=1}}";
        assertEquals(expected, graph.toString());
    }
    @Test
    public void testConvertTextToGraph10() {
        graph = new DirectedGraph();
        String filePath = "D:/JAVAcode/lab1/code/testcase/testcase7.txt";
        File file = new File(filePath);
        graph = GraphConverter.convertTextToGraph(TextProcessor.processTextFile(file));
//        System.out.println(graph.toString());
        String expected = "{={}}";
        assertEquals(expected, graph.toString());
    }
    @Test
    public void testConvertTextToGraph11() {
        graph = new DirectedGraph();
        String filePath = "D:/JAVAcode/lab1/code/testcase/testcase8.txt";
        File file = new File(filePath);
        graph = GraphConverter.convertTextToGraph(TextProcessor.processTextFile(file));
//        System.out.println(graph.toString());
        String expected = "{test={}}";
        assertEquals(expected, graph.toString());
    }


}