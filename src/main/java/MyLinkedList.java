public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Добавляет элементы в массив
     *
     * @param element элемент который добавляем в массив
     */
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Добавляет элементы в массив
     *
     * @param index индекс элемента который мы хотим удалить
     * @return возвращает массив с удаленным элементом по индексу
     */
    public void remove(T index) {
        if (head == null) return;

        if (head.data.equals(index)) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            size--;
            return;
        }

        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(index)) {
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    /**
     * Получает элемент массива по индексу
     *
     * @param index индекс элемента который мы хотим получить
     * @return возвращает элемент по индексу
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Изменяет элемент в массив по индексу
     *
     * @param index индекс элемента который мы хотим изменить
     */
    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }

    /**
     * Возвращает представление части массива между указанными индексами fromIndex (включительно) и toIndex (исключительно)
     *
     * @param fromIndex индекс элемента с которого мы хотим получить
     * @param toIndex индекс элемента по который мы хотим получить
     * @return возвращает список элементов по указанным индексам
     * @exception IndexOutOfBoundsException указывает что индекс находится вне диапазона
     */
    public MyLinkedList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }
        MyLinkedList<T> subList = new MyLinkedList<>();
        Node<T> current = head;
        for (int i = 0; i < fromIndex; i++) {
            current = current.next;
        }
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(current.data);
            current = current.next;
        }
        return subList;
    }

    /**
     * Получает размер списка
     */
    public int size() {
        return size;
    }
}
