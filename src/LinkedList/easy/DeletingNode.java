package LinkedList.easy;
//here we are only given the node that we need to delete not the head of linked list
public class DeletingNode {
    //what we do here is to simply swap out the nodes to make the required to go away...

    public void deleteNode(ListNode node) {
        ListNode head = node;
        ListNode prev = node;

        while(head.next!=null){
            swap(head,head.next);
            prev = head;
            head = head.next;
        }

        prev.next = null;
    }

    public void  swap(ListNode head, ListNode next){
        int temp = head.val;
        head.val = next.val;
        next.val = temp;
    }
}
