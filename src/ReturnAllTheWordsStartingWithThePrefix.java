import java.util.*;

public class ReturnAllTheWordsStartingWithThePrefix {

    void call(String[] words, String prefix) {
        System.out.println(Arrays.toString(words));
        System.out.println();

        Trie trie = new Trie();
        for (String word : words) trie.insert(word);

        List<String> result = trie.getWordsWithPrefix(prefix);
        System.out.println("Words starting with prefix \"" + prefix + "\": " + result);
    }

    /// Trie
    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.flag = true;
        }

        List<String> getWordsWithPrefix(String prefix) {
            List<String> result = new ArrayList<>();
            TrieNode node = root;

            for (char ch : prefix.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    return result;
                }
                node = node.children.get(ch);
            }

            findAllWords(node, new StringBuilder(prefix), result);
            return result;
        }

        void findAllWords(TrieNode node, StringBuilder prefix, List<String> result) {
            if (node.flag) {
                result.add(prefix.toString());
            }

            for (char ch : node.children.keySet()) {
                findAllWords(node.children.get(ch), prefix.append(ch), result);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }

    /// TrieNode
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean flag;

        TrieNode() {
            children = new HashMap<>();
            flag = false;
        }
    }
}
