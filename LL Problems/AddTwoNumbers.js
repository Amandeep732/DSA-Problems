
/*
 problem number 2 on leetcode 
 topic = Linked list
 level = medium
*/

var addTwoNumbers = function(l1, l2) {
    let num1 = "";
    while (l1) {
        num1 = l1.val + num1; // prepend
        l1 = l1.next;
    }
    let cal1 = BigInt(num1);

    // Convert l2 to BigInt
    let num2 = "";
    while (l2) {
        num2 = l2.val + num2;
        l2 = l2.next;
    }
    let cal2 = BigInt(num2);

    // Add them
    let sum = (cal1 + cal2).toString();

    // Build new Linked List (reverse order)
    let dummy = new ListNode(0);
    let curr = dummy;
    for (let i = sum.length - 1; i >= 0; i--) {
        curr.next = new ListNode(Number(sum[i]));
        curr = curr.next;
    }

    return dummy.next; // new LL
};
