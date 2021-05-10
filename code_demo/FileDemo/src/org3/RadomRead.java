package org3;

import java.io.FileInputStream;
import java.util.Scanner;

public class RadomRead {
    public static void main(String[] args) throws Exception {
        System.out.println("随机文件读测试");
        FileInputStream fis = new FileInputStream("/home/wq/student1.xml");
        System.setIn(fis);
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        while (sc.hasNext()) {
            System.out.println("键盘输入的内容是：" + sc.next());
        }
        fis.close();
    }
}

