package test;

public class QueueEasy {
    private int[] queue;
    private int maxSize; // максимальное количество элементов в очереди
    private int nElem;  // текущее количество элементов в очереди
    private int front;
    private int rear;

    public int getFront() {
        return queue[front];
    }

    public int getRear() {
        return queue[rear];
    }
    public boolean isEmpty(){
        return (nElem == 0);
    }
    public boolean isFull(){
        return (nElem == maxSize);
    }
    public int getSize(){
        return nElem;
    }

    public QueueEasy(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        rear = -1;
        front = 0;
        nElem = 0;
    }

    public void insert(int elem) {
        if (rear == maxSize - 1) {  // циклический перенос
            rear = -1;
        }

        queue[++rear] = elem;  //вставка и увеличение Rear
        nElem++;  // увеличение количества элементов в очереди
    }

    public int remove() {
        int temp = queue[front++]; // получаем первый элемент из очереди

        if (front == maxSize) { // циклический перенос
            front = 0;
        }
        nElem--; // уменьшаем количество элементов в очереди
        return temp;
    }
}
class Test {

    public static void main(String[] args) {
        QueueEasy myQueue = new QueueEasy(5);

        myQueue.insert(10);
        myQueue.insert(20);
        myQueue.insert(30);
        myQueue.insert(40);
        myQueue.insert(50);

        myQueue.remove();
        myQueue.remove();
        myQueue.remove();

        myQueue.insert(60);

        while (!myQueue.isEmpty()) {
            int n = myQueue.remove();
            System.out.println("Elem: " + n);
        }
    }
}
