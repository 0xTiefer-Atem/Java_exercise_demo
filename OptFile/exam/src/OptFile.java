import com.alibaba.fastjson.JSON;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OptFile {
    private File xmlFile;
    private Document document;
    private MyFile myFile;


    public OptFile(File optFile) throws DocumentException {
        this.xmlFile = optFile;
        SAXReader reader = new SAXReader();
        document = reader.read(xmlFile);
        Element root = document.getRootElement();
        myFile = new MyFile();
        mergeFile(root);
    }

    public void mergeFile(Element element) {
        Element root = element;
        String eleName = root.getName();
        String eleValue = root.getTextTrim();
        if (!eleValue.equals("") && eleValue != null) {
            myFile.setValue(eleName, eleValue);
        }


        List<Element> listElement = root.elements();
        for (Element e : listElement) {
            this.mergeFile(e);
        }
    }

    public String toJsonString() {
        ArrayList<Annotation> annotations = myFile.getAnnotationArrayList();
        String jsonStr = JSON.toJSONString(myFile);
        String jsonStr1 = JSON.toJSONString(annotations);
        return jsonStr1+","+jsonStr;
    }
}
