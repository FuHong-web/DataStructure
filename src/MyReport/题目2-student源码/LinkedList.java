package MyReport.student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/28 10:28
 * @desc:
 */

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public Node getHead() { return head; }
    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }

    /**
     * 按学号升序插入学生
     */
    public int insertStudent(Student stu) {
        Node newNode = new Node(stu);

        if (size == 0) {
            head = newNode;
            size++;
            return 1;
        }

        Node p = head;
        while (p != null && p.getData().getId() < stu.getId()) {
            p = p.getNext();
        }

        // 检查学号是否重复
        if (p != null && p.getData().getId() == stu.getId()) {
            return -1;  // 学号重复
        }

        if (p == null) {  // 插入到尾部
            Node tail = head;
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }
            tail.setNext(newNode);
            newNode.setPrev(tail);
        } else if (p == head) {  // 插入到头部
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        } else {  // 插入到中间
            newNode.setPrev(p.getPrev());
            newNode.setNext(p);
            p.getPrev().setNext(newNode);
            p.setPrev(newNode);
        }
        size++;
        return 1;
    }

    /**
     * 按学号删除学生
     */
    public boolean deleteStudent(int id) {
        if (size == 0) {
            return false;
        }

        Node p = head;
        while (p != null && p.getData().getId() != id) {
            p = p.getNext();
        }

        if (p == null) {
            return false;
        }

        if (p == head) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
        } else {
            p.getPrev().setNext(p.getNext());
            if (p.getNext() != null) {
                p.getNext().setPrev(p.getPrev());
            }
        }
        size--;
        return true;
    }

    /**
     * 按学号修改学生信息
     */
    public boolean updateStudent(int id, Student newData) {
        if (size == 0) {
            return false;
        }

        Node p = head;
        while (p != null && p.getData().getId() != id) {
            p = p.getNext();
        }

        if (p == null) {
            return false;
        }

        p.setData(newData);
        return true;
    }

    /**
     * 顺序查找 - 按姓名模糊查找
     */
    public List<Student> searchByName(String namePattern) {
        List<Student> results = new ArrayList<>();
        if (size == 0) {
            return results;
        }

        Node p = head;
        while (p != null) {
            if (p.getData().getName().contains(namePattern)) {
                results.add(p.getData());
            }
            p = p.getNext();
        }
        return results;
    }

    /**
     * 顺序查找 - 按成绩区间查找
     */
    public List<Student> searchByScore(int courseIndex, double minScore, double maxScore) {
        List<Student> results = new ArrayList<>();
        if (size == 0 || courseIndex < 0 || courseIndex > 2) {
            return results;
        }

        Node p = head;
        while (p != null) {
            double score = p.getData().getScores()[courseIndex];
            if (score >= minScore && score <= maxScore) {
                results.add(p.getData());
            }
            p = p.getNext();
        }
        return results;
    }

    /**
     * 折半查找 - 按学号精准查找
     */
    public Node binarySearchById(int targetId) {
        if (size == 0) {
            return null;
        }

        // 将链表数据导出到临时数组
        Student[] arr = new Student[size];
        Node p = head;
        for (int i = 0; i < size; i++) {
            arr[i] = p.getData();
            p = p.getNext();
        }

        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid].getId() == targetId) {
                // 在链表中定位该节点
                p = head;
                for (int i = 0; i < mid; i++) {
                    p = p.getNext();
                }
                return p;
            } else if (arr[mid].getId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    /**
     * 快速排序 - 按指定课程成绩降序
     */
    public void quickSortByScore(int courseIndex) {
        if (size <= 1 || courseIndex < 0 || courseIndex > 2) {
            return;
        }
        head = quickSortRecursive(head, courseIndex);
        // 重置prev指针
        if (head != null) {
            head.setPrev(null);
            Node p = head;
            while (p.getNext() != null) {
                p.getNext().setPrev(p);
                p = p.getNext();
            }
        }
    }

    private Node quickSortRecursive(Node headNode, int courseIndex) {
        if (headNode == null || headNode.getNext() == null) {
            return headNode;
        }

        // 以第一个节点的成绩为基准
        Node pivot = headNode;
        Node p = pivot.getNext();
        Node lessHead = new Node();
        Node greaterHead = new Node();
        Node lessTail = lessHead;
        Node greaterTail = greaterHead;

        pivot.setNext(null);

        while (p != null) {
            Node next = p.getNext();
            p.setNext(null);

            double pivotScore = pivot.getData().getScores()[courseIndex];
            double currentScore = p.getData().getScores()[courseIndex];

            if (currentScore <= pivotScore) {
                lessTail.setNext(p);
                lessTail = p;
            } else {
                greaterTail.setNext(p);
                greaterTail = p;
            }
            p = next;
        }

        // 递归排序
        Node sortedLess = quickSortRecursive(lessHead.getNext(), courseIndex);
        Node sortedGreater = quickSortRecursive(greaterHead.getNext(), courseIndex);

        // 合并：sortedLess -> pivot -> sortedGreater
        Node result;
        if (sortedLess == null) {
            result = pivot;
        } else {
            result = sortedLess;
            Node tail = sortedLess;
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }
            tail.setNext(pivot);
            pivot.setPrev(tail);
        }

        pivot.setNext(sortedGreater);
        if (sortedGreater != null) {
            sortedGreater.setPrev(pivot);
        }

        return result;
    }

    /**
     * 冒泡排序 - 按平均成绩降序
     */
    public void bubbleSortByAverage() {
        if (size <= 1) {
            return;
        }

        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            Node p = head;
            for (int j = 0; j < size - 1 - i; j++) {
                if (p.getData().getAverage() < p.getNext().getData().getAverage()) {
                    // 交换数据
                    Student temp = p.getData();
                    p.setData(p.getNext().getData());
                    p.getNext().setData(temp);
                    swapped = true;
                }
                p = p.getNext();
            }
            if (!swapped) break;
        }
    }

    /**
     * 插入排序 - 按学号升序
     */
    public void insertionSortById() {
        if (size <= 1) {
            return;
        }

        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node next = current.getNext();
            current.setPrev(null);
            current.setNext(null);

            if (sorted == null) {
                sorted = current;
            } else if (current.getData().getId() < sorted.getData().getId()) {
                current.setNext(sorted);
                sorted.setPrev(current);
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.getNext() != null &&
                        temp.getNext().getData().getId() < current.getData().getId()) {
                    temp = temp.getNext();
                }
                current.setNext(temp.getNext());
                if (temp.getNext() != null) {
                    temp.getNext().setPrev(current);
                }
                temp.setNext(current);
                current.setPrev(temp);
            }
            current = next;
        }
        head = sorted;
    }

    /**
     * 统计功能
     */
    public StatisticsResult calculateStatistics(int courseIndex) {
        StatisticsResult result = new StatisticsResult();
        if (size == 0 || courseIndex < 0 || courseIndex > 2) {
            return result;
        }

        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        int[] levels = new int[5]; // 优、良、中、及格、不及格

        Node p = head;
        while (p != null) {
            double score = p.getData().getScores()[courseIndex];
            sum += score;
            if (score < min) min = score;
            if (score > max) max = score;

            if (score >= 90) levels[0]++;
            else if (score >= 80) levels[1]++;
            else if (score >= 70) levels[2]++;
            else if (score >= 60) levels[3]++;
            else levels[4]++;

            p = p.getNext();
        }

        result.setAverage(sum / size);
        result.setMin(min);
        result.setMax(max);
        result.setLevels(levels);
        return result;
    }

    /**
     * 遍历输出
     */
    public void display() {
        if (size == 0) {
            System.out.println("链表为空！");
            return;
        }
        Node p = head;
        while (p != null) {
            System.out.println(p.getData());
            p = p.getNext();
        }
    }

    // 统计结果内部类
    public static class StatisticsResult {
        private double average;
        private double min;
        private double max;
        private int[] levels;

        public StatisticsResult() {
            this.average = 0;
            this.min = 0;
            this.max = 0;
            this.levels = new int[5];
        }

        public double getAverage() { return average; }
        public void setAverage(double average) { this.average = average; }

        public double getMin() { return min; }
        public void setMin(double min) { this.min = min; }

        public double getMax() { return max; }
        public void setMax(double max) { this.max = max; }

        public int[] getLevels() { return levels; }
        public void setLevels(int[] levels) { this.levels = levels; }

        @Override
        public String toString() {
            return String.format("平均分: %.2f, 最高分: %.1f, 最低分: %.1f\n" +
                            "优(>=90): %d人, 良(80-89): %d人, 中(70-79): %d人, " +
                            "及格(60-69): %d人, 不及格(<60): %d人",
                    average, max, min, levels[0], levels[1], levels[2], levels[3], levels[4]);
        }
    }
}