package in.aascar;

import java.util.Stack;

/**
 * This problem was asked by Google.
 * <p>
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
 * <p>
 * For example, given the following Node class
 * <p>
 * class Node:
 * def __init__(self, val, left=None, right=None):
 * self.val = val
 * self.left = left
 * self.right = right
 * <p>
 * The following test should pass:
 * <p>
 * node = Node('root', Node('left', Node('left.left')), Node('right'))
 * assert deserialize(serialize(node)).left.left.val == 'left.left'
 */

public class TreeSerializer {

    static class Node {

        String val;
        Node left;
        Node right;

        public Node(String val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Node(String val) {
            this.val = val;
        }

        public Node(String val, Node left) {
            this.val = val;
            this.left = left;
        }

    }


    static String serialize(Node root){
        String str = "";
        if(root == null){
            return str;
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        str = "('" + root.val + "'";
        if(left.length() > 0){
            str += "," + left;
        }
        if(right.length() > 0){
            str += "," + right;
        }
        str += ")";
        return str;
    }

    static int parseForEndOfNode(String str){
        int index = 0;
        if(str.length() < 4){//('')
            return index;
        }
        Stack<Character> stack = new Stack<Character>();
        char[] chars = str.toCharArray();
        char tempC;
        for (char c : chars){
            index++;
            if(c == '('){
                stack.push(c);
            } else if(c == ')' && !stack.empty()){
                tempC = stack.peek();
                if(tempC == '(' && stack.size() == 1){
                    break;
                }
                if(tempC == '('){
                    stack.pop();
                }
            }
        }
        return index;
    }

    static Node deserialize(String str){ //Write Try catch for parse errors
        Node node = null;
        int size = str.length();
        if(size > 3){ //('')
            /*For Node Value*/
            char[] chars = str.toCharArray();
            int index = 2;
            while (index < chars.length){
                if(chars[index] == '\''){ //end of value
                    break;
                }
                index++;
            }
            /*End: For Node Value*/
            String nodeValue = str.substring(2, index);
            node = new Node(nodeValue);
            int leftNodeStartIndex = index + 2;
            if(size > leftNodeStartIndex){
                int leftNodeEndIndex = leftNodeStartIndex + parseForEndOfNode(str.substring(index + 2));
                node.left = deserialize(str.substring(index + 2, leftNodeEndIndex));
                int rightNodeStartIndex = leftNodeEndIndex + 1;
                if(size > rightNodeStartIndex){
                    int rightNodeEndIndex =
                            rightNodeStartIndex + parseForEndOfNode(str.substring(leftNodeEndIndex + 1));
                    node.right = deserialize(str.substring(rightNodeStartIndex, rightNodeEndIndex));
                }
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Node test = new Node("root", new Node("left"), new Node("right", new Node("right-left")));
        System.out.println(serialize(test));
        System.out.println(serialize(deserialize(serialize(test))));
        System.out.println(deserialize(serialize(test)).right.left.val);
    }

}
