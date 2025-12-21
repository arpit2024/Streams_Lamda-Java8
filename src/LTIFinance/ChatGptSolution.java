package LTIFinance;

public class ChatGptSolution {

        // Main solve function
        public static String solve(int n, String[] words, String target) {

                String result = "";
                int minDistance = Integer.MAX_VALUE;

                for (String word : words) {
                        int distance = editDistance(word, target);

                        // Case 1: Found smaller distance
                        if (distance < minDistance) {
                                minDistance = distance;
                                result = word;
                        }
                        // Case 2: Same distance → pick shorter word
                        else if (distance == minDistance) {
                                if (word.length() < result.length()) {
                                        result = word;
                                }
                        }
                }
                return result;
        }

        // Levenshtein Edit Distance using DP
        private static int editDistance(String s1, String s2) {

                int m = s1.length();
                int n = s2.length();

                int[][] dp = new int[m + 1][n + 1];

                // Base cases
                for (int i = 0; i <= m; i++) {
                        dp[i][0] = i; // deletions
                }
                for (int j = 0; j <= n; j++) {
                        dp[0][j] = j; // insertions
                }

                // Fill DP table
                for (int i = 1; i <= m; i++) {
                        for (int j = 1; j <= n; j++) {

                                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                                        dp[i][j] = dp[i - 1][j - 1]; // no operation
                                } else {
                                        dp[i][j] = 1 + Math.min(
                                                dp[i - 1][j - 1], // replace
                                                Math.min(
                                                        dp[i - 1][j], // delete
                                                        dp[i][j - 1]  // insert
                                                )
                                        );
                                }
                        }
                }
                return dp[m][n];
        }

        // Optional: test
        public static void main(String[] args) {
                String[] words = {"cart", "care", "cards", "scar", "car"};
                String target = "cars";

                System.out.println(solve(words.length, words, target));
                // Output: car
        }
}
