import java.util.Scanner;

public class programStack {
    public String[] data;
    public int top;
    private final int maxSize;

    public programStack(int size) {
        this.maxSize = size;
        this.data = new String[maxSize];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(String value) {
        if (!isFull()) {
            data[++top] = value;
        } else {
            System.out.println("Stack is full");
        }
    }

    public String pop() {
        if (!isEmpty()) {
            return data[top--];
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(data[i]);
            }
        }
    }

    public void swap() {
        if (top < 1) {
            System.out.println("Not enough elements to swap");
        } else {
            String temp = data[top];
            data[top] = data[top - 1];
            data[top - 1] = temp;
            System.out.println("Top two elements swapped");
        }
    }

    public static void main(String[] args) {
        programStack stack = new programStack(10);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do{
            System.out.println("\nMenu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Swap Top Two Elements");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    String value = scanner.nextLine();
                    stack.push(value);
                    break;
                case 2:
                    String poppedValue = stack.pop();
                    if (poppedValue != null) {
                        System.out.println("Popped: " + poppedValue);
                    }
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    stack.swap();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
