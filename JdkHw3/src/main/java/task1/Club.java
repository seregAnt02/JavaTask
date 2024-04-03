package task1;

import java.util.NoSuchElementException;

public class Club<T extends Person> {
    T[] array;
    private MyCollectionIterator collection;
    public Club(T[] array) {
        this.array = array;
        this.collection = new MyCollectionIterator(array);
    }

    public void start() {
        for (int i = 0; i < array.length; i++) {
            array[i].haveRest();
        }
    }

    public void showCollection(){
        while (collection.hasNext()) {
            System.out.println(collection.next());
        }
    }

    private class MyCollectionIterator<T> {
        private T[] array;
        private int currentIndex = 0;

        public MyCollectionIterator(T[] array) {
            this.array = array;
        }

        public boolean hasNext() {
            if (currentIndex < array.length && array[currentIndex] != null) {
                return true;
            }
            return false;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return array[currentIndex++];
        }
    }
}
