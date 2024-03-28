package task_1_2_3;

import javax.swing.*;

public class Map extends JPanel {

    public static int MODE_HVA = 0;
    public static int MODE_HVH = 1;

    private  GameWindow gameWindow;
    private Settings settings;

    public Map(GameWindow gameWindow, Settings settings){
        this.gameWindow = gameWindow;
        this.settings = settings;
    }
    public void btnStartDelegate(){

        int gameMode = 0;
        if(settings.getPvc().isSelected()){
            gameMode = Map.MODE_HVA;
        } else if (settings.getPvp().isSelected()) {
            gameMode = Map.MODE_HVH;
        } else {
            throw new RuntimeException("UnkNown game mode");
        }
        gameWindow.startNewGame(gameMode ,settings.getSlideFileSize().getValue(),
                settings.getSlideFileSize().getValue(), settings.getSlideWinLength().getValue());

    }
}
