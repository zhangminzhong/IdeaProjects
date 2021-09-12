import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
/**
 * Created by AdministratorZhang on 2017/11/25.
 */
public class Test extends AbstractJavaSamplerClient {
    // Sock begin----------------------------------------------
    private Socket sid;
    private PrintWriter out;
    private BufferedReader in;
    private String ip;
    private String port;
    // Sock end------------------------------------------------

    private static String label = "howsky.net";

    // 测试结果
    private SampleResult sr;

    /**
     * 初始化
     */
    public void setupTest(JavaSamplerContext arg0) {
        System.out.println("setupTest");
    }

    /**
     * 设置请求的参数
     */
    public Arguments getDefaultParameters() {
        Arguments params = new Arguments();
        params.addArgument("ip", "127.0.0.1");
        params.addArgument("port", "6003");
        return params;
    }

    /**
     * 运行过程
     */
    public SampleResult runTest(JavaSamplerContext arg0) {
        ip = arg0.getParameter("ip");
        port = arg0.getParameter("port");
        sr = new SampleResult();
        sr.setSampleLabel(label);
        try{
            sr.sampleStart(); //记录程序执行时间，以及执行结果
            //发送数据
            String msg = "hello world\n";
            System.out.println("begin");
            sendMsg(ip, Integer.parseInt(port), msg);
            sr.setSuccessful(true);
            System.out.println("end");
        }catch(Throwable e){
            sr.setSuccessful(false);
        }finally{
            sr.sampleEnd();
        }
        return sr;
    }

    /**
     * 结束
     */
    public void teardownTest(JavaSamplerContext arg0) {
    }

    /**
     * 发送消息
     * @param ip
     * @param port
     * @param msg
     * @throws Exception
     */
    private void sendMsg(String ip, int port, String msg) throws Exception{
        sid = new Socket(ip, port);
        in = new BufferedReader(new InputStreamReader(sid.getInputStream(),"UTF-8"));
        //out = new PrintWriter(sid.getOutputStream(), true);
        OutputStream os = sid.getOutputStream();
        os.write(msg.getBytes("UTF-8"));
        //out.println(msg);
        in.readLine();
        System.out.println("success");
    }
}
