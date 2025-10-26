import java.util.Scanner;
import java.util.Stack;

public class ItemList {
    String no;
    String item;
    int price, qty, subtotal;

    public ItemList(String no, String item, int price, int qty) {
        this.no = no;
        this.item = item;
        this.price = price;
        this.qty = qty;
        this.subtotal = price * qty;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<ItemList> itemStack = new Stack<ItemList>();

        String jawab;
        do {
            System.out.print("No Barang: ");
            String no = input.nextLine();

            System.out.print("Nama Barang: ");
            String item = input.nextLine();

            System.out.print("Harga Barang: ");
            int price = input.nextInt();
            
            System.out.print("Jumlah Barang: ");
            int qty = input.nextInt();
            input.nextLine();

            itemStack.push(new ItemList(no, item, price, qty));

            System.out.print("Apakah ingin menambah barang? (iya/tidak): ");
            jawab = input.nextLine();
        } while (jawab.equalsIgnoreCase("iya"));
        if (!itemStack.isEmpty()) {
            ItemList topItem = itemStack.peek();
            System.out.println("\n*** Item Teratas (PEEK) ***");
            System.out.printf("NO: %s\tITEM: %s\tHARGA: %d\tQTY: %d\tSUBTOTAL: %d\n", 
                                topItem.no, topItem.item, topItem.price, topItem.qty, topItem.subtotal);
            System.out.println("Stack size setelah PEEK: " + itemStack.size());
        }

        System.out.println("\n----------------- Daftar Belanja (Pop-Out) -----------------");
        System.out.println("NO\tITEM\tPRICE\tQTY\tSUBTOTAL");
        System.out.println("------------------------------------------------------------");

        int total = 0;
        while (!itemStack.isEmpty()) {
            ItemList x = itemStack.pop();
            System.out.printf("%s\t%s\t%d\t%d\t%d\n", 
                                x.no, x.item, x.price, x.qty, x.subtotal);
            total += x.subtotal;
        }
        
        System.out.println("------------------------------------------------------------");
        System.out.printf("Total\t\t\t\t\t%d\n", total);
        System.out.println("Stack size setelah POP semua: " + itemStack.size());
        
        input.close();
    }
}
