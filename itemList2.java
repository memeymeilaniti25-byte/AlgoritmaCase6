import java.util.Scanner;
import java.util.Queue;      
import java.util.LinkedList; 

public class itemList2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<ItemList> itemList = new LinkedList<ItemList>();

        String jawab;
        do {
            System.out.print("No Barang: ");
            String no=input.nextLine();
            System.out.print("Nama Barang: ");
            String item=input.nextLine();
            System.out.print("Harga Barang: ");
            int price=input.nextInt();
            
            input.nextLine(); 
            
            System.out.print("Jumlah Barang: ");
            int qty=input.nextInt();
            
            itemList.offer(new ItemList(no, item, price, qty)); 
            
            input.nextLine(); 
            System.out.print("Apakah ingin menambah barang (iya/tidak): ");
            jawab=input.nextLine();
        } while(jawab.equalsIgnoreCase("iya"));

        System.out.println("No\tItem\tPrice\tQty\tSubtotal");
        System.out.println("---------------------------------------------");
        
        int total=0;
        for (ItemList x : itemList) {
            System.out.println(x.no + "\t" + x.item + "\t" + x.price + "\t" + x.qty + "\t" + x.subtotal);
            total += x.subtotal;
        }

        System.out.println("---------------------------------------------");
        System.out.println("Total\t\t\t\t" + total);
        input.close();
    }
}
