package org.NioTest;

import java.util.Scanner;

public class NioTest {
    public static void main(String[] args) throws Exception {
        System.out.println("请输入文件名:");
        Scanner sc = new Scanner(System.in);
        String fliename = sc.nextLine();
        NioMap nioWork = new NioMap(fliename);
        nioWork.WriteFile();
        nioWork.ReadFile();
        nioWork.CloseAll();
    }
}
