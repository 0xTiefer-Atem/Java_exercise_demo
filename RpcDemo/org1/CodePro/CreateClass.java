package org1.CodePro;


import java.io.*;

/**
 * Author:WangQian
 * Date:18-6-9 下午8:18
 */
public class CreateClass extends ClassLoader {

    private byte[] readefile(String classfile) throws IOException {
        File f = new File(classfile);
        byte[] bytes = new byte[(int) f.length()];
        FileInputStream fin = new FileInputStream(classfile);
        int read = fin.read(bytes);
        if (read != f.length()) {
            throw new IOException("无法读取全部文件");
        }

        System.out.println("读取完成");
        return bytes;
    }

    private boolean compile(String javafile) throws IOException, InterruptedException {
        System.out.println("正在编译" + javafile + "...");
        Process p = Runtime.getRuntime().exec("javac " + javafile);
        p.waitFor();

        int res = p.exitValue();

        return res == 0;
    }

    @Override
    protected Class<?> findClass(String filename) throws ClassNotFoundException {
        Class clazz = null;
        File javafile = new File(filename);
        File classfile = new File(filename.replace("java", "class"));
        if (javafile.exists() && !classfile.exists()) {
            try {
                if (!compile(filename) || !classfile.exists()) {
                    throw new ClassNotFoundException("Class Not Found " + filename);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (classfile.exists()) {
            try {
                byte[] filebytes = readefile(classfile.getPath());
                String[] tempclasspath = classfile.getPath().split("/");
                String classpath = tempclasspath[tempclasspath.length-1].split("\\.")[0];
                clazz = defineClass(classpath, filebytes, 0, filebytes.length);
                System.out.println("类加载完成");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return clazz;
    }
}