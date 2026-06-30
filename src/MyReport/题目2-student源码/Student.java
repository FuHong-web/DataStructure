package MyReport.student;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/28 10:27
 * @desc:
 */
public class Student {
    private int id;
    private String name;
    private double[] scores;  // 高数、数据结构、英语
    private double average;

    public Student() {
        this.scores = new double[3];
        this.average = 0.0;
    }

    public Student(int id, String name, double[] scores) {
        this.id = id;
        this.name = name;
        this.scores = new double[3];
        System.arraycopy(scores, 0, this.scores, 0, Math.min(scores.length, 3));
        calculateAverage();
    }

    public void calculateAverage() {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        this.average = sum / scores.length;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double[] getScores() { return scores; }
    public void setScores(double[] scores) {
        System.arraycopy(scores, 0, this.scores, 0, Math.min(scores.length, 3));
        calculateAverage();
    }

    public double getAverage() { return average; }
    public void setAverage(double average) { this.average = average; }

    @Override
    public String toString() {
        return String.format("学号: %d, 姓名: %s, 高数: %.1f, 数据结构: %.1f, 英语: %.1f, 平均分: %.2f",
                id, name, scores[0], scores[1], scores[2], average);
    }
}