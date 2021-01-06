public class Bfs {
    boolean[] visited;
    AdjacencyList adj;
    Node start;
    public Bfs(AdjacencyList adj, Node start){
        this.adj=adj;
        this.start=start;
        visited=new boolean[adj.lstArr.length];
    }
    public void myBfsCode(AdjacencyList adj, Node start){
        
        MyQueue s= new MyQueue(10);
        s.enQ(start);
        while(s.size!=0){
            Node currentVertex=s.deQ();
            if(visited[currentVertex.data.index]==false){
                visited[currentVertex.data.index]=true;
                System.out.print(""+currentVertex.data+" --> ");
            }
            Node edges=adj.getChildren(currentVertex);
            while(edges !=null){
                
                if(visited[edges.data.index]==false){
                    s.enQ(edges);
                }
                edges=edges.next;
            }
        }
    }
}