public class Test {
    public static void main(String[] args) {
        Person p1= new Person("Rupam", "burdwan");
        Person p2= new Person("Urmi", "asansol");
        Person p3= new Person("Dipen", "asansol");
        Person p4= new Person("Abhilash", "purilia");
        Person p5= new Person("Krishnendu", "gurap");
        Person p6= new Person("rupam", "burdwan");
        Person p7= new Person("urmi", "burdwan");
        Person p8= new Person("dipen", "asansol");
        Person p9= new Person("abhilash", "purulia");
        Person p10= new Person("krishnendu", "gurap");
        Person p11= new Person("tusi", "burdwan");
        Person p12= new Person("futu", "burdwan");
        HashTable ht = new HashTable(12);
        ht.put(p1);
        ht.put(p2);
        ht.put(p3);
        ht.put(p4);
        ht.put(p5);
        ht.get(p2);
        ht.put(p6);
        ht.put(p7);
        ht.put(p7);
        ht.put(p8);
        ht.put(p7);
        ht.put(p10);
        ht.put(p7);
        ht.get(p11);
        ht.get(p12);
        ht.show();
        ht.remove(p5);
        ht.remove(p4);
        ht.show();
    }
}