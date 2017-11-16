package list;
import java.util.Objects;
import java.util.Optional;

/**
 * Java implementation of the Immutable linked list.
 *
 * @author abhishekmaurya
 *
 * @param <K>
 */
public class ImmutableList<K> {

    private final Optional<K> head;
    private final ImmutableList<K> tail;

    public ImmutableList() {
        this.head = null;
        this.tail = null;
    }

    public ImmutableList(final K value) {
        this.head = Optional.ofNullable(value);
        this.tail = new ImmutableList<>();
    }

    public ImmutableList(final K value, final ImmutableList<K> tail) {
        if (tail == null) {
            throw new RuntimeException("Tail can't be null. Use another constructor.");
        }
        this.head = Optional.ofNullable(value);
        this.tail = tail;
    }

    public boolean isEmpty() {
        return head == null;
    }
    /**
     * Method to return the head element of the list.
     *
     * @return Head of the list.
     */

    public K head() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }
        return head.orElse(null);
    }

    /**
     * Method to return the tail of the list.
     *
     * @return Tail of the list.
     */

    public ImmutableList<K> tail() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }
        return tail;
    }

    /**
     * Method to return a new list with the given value added in the beginning.
     *
     * @param value
     *            Value to be added in the list
     * @return Another list with the given value added at the head.
     */

    public ImmutableList<K> cons(K value) {
        return new ImmutableList<>(value, this);
    }


    public static void main(String[] args){
        System.out.println("hello world");
    }

    /**
     * Method to return another list without first n elements of the original
     * list.
     *
     * @param n
     *            Number of elements not needed from the original list.
     * @return Another list without first 'n' elements of the original list.
     */

    public ImmutableList<K> drop(int n) {
        if (n < 0) {
            throw new RuntimeException("Invalid param for drop.");
        } else if (n == 0) {
            return this;
        }
        return tail().drop(n - 1);
    }

    /**
     * Method to return a new list having the elements in the reversed order.
     *
     * @return Another list containing the elements in the reversed order than
     *         the original one.
     */

    public ImmutableList<K> reverse() {
        return reverse(new ImmutableList<>());
    }

    private ImmutableList<K> reverse(ImmutableList<K> anotherList) {
        if (isEmpty()) {
            return anotherList;
        }
        return tail().reverse(anotherList.cons(head()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableList<?> that = (ImmutableList<?>) o;
        return Objects.equals(head, that.head) &&
                Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail);
    }
}
