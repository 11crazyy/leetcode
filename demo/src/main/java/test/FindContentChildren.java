package test;

import java.util.Arrays;

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int cookie = 0, children = 0; cookie < s.length && children < g.length; cookie++) {
            if (s[cookie] >= g[children]) {
                res++;
                children++;
            }
        }
        return res;
    }
}
