package task1;

import java.util.NoSuchElementException;

public class Workplace<T extends Person> {
    T[] arrayT;

    private MyCollectionIterator collection;

    public Workplace(T[] array) {
        this.arrayT = array;
        this.collection = new MyCollectionIterator(array);
    }

    public void start() {
        for (int i = 0; i < arrayT.length; i++) {
            arrayT[i].doWork();
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
