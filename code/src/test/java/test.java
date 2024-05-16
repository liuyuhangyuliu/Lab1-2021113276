import org.junit.Test;

import java.io.File;
import java.util.HashMap;


public class test {


    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
        File file = new File("./testcase/testcase1.txt");
        System.out.println(file.isFile());
    }

    @Test
    public void Test1(){
        HashMap<String, String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");

    }
}
