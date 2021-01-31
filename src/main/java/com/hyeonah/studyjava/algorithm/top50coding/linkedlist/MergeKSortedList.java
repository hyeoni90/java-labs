package com.hyeonah.studyjava.algorithm.top50coding.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hyeonahlee on 2020-12-19.
 *
 * hint) priorityQueue 이용
 *
 * input    1 > 4 > 5
 *          1 > 3 > 4
 *          2 > 6
 *
 * output  1 > 1 > 2 > 3 > 4 > 4 > 5 > 6
 */
public class MergeKSortedList {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        ListNode result = mergeKSortedList.mergeKLists(list);
        System.out.println("======");

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public ListNode mergeKLists(ListNode[] list) {
        // 1. 오름차순 소팅
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comp);
        ListNode resultNode = new ListNode(0); // dummy data
        ListNode copyNode = resultNode;

        // list 3개를 넣는다!
        for (ListNode node : list) {
            if(node != null) {
                queue.offer(node);
            }
        }

        // 2
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            copyNode.next = node;  // 소팅된 큐에 있는 node를 copyNode 넣는다
            copyNode = copyNode.next;

            if(node.next != null) {
                queue.offer(node.next); // 하나 빼고 다시 queue를 조정!
            }
        }
        return resultNode.next;     // dummy 0 값 이후로 쭈-욱 뽑는다
    }

    // 1) 기존 방식
//    Comparator<ListNode> Comp = new Comparator<>() {
//        @Override
//        public int compare(ListNode o1, ListNode o2) {
//            return o1.val - o2.val;
//        }
//    };

    // 2) 람다 방식
//    Comparator<ListNode> Comp = (o1, o2) -> o1.val - o2.val;

    // 3)
    Comparator<ListNode> Comp = Comparator.comparingInt(o -> o.val);
}
