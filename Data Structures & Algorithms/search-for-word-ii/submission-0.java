

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();

    private int rows;
    private int cols;

    public List<String> findWords(char[][] board, String[] words) {

        rows = board.length;
        cols = board[0].length;

        // 1. Build Trie
        for (String word : words) {
            insert(word);
        }

        // 2. Start DFS from every cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.word = word;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {

        // Boundary check
        if (r < 0 || r >= rows ||
            c < 0 || c >= cols) {
            return;
        }

        char ch = board[r][c];

        // Already visited
        if (ch == '#') {
            return;
        }

        int index = ch - 'a';

        // Character doesn't exist in Trie
        if (node.children[index] == null) {
            return;
        }

        TrieNode next = node.children[index];

        // Found a complete word
        if (next.word != null) {
            result.add(next.word);

            // Prevent duplicate result
            next.word = null;
        }

        // Mark current cell as visited
        board[r][c] = '#';

        // Explore 4 directions
        dfs(board, r + 1, c, next); // down
        dfs(board, r - 1, c, next); // up
        dfs(board, r, c + 1, next); // right
        dfs(board, r, c - 1, next); // left

        // Backtrack
        board[r][c] = ch;
    }
}