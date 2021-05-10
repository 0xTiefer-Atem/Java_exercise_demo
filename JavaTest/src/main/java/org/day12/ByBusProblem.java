package org.day12;

import java.util.ArrayList;
import java.util.List;

public class ByBusProblem {
    public static ArrayList list = new ArrayList<String>();

    public static void main(String[] args) {
        int n = 5;
        nNumPaiLie(n - 2);
//        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, "1" + list.get(i) + "1");
        }
        //打印
        printPath2(list);
    }

    //计算n-2位 1出现的情况(可出现0次) 全排列
    public static void pailie(int step, int data[], int n) {
        if (step == n) {
            String item = "";
            for (int i = 0; i < n; i++) {
                item += data[i] + "";
            }
            list.add(item);
            return;
        }
        data[step] = 0;
        pailie(step + 1, data, n);

        data[step] = 1;
        pailie(step + 1, data, n);
    }

    public static void nNumPaiLie(int n) {
        //计算除去第一站和最后一站 1 的全排列
        int data[] = new int[n];
        for (int i = 0; i < n; i++) {
            //初始化数组
            data[i] = -1;
        }
        pailie(0, data, n);
    }

    //打印结果
    public static void printPath2(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            String[] strArr = item.split("");
            for (int j = 0; j < strArr.length; j++) {
                if ("1".equals(strArr[j])) {
                    System.out.print((j + 1));
                    if(j != strArr.length-1) {
                        System.out.print("->");
                    }
                }
            }
            System.out.println();
        }
    }
}
