public class Main {

    public static void main(String[] args) {
        // initialize text with first text as original text and second text as user input
        String a = "auction", b = "autcion"; // user input with one miss aligned character
        String c = "auction", d = "aution"; // user input with one missing character

        Main lev = new Main();
        System.out.println("Levenshtein Distance between "+a+" and "+b+" : " + lev.findDistance(a, b));
        System.out.println("Levenshtein Distance between "+c+" and "+d+" : " + lev.findDistance(c, d));
    }

    int findDistance(String a, String b) {
        int d[][] = new int[a.length() + 1][b.length() + 1];

        // Initialising first column:
        for(int i = 0; i <= a.length(); i++)
            d[i][0] = i;

        // Initialising first row:
        for(int j = 0; j <= b.length(); j++)
            d[0][j] = j;

        // Applying the algorithm:
        int insertion, deletion, replacement;
        for(int i = 1; i <= a.length(); i++) {
            for(int j = 1; j <= b.length(); j++) {
                if(a.charAt(i - 1) == (b.charAt(j - 1)))
                    d[i][j] = d[i - 1][j - 1];
                else {
                    insertion = d[i][j - 1];
                    deletion = d[i - 1][j];
                    replacement = d[i - 1][j - 1];

                    // Using the sub-problems
                    d[i][j] = 1 + findMin(insertion, deletion, replacement);
                }
            }
        }

        return d[a.length()][b.length()];
    }

    // Helper funciton used by findDistance()
    int findMin(int x, int y, int z) {
        if(x <= y && x <= z)
            return x;
        if(y <= x && y <= z)
            return y;
        else
            return z;
    }
}






