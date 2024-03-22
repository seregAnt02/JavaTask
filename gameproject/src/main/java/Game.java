

import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Game {
    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static char[][] field;
    private static int SIZE_X = 0;
    private static int SIZE_Y = 0;

    public static void main(String[] args) {
        initialize();
        printField();
        while(true) {
            humanTurn();
            printField();
            if (gameCheck(DOT_HUMAN, "You won!"))
                break;

            aiTurn();
            printField();
            if (gameCheck(DOT_AI, "Computer won!"))
                break;
        }
    }

    private static void initialize(){
        SIZE_X = WIN_COUNT;
        SIZE_Y = WIN_COUNT;

        field = new char[SIZE_X][SIZE_Y];
        for(int x = 0; x < SIZE_X; x++){
            for(int y = 0; y < SIZE_Y; y++){
                field[x][y] = DOT_EMPTY;
            }
        }

        patternAdd();
    }

    private  static  void patternAdd(){
        int count = 0;
        while(count == 0 || !(WIN_COUNT == count)) {
            patternCounts.add(0);
            count++;
        }
    }
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < SIZE_X * 2 + 1; i++){
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < SIZE_X; i++){
            System.out.print(i + 1 + "|");

            for (int j = 0; j <  SIZE_Y; j++)
                System.out.print(field[i][j] + "|");

            System.out.println();
        }

        for (int i = 0; i < SIZE_X * 2 + 2; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter the coordinates Х и Y  (1 to 3) space separated: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while(!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    private static boolean isCellValid(int x, int y){
        return x >= 0 && x < SIZE_X
                && y >= 0 && y < SIZE_Y;
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(SIZE_X);
            y = RANDOM.nextInt(SIZE_Y);
        } while(!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    private static boolean gameCheck(char symbol, String message){
        if(checkWin(symbol)){
            System.out.println(message);
            return true;
        }
        if(checkDraw()){
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    private static boolean checkDraw() {
        for(int x = 0; x < SIZE_X; x++){
            for(int y = 0; y < SIZE_Y; y++){
               if(isCellEmpty(x, y)) return false;
            }
        }

        return true;
    }
    static private List<Integer> patternCounts = new ArrayList();
    private static boolean checkWin(char symbol) {
        int countDiagonal = 0;
        for (int i = 0; i < field.length; i++){
            int countHorizontal = 0, countVertical = 0;
            for (int j = 0; j < field[i].length; j++){
                // Проверка по трем горизонталям
                if(field[i][j] == symbol) countHorizontal++;
                if(field[i].length  == countHorizontal) return  true;
                // Проверка по трем вертикалям
                if(field[j][i] == symbol){
                    countVertical++;
                }
                if(field[j].length == countVertical){
                    return true;
                }
            }
            //  Проверка по диагоналям
            if(field[i][i] == symbol || field[i][field.length - i - 1] == symbol ) countDiagonal++;
            if(field[i].length == countDiagonal) return true;
        }
        return false;
    }
}
