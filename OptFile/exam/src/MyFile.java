import java.util.ArrayList;

public class MyFile {
    private String name;
    private String width;
    private String height;
    private String depth;
    private transient ArrayList<Annotation> annotationArrayList = new ArrayList<>();
    private transient Annotation annotation = null;
    public MyFile() {
        annotation = new Annotation();
    }

    public void setValue(String name, String value) {

        switch (name) {
            case "filename":
                this.name = value;
                break;
            case "width":
                this.width = value;
                break;
            case "height":
                this.width = value;
                break;
            case "depth":
                this.depth = value;
                break;
            case "difficult":
                annotation.setDifficult(value);
                break;
            case "name":
                annotation.setType(value);
                break;
            case "xmin":
                annotation.setHeight(value);
                break;
            case "ymin":
                annotation.setWidth(value);
                break;
            default:
                annotation.setKv(name, value);
                if (name.equals("ymax")) {
                    annotationArrayList.add(annotation);
                    annotation = new Annotation();
                }
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public ArrayList<Annotation> getAnnotationArrayList() {
        return annotationArrayList;
    }

    public void setAnnotationArrayList(ArrayList<Annotation> annotationArrayList) {
        this.annotationArrayList = annotationArrayList;
    }

}
