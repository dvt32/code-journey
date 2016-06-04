// https://www.hackerrank.com/challenges/30-binary-trees

static void levelOrder(Node root){
      Queue<Node> nodeQueue = new LinkedList<Node>();
      if (root != null) {
          nodeQueue.add(root);
          while(!nodeQueue.isEmpty()) {
             Node currentNode = nodeQueue.remove();
             System.out.print(currentNode.data + " ");
             if (currentNode.left != null) {
                  nodeQueue.add(currentNode.left);
             }
             if (currentNode.right != null) {
                 nodeQueue.add(currentNode.right);
             }
          }
      } 
}
