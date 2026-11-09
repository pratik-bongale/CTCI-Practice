package problems.ch2;

import problems.ch2.util.LinkedList;

public class LinkedListP8<E> {
    // given linkedlist detect the first node of loop if a loop exists

    LinkedList.Node<E> detectLoopStart(LinkedList<E> ll) {
        // first find if a loop exists (slow runner meets fast runner)
        // then place slow runner at head and find where slow runner meets fast runner
        // because they will be exactly k steps away from the start of loop

        LinkedList.Node<E> slowRunner = ll.getHead();
        LinkedList.Node<E> fastRunner = ll.getHead();

        // find their meeting point if there is a loop
        while(fastRunner.next != null && fastRunner.next.next != null) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;

            if(fastRunner == slowRunner) {
                break;
            }
        }

        // check if you reached the end of LL, no loop
        if(fastRunner.next == null || fastRunner.next.next == null)
            return null;

        slowRunner = ll.getHead();
        while(slowRunner != fastRunner) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }

        return fastRunner;
    }

}
