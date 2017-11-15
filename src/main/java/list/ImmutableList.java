package list;

import org.apache.log4j.Logger;

public class ImmutableList<K> {
    final static Logger logger = Logger.getLogger(ImmutableList.class);

    private Node head;
    private Node last;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImmutableList<?> that = (ImmutableList<?>) o;

        return head != null ? head.equals(that.head) : that.head == null;
    }

    @Override
    public int hashCode() {
        return head != null ? head.hashCode() : 0;
    }

    @Override

    public String toString() {
        return "ImmutableList{" +
                head +
                '}';
    }

    private ImmutableList() {

    }

    public ImmutableList(K... values) {
        for(K value : values) {
            add(value);
        }
    }

    public K head() {
        return head.value;
    }

    private void add(K value) {
        Node n = new Node(value);
        if(head == null) {
            head = n;
            last = n;
        } else {
            last.next = n;
            last = n;
        }
    }
    private void prepend(K value) {
        Node n = new Node(value);
        if(head == null) {
            head = n;
            last = n;
        } else {
            Node nxt=head;
            head=n;
            head.next=nxt;
        }
    }

    public ImmutableList tail() {
        if(head == null || head.next == null) {
            return new ImmutableList();
        }
        ImmutableList tail = new ImmutableList();
        Node n = head.next;
        while(n != null) {
            tail.add(n.value);
            n = n.next;
        }
        return tail;
    }
    public ImmutableList cons(K elem) {
        ImmutableList cons = new ImmutableList();
        cons.prepend(elem);
        Node n = head;
        while(n!=null){
            cons.add(n.value);
            n= n.next;
        }
        return cons;
    }
    public ImmutableList drop(int count) {
        ImmutableList drop = new ImmutableList();
        Node n=head;
        while(n != null) {
            if(count<=0)
            drop.add(n.value);
            n = n.next;
            count--;
        }
        return drop;
    }
    public ImmutableList reverse() {
        ImmutableList rev = new ImmutableList();
        Node n=head;
        while(n != null) {
            rev.prepend(n.value);
            n = n.next;
        }
        return rev;
    }


    public int size() {
        int size = 0;
        Node n = head;
        while(n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    public static void main(String[] args){
        System.out.println("hello world");
        logger.info("Hello World");
    }


    class Node {
        K value;
        Node next;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (value != null ? !value.equals(node.value) : node.value != null) return false;
            return next != null ? next.equals(node.next) : node.next == null;
        }

        @Override
        public int hashCode() {
            int result = value != null ? value.hashCode() : 0;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return next == null ? value.toString() : value.toString() + ", " + next;
        }

        Node(K value) {
            this.value = value;
            this.next = null;
        }
    }
}
