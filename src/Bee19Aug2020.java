import java.util.Scanner;

public class Bee19Aug2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int      n     = Integer.parseInt (scanner.nextLine ());
        char[][] field = new char[n][n];

        for (int i = 0; i < field.length; i++) {
            field[i] = scanner.nextLine ().toCharArray ();
        }

        boolean isLost            = false;
        int     pollinatedFlowers = 0;

        int beeRow = 0;
        int beeCol = 0;

        int bonusRow = 0;
        int bonusCol = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'B') {
                    beeRow = i;
                    beeCol = j;
                }
                if (field[i][j] == 'O') {
                    bonusRow = i;
                    bonusCol = j;
                }
            }
        }

        String command = scanner.nextLine ();
//"up", "down", "left", "right", "End
        while ( !"End".equals (command)) {

            switch (command) {
                case "up":
                    moveTheBee (field, beeRow, beeCol);
                    beeRow -= 1;
                    if (inTheField (beeRow, beeCol, field)) {
                        if (field[beeRow][beeCol] == 'f') {
                            pollinatedFlowers++;
                            field[beeRow][beeCol] = 'B';
                        } else if (field[beeRow][beeCol] == 'O') {
                            moveTheBee (field, beeRow, beeCol);
                            beeRow -= 1;
                            if (!inTheField (beeRow, beeCol, field)) {
                                System.out.println ("The bee got lost!");
                                isLost = true;
                                break;
                            } else {
                                if (field[beeRow][beeCol] == 'f') {
                                    pollinatedFlowers++;
                                }
                                field[beeRow][beeCol] = 'B';
                            }

                        } else {
                            field[beeRow][beeCol] = 'B';
                        }

                    } else {
                        System.out.println ("The bee got lost!");
                        isLost = true;
                        break;
                    }
                    break;
                case "down":
                    moveTheBee (field, beeRow, beeCol);
                    beeRow += 1;
                    if (inTheField (beeRow, beeCol, field)) {
                        if (field[beeRow][beeCol] == 'f') {
                            pollinatedFlowers++;
                            field[beeRow][beeCol] = 'B';
                        } else if (field[beeRow][beeCol] == 'O') {
                            moveTheBee (field, beeRow, beeCol);
                            beeRow += 1;
                            if (!inTheField (beeRow, beeCol, field)) {
                                System.out.println ("The bee got lost!");
                                isLost = true;
                                break;
                            } else {
                                if (field[beeRow][beeCol] == 'f') {
                                    pollinatedFlowers++;
                                }
                                field[beeRow][beeCol] = 'B';
                            }

                        } else {
                            field[beeRow][beeCol] = 'B';
                        }

                    } else {
                        System.out.println ("The bee got lost!");
                        isLost = true;

                    }
                    break;
                case "left":
                    moveTheBee (field, beeRow, beeCol);
                    beeCol -= 1;
                    if (inTheField (beeRow, beeCol, field)) {
                        if (field[beeRow][beeCol] == 'f') {
                            pollinatedFlowers++;
                            field[beeRow][beeCol] = 'B';
                        } else if (field[beeRow][beeCol] == 'O') {
                            moveTheBee (field, beeRow, beeCol);
                            beeCol -= 1;
                            if (!inTheField (beeRow, beeCol, field)) {
                                System.out.println ("The bee got lost!");
                                isLost = true;

                            } else {
                                if (field[beeRow][beeCol] == 'f') {
                                    pollinatedFlowers++;
                                }
                                field[beeRow][beeCol] = 'B';
                            }

                        } else {
                            field[beeRow][beeCol] = 'B';
                        }

                    } else {
                        System.out.println ("The bee got lost!");
                        isLost = true;
                    }
                    break;
                case "right":
                    moveTheBee (field, beeRow, beeCol);
                    beeCol += 1;
                    if (inTheField (beeRow, beeCol, field)) {
                        if (field[beeRow][beeCol] == 'f') {
                            pollinatedFlowers++;
                            field[beeRow][beeCol] = 'B';
                        } else if (field[beeRow][beeCol] == 'O') {
                            moveTheBee (field, beeRow, beeCol);
                            beeCol += 1;
                            if (!inTheField (beeRow, beeCol, field)) {
                                System.out.println ("The bee got lost!");
                                isLost = true;
                                break;
                            } else {
                                if (field[beeRow][beeCol] == 'f') {
                                    pollinatedFlowers++;
                                }
                                field[beeRow][beeCol] = 'B';
                            }

                        } else {
                            field[beeRow][beeCol] = 'B';
                        }

                    } else {
                        System.out.println ("The bee got lost!");
                        isLost = true;

                    }
                    break;
            }

            if (isLost) {
                break;
            }
            command = scanner.nextLine ();
        }
        if (pollinatedFlowers >= 5) {
            System.out.printf ("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf ("The bee couldn't pollinate the flowers, she needed %d flowers more%n", (5 - pollinatedFlowers));
        }
        for (
                int i = 0;
                i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print (field[i][j]);
            }
            System.out.println ();
        }

    }


    private static
    void moveTheBee (char[][] field, int i, int j) {
        field[i][j] = '.';
    }


    private static
    boolean inTheField (int beeRow, int beeCol, char[][] field) {
        return beeRow >= 0 && beeRow < field.length && beeCol >= 0 && beeCol < field[beeRow].length;
    }
}


