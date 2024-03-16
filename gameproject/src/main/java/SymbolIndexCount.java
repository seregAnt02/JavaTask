import lombok.Getter;
import lombok.Setter;

public class SymbolIndexCount {
    @Setter
    @Getter
    char symbol;

    @Setter
    @Getter
    int index;

    @Setter
    @Getter
    int count;

    public SymbolIndexCount(char symbol, int index, int count){
        this.symbol = symbol;
        this.index = index;
        this.count = count;
    }
}
