package 并发;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhang_minzhong on 2017/6/29.
 */
class NIOBlocked implements Runnable{
    private  final SocketChannel sc;
    public NIOBlocked(SocketChannel sc){
        this.sc = sc;
    }
    @Override
    public void run() {
        try {
            System.out.println(this+"等待读");
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e){
            System.out.println("ClosedByInterruptException");
        } catch (AsynchronousCloseException e){
            System.out.println("AsynchronousCloseException");
        }catch (IOException e) {
            throw new RuntimeException();
        }
        System.out.println("NIOBlocked.run()"+this+"退出");
    }
}
public class NIOInterruption {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InetSocketAddress isa = new InetSocketAddress("localhost",8080);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);
        Future<?> f = exec.submit(new NIOBlocked(sc1));
        exec.execute(new NIOBlocked(sc2));
        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);
        f.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        sc2.close();
    }
}
