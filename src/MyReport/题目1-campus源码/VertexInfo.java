package MyReport.campus;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/28 10:30
 * @desc:
 */

public class VertexInfo {
    private String name;
    private String description;

    public VertexInfo() {
        this.name = "";
        this.description = "";
    }

    public VertexInfo(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return name + "：" + description;
    }
}