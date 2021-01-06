public class Test {
    public static void main(String[] args) {
        Person p1=new Person("Rupam", 0, 1);
        Person p2=new Person("Dipen", 23, 2);
        Person p3=new Person("U", 12, 3);
        Person p4=new Person("T", 11, 4);
        Person p5=new Person("M", 44, 5);
        Person p6=new Person("R", 0, 6);
        Person p7=new Person("D", 23, 7);
        Person p8=new Person("Ur", 12, 8);
        Person p9=new Person("Ty", 11, 9);
        Person p10=new Person("Mv", 44, 10);
        AdjacencyList obj =new AdjacencyList(11);
        
        // obj.addedges(p1,p2);
        // obj.addedges(p1,p3);
        // obj.addedges(p1,p4);
        // obj.addedges(p2,p3);
        // obj.addedges(p2,p5);
        // obj.addedges(p4, p5);
        // /**
        //  * 1->2,3,4
        //  * 2->1,3,5
        //  * 3->1,2
        //  * 4->1,5
        //  * 5-2,4
        //  */

        obj.addedges(p1, p2);
        obj.addedges(p1, p3);
        obj.addedges(p4, p2);
        obj.addedges(p4, p6);
        obj.addedges(p2, p7);
        obj.addedges(p7, p8);
        obj.addedges(p3, p7);
        obj.addedges(p3, p9);
        obj.addedges(p9, p10);
        obj.addedges(p3, p5);
        obj.addedges(p5, p10);
        
        Node start=obj.lstArr[1].head;
        Bfs objbf=new Bfs(obj, start);
        System.out.println("BFS:__");
        objbf.myBfsCode(obj, start);
        System.out.println("");
        System.out.println("---------------------");
        Dfs objdf=new Dfs(obj, start);
        System.out.println("DFS__");
        objdf.myDfsCode(obj, start);
    }
}