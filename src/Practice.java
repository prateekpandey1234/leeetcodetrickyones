
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
public class Practice {
    public Node copyRandomList(Node head) {
        Node temp =head;
        ArrayList<Node> list = new ArrayList<>();
        while(temp!=null){
            list.add(new Node(temp.val);
            temp = temp.next;
        }
        Node newhead = new Node(head.val);
        temp=head;
        while(temp!=null ){

            newhead.val = temp.val;
            newhead.random = list.indexOf();
            newhead = newhead.next;
            temp=temp.next;
        }
        return newhead;
    }
}
