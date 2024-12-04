package com.keyin;


import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;




public class BinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public Object toMap() {
        return nodeToMap(root);
    }

    private Map<String, Object> nodeToMap(Node node) {
        if (node == null) return null;
        Map<String, Object> map = new HashMap<>();
        map.put("value", node.value);
        map.put("left", nodeToMap(node.left));
        map.put("right", nodeToMap(node.right));
        return map;
    }
}

public String treeifyAndDescribe(int[] intArray) {
    return new Gson().toJson(new HashMap<String, Object>() {{
    }});
}

private class Node {
    int value;
    Node left, right;
    Node(int value) {
        this.value = value;
    }
}

public void insert(int value) {
    root = insertRec(root, value);
}

private Node insertRec(Node root, int value) {
    if (root == null) {
        return new Node(value);
    }
    if (value < root.value) {
        root.left = insertRec(root.left, value);
    } else {
        root.right = insertRec(root.right, value);
    }
    return root;
}

public void createBalancedTree(int[] values) {
    root = createBalancedTreeRec(values, 0, values.length - 1);
}

private Node createBalancedTreeRec(int[] values, int start, int end) {
    if (start > end) {
        return null;
    }
    int mid = (start + end) / 2;
    Node node = new Node(values[mid]);
    node.left = createBalancedTreeRec(values, start, mid - 1);
    node.right = createBalancedTreeRec(values, mid + 1, end);
    return node;
}

public String displayTree() {
    if (root == null) {
        return "Tree is empty";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("Root: ").append(root.value).append("\n");
    sb.append("Left subtree: ");
    appendSubtree(sb, root.left);
    sb.append("\nRight subtree: ");
    appendSubtree(sb, root.right);
    return sb.toString();
}

private void appendSubtree(StringBuilder sb, Node node) {
    if (node == null) {
        sb.append("null");
    } else {
        sb.append(node.value);
        if (node.left != null || node.right != null) {
            sb.append(" (");
            appendSubtree(sb, node.left);
            sb.append(", ");
            appendSubtree(sb, node.right);
            sb.append(")");
        }
    }
}

public boolean isBalanced() {
    return isBalancedRec(root) != -1;
}

private int isBalancedRec(Node node) {
    if (node == null) {
        return 0;
    }
    int leftHeight = isBalancedRec(node.left);
    if (leftHeight == -1) return -1;
    int rightHeight = isBalancedRec(node.right);
    if (rightHeight == -1) return -1;
    if (Math.abs(leftHeight - rightHeight) > 1) {
        return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        