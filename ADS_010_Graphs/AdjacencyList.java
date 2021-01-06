public class AdjacencyList {
    int d;
    int i=0;
    LinkedList lstArr[];
    public AdjacencyList(int noOfv){
        d=noOfv;
         lstArr=new LinkedList[d];
        for(int i=0; i<noOfv; i++){
            lstArr[i]=new LinkedList();
        }
    }
    public void addedges(Person u, Person v){
        int indexOfU=u.index;
        int indexOfV=v.index;
        if(lstArr[indexOfU].head==null){
            lstArr[indexOfU].add(u);
        }
        if(lstArr[indexOfV].head==null){
            lstArr[indexOfV].add(v);
        }
        lstArr[indexOfU].add(v);
        lstArr[indexOfV].add(u);// FOR unDirected Graph only
    }
    public Node getChildren(Node n){
        Node connections=lstArr[n.data.index].head;
        return connections;
    }
}