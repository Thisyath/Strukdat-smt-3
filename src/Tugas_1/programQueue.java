package Tugas_1;

import java.util.Scanner;

public class programQueue{
    private final String[] data;
    private int front;
    private int rear;
    private int count;
    private final int maxSize;

    public programQueue(int size) {
        this.maxSize = size;
        this.data = new String[maxSize];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == maxSize;
    }

    public void enqueue(String item){
        if (isFull()){
            System.out.println("ERROR:Queue is Full");
        } else {
            rear = (rear + 1) % maxSize;
            data[rear] = item;
            count++;
        }
    }

    public String dequeue(){
        if (isFull()){
            return null;
        } else {
            String temp = data[front];
            front = (front + 1) % maxSize;
            count--;
            return temp;
        } 
    }
    
    public void display(){
        if (isEmpty()){
            System.out.println("Queue kosong");
        } else{
            System.out.println("Queue: [");
            int index = front;
            for (int i = 0; i < count; i++){
                System.out.print(data[index]);
                if (i < count - 1) System.out.print(",");
                index = (index +1) %maxSize;
            }
            System.out.println("]");
        } 
    }

    public void swap() {
        if (count < 2) {
            System.out.println("ERROR: Perlu minimal 2 elemen!");
        } else {
            int firstIndex = front;
            int secondIndex = (front + 1) % maxSize;
            
            String temp = data[firstIndex];
            data[firstIndex] = data[secondIndex];
            data[secondIndex] = temp;
            System.out.println("Swap berhasil!");
        }
    }

     public static void main(String[] args) {
        programQueue queue = new programQueue(10);
        Scanner input = new Scanner(System.in);
        int pilihan;
        
        do {
            System.out.println("\n--- PROGRAM QUEUE MANUAL ---");
            System.out.println("1. Dequeue saat queue kosong");
            System.out.println("2. Enqueue elemen");
            System.out.println("3. Dequeue elemen");
            System.out.println("4. Swap 2 elemen depan");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            
            switch(pilihan) {
                case 1:
                    if(queue.isEmpty()) {
                        System.out.println("ERROR: Queue kosong!");
                    } else {
                        System.out.println("Queue tidak kosong:");
                        queue.display();
                    }
                    break;
                    
                case 2:
                    System.out.print("Masukkan elemen: ");
                    String elemen = input.next();
                    queue.enqueue(elemen);
                    queue.display();
                    break;
                    
                case 3:
                    String hasil = queue.dequeue();
                    if(hasil == null) {
                        System.out.println("ERROR: Queue kosong!");
                    } else {
                        System.out.println("Dequeue: " + hasil);
                        queue.display();
                    }
                    break;
                    
                case 4:
                    queue.swap();
                    queue.display();
                    break;
                    
                case 5:
                    System.out.println("Selesai!");
                    break;
                    
                default:
                    System.out.println("Pilihan salah!");
            }
        } while(pilihan != 5);
        
        input.close();
    }
}
