public class Dfs {
    boolean[] visited;
    AdjacencyList adj;
    Node start;
    public Dfs(AdjacencyList adj, Node start){
        this.adj=adj;
        this.start=start;
        visited=new boolean[adj.lstArr.length];
    }
    public void myDfsCode(AdjacencyList adj, Node start){
        
        MyStack s= new MyStack(50);
        s.ins(start);
        while(s.size!=0){
            Node currentVertex=s.pop();
            if(visited[currentVertex.data.index]==false){
                visited[currentVertex.data.index]=true;
                System.out.print(""+currentVertex.data+" --> ");
            }
            Node edges=adj.getChildren(currentVertex);
            while(edges !=null){
                
                if(visited[edges.data.index]==false){
                    s.ins(edges);
                }
                edges=edges.next;
            }
        }
    }
}