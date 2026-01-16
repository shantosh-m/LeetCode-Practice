class Solution {
    public static class LinkNode {
        int val;
        LinkNode next;
        LinkNode() {}
        LinkNode(int val) { this.val = val; }
        LinkNode(int val, LinkNode next) { this.val = val; this.next = next; }
    }

    public static LinkNode sortList(LinkNode head) {
        // Base Case: If list is empty or has 1 node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find the middle (actually the end of the left half)
        LinkNode leftTail = getMidNode(head);
        LinkNode rightHead = leftTail.next;
        
        // Step 2: CUT THE LIST
        // This is crucial! We break the link to make two independent lists.
        leftTail.next = null; 

        // Step 3: Recurse
        // Note: You must capture the returned 'new' heads
        LinkNode left = sortList(head);
        LinkNode right = sortList(rightHead);

        // Step 4: Merge
        return merge(left, right);
    }

    public static LinkNode merge(LinkNode list1, LinkNode list2) {
        LinkNode head = new LinkNode(); // Dummy node
        LinkNode tail = head;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return head.next;
    }

    // Modified to return the END of the first half (Node before mid)
    public static LinkNode getMidNode(LinkNode head) {
        LinkNode slow = head;
        // Important: Fast starts at head.next to ensure slow stops 
        // one step BEFORE the actual middle for even-sized lists.
        LinkNode fast = head.next; 
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // Creating 4 -> 3 -> 2 -> 1
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2, node1);
        LinkNode node3 = new LinkNode(3, node2);
        LinkNode node4 = new LinkNode(4, node3); // Head is 4

        System.out.println("Before:");
        print(node4);

        LinkNode sortedHead = sortList(node4);
        
        System.out.println("After:");
        print(sortedHead);
    }

    public static void print(LinkNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}