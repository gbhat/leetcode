//https://leetcode.com/problems/satisfiability-of-equality-equations/

public class SatisfiabilityEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        int[] uf = new int[26];
        for(int i = 0; i < 26; i++)
            uf[i] = i;

        for(String eq : equations)
            if (eq.charAt(1) == '=')
                uf[find(uf, eq.charAt(0) - 'a')] = find(uf, eq.charAt(3) - 'a');

        for(String eq : equations)
            if (eq.charAt(1) == '!' && find(uf, eq.charAt(0) - 'a') == find(uf, eq.charAt(3) - 'a'))
                return false;
        return true;
    }

    private int find(int[] uf, int i) {
        while (uf[i] != i)
            i = uf[i];

        return i;
    }
}