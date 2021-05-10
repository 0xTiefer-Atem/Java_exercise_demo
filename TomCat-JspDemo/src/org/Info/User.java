package org.Info;

/**
 * Author:WangQian
 * Date: 18-7-13 上午1:29
 */
public class User {
    private int id;
    private String name;
    private String tele_num;
    private String start;
    private String end;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public String getTele_num() {
        return tele_num;
    }

    public void setTele_num(String tele_num) {
        this.tele_num = tele_num;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setName(String name) {
        this.name = name;

    }
}
