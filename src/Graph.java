import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * Created by apaswami on 3/26/17.
 */
public class Graph {
    private int numVertices;

    private LinkedList<Integer> adj[];

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adj = new LinkedList[numVertices];
    }

    public void addEdge(int v, int w) {
        if (adj[v] == null) {
            adj[v] = new LinkedList<>();
        }
        adj[v].add(w);
    }

    public void bfs(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);

        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int v = queue.remove();

            if (!visited.contains(v)) {
                visited.add(v);

                if (adj[v] != null) {
                    queue.addAll(adj[v]);
                }

                System.out.println(v);
            }
        }
    }

    public void dfs(int start) {
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[numVertices];

        stack.add(start);

        while (!stack.isEmpty()) {
            int v = stack.pop();

            if (visited[v] == false) {
                visited[v] = true;

                if (adj[v] != null) {
                    stack.addAll(adj[v]);
                }

                System.out.println(v);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(3, 4);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.bfs(2);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.dfs(2);
    }
}
