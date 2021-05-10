package org.day12;

import java.util.Scanner;

/**
 * @Author WangQian
 * @Date 2020/12/28 下午 9:39
 */
public class TaskTimeCost {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.print("请输入任务个数: ");
        int n = 4;               //输入n
        int[] a = {1, 2, 3, 4};
        int[] b = {5, 4, 3, 2};
        int minTime = Integer.MAX_VALUE;//最后结果
//        System.out.println("请输入a完成n个任务的时间: ");
//        for (int i = 0; i < n; i++) {       //输入a数组
//            a[i] = in.nextInt();
//        }
//        System.out.println("请输入b完成n个任务的时间: ");
//        for (int i = 0; i < n; i++) {       //输入b数组
//            b[i] = in.nextInt();
//        }
        for (int i = 0; i < (int) Math.pow(2.0, n); i++) {  //n<30 int型足够
            int AtimeCost = 0;
            int BtimeCost = 0;
            String solution = Integer.toBinaryString(i); //将i转换为2进制
            while (solution.length() < n) { //例如0转为成了0，所以需要补全到n位
                solution = "0" + solution;
            }
            for (int j = 0; j < solution.length(); j++) {
                if (solution.charAt(j) == '0') {
                    AtimeCost += a[j];                //统计A的执行时间
                } else {
                    BtimeCost += b[j];                  //统计B的执行时间
                }
            }
            AtimeCost = AtimeCost > BtimeCost ? AtimeCost : BtimeCost;
            if (AtimeCost < minTime) {
                minTime = AtimeCost; //更新全局最小值
            }
        }
//        System.out.println(minTime); //输出最早完成时间

        quanpailie();
    }

    public static void quanpailie() {
        int n = 5;
        for (int i = 0; i < (int) Math.pow(2.0, n); i++) {
            String solution = Integer.toBinaryString(i); //将i转换为2进制
            while (solution.length() < n) { //例如0转为成了0，所以需要补全到n位
                solution = "0" + solution;
            }
            System.out.println(solution);
        }
    }
}
