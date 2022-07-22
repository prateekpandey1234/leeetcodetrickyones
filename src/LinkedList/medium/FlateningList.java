package LinkedList.medium;
class Node1
{
    int data;
    Node1 next;
    Node1 bottom;

    Node1(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}
/**Fucked up .... , didn't solve carefully*/
public class FlateningList {
    Node1 mergeTwoLists(Node1 a, Node1 b) {

        Node1 temp = new Node1(0);
        Node1 res = temp;

        while(a != null && b != null) {
            if(a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            }
            else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if(a != null) temp.bottom = a;
        else temp.bottom = b;
        return res.bottom;

    }
    Node1 flatten(Node1 root)
    {

        if (root == null || root.next == null)
            return root;

        // recur for list on right
        root.next = flatten(root.next);

        // now merge
        root = mergeTwoLists(root, root.next);

        // return the root
        // it will be in turn merged with its left
        return root;
    }
}
