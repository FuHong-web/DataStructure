package MyReport.campus;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/28 10:31
 * @desc:
 */


import java.util.*;

public class MGraph {
    public static final int MAX_VERTEX = 20;
    public static final int INF = 99999;

    private int[][] adjMatrix;
    private VertexInfo[] vertices;
    private int vertexCount;
    private int edgeCount;

    public MGraph() {
        this.adjMatrix = new int[MAX_VERTEX][MAX_VERTEX];
        this.vertices = new VertexInfo[MAX_VERTEX];
        for (int i = 0; i < MAX_VERTEX; i++) {
            Arrays.fill(adjMatrix[i], INF);
            adjMatrix[i][i] = 0;
        }
        this.vertexCount = 0;
        this.edgeCount = 0;
    }

    public int[][] getAdjMatrix() { return adjMatrix; }
    public VertexInfo[] getVertices() { return vertices; }
    public int getVertexCount() { return vertexCount; }
    public int getEdgeCount() { return edgeCount; }

    /**
     * 添加景点
     */
    public boolean addVertex(String name, String description) {
        if (vertexCount >= MAX_VERTEX) {
            System.out.println("错误：景点数量已达上限！");
            return false;
        }

        // 检查是否已存在同名景点
        for (int i = 0; i < vertexCount; i++) {
            if (vertices[i].getName().equals(name)) {
                System.out.println("错误：景点名称已存在！");
                return false;
            }
        }

        vertices[vertexCount] = new VertexInfo(name, description);
        vertexCount++;
        return true;
    }

