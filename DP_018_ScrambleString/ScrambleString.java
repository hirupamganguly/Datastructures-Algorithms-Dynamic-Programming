import java.util.HashMap;

class Solution {
    static HashMap<String, Boolean> map;

    public static boolean isScramble(final String a, final String b) {
        map = new HashMap();
        return solver(a, b);
    }
    public static boolean solver(final String a, final String b) {
        if (a.equals(""))
            return false;
        if (a.equals(b))
            return true;
        final int n = a.length();
        if (n == 1) {
            return false;
        }
        if (map.containsKey(a + "-" + b))
            return map.get(a + "-" + b);
        boolean flag = false;
        for (int k = 0; k < n - 1; k++) {

            // substring (start index, end index)-->
            
            //              n                    k=2            n
            //       --------------------------       ------------------------
            //       g    r       e       a   t   --  e  a   t        g      r
            //       0         n-k+1          n   --  0          n- k+1      n
            //       0    1     2         3   4       0  1   2       3       4

            flag = solver(a.substring(0, k + 1), b.substring(n - (k + 1), n))
                    && solver(a.substring(k + 1, n), b.substring(0, n - (k + 1)))
                    || (solver(a.substring(0, k + 1), b.substring(0, k + 1))
                            && solver(a.substring(k + 1, n), b.substring(k + 1, n)));
            
            //Map->  key            : value
            //      gr-at           : false
            //      great-rgeat     : false
            //------------------------------- a = "great", b = "rgtae"
            //      gr-ae           : false
            //      great-rgtae     : false
            map.put(a + "-" + b, flag);
            if (flag)
                return true;
        }
        // map.forEach((key, value) -> System.out.println(key + ":" + value));
        return flag;
    }

    public static void main(final String[] args) {
        String a = "great", b = "rgeat";
        // String a = "abcde", b = "caebd";
        System.out.println(isScramble(a, b));
    }
}