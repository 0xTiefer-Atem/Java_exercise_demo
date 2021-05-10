package org1.CodePro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Author:WangQian
 * Date:18-6-9 上午10:26
 */
public class CreateJava {

    private String[] jsons;
    private LinkedList<String> mylist = new LinkedList();

    private File file;

    public CreateJava(String[] temp, File file1) {
        this.jsons = temp;
        this.file = file1;
        splitJson();
    }


    private void splitJson() {
        for (int i = 0; i < jsons.length; i++) {
            mylist.add(jsons[i]);
        }
    }

    public String createJava() throws IOException {
        File file = null;
        FileWriter fw = null;
        for (String tempstring : mylist) {
            System.out.println(tempstring);
            if (tempstring.contains("classname")) {
                String[] splits = tempstring.split(":");
                String classname = splits[1];
                file = new File(this.file.getPath() + "/" + classname + ".java");
                if (!file.exists()) {
                    file.createNewFile();
                }
                fw = new FileWriter(file);
                fw.write("public interface " + classname + "{\n");
                fw.flush();
            } else if (tempstring.contains("methodname")) {
                String methodname = tempstring.split(":")[1];
                fw.write(methodname + "(");
                fw.flush();
            } else if (tempstring.contains("methodtype")) {
                String type = tempstring.split(":")[1];
                fw.write("    " + type + " ");
                fw.flush();
            } else if (tempstring.contains("parameters")) {
                tempstring = tempstring.trim();
                String tempparameters = tempstring.split(":")[1];
                String[] parameters = tempparameters.split(" ");
                for (int i = 0; i < parameters.length; i++) {
                    if (i == parameters.length - 1) {
                        fw.write(parameters[i] + " var" + i + ");\n");
                        fw.flush();
                    } else {
                        fw.write(parameters[i] + " var" + i + ",");
                        fw.flush();
                    }
                }
            }
        }
        fw.write("}");
        fw.flush();
        System.out.println(file.getPath());
        return file.getPath();
    }
}
