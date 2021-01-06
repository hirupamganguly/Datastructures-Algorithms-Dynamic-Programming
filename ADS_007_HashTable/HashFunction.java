public class HashFunction{
    public int getHashedValue(String str){
        char[] ch=str.toCharArray();
        int total=0;
        for(int i=0,j=ch.length-1;i<ch.length;i++){
            String temp=((int)ch[i]+""+i+""+(int)ch[j--]);
            total=total+Integer.parseInt(temp);

        }
        return total%9;
    }
}