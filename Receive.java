package Demo24;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive implements Runnable{
    //定义端口号用于接收线程接收数据
    private Integer port;

    public Receive(Integer port) {
        this.port = port;
    }

    @Override
    public void run() {
        try{
            DatagramSocket ds = new DatagramSocket(this.port); //创建接收对象
            System.out.println("User login successful!");

            //接收数据
            while (true) {
                byte[] bytes = new byte[1024];
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

                ds.receive(dp); //接收数据
                //接收到的数据格式  用户民##@@##消息
                String recStr = new String(dp.getData(), 0, dp.getLength());
                //将消息进行拆分按照 ##@@##
                String[] info = recStr.split("##@@##");
                //如果发送了空消息，可能就没有info[1]
                String mes = info.length > 1 ? info[1] : " ";

                if (!Thread.currentThread().getName().equals(info[0]) && !mes.equals("")) {
                    System.out.println("Received - " + info[0] + " --> " + mes);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
