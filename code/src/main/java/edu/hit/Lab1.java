package edu.hit;


import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

@CommandLine.Command(name="Lab1",version = "Lab1 1.0",mixinStandardHelpOptions = true)
public class Lab1 implements Callable<Integer> {


    @CommandLine.Option(names = {"-s","--src"},description = "absolute path of source text file",required = true)
    private File srcFile;

    @CommandLine.Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
    private boolean helpRequested;

    @CommandLine.Option(names = {"--show"},description = "print DirectedGraph")
    private boolean showGraph;

    @CommandLine.Option(names = {"-d","--dst"},description = "absolute path of destination graph file")
    private File dstFile;

    @Override
    public Integer call() {

        String processedText = TextProcessor.processTextFile(srcFile);
        DirectedGraph graph = GraphConverter.convertTextToGraph(processedText);

        if(showGraph){
            GraphConverter.showDirectedGraph(graph);
        }
        return 0;
    }


    public static void main(String[] args) {
        new CommandLine(new Lab1()).execute(args);
    }

}