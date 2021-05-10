import java.util.HashMap;

public class Annotation {
    private String difficult;
    private HashMap<String, String> coordinate = new HashMap<>();
    private String width;
    private String height;
    private String type;

    public String getDifficult() {
        return difficult;
    }

    public void setKv(String name, String value) {
        switch (name) {
            case "xmax":
                coordinate.put("x", value);
                break;
            case "ymax":
                coordinate.put("y", value);
                break;
        }
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }

    public HashMap<String, String> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(HashMap<String, String> coordinate) {
        this.coordinate = coordinate;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
