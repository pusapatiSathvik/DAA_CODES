import java.util.*;

class SuffixTrie {
    static final int NUM_CHARS = 26;
    static boolean isDeleted = false;

    static class TrieNode {
        TrieNode[] children = new TrieNode[NUM_CHARS];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < NUM_CHARS; i++)
                children[i] = null;
        }
    }

    static TrieNode root;

    static void insertSuffixes(String text) {
        for (int i = 0; i < text.length(); i++) {
            insert(text.substring(i));
        }
    }

    static void insert(String key) {
        TrieNode currentNode = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currentNode.children[index] == null)
                currentNode.children[index] = new TrieNode();
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    static boolean search(String key) {
        TrieNode currentNode = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currentNode.children[index] == null)
                return false;
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord;
    }

    static boolean isEmpty(TrieNode node) {
        for (int i = 0; i < NUM_CHARS; i++)
            if (node.children[i] != null)
                return false;
        return true;
    }

    static TrieNode delete(TrieNode node, String key, int depth) {
        if (node == null)
            return null;

        if (depth == key.length()) {
            isDeleted = node.isEndOfWord;
            node.isEndOfWord = false;
            if (isEmpty(node))
                return null;
            return node;
        }

        int index = key.charAt(depth) - 'a';
        node.children[index] = delete(node.children[index], key, depth + 1);

        if (isEmpty(node) && !node.isEndOfWord)
            return null;

        return node;
    }

    static boolean isLeafNode(TrieNode node) {
        return node.isEndOfWord;
    }

    static void print(TrieNode node, char[] str, int level) {
        if (isLeafNode(node)) {
            for (int i = level; i < str.length; i++)
                str[i] = 0;
            System.out.println(new String(str, 0, level));
        }

        for (int i = 0; i < NUM_CHARS; i++) {
            if (node.children[i] != null) {
                str[level] = (char) (i + 'a');
                print(node.children[i], str, level + 1);
            }
        }
    }
    static int countNodes(TrieNode node) {
        if (node == null) return 0;
        int count = 0;
        for (int i = 0; i < NUM_CHARS; i++) {
            if (node.children[i] != null)
                count += countNodes(node.children[i]);
        }
        return 1 + count; // +1 for the current node
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        root = new TrieNode();

        System.out.println("Enter a string to build Suffix Trie:");
        String text = sc.nextLine();
        insertSuffixes(text);

        char[] str = new char[100];
        System.out.println("All suffixes stored in Suffix Trie:");
        print(root, str, 0);

        while (true) {
            System.out.println("Enter a substring to search (-1 to stop):");
            String word = sc.next();
            if (word.equals("-1")) break;

            if (search(word))
                System.out.println(word + " is present in the Suffix Trie");
            else
                System.out.println(word + " is NOT present");
        }

        while (true) {
            System.out.println("Enter a substring to delete (-1 to stop):");
            String word = sc.next();
            if (word.equals("-1")) break;

            isDeleted = false;
            root = delete(root, word, 0);
            if (isDeleted)
                System.out.println(word + " is deleted from the Suffix Trie");
            else
                System.out.println(word + " was not found in the Suffix Trie");

            System.out.println("Suffix Trie after deletion:");
            print(root, str, 0);
        }
    }
}