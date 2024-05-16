package andaeys.io.dstruct;

public class ELinkedList<E> {
    private class Node<E>{
        E element;
        Node<E> next;
        public Node(E e){this.element = e; this.next=null;}
    }

    Node<E> head;
    public ELinkedList() {this.head=null;}

    public void add(E e){
        Node<E> newNode = new Node<>(e);
        if (head==null){
            head = newNode;
        }else {
            Node<E> current = head;
            while (current.next!=null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void remove(E e){
        if(head==null) return;
        if(head.element.equals(e)){
            head = head.next;
            return;
        }
        Node<E> current = head;
        while (current.next!=null){
            if(current.next.element.equals(e)){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void display(){
        Node<E> node = head;
        while (node!=null){
            System.out.println(""+node.element);
            node = node.next;
        }
    }
}
