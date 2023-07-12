


import java.io.*; 
public class linklist1{
   public  Node head;
    public linklist1(){
        head = new Node(null , null);
    }




    public linklist1(linklist1[] array) {
    this.head = new Node(null , null);
        
    }
public void Binsert(String data){
    Node first = new Node(data);
    this.head = first;
}
public void Einsert(String data){
    Node last = new Node(data);
    Node cur = head;
    while(cur.next != null){
        cur = cur.next;
    }
    cur.next = last;
}
public void Minsert(int index, String data){
Node middle = new Node(data);
Node curr = head;
while(index>0 && curr.next != null){
curr = curr.next;
index--;
}
if(index!=0){
    System.out.println("Out of bound exceptions");
    System.exit(1);
}
middle.next = curr.next;
curr.next = middle; 
}
public void Fdelete(){
    // check is the linklist1 is empty
    if(head.next == null){
        System.out.println("Cannot remove item from empty list");
        System.exit(1);
    }
    head = head.next;
}
public void Ldelete(){
    if(head.next == null){
        System.out.println("Cannot remove item from empty list");
        System.exit(1);
    }
    Node cur = head;
    while(cur.next.next!= null){
        cur = cur.next;
    }
    cur.next = null;

}  
public void Mdelete(int index){
    Node cur = head;
    while (index >0&& cur.next.next != null){
        cur = cur.next;
        index -- ;
    }
    if (index >0){
        System.out.println("Delete failed index exceeds lst bounds !");
        return;
    }
    cur.next = cur.next.next;
}

public static void main(String[] args) {
linklist1[] arrayi = new linklist1[3];
linklist1  f1 = new linklist1(); 
arrayi[0] = f1;
arrayi[1] = new linklist1();
arrayi[2] = new linklist1();


f1.Binsert("car");
f1.Einsert("arc");
;// Binsert only one time 
f1.Einsert("place");
f1.Minsert(2, "apple");
arrayi[0] = f1;
arrayi[1].Binsert("mango");
arrayi[2].Binsert("banana");
arrayi[2].Einsert("helpme");
quickSort(arrayi,0,3-1);
for(int i=0; i<arrayi.length;i++){
    arrayi[i].printList();}
}

public void printList(){
Node  cur = this.head; 
while(cur!=null){
    System.out.print(cur.data + " ");
    
    cur = cur.next;
}
System.out.println();
}

public int lenghtOfList(){
    Node  cur = this.head;
    int count = 0 ;
    while(cur!=null){
        count++;
        
        cur = cur.next;
    }

    return count;
}
 
public void insertionSort() {
    Node curr = head;
while(curr.next!=null){
    curr = curr.next;
    Node insert = this.head;
    while(insert != curr){
        if(curr.data.compareTo(insert.data) <0){
            String temp = curr.data ;
            curr.data = insert.data;
            insert.data = temp;
            insert = insert.next;

        }
    else{
        insert = insert.next;
    }

    }
}
}
public static int partition(linklist1 array[], int lb, int ub){
String pivot = array[lb].head.data;
int start = lb;
int end = ub;
while(start <end){
    while(array[start].head.data.compareTo(pivot)<=0){
        start++;
    }
    while(array[end].head.data.compareTo(pivot)>0){
        end--;
    }
    if(start < end){
        linklist1 temp = array[start];
        array[start] = array[end];
        array[end] = temp; 
        
    }
}
linklist1 temp = array[lb];
        array[lb] = array[end];
        array[end] = temp; 

return end;
}

public static void swap(linklist1 curr, linklist1 end){
linklist1 temp = curr;
curr = end;
end = temp;
}

public static void quickSort(linklist1[] array,int lb,int ub){
    if(lb <ub){
    int loc = partition(array, lb, ub); 
    quickSort(array,lb, loc-1);
    quickSort(array,loc+1,ub);

    }
}


   




public void printListToText(String outputfile){
    Node  cur = this.head; 
    StringBuilder T  = new StringBuilder();
    while(cur!=null){
       T= T.append(cur.data + " ");
        
        cur = cur.next;
    }
   T= T.append("\n");      
    try{
            FileWriter writer = new FileWriter(outputfile);
            writer.write("THE LIST OF ANAGRAM");
            writer.write(String.valueOf(T));
            
        writer.write("\n");
        writer.close(); 
    }
    
    catch(IOException e){
        e.printStackTrace();
    }
}

}


