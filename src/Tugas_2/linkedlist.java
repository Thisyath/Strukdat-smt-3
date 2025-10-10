package Tugas_2;

public class linkedlist {

    private Node head;

    // Inner class untuk node
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public linkedlist() {
        this.head = null;
    }

    // Method untuk menambah elemen di awal
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method untuk menambah elemen di akhir
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Method untuk menampilkan linked list
    public void display() {
        if (head == null) {
            System.out.println("LinkedList kosong");
            return;
        }

        Node current = head;
        System.out.print("LinkedList: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Method untuk mengkonversi ke array
    public int[] toArray() {
        if (head == null) {
            return new int[0];
        }

        // Hitung panjang list
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Konversi ke array
        int[] array = new int[length];
        current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }

        return array;
    }

    // Method untuk membuat LinkedList dari array
    public void fromArray(int[] array) {
        head = null; // Reset

        for (int value : array) {
            addLast(value);
        }
    }

    // Method untuk sorting LinkedList menggunakan bubble sort
    public void bubbleSort() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = head;

            while (current.next != null) {
                if (current.data > current.next.data) {
                    // Swap data
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    // Method untuk mendapatkan ukuran linked list
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Method untuk mengecek apakah list kosong
    public boolean isEmpty() {
        return head == null;
    }
}
