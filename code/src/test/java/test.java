import edu.hit.Utils;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;


public class test {


    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
        File file = new File("./testcase/testcase1.txt");
        System.out.println(file.isFile());
    }

    @Test
    public void Test1(){
        List<String> list = Utils.getList("a b  c");
        for(String s : list){
            System.out.println(s);
        }

    }
}
