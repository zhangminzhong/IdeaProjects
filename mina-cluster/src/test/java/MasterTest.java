import org.apache.mina.cluster.master.Master;
import org.apache.mina.cluster.master.algorithm.Dynamic;
import org.apache.mina.cluster.master.algorithm.Hash;

import java.io.IOException;

/**
 * Created by AdministratorZhang on 2017/11/14.
 */
public class MasterTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Master master = new Master();
        //master.setLoadBalancer(new Dynamic());
        master.start();
    }
}
