public class Test {
    public static void main(String[] args) {
        Person p1= new Person("Rupam", 50);
        Person p2= new Person("Urmi", 70);
        Person p3= new Person("Dipen", 90);
        Person p4= new Person("Abhilash", 80);
        Person p5= new Person("Krishnendu",30);
        Person p6= new Person("Subhankar", 40);
        Person p7= new Person("Subrata", 20);
        Person p8= new Person("Apu", 100);
        Person p9= new Person("Banani", 95);
        Person p10= new Person("Tusi", 85);
        Person p11= new Person("Munna", 45);
        Person p12= new Person("Tapan", 10);
        Person p13= new Person("Tandra", 15);

        BinarySearchTree obj = new BinarySearchTree();
        obj.ins(p1);
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.ins(p2);
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.ins(p3);
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.ins(p4);
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.ins(p5);
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.ins(p6);
        System.out.println("--------------");
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.ins(p7);
        System.out.println("--------------");
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.ins(p8);
        System.out.println("--------------");
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.ins(p9);
        System.out.println("--------------");
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.ins(p10);
        System.out.println("--------------");
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.ins(p11);
        System.out.println("--------------");
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.ins(p12);
        System.out.println("--------------");
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.ins(p13);
        System.out.println("--------------");
        obj.printPostorder(obj.root);
        System.out.println("--------------");

        obj.del(90);
        System.out.println("--------------");
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.del(45);
        System.out.println("--------------");
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.del(70);
        System.out.println("--------------");
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.del(50);
        System.out.println("--------------");
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        obj.del(20);
        System.out.println("--------------");
        obj.printPostorder(obj.root);
        System.out.println("--------------");
        
    }
    
}