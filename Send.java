package Demo24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable {
    @Override
    public void run() {
        try {
            DatagramSocket ds = new DatagramSocket();
            //
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;

            while ((line = br.readLine()) != null){
                if ("exit".equals(line))
                    System.exit(0);//exit program
                //将发送的数据进行整理
                byte[] bytes = (Thread.currentThread().getName() + "##@@##" + line).getBytes();
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length,
                        InetAddress.getByName("127.0.0.1"), 9527);
                ds.send(dp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
