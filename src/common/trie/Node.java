package common.trie;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ugurdonmez on 30/07/16.
 */
class Node {

    private final char c;
    private Map<Character, Node> children;
    private boolean isLeaf;

    public Node(char c) {
        this.c = c;
        this.isLeaf = false;
        this.children = new TreeMap<>();
    }

    public boolean isIsLeaf() {
        return isLeaf;
    }

    public Map<Character, Node> getChildren() {
        return children;
    }

    public Node getByChar(Character c) {
        return children.get(c);
    }

    public char getC() {
        return c;
    }

    public void addWord (String str, int level) {
        if (level == str.length()) {
            this.isLeaf = true;
            return;
        }

        char c = str.charAt(level);

        if (!children.containsKey(c)) {
            children.put(c, new Node(c));
        }

        children.get(c).addWord(str, level+1);
    }

    public ArrayList<String> getWords(String str) {
        ArrayList<String> list = new ArrayList<>();

        if (this.isLeaf) {
            list.add(str);
        }

        Iterator<Character> it = this.children.keySet().iterator();

        while (it.hasNext()) {
            list.addAll(children.get(it.next()).getWords(str+c));
        }

        return list;
    }

}
