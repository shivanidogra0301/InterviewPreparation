package Generictree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Construction {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void mirror(Node node) {
    Collections.reverse(node.children);
    for (Node n : node.children) {
      mirror(n);
    }
  }

  

  

  public static void removeLeaves(Node node) {
    int size = node.children.size();
    for (int i = size - 1; i >= 0; i--) {
      Node n = node.children.get(i);
      if (n.children.size() == 0) {
        node.children.remove(n);
      }
    }
    for (Node n : node.children) {
      removeLeaves(n);
    }

  }

  public static void main(String[] args) {
    Node root;
    int[] arr = { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1 };
    root = construct(arr);
    display(root);
  }

}
