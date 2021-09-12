import org.apache.mina.cluster.master.Master;
import org.apache.mina.cluster.master.algorithm.Dynamic;
import org.apache.mina.cluster.master.algorithm.Hash;
import org.apache.mina.cluster.master.algorithm.interfaces.LoadBalancer;

public class MasterTest {
    public static void main(String[] args) {
        Master master = new Master();
        //Dynamic dynamic = new Dynamic();
        //dynamic.setA();
        //master.setLoadBalancer(dynamic);
        //LoadBalancer loadBalancer = new Hash();
        //master.setLoadBalancer(loadBalancer);
        master.start();
    }
}
