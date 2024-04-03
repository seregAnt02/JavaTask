package task1.test;

public class GBox<T> {
    private T value;
    GBox(T value){
        this.value = value;
    }

    public void showType() {
        System.out.printf("Type is %s, with value %s \r\n", getValue().getClass().getName(), getValue() );
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
