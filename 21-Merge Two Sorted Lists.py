# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        # list the special cases
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        
        # dummy define the head of the new list. it is fixed, cannot move forward
        dummy = ListNode(0)
        # use newlist to move forware link each node
        newlist = dummy 
        
        while l1 and l2:
            if l1.val <= l2.val:
                newlist.next = l1
                l1 = l1.next
            else:
                newlist.next = l2
                l2 = l2.next
            # move the new node to next 
            newlist = newlist.next
            # print(newlist)
        newlist.next = l1 if l1 else l2

        return dummy.next
        
        