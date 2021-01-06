public class Person {
    String name;
    String city;
    public Person(String name, String city){
        this.name=name;
        this.city=city;
    }
    public String toString(){
        return "Name: "+this.name+" city: "+this.city;
    }
}