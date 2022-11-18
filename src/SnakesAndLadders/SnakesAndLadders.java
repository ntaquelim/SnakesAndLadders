package SnakesAndLadders;

public class SnakesAndLadders{

    String[][] matrix = new String[10][10];
    int playerStartPosition = 0;
    

    public int rollDice() {
                return (int)(Math.random() * 6) + 1;
            
    } 

    public String moveChar(int playerPosition){
        int diceNumber = rollDice();
        int i =0;
        int row = playerPosition/10;
        int column = playerPosition==0 ? 0:(playerPosition%10)-1;
        while(i<diceNumber){
            if(row == 9 && column == 9) return "Congrats, you won!";
            column++;
            if(column > 9) {
                column = 0;
                row +=1;
            }
            
            i++;
        }
        playerPosition += diceNumber;
        System.out.println(playerPosition);
        clearMatrix(matrix);
        matrix[row][column] = "[X]";
        System.out.println("X: " + row + " Y: " + column+1);
        printMatrix(matrix);
        playerStartPosition = playerPosition;
        return null;
    }

    public void clearMatrix (String[][] matrix){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                matrix[i][j] = "[ ]";
            }
        }
    }

    public void printMatrix (String[][] matrix){
        for(int i=0;i<10;i++){
            System.out.print("\n");
            for(int j=0;j<10;j++){
                System.out.print(matrix[i][j]);
            }
        }
    }
}