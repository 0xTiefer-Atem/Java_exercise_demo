import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args)  {
        int fileNum = 0, folderNum = 0;
        FileWriter fr = null;
        try {
            File f = new File("/home/wq/intern_test");
            fr = new FileWriter("/home/wq/res.txt");
            if (f.exists()) {
                LinkedList<File> list = new LinkedList<File>();
                File[] files = f.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        list.add(file2);
                        folderNum++;
                    } else if (file2.getName().contains("xml")) {
                        OptFile optFile = new OptFile(file2);
                        String res = optFile.toJsonString();
                        fr.write(res + "\t");
                        fr.flush();
                        fileNum++;
                    }
                }
                File temp_file;
                while (!list.isEmpty()) {
                    temp_file = list.removeFirst();
                    files = temp_file.listFiles();
                    for (File file2 : files) {
                        if (file2.isDirectory()) {
                            list.add(file2);
                            folderNum++;
                        } else if (file2.getName().contains("xml")) {
                            OptFile optFile = new OptFile(file2);
                            optFile.toJsonString();
                            String res = optFile.toJsonString();
                            fr.write(res + "\n\n");
                            fr.flush();
                            fileNum++;
                        }
                    }
                }
            } else {
                System.out.println("文件不存在!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);
    }
}
