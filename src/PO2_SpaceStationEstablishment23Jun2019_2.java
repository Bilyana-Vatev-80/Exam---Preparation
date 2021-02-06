import java.util.Scanner;

public class PO2_SpaceStationEstablishment23Jun2019_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        readTheMatrix(scanner,matrix,n,n);
        int playRow = getFirstRowSymbol('S',matrix);
        int playCol = getFirstColSymbol('S',playRow,matrix);

        boolean isInVoid = false;
        int power = 0;

        while (power < 50){
            String direction = scanner.nextLine();
            int currentPlayerRow = playRow;
            int currentPlayerCol = playCol;

            switch (direction){
                case "up":
                    currentPlayerRow -=1; //zashtoto se mestim na gore
                    break;
                case "down":
                    currentPlayerRow += 1;
                    break;
                case "left":
                     currentPlayerCol -= 1;
                    break;
                case "right":
                     currentPlayerCol += 1;
                    break;
            }
            //is in galaxy end //empty: -
            isInVoid = isInSpace(currentPlayerRow,currentPlayerCol,matrix.length);
            if(isInVoid){
                matrix[playRow][playCol] = '-';
                break;
            }
            char currentSymbol = matrix[currentPlayerRow][currentPlayerCol];
            if(currentSymbol == '-'){
                matrix[playRow][playCol] = '-';
                matrix[currentPlayerRow][currentPlayerCol] = 'S';
                playRow = currentPlayerRow;
                playCol = currentPlayerCol;
            } else if (Character.isDigit(currentSymbol)){   //start: digits
                matrix[playRow][playCol] = '-';
                matrix[currentPlayerRow][currentPlayerCol] = 'S';
                playRow = currentPlayerRow;
                playCol = currentPlayerCol;

                power += currentSymbol - 48; // zashoto vzima stoinosta ot asci tablicata
            } else if (currentSymbol == '0'){ //black holes:0
                matrix[playRow][playCol] = '-';
                matrix[currentPlayerRow][currentPlayerCol] = '-';

                playRow = getFirstRowSymbol('0',matrix) ;
                playCol = getFirstColSymbol('0',playRow ,matrix) ;

                matrix [playRow][playCol] = 'S';
            }
          if(isInVoid){
              System.out.println("Bad news, the spaceShip went to the void.");
          } else {
              System.out.println("Good news! Stephan succeeded in collecting enough star power!");
          }
            System.out.println("Star power collected: " + power);
          printMatrix(matrix);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char symbol : chars) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static boolean isInSpace(int playerRow, int playerCol, int length) {
        boolean isInSpace = playerRow < 0 || playerRow >= length || playerCol < 0 || playerCol >= length;
        return isInSpace ;

    }

    private static int getFirstColSymbol(char symbol, int row, char[][] matrix) {
        int index = -1;
        for (int col = 0; col < matrix.length; col++) {
            if(matrix[row][col] == symbol){
                index = col;
                break;
            }
        }
        return index;
    }

    private static int getFirstRowSymbol(char symbol, char[][] matrix) {
        int index = -1; //invalid index
        int length = matrix.length;

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                if(matrix[row][col] == symbol){
                    index = row;
                    break;
                }
            }
            if(index != -1){
                break;
            }
        }
        return index;
    }

    private static void readTheMatrix(Scanner scanner, char[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            char[] col = scanner.nextLine().toCharArray();
            matrix[row] = col;
        }
    }
}