    /**
     * 删除景点
     */
    public boolean removeVertex(String name) {
        int index = findVertexIndex(name);
        if (index == -1) {
            System.out.println("错误：景点不存在！");
            return false;
        }

        // 删除该顶点相关的边
        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[index][i] < INF && i != index) {
                edgeCount--;
            }
            adjMatrix[index][i] = INF;
            adjMatrix[i][index] = INF;
        }

        // 移动顶点
        for (int i = index; i < vertexCount - 1; i++) {
            vertices[i] = vertices[i + 1];
            for (int j = 0; j < vertexCount; j++) {
                adjMatrix[i][j] = adjMatrix[i + 1][j];
                adjMatrix[j][i] = adjMatrix[j][i + 1];
            }
        }
        vertexCount--;
        return true;
    }

    /**
     * 添加路径
     */
    public boolean addEdge(String from, String to, int weight) {
        if (weight <= 0) {
            System.out.println("错误：距离必须大于0！");
            return false;
        }

        int fromIndex = findVertexIndex(from);
        int toIndex = findVertexIndex(to);

        if (fromIndex == -1 || toIndex == -1) {
            System.out.println("错误：景点不存在！");
            return false;
        }

        if (fromIndex == toIndex) {
            System.out.println("错误：不能添加自环路径！");
            return false;
        }

        if (adjMatrix[fromIndex][toIndex] < INF) {
            System.out.println("错误：路径已存在！");
            return false;
        }

        adjMatrix[fromIndex][toIndex] = weight;
        adjMatrix[toIndex][fromIndex] = weight;
        edgeCount++;
        return true;
    }

    /**
     * 修改路径权值
     */
    public boolean updateEdge(String from, String to, int weight) {
        if (weight <= 0) {
            System.out.println("错误：距离必须大于0！");
            return false;
        }

        int fromIndex = findVertexIndex(from);
        int toIndex = findVertexIndex(to);

        if (fromIndex == -1 || toIndex == -1) {
            System.out.println("错误：景点不存在！");
            return false;
        }

        if (adjMatrix[fromIndex][toIndex] >= INF) {
            System.out.println("错误：路径不存在！");
            return false;
        }

        adjMatrix[fromIndex][toIndex] = weight;
        adjMatrix[toIndex][fromIndex] = weight;
        return true;
    }

    /**
     * 查找景点索引
     */
    public int findVertexIndex(String name) {
        for (int i = 0; i < vertexCount; i++) {
            if (vertices[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * DFS深度优先遍历
     */
    public List<String> dfs(String startName) {
        List<String> result = new ArrayList<>();
        int startIndex = findVertexIndex(startName);
        if (startIndex == -1) {
            System.out.println("错误：起点不存在！");
            return result;
        }

        boolean[] visited = new boolean[vertexCount];
        dfsRecursive(startIndex, visited, result);
        return result;
    }

    private void dfsRecursive(int index, boolean[] visited, List<String> result) {
        visited[index] = true;
        result.add(vertices[index].getName());

        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[index][i] < INF && !visited[i]) {
                dfsRecursive(i, visited, result);
            }
        }
    }

    /**
     * BFS广度优先遍历
     */
    public List<String> bfs(String startName) {
        List<String> result = new ArrayList<>();
        int startIndex = findVertexIndex(startName);
        if (startIndex == -1) {
            System.out.println("错误：起点不存在！");
            return result;
        }

        boolean[] visited = new boolean[vertexCount];
        Queue<Integer> queue = new LinkedList<>();

        visited[startIndex] = true;
        queue.offer(startIndex);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            result.add(vertices[index].getName());

            for (int i = 0; i < vertexCount; i++) {
                if (adjMatrix[index][i] < INF && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        return result;
    }

    /**
     * Dijkstra算法 - 单源最短路径
     */
    public DijkstraResult dijkstra(String startName) {
        int startIndex = findVertexIndex(startName);
        if (startIndex == -1) {
            System.out.println("错误：起点不存在！");
            return null;
        }

        int n = vertexCount;
        int[] dist = new int[n];
        int[] path = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            dist[i] = adjMatrix[startIndex][i];
            path[i] = (dist[i] < INF) ? startIndex : -1;
        }
        dist[startIndex] = 0;
        visited[startIndex] = true;
        path[startIndex] = -1;

        for (int count = 1; count < n; count++) {
            int minDist = INF, u = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    u = i;
                }
            }
            if (u == -1) break;
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && adjMatrix[u][v] < INF) {
                    int newDist = dist[u] + adjMatrix[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        path[v] = u;
                    }
                }
            }
        }

        return new DijkstraResult(dist, path, startIndex);
    }

    /**
     * Floyd算法 - 全源最短路径
     */
    public FloydResult floyd() {
        int n = vertexCount;
        int[][] dist = new int[n][n];
        int[][] path = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(adjMatrix[i], 0, dist[i], 0, n);
            for (int j = 0; j < n; j++) {
                path[i][j] = (dist[i][j] < INF) ? i : -1;
            }
            dist[i][i] = 0;
            path[i][i] = -1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        return new FloydResult(dist, path);
    }

    /**
     * 显示邻接矩阵
     */
    public void displayAdjMatrix() {
        System.out.println("\n========== 邻接矩阵 ==========");
        System.out.print("     ");
        for (int i = 0; i < vertexCount; i++) {
            System.out.printf("%-10s", vertices[i].getName());
        }
        System.out.println();

        for (int i = 0; i < vertexCount; i++) {
            System.out.printf("%-5s", vertices[i].getName());
            for (int j = 0; j < vertexCount; j++) {
                if (adjMatrix[i][j] >= INF) {
                    System.out.printf("%-10s", "∞");
                } else {
                    System.out.printf("%-10d", adjMatrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    // Dijkstra结果内部类
    public static class DijkstraResult {
        private int[] dist;
        private int[] path;
        private int startIndex;

        public DijkstraResult(int[] dist, int[] path, int startIndex) {
            this.dist = dist;
            this.path = path;
            this.startIndex = startIndex;
        }

        public int[] getDist() { return dist; }
        public int[] getPath() { return path; }
        public int getStartIndex() { return startIndex; }
    }

    // Floyd结果内部类
    public static class FloydResult {
        private int[][] dist;
        private int[][] path;

        public FloydResult(int[][] dist, int[][] path) {
            this.dist = dist;
            this.path = path;
        }

        public int[][] getDist() { return dist; }
        public int[][] getPath() { return path; }
    }
}
