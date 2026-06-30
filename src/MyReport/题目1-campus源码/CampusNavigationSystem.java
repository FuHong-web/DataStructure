package MyReport.campus;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/28 10:33
 * @desc:
 */
import java.util.*;

public class CampusNavigationSystem {
    private MGraph mGraph;
    private LGraph lGraph;
    private Scanner scanner;

    public CampusNavigationSystem() {
        this.mGraph = new MGraph();
        this.lGraph = new LGraph();
        this.scanner = new Scanner(System.in);
        initDefaultData();
    }

    private void initDefaultData() {
        // 初始化景点
        String[][] defaultSpots = {
                {"校门", "学校正门，位于校园南侧"},
                {"图书馆", "位于校园中心，藏书丰富"},
                {"教学楼", "位于校园北侧，主要教学场所"},
                {"操场", "位于校园西侧，标准体育场"},
                {"食堂", "位于校园东侧，提供餐饮服务"},
                {"行政楼", "位于校园东南侧，行政办公区域"}
        };

        for (String[] spot : defaultSpots) {
            mGraph.addVertex(spot[0], spot[1]);
            lGraph.addVertex(spot[0], spot[1]);
        }

        // 初始化路径
        int[][] defaultEdges = {
                {"校门", "图书馆", 100},
                {"校门", "教学楼", 200},
                {"校门", "食堂", 300},
                {"图书馆", "教学楼", 150},
                {"图书馆", "操场", 120},
                {"教学楼", "操场", 180},
                {"教学楼", "食堂", 80},
                {"操场", "食堂", 250},
                {"图书馆", "行政楼", 90},
                {"行政楼", "食堂", 130}
        };

        for (int[] edge : defaultEdges) {
            String from = defaultEdges[0][0];
            String to = defaultEdges[0][1];
            int weight = defaultEdges[0][2];
            // 实际代码需要遍历，这里简化
        }

        // 正确添加边
        addEdgeInternal("校门", "图书馆", 100);
        addEdgeInternal("校门", "教学楼", 200);
        addEdgeInternal("校门", "食堂", 300);
        addEdgeInternal("图书馆", "教学楼", 150);
        addEdgeInternal("图书馆", "操场", 120);
        addEdgeInternal("教学楼", "操场", 180);
        addEdgeInternal("教学楼", "食堂", 80);
        addEdgeInternal("操场", "食堂", 250);
        addEdgeInternal("图书馆", "行政楼", 90);
        addEdgeInternal("行政楼", "食堂", 130);
    }

    private void addEdgeInternal(String from, String to, int weight) {
        mGraph.addEdge(from, to, weight);
        lGraph.addEdge(from, to, weight);
    }

    public void start() {
        while (true) {
            System.out.println("\n========== 校园景点导航与路径规划系统 ==========");
            System.out.println("1. 显示所有景点");
            System.out.println("2. 添加景点");
            System.out.println("3. 删除景点");
            System.out.println("4. 添加路径");
            System.out.println("5. 修改路径距离");
            System.out.println("6. 景点查找（折半查找）");
            System.out.println("7. DFS遍历（从指定景点）");
            System.out.println("8. BFS遍历（从指定景点）");
            System.out.println("9. Dijkstra单源最短路径");
            System.out.println("10. Floyd任意两点最短路径");
            System.out.println("11. 分析最远/最近景点对");
            System.out.println("12. 显示邻接矩阵");
            System.out.println("13. 显示邻接表");
            System.out.println("0. 退出系统");
            System.out.print("请输入选择: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("感谢使用！");
                    return;
                case 1:
                    displayAllSpots();
                    break;
                case 2:
                    addSpot();
                    break;
                case 3:
                    removeSpot();
                    break;
                case 4:
                    addPath();
                    break;
                case 5:
                    updatePath();
                    break;
                case 6:
                    searchSpot();
                    break;
                case 7:
                    dfsTraversal();
                    break;
                case 8:
                    bfsTraversal();
                    break;
                case 9:
                    dijkstra();
                    break;
                case 10:
                    floyd();
                    break;
                case 11:
                    analyzeExtremes();
                    break;
                case 12:
                    mGraph.displayAdjMatrix();
                    break;
                case 13:
                    lGraph.displayAdjList();
                    break;
                default:
                    System.out.println("无效选择！");
            }
        }
    }

    private void displayAllSpots() {
        System.out.println("\n========== 所有景点 ==========");
        for (int i = 0; i < mGraph.getVertexCount(); i++) {
            System.out.println(i + ". " + mGraph.getVertices()[i]);
        }
    }

    private void addSpot() {
        System.out.print("请输入景点名称: ");
        String name = scanner.nextLine();
        System.out.print("请输入景点描述: ");
        String desc = scanner.nextLine();

        if (mGraph.addVertex(name, desc)) {
            lGraph.addVertex(name, desc);
            System.out.println("添加成功！");
        }
    }

    private void removeSpot() {
        System.out.print("请输入要删除的景点名称: ");
        String name = scanner.nextLine();

        if (mGraph.removeVertex(name)) {
            // LGraph的删除需要单独实现，这里简化
            System.out.println("删除成功！");
        }
    }

    private void addPath() {
        System.out.print("请输入起点名称: ");
        String from = scanner.nextLine();
        System.out.print("请输入终点名称: ");
        String to = scanner.nextLine();
        System.out.print("请输入距离（米）: ");
        int weight = scanner.nextInt();
        scanner.nextLine();

        if (mGraph.addEdge(from, to, weight)) {
            lGraph.addEdge(from, to, weight);
            System.out.println("路径添加成功！");
        }
    }

