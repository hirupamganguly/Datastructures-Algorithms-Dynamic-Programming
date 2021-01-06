public class Test {
    public static void main(String[] args) {
        HashMap map= new HashMap<String,String>(10);
        map.put("ru", "rup");
        map.show();
        map.put("pa", "pam");
        map.show();
        map.put("m", "gangu;y");
        map.show();
        map.get("ru");
        map.show();
        map.remove("pa");
        map.show();
    }
}