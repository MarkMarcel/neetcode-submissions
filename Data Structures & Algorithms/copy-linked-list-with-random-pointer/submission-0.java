/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        final HashMap<Node,Node> map = new HashMap();
        var currentNode = head;
        Node deepCopy = null;
        while(currentNode != null){
            //Creation of it
            final Node copy = (map.containsKey(currentNode))? map.get(currentNode): new Node(currentNode.val);
            map.put(currentNode, copy);
            //Creation of random
            if(currentNode.random != null){
                final Node randomCopy = (map.containsKey(currentNode.random))? map.get(currentNode.random): new Node(currentNode.random.val);
                copy.random = randomCopy;
                map.put(currentNode.random,randomCopy);
            }
            //linking
            if(deepCopy != null){
                deepCopy.next = copy;
            }
            deepCopy = copy;
            currentNode = currentNode.next;
        }
        return map.get(head);
    }
}
