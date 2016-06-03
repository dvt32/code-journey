// https://www.hackerrank.com/challenges/30-binary-search-trees

public static int getHeight(Node root) {
      if (root == null) { return -1; }
      else {
          return 1 + Math.max(getHeight(root.left), getHeight(root.right));
      }
}
