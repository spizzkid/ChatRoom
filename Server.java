package Demo24;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建收发对象
        DatagramSocket dsSend = new DatagramSocket();//发送端
        DatagramSocket dsRec = new DatagramSocket(9527);

        byte[] bytes = new byte[1024];//创建容器，储存聊天数据

        //服务器不能关闭，需要一直转发数据
        while (true) {
            //接收数据
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            dsRec.receive(dp);//接收数据之后，将数据转发给客户端

            //发送数据给客户端

            int length = dp.getLength();
            InetAddress address = InetAddress.getByName("127.0.0.1");

            Set<Integer> portSet = Global.portMap.keySet();

            for (Integer port : portSet) {//遍历端口，发送数据
                dsSend.send(new DatagramPacket(bytes,length,address,port));
            }
            System.out.println("Successfully sent a data");
        }
    }
}
