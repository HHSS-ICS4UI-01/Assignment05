/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yaol9270
 */
public class OrderedList {

    Node head;
    private int numItems;

    public OrderedList() {
        head = null;
        numItems = 0;
    }

    
    

    /**
     * add a number to the list
     * @param n the number
     */
    public void add(Node n) {
        if (numItems == 0) {
            n.setNext(head);
            head = n;
            n.getPrev();
                 
            System.out.println("first");
        } else {
            Node current = head;

            for (int i = 0; i < numItems-1; i++) {
                
                if(current.getNum()>n.getNum()){
                    break;
                }
                current = current.getNext();
                

            }
            //set the adding node's next node
            
            if(current.getNext()==null&&current.getNum() < n.getNum()){
                
                n.setPrev(current);
                n.setNext(null);
                current.setNext(n);
                System.out.println("end");
                
            }
            else if(current.getPrev()==null){
                
                n.setNext(current);
                n.setPrev(null);
                current.setPrev(n);
                head = n;
                System.out.println("start");
                
                
            }
            else{
                
                n.setPrev(current.getPrev());
                current.getPrev().setNext(n);
                n.setNext(current);
                current.setPrev(n);
                System.out.println("mid");
                
                
                
                
                
                
            }

            
            
        }
        //1 more item in list
        numItems++;
    }

    /**
     * Take a number away from the list
     * @param num the number
     */
    public void remove(int num) {
        Node current = head;
        for(int i = 0; i < numItems-1; i++){
            
            if(current.getNum()==num){
                break;
            }
            current=current.getNext();
        }
        
        
        if(current.getNext()==null){
                
                current.getPrev().setNext(null);
                
                
            }
            else if(current.getPrev()==null){
                
                current.getNext().setPrev(null);
                
                head = current.getNext();
                System.out.println("start");
                
                
            }
            else{
                
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
                
                System.out.println("mid");
                
                
                
                
                
                
            }
        
        
        //since I removed a number, the total number of items -1
        numItems--;
    }

    /**
     * the size of the list
     * @return the number of items on the list
     */
    public int size() {
        return numItems;
    }

    /**
     * if there are 0 items in the list
     * @return if the list is empty
     */
    public boolean isEmpty() {
        if(size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Get the number at the position in the index
     * @param index the position
     * @return the number at the position
     */
    public int get(int index) {
        Node n = head;
        for(int i = 0; i < index; i++){
            n = n.getNext();
        }
        return n.getNum();
    }
    
    /**
     * print everything out
     */
    public void printList(){
        Node n = head;
        while(n != null){
            System.out.println(n.getNum());
            n = n.getNext();
        }

    }
}
