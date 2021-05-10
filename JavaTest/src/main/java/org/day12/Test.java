package org.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) {
//        List<Character> alp = new ArrayList<Character>();
//        alp.add('A');
//        alp.add('B');
//        alp.add('C');
//        List<String> res = mul(alp, 0, alp.size() - 1);
//        System.out.println(res);

//        int[] nums = {1, 2, -1, 3, 4 - 2, 5, -6, 7 - 10};
//        List<Integer> cur1 = new ArrayList<Integer>();
//        System.out.println(kSum(nums, 2,0,0,nums.length - 1, cur1));


//        int[] nums = {1,2,3,4,5,6,7,8,9};
//        List<Integer> cur = new ArrayList<>();
//
//        boolean res = kSum(nums, 2, 3, 0, nums.length-1, cur);
//        System.out.println(res);

//        printStationLine1(1, 6);
//        printStationLine2(1, 6);

        int[] a = {1, 9, 2, 6, 3, 5, 4, 7, 8};
        int k = 2;
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
        KSUM(0, k, 10, a, 9);
        if (flag == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

    //打印大写字母解决方案
    public static List<String> mul(List<Character> alp, int start, int end) {
        List<String> temp = new ArrayList<String>();
        if (start == end) {
            temp.add(alp.get(start) + "");
            return temp;
        } else {
            for (int i = start; i < end; i++) {
                List<String> p1 = mul(alp, start, i);
                List<String> p2 = mul(alp, i + 1, end);
                for (int j = 0; j < p1.size(); j++) {
                    for (int k = 0; k < p2.size(); k++) {
                        String str = "";
                        str += "(";
                        str += p1.get(j);
                        str += p2.get(k);
                        str += ")";
                        temp.add(str);
                    }
                }
            }
        }
        return temp;
    }


    //2 kSum 问题
    public static boolean kSum(int[] nums, int k, int target, int from, int end, List<Integer> cur) {
        if (k == 2) {
            int left = from;
            int right = end;
            while (left < end) {
                int diff = target - nums[left] - nums[right];
                if (diff == 0) {
                    left++;
                } else {
                    left--;
                }
            }
        } else {
            for (int i = from; i < end - k + 2; i++) {
                int temp = k;
                int large = 0;
                int small = 0;
                while (temp > 0) {
                    large += nums[end - temp + 1];
                    small += nums[from + temp + 1];
                    temp--;
                }
                if (small > target) {
                    return false;
                }
                if (large > target) {
                    return false;
                }
                if (i > from && nums[i] == nums[i - 1]) {
                    continue;
                }
                cur.add(nums[i]);
                kSum(nums, k - 1, target - nums[i], i + 1, end, cur);
                cur.remove(cur.size() - 1);
            }
        }
        return false;
    }

    //车站问题
    public static String printStationLine1(int start, int end) {
        if (start == end) {
            return "" + start;
        }
        String station = printStationLine1(start + 1, end);
//        System.out.println();
//        System.out.println("start: " + start + "  station: " + station);
        for (int i = 1; i <= start; i++) {
            if (i != 1) {
                System.out.println("1-" + i + "-" + station);
            } else {
                System.out.println("1-" + station);
            }
        }
//        System.out.println();
        return start + "-" + station;
    }

    //车站问题
    public static String printStationLine2(int start, int end) {
        if (start == end) {
            return "" + start;
        }
        String station = printStationLine2(start + 1, end);
        System.out.println();
        System.out.println("currStart: " + start);

        //利用步长计算从当前站点到之后站点的所可能乘坐情况
//        List<String> curToEnd = new ArrayList<>();
//        if (end - start - 1 == 0) {
//            curToEnd.add(start + "-" + end);
//        } else {
//            //控制步长
//            for (int i = 1; i <= end - start; i++) {
//                StringBuilder path = new StringBuilder();
//                //过站的情况
//                for (int j = start; j < end; j = j + i) {
//                    path.append(j)
//                            .append("-");
//                }
//                path.append(end);
//                curToEnd.add(path.toString());
//            }
//        }
//        System.out.println("curToEnd: " + curToEnd);

        //利用步长计算从开始站点到当前站点的情况
        List<String> startToCur = new ArrayList<>();
        //控制步长
        for (int step = 1; step < start - 1; step++) {
            StringBuilder path = new StringBuilder();
//            path.append(1).append("-");
            //过站的情况
            int k = 2;
            if (k + step > start) {
                path.append(k).append("-");
            } else {
                for (int nextStation = 1; nextStation < start; nextStation = nextStation + step) {
                    path.append(nextStation).append("-");
                }
                startToCur.add(path.toString());
            }
        }
        System.out.println("startToCur: " + startToCur);
        System.out.println();

//        for (int i = 0; i < startToCur.size(); i++) {
//            for (int j = 0; j < curToEnd.size(); j++) {
//                System.out.println(startToCur.get(i) + curToEnd.get(j));
//            }
//        }
        return start + "-" + station;
    }

    //双人任务安排问题可以描述如下：有 n 个任务，可以分别由 A 或 B 来独立完成(不能间断和分拆)。
    // 已知第 i 项任务由 A 来完成需要 ai长度时间，由 B 来完成需要 bi长度时间，每人都可以不休息。
    // 问怎样安排任务，使得最后被完成的任务得到最早完成。本题只要求用穷举得到最优值，
    // 即在输入 n 和两个长度为 n的数组后（n<30），输出在最早全部完成情况下最后被完成任务的完成时间。

    private static int min = 10000;

    public static void dfs(int pos, int n, int[] a, int[] b, int[] c) {
        if (pos == n) {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < n; i++) {
                if (c[i] == 0) {
                    sum1 += a[i];
                } else {
                    sum2 += b[i];
                }
                System.out.println(c[i]);
            }
            int ans = Math.max(sum1, sum2);//每个人都可以分别不休息的做任务，最晚完成的为该情况所用的时间
            System.out.println(ans);
            if (ans < min) {
                min = ans;
            }
            return;
        }
        c[pos] = 0;
        dfs(pos + 1, n, a, b, c);
        c[pos] = 1;
        dfs(pos + 1, n, a, b, c);
    }


    //    1-2. 编写一个穷举程序解决任意 kSUM 问题：先从控制台读入两个整数 n 和 k，其中 n<100,
    //    k<n，然后读入 n 个整数到数组 A[1…n]中。你的程序需要判断是否存在 A 中的 k 个下标不同的数，
    //    其和值恰好为 0。（无需考虑时间消耗。） 如果存在打印“true”，否则打印“false”。

    private static int flag = 0;

    private static void KSUM(int pos, int k, int sum, int[] a, int n) {
        if (k == 0 && sum == 0) {
            flag = 1;
            return;
        }
        if (k == 0 || pos == n) return;
        KSUM(pos + 1, k, sum, a, n);
        KSUM(pos + 1, k - 1, sum -= a[pos], a, n);
    }

}
