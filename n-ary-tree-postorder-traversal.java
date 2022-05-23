/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> out = new LinkedList<>();
    public List<Integer> postorder(Node root) {
      recurser(root);
      return out;
    }
  
    private void recurser(Node root) {
      if (root != null) {
        if (root.children != null) {
          List<Node> children = root.children;
          for (int i = 0; i < children.size(); i++) {
            recurser(children.get(i));
          }
        }
        out.add(root.val);
      }      
    }
}