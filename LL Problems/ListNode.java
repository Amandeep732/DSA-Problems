public class ListNode {
   int val;
   ListNode next;

   ListNode() {
   }

   ListNode(int val) {
      this.val = val;
   }

   ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
   }
}

class Merge_Nodes_in_Between_Zeros {
   public ListNode mergeNodes(ListNode head) {
      ListNode left = head;
      int val = 0;
      boolean isTrue = true;
      ListNode dummy = new ListNode(0);
      ListNode curr = dummy;
      ListNode right = head;
      ;
      while (right != null) {
         while (left.val != 0 && isTrue) {
            left = left.next;
         }
         if (isTrue) {
            right = left.next;
         }
         while (right.val != 0) {
            val += right.val;
            right = right.next;
         }
         if (right.val == 0) {
            curr.next = new ListNode(val); // create fresh node with sum
            curr = curr.next; // move curr
            val = 0;
            left = right;
            right = right.next;
            isTrue = false;
         }
      }
      return dummy.next;
   }
}