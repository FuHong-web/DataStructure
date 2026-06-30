package MyReport.campus;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/28 10:31
 * @desc:
 */

import java.util.*;

import java.util.*;

public class LGraph {
    private static final int MAX_VERTEX = 20;
    private AdjListNode[] adjList;
    private int vertexCount;
    private int edgeCount;

    public LGraph() {
        this.adjList = new AdjListNode[MAX_VERTEX];
        for (int i = 0; i < MAX_VERTEX; i++) {
            adjList[i] = new AdjListNode();
        }
        this.vertexCount = 0;
        this.edgeCount = 0;
    }

    // 邻接表节点
    private static class AdjListNode {
        private VertexInfo info;
        private EdgeNode firstEdge;

        public AdjListNode() {
            this.info = new VertexInfo();
            this.firstEdge = null;
        }
    }

    // 边节点
    private static class EdgeNode {
        private int adjVertex;
        private int weight;
        private EdgeNode next;

        public EdgeNode(int adjVertex, int weight) {
            this.adjVertex = adjVertex;
            this.weight = weight;
            this.next = null;
        }
    }

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

        for (int i = 0; i < vertexCount; i++) {
            if (adjList[i].info.getName().equals(name)) {
                System.out.println("错误：景点名称已存在！");
                return false;
            }
        }

        adjList[vertexCount].info = new VertexInfo(name, description);
        adjList[vertexCount].firstEdge = null;
        vertexCount++;
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

        // 检查是否已存在
        EdgeNode p = adjList[fromIndex].firstEdge;
        while (p != null) {
            if (p.adjVertex == toIndex) {
                System.out.println("错误：路径已存在！");
                return false;
            }
            p = p.next;
        }

        // 添加边 from->to
        EdgeNode newEdge1 = new EdgeNode(toIndex, weight);
        newEdge1.next = adjList[fromIndex].firstEdge;
        adjList[fromIndex].firstEdge = newEdge1;

        // 添加边 to->from (无向图)
        EdgeNode newEdge2 = new EdgeNode(fromIndex, weight);
        newEdge2.next = adjList[toIndex].firstEdge;
        adjList[toIndex].firstEdge = newEdge2;

        edgeCount++;
        return true;
    }

    /**
     * 查找景点索引
     */
    public int findVertexIndex(String name) {
        for (int i = 0; i < vertexCount; i++) {
            if (adjList[i].info.getName().equals(name)) {
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
        result.add(adjList[index].info.getName());

        EdgeNode p = adjList[index].firstEdge;
        while (p != null) {
            if (!visited[p.adjVertex]) {
                dfsRecursive(p.adjVertex, visited, result);
            }
            p = p.next;
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
            result.add(adjList[index].info.getName());

            EdgeNode p = adjList[index].firstEdge;
            while (p != null) {
                if (!visited[p.adjVertex]) {
                    visited[p.adjVertex] = true;
                    queue.offer(p.adjVertex);
                }
                p = p.next;
            }
        }
        return result;
    }

    /**
     * 显示邻接表
     */
    public void displayAdjList() {
        System.out.println("\n========== 邻接表 ==========");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(adjList[i].info.getName());
            EdgeNode p = adjList[i].firstEdge;
            while (p != null) {
                System.out.print(" -> " + adjList[p.adjVertex].info.getName() +
                        "(" + p.weight + "m)");
                p = p.next;
            }
            System.out.println();
        }
    }
}