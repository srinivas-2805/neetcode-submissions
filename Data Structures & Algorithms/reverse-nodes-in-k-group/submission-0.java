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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1 || head==null){
            return head;
        }

        ListNode current=head;
        ListNode prev=null;

        while(true){

            // check whether k nodes are present
            ListNode check=current;
            int count=0;

            while(count<k && check!=null){
                check=check.next;
                count++;
            }

            if(count<k){
                break;
            }

            ListNode last=prev;
            ListNode newend=current;

            for(int i=0;i<k && current!=null;i++){
                ListNode nextnode=current.next;
                current.next=last;
                last=current;
                current=nextnode;
            }

            if(prev!=null){
                prev.next=last;
            }
            else{
                head=last;
            }

            newend.next=current;

            prev=newend;
        }

        return head;
    }
}