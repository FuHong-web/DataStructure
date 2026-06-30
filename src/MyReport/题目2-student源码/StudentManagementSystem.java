package MyReport.student;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/28 10:29
 * @desc:
 */
import java.util.*;

public class StudentManagementSystem {
    private LinkedList list;
    private Scanner scanner;

    public StudentManagementSystem() {
        this.list = new LinkedList();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n========== 学生成绩信息管理系统 ==========");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生（按学号）");
            System.out.println("3. 修改学生信息（按学号）");
            System.out.println("4. 显示所有学生");
            System.out.println("5. 顺序查找（按姓名模糊）");
            System.out.println("6. 顺序查找（按成绩区间）");
            System.out.println("7. 折半查找（按学号精准，需先排序）");
            System.out.println("8. 插入排序（按学号升序）");
            System.out.println("9. 快速排序（按单科成绩降序）");
            System.out.println("10. 冒泡排序（按平均成绩降序）");
            System.out.println("11. 统计课程成绩");
            System.out.println("0. 退出系统");
            System.out.print("请输入选择: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("感谢使用！");
                    return;
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    list.display();
                    break;
                case 5:
                    searchByName();
                    break;
                case 6:
                    searchByScoreRange();
                    break;
                case 7:
                    binarySearchById();
                    break;
                case 8:
                    list.insertionSortById();
                    System.out.println("按学号升序排序完成！");
                    list.display();
                    break;
                case 9:
                    quickSortByScore();
                    break;
                case 10:
                    list.bubbleSortByAverage();
                    System.out.println("按平均成绩降序排序完成！");
                    list.display();
                    break;
                case 11:
                    calculateStatistics();
                    break;
                default:
                    System.out.println("无效选择！");
            }
        }
    }

    private void addStudent() {
        System.out.print("请输入学号: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("请输入姓名: ");
        String name = scanner.nextLine();

        System.out.print("请输入高数成绩: ");
        double math = scanner.nextDouble();
        System.out.print("请输入数据结构成绩: ");
        double ds = scanner.nextDouble();
        System.out.print("请输入英语成绩: ");
        double eng = scanner.nextDouble();

        if (math < 0 || math > 100 || ds < 0 || ds > 100 || eng < 0 || eng > 100) {
            System.out.println("错误：成绩必须在0-100之间！");
            return;
        }

        Student stu = new Student(id, name, new double[]{math, ds, eng});
        int result = list.insertStudent(stu);
        if (result == -1) {
            System.out.println("错误：学号已存在！");
        } else {
            System.out.println("添加成功！");
        }
    }

    private void deleteStudent() {
        System.out.print("请输入要删除的学号: ");
        int id = scanner.nextInt();
        if (list.deleteStudent(id)) {
            System.out.println("删除成功！");
        } else {
            System.out.println("错误：学号不存在！");
        }
    }

    private void updateStudent() {
        System.out.print("请输入要修改的学号: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("请输入新姓名: ");
        String name = scanner.nextLine();

        System.out.print("请输入新高数成绩: ");
        double math = scanner.nextDouble();
        System.out.print("请输入新数据结构成绩: ");
        double ds = scanner.nextDouble();
        System.out.print("请输入新英语成绩: ");
        double eng = scanner.nextDouble();

        if (math < 0 || math > 100 || ds < 0 || ds > 100 || eng < 0 || eng > 100) {
            System.out.println("错误：成绩必须在0-100之间！");
            return;
        }

        Student stu = new Student(id, name, new double[]{math, ds, eng});
        if (list.updateStudent(id, stu)) {
            System.out.println("修改成功！");
        } else {
            System.out.println("错误：学号不存在！");
        }
    }

    private void searchByName() {
        System.out.print("请输入姓名关键字: ");
        String keyword = scanner.nextLine();
        List<Student> results = list.searchByName(keyword);
        if (results.isEmpty()) {
            System.out.println("未找到匹配的学生！");
        } else {
            System.out.println("找到 " + results.size() + " 名学生：");
            for (Student s : results) {
                System.out.println(s);
            }
        }
    }

    private void searchByScoreRange() {
        System.out.println("选择课程：1-高数，2-数据结构，3-英语");
        int courseChoice = scanner.nextInt();
        int courseIndex = courseChoice - 1;
        if (courseIndex < 0 || courseIndex > 2) {
            System.out.println("无效课程选择！");
            return;
        }

        System.out.print("请输入最低分: ");
        double minScore = scanner.nextDouble();
        System.out.print("请输入最高分: ");
        double maxScore = scanner.nextDouble();

        List<Student> results = list.searchByScore(courseIndex, minScore, maxScore);
        if (results.isEmpty()) {
            System.out.println("未找到匹配的学生！");
        } else {
            System.out.println("找到 " + results.size() + " 名学生：");
            for (Student s : results) {
                System.out.println(s);
            }
        }
    }

    private void binarySearchById() {
        System.out.println("注意：请先执行插入排序（按学号升序），否则折半查找可能不准确！");
        System.out.print("请输入要查找的学号: ");
        int id = scanner.nextInt();
        Node result = list.binarySearchById(id);
        if (result == null) {
            System.out.println("未找到该学生！");
        } else {
            System.out.println("找到学生：");
            System.out.println(result.getData());
        }
    }

    private void quickSortByScore() {
        System.out.println("选择课程：1-高数，2-数据结构，3-英语");
        int courseChoice = scanner.nextInt();
        int courseIndex = courseChoice - 1;
        if (courseIndex < 0 || courseIndex > 2) {
            System.out.println("无效课程选择！");
            return;
        }
        String[] courseNames = {"高数", "数据结构", "英语"};
        list.quickSortByScore(courseIndex);
        System.out.println("按" + courseNames[courseIndex] + "成绩降序排序完成！");
        list.display();
    }

    private void calculateStatistics() {
        System.out.println("选择课程：1-高数，2-数据结构，3-英语");
        int courseChoice = scanner.nextInt();
        int courseIndex = courseChoice - 1;
        if (courseIndex < 0 || courseIndex > 2) {
            System.out.println("无效课程选择！");
            return;
        }
        String[] courseNames = {"高数", "数据结构", "英语"};
        LinkedList.StatisticsResult result = list.calculateStatistics(courseIndex);
        if (result.getMin() == Double.MAX_VALUE) {
            System.out.println("链表为空！");
            return;
        }
        System.out.println(courseNames[courseIndex] + "统计结果：");
        System.out.println(result);
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.start();
    }
}
