package org1.CodePro;

/**
 * Author:WangQian
 * Date:18-6-8 下午11:01
 */
public class AnalyJson {
    private String json;

    public String splitjson(String jsonline) {
        this.json = jsonline;
        String[] tempstrings = json.split("\\}");
        String res = "";
        for (int i = 0; i < tempstrings.length; i++) {
            res += tempstrings[i];
        }

        String[] tempstrings1 = res.split("\\{");
        String res1 = "";
        for (int i = 0; i < tempstrings1.length; i++) {
            res1 += tempstrings1[i];
        }

        String res2 = "";
        String[] strings = res1.split("]");
        for (int i = 0; i < strings.length; i++) {
            res2 += strings[i];
        }

        String res3 = "";
        String[] strings1 = res2.split("\\[");
        for (int i = 0; i < strings1.length; i++) {
            res3 += strings1[i];
        }
        String res4 = splitjson1(res3);
        return res4;
    }

    private String splitjson1(String linejson) {
        String res = "";
        String[] temps1 = linejson.split("\"");
        for (int i = 0; i < temps1.length; i++) {
            res += temps1[i];
        }
        return res;
    }
}