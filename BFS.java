import java.util.*;

class BFSTraversal{
    private int vertex;
    private LinkedList<Integer> adj[];
    private Queue<Integer> que;

    BFSTraversal(int v){
        vertex = v;
        adj = new LinkedList[vertex];
        for(int i=0; i<vertex; i++){
            adj[i] = new LinkedList<>();
        }
        que = new LinkedList<Integer>();
    }
    void insertNode(int u, int v){
        adj[u].add(v);
    }
    void BFS(int n){
        boolean isVisited[] = new boolean[vertex];
        isVisited[n] = true;
        que.add(n);
        while(que.size()!=0){
            n = que.poll();
            System.out.print(n+" ");
            for(int i=0; i<adj[n].size(); i++){
                int a = adj[n].get(i);
                if(!isVisited[a]){
                    isVisited[a] = true;
                    que.add(a);
                }
            }
        }

    }
    public static void main(String args[]){
        BFSTraversal graph = new BFSTraversal(5);
        graph.insertNode(0,1);
        graph.insertNode(1,0);
        graph.insertNode(1,2);
        graph.insertNode(2,1);
        graph.insertNode(0,3);
        graph.insertNode(3,0);
        graph.BFS(0);
    }
}

/* 
Sample I/P: 3-0-1-2 
BFS Output: 0, 1, 3, 2
*/