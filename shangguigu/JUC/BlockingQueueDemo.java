package code.shangguigu.JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列：
 * 1、阻塞队列有没有好的一面
 * 2、不得不阻塞，如何进行管理
 */
public class BlockingQueueDemo {
    /**
     * 1 当队列为空的时候，获取元素操作会被阻塞
     * 2 当队列满的时候，添加元素的操作会被阻塞
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue<Integer>(10);
        for (int i = 0; i < 3; i++) {
          //  blockingQueue.add(i);
            blockingQueue.offer(i);
        }
       /* blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();*/
        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll();
        System.out.println(blockingQueue.poll());
    }
}
