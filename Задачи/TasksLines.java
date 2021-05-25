import java.util.*;

public class TasksLines {
    public static void main(String[] args) {
        System.out.println("1) " + Task1("abc", "xya"));
        System.out.println("2) " + Task2("babad"));
        System.out.println("3) " + Task3("abcabcabc"));
    }

    public static boolean Task1(String s1, String s2)
    {
        if(s1.length() != s2.length())
            return false;
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int i=0;
        while(i<s1.length())
        {
            if(c1[i]<c2[i])
                break;
            i++;
        }
        if(i==s1.length())
            return true;
        i=0;
        while(i<s2.length())
        {
            if(c1[i]>c2[i]) break;
            i++;
        }
        return i == s2.length();
    }

    public static String Task2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static int Task3(String str) {
        HashSet<String> set = new HashSet<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int len = 2; i + len <= n; len += 2) {
                int mid = i + len / 2;
                String subStr1 = str.substring(i, mid);
                String subStr2 = str.substring(mid, i + len);
                if (subStr1.equals(subStr2)) set.add(subStr1);
            }
        }
        return set.size();
    }
}
