package task_1_2_3;

public class GameWindow {
    private Settings settings;
    public GameWindow(){

        settings = new Settings(this);
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen){

        System.out.printf("Mode: %d; \nSize: x=%d, y=%d;\nWin Length: %d\n",
                mode, fSzX, fSzY, wLen);
    }
}
