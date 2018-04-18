import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;

/**
 * Created by liang on 2018/4/8.
 */
public class App  {
    @Test
    public void test() throws Exception {
        String pwd = ConfigTools.encrypt("root");

        System.out.println("pwd = " + pwd);
    }


}
