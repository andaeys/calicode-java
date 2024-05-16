package andaeys.io;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution4 {

    public static void main(String[] args) {
        //case 1
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode merged = mergeTwoLists(list1, list2);
        printList(merged);

        //case 2
        list1 = null;
        list2 = null;
        merged = mergeTwoLists(list1, list2);
        printList(merged);

        //case 3
        list1 = null;
        list2 = new ListNode(0);
        merged = mergeTwoLists(list1, list2);
        printList(merged);
    }

    static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        //handle empty
        if (node1==null && node2==null) return null;

        ListNode mergedNode = new ListNode(0);
        ListNode current = mergedNode;

        while (node1!=null && node2!=null) {
            if (node1.val< node2.val) {
                current.next = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }
        //if one if is empty. putt remaining to current
        if (node1!=null){
            current.next = node1;
        } else {
            current.next = node2;
        }
        return mergedNode.next;
    }

    static void printList(ListNode root){
        System.out.print("[");
        ListNode node = root;
        while (node!=null) {
            System.out.print(node.val+",");
            node = node.next;
        }
        System.out.print("] \n");
    }
}