package task_1_2_3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {

    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 100;
    private  static  final String FIELD_SIZE_PREFIX = "Установленный размер поля: ";
    private  static  final int MIN_FIELD_SIZE = 3;
    private  static  final int MAX_FIELD_SIZE = 10;
    private  static  final String WIN_LENGTH_PREFIX = "Выберите длину для победы ";
    private JButton btnStart = new JButton("Start");
    private Map map;
    private JRadioButton pvc, pvp;
    private JSlider slideFileSize, slideWinLength;
    public  Settings(GameWindow gameWindow){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Settings");
        setResizable(true);

        setLayout(new GridLayout(10, 1));
        add(new JLabel("Выберите режим игры"));
        ButtonGroup bg = new ButtonGroup();
        pvc = new JRadioButton();
        pvp = new JRadioButton();
        bg.add(pvc);
        bg.add(pvp);
        add(pvc);
        add(pvp);
        add(new JLabel("Выберите размер поля: "));
        JLabel lbFileSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        add(lbFileSize);
        slideFileSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        add(slideFileSize);
        add(new JLabel("Установленный размер поля: "));
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_FIELD_SIZE);
        add(lbWinLength);
        slideWinLength = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        add(slideWinLength);
        add(btnStart);

        map = new Map(gameWindow, this);

        slideWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLength.getValue());
            }
        });

        slideFileSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFileSize.getValue();
                lbFileSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLength.setMaximum(currentValue);
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.btnStartDelegate();
            }
        });

        setVisible(true);
    }

    public JRadioButton getPvc() {
        return pvc;
    }

    public JRadioButton getPvp() {
        return pvp;
    }

    public JSlider getSlideFileSize() {
        return slideFileSize;
    }

    public JSlider getSlideWinLength() {
        return slideWinLength;
    }
}
