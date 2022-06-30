package Demo24;

import java.util.TreeMap;

public class Global {
    //
    public static TreeMap<Integer, String> portMap = new TreeMap<>();

    //类加载时，直接初始化用户
    static {
        portMap.put(20001,"Huang");
        portMap.put(20002,"O'Yang");
        portMap.put(20003,"Duan");
        portMap.put(20004,"Hong");
    }
}
