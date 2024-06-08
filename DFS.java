import java.util.*;

class DFSTraversal{
    private int vertex;
    private LinkedList<Integer> adj[];
    boolean isVisited[];

    DFSTraversal(int v){
        vertex = v;
        adj = new LinkedList[vertex];
        for(int i=0; i<vertex; i++){
            adj[i] = new LinkedList<>();
        }
        isVisited = new boolean[vertex];
    }
    void insertNode(int u, int v){
        adj[u].add(v);
    }
    void DFS(int n){
        isVisited[n] = true;
        System.out.print(n+" ");
        for(int i=0; i<adj[n].size(); i++){
            int a = adj[n].get(i);
            if(!isVisited[a]){
                isVisited[a] = true;
                DFS(a);
            }
        }
    }
    public static void main(String args[]){
        DFSTraversal graph = new DFSTraversal(5);
        graph.insertNode(0,1);
        graph.insertNode(1,0);
        graph.insertNode(1,2);
        graph.insertNode(2,1);
        graph.insertNode(0,3);
        graph.insertNode(3,0);
        graph.DFS(0);
    }
}

/* 
Sample I/P: 3-0-1-2 
BFS Output: 0, 1, 2, 3
*/