package Demo24;

import java.util.Scanner;
import java.util.Set;

/**
 * 客户端
 */
public class chatRoom {
    public static void main(String[] args) {
        //提示用户登陆，获取用户序号
        int index = getUser();
        //获取用户对应端口号
        Integer port = 20000 + index;
        //获取用户名
        String userName = Global.portMap.get(port);
        Thread sendT = new Thread(new Send(), userName);
        Thread recT = new Thread(new Receive(port), userName);

        sendT.start();
        recT.start();
    }

    private static int getUser() {
        System.out.println("User list: ");
        Set<Integer> portSet = Global.portMap.keySet();
        int index = 1;//用户序号
        for (Integer port : portSet) {
            System.out.println(index++ + " : " + Global.portMap.get(port));
        }
        //判断用户输入的序号是否正确
        do{
            System.out.println("Enter correct user id: ");
            index = new Scanner(System.in).nextInt();
        }while (index < 1 || index > 4);

        return index;
    }
}
