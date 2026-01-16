# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def sortList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        if(head == None or head.next == None):
            return head
        
        leftTail = self.getMidNode(head)
        rightHead = leftTail.next
        leftTail.next = None
        Left = self.sortList(head)
        Right = self.sortList(rightHead)
        return self.merge(Left, Right)

    def merge(self, List1, List2):
        head = ListNode()
        tail = head
        while(List1 != None and List2 != None):
            if(List1.val < List2.val):
                tail.next = List1
                List1 = List1.next
            else:
                tail.next = List2
                List2 = List2.next
            tail = tail.next
        tail.next = List1 if List1 != None else List2
        return head.next 

    
    def getMidNode(self, head):
        slow = head
        fast = head.next
        while(fast != None and fast.next != None):
            slow = slow.next
            fast = fast.next.next
        return slow
    
# Helper to print
def print_list(node):
    while node:
        print(f"{node.val} -> ", end="")
        node = node.next
    print("None")

if __name__ == "__main__":
    # Test with an unsorted list: 3 -> 2 -> 1
    node1 = ListNode(3)
    node2 = ListNode(2, node1)  
    node3 = ListNode(1, node2)  
    head = node3
    
    print("Before Sorting:")
    print_list(head)

    # 1. Create the instance
    sol = Solution()
    
    # 2. Capture the NEW head (Crucial!)
    sorted_head = sol.sortList(head)

    print("After Sorting:")
    # 3. Print the new head, not the old variable
    print_list(sorted_head)