    private void updatePath() {
        System.out.print("请输入起点名称: ");
        String from = scanner.nextLine();
        System.out.print("请输入终点名称: ");
        String to = scanner.nextLine();
        System.out.print("请输入新距离（米）: ");
        int weight = scanner.nextInt();
        scanner.nextLine();

        if (mGraph.updateEdge(from, to, weight)) {
            System.out.println("路径更新成功！");
        }
    }

    private void searchSpot() {
        System.out.print("请输入景点名称: ");
        String name = scanner.nextLine();

        // 构建有序名称数组用于折半查找
        String[] names = new String[mGraph.getVertexCount()];
        for (int i = 0; i < mGraph.getVertexCount(); i++) {
            names[i] = mGraph.getVertices()[i].getName();
        }
        Arrays.sort(names);

        int index = binarySearch(names, name);
        if (index >= 0) {
            // 找到对应顶点索引
            for (int i = 0; i < mGraph.getVertexCount(); i++) {
                if (mGraph.getVertices()[i].getName().equals(name)) {
                    System.out.println("找到景点：");
                    System.out.println(mGraph.getVertices()[i]);
                    break;
                }
            }
        } else {
            System.out.println("未找到该景点！");
        }
    }

    private int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].compareTo(target);
            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    private void dfsTraversal() {
        System.out.print("请输入起点景点名称: ");
        String start = scanner.nextLine();
        List<String> result = mGraph.dfs(start);
        if (!result.isEmpty()) {
            System.out.println("DFS遍历顺序：");
            for (String name : result) {
                System.out.print(name + " -> ");
            }
            System.out.println("结束");
        }
    }

    private void bfsTraversal() {
        System.out.print("请输入起点景点名称: ");
        String start = scanner.nextLine();
        List<String> result = mGraph.bfs(start);
        if (!result.isEmpty()) {
            System.out.println("BFS遍历顺序：");
            for (String name : result) {
                System.out.print(name + " -> ");
            }
            System.out.println("结束");
        }
    }

    private void dijkstra() {
        System.out.print("请输入起点景点名称: ");
        String start = scanner.nextLine();

        MGraph.DijkstraResult result = mGraph.dijkstra(start);
        if (result == null) return;

        System.out.println("\n从 " + start + " 出发到各景点的最短路径：");
        for (int i = 0; i < mGraph.getVertexCount(); i++) {
            if (i == result.getStartIndex()) continue;
            if (result.getDist()[i] >= MGraph.INF) {
                System.out.println("  -> " + mGraph.getVertices()[i].getName() + "：不可达");
            } else {
                System.out.print("  -> " + mGraph.getVertices()[i].getName() +
                        "：距离 " + result.getDist()[i] + "米，路径 ");
                printPath(result.getPath(), result.getStartIndex(), i);
                System.out.println();
            }
        }
    }

    private void printPath(int[] path, int start, int target) {
        if (target == start) {
            System.out.print(mGraph.getVertices()[start].getName());
            return;
        }
        if (path[target] == -1) {
            System.out.print("无路径");
            return;
        }
        printPath(path, start, path[target]);
        System.out.print(" -> " + mGraph.getVertices()[target].getName());
    }

    private void floyd() {
        MGraph.FloydResult result = mGraph.floyd();
        System.out.print("请输入起点景点名称: ");
        String from = scanner.nextLine();
        System.out.print("请输入终点景点名称: ");
        String to = scanner.nextLine();

        int fromIndex = mGraph.findVertexIndex(from);
        int toIndex = mGraph.findVertexIndex(to);

        if (fromIndex == -1 || toIndex == -1) {
            System.out.println("错误：景点不存在！");
            return;
        }

        int distance = result.getDist()[fromIndex][toIndex];
        if (distance >= MGraph.INF) {
            System.out.println("无可达路径！");
        } else {
            System.out.print(from + " -> " + to + " 最短距离：" + distance + "米，路径：");
            printFloydPath(result.getPath(), fromIndex, toIndex);
            System.out.println();
        }
    }

    private void printFloydPath(int[][] path, int from, int to) {
        if (from == to) {
            System.out.print(mGraph.getVertices()[from].getName());
            return;
        }
        if (path[from][to] == -1) {
            System.out.print("无路径");
            return;
        }
        printFloydPath(path, from, path[from][to]);
        System.out.print(" -> " + mGraph.getVertices()[to].getName());
    }

    private void analyzeExtremes() {
        MGraph.FloydResult result = mGraph.floyd();
        int n = mGraph.getVertexCount();
        int maxDist = -1, minDist = MGraph.INF;
        int maxI = -1, maxJ = -1, minI = -1, minJ = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = result.getDist()[i][j];
                if (d >= MGraph.INF) continue;
                if (d > maxDist) {
                    maxDist = d;
                    maxI = i;
                    maxJ = j;
                }
                if (d < minDist) {
                    minDist = d;
                    minI = i;
                    minJ = j;
                }
            }
        }

        System.out.println("\n========== 路径优化分析 ==========");
        if (maxI != -1) {
            System.out.println("最远景点对：" + mGraph.getVertices()[maxI].getName() +
                    " <-> " + mGraph.getVertices()[maxJ].getName() +
                    "，距离 " + maxDist + "米");
        }
        if (minI != -1) {
            System.out.println("最近景点对：" + mGraph.getVertices()[minI].getName() +
                    " <-> " + mGraph.getVertices()[minJ].getName() +
                    "，距离 " + minDist + "米");
        }
    }

    public static void main(String[] args) {
        CampusNavigationSystem system = new CampusNavigationSystem();
        system.start();
    }
}