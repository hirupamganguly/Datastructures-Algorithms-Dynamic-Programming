public class PalindromeString {
    public static void main(String[] args) {
        System.out.println("Hello World");
		String str="A man a plan, a canal: Panama";
		String s1= str.replaceAll("[^A-Za-z0-9]", "");
		s1=s1.toLowerCase();
		char[] s=s1.toCharArray();
		String s2="";
		for(int i=s.length-1; i>=0;i--){
		    s2+=s[i];
		}
		System.out.println(s1);
		System.out.println(s2);
		if(s1.equals(s2)){
		    System.out.println("yes");
		}else{
		    System.out.println("no");
		}
    }
   }
   
//    public class Solution {
   
//     public int isPalindrome(String A) {
//        String str=A;
//        String s1=str.replaceAll("[^A-Za-z0-9]","");
//        s1=s1.toLowerCase();
//        int left=0,right=s1.length()-1;
//        while(left<right){
//            if(s1.charAt(left)!=s1.charAt(right)){
//                return 0;
//            }
//             left++;
//             right--;
//        }
//        return 1;
//     }
// }


//    public class Solution {
   
//     public int isPalindrome(String A) {
//        String str=A;
//        String s1=str.replaceAll("[^A-Za-z0-9]","");
//        s1=s1.toLowerCase();
//        char[] s= s1.toCharArray();
//        String s2="";
//        for(int i=s.length-1; i>=0;i--){
//            s2+=s[i];
//        }
//        if(s1.equals(s2)){
//            return 1;
//        }
//        else{
//            return 0;
//        }
//     }
// }