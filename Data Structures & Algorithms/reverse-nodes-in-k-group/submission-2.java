/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public int len(ListNode head){
        int counter = 0;
        while(head != null){
            counter++;
            head = head.next;
        }
        return counter;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = len(head);
        int groups = n/k;
        ListNode prevHead = null;
        ListNode currHead = head;
        ListNode ansNode = null;
        for(int i=0; i<groups; i++){
            ListNode prev = null;
            ListNode curr = currHead;
            ListNode nextNode = null;
            // Reverse 
            for(int j=0; j<k; j++){
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            if(prevHead == null){
                ansNode = prev;
            }else{
                prevHead.next = prev;
            }
            prevHead = currHead;
            currHead = curr;
        }
        // Link the last incomplete group and if last group was complete
        // currHead would be null
        prevHead.next = currHead;
        return ansNode;
    }
}
