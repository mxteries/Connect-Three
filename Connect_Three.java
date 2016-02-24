package boolean_labs;
import java.util.Scanner;

/**
 * David Shen
 * 10/26/15
 * "Connect Four" (three) according to the specifications outlined in the summer assignment
 * NOW with LOOPS!
 */
 
public class Connect_Three {

	public static void main(String[] args) {
	
		System.out.println("Player 1 uses piece \"O\", and Player 2 uses piece \"X\"");
		System.out.println("Please be logical and don't play columns are already filled");
		System.out.println("And for the love of god don't enter a column number that doesn't even exist");
		System.out.println(drawBoard("     ", "     ", "     ", "     ", "     ")); //these strings represent the columns
		System.out.println("Player 1 begins; type the column you wish to play"); 
		makeMove("     ", "     ", "     ", "     ", "     "); 
	}
	
	public static void makeMove(String column1, String column2, String column3, String column4, String column5){
	
		Scanner placeGamePiece = new Scanner(System.in);
		boolean spotOccupied = true;
		boolean winnerFound = false;
		int columnNum = 0; //which column did the user pick
		int columnIndex = 0; //the position of a character in the column (used to loop through a column string)
		int freeSpot = -1; //the index of a space within a column - used to see if theres a spot available
		int moveCount = 1; //number of moves - max is 25
		int playerNum = 0; //who is playing the game
		int rowSpot = 0; //WHERE on the ROW is the piece being placed (in terms of substring)
		
		while (!winnerFound){ //when there is no winner, progress through the game
			columnIndex = 4;
			columnNum = placeGamePiece.nextInt();
			rowSpot = columnNum - 1;
			spotOccupied = true;
			if ((moveCount % 2) == 0){ //player 1 moves on odd turns, player 2 moves on even turns
				playerNum = 2;
			}
			else{
				playerNum = 1;
			}
			if ((playerNum) == 2){ //player two moves
				if (columnNum == 1){
					while (spotOccupied){ //go through each spot in a column to see if there is a piece there. infinite loop if user picks a filled column
						if (column1.substring(columnIndex, columnIndex + 1).equals(" ")){ 
							spotOccupied = false;
							freeSpot = columnIndex; //if the index has nothing (has a space), that index is assigned to var. freeSpot
						}
						columnIndex--;
					}
					column1 = column1.substring(0, freeSpot) + "X" + column1.substring(freeSpot + 1); //puts a piece in the aforementioned freeSpot
				}
				else if (columnNum == 2){
					while (spotOccupied){
						if (column2.substring(columnIndex, columnIndex + 1).equals(" ")){ 
							spotOccupied = false;
							freeSpot = columnIndex;
						}
						columnIndex--;
					}
					column2 = column2.substring(0, freeSpot) + "X" + column2.substring(freeSpot + 1);
				}
				else if (columnNum == 3){
					while (spotOccupied){
						if (column3.substring(columnIndex, columnIndex + 1).equals(" ")){ 
							spotOccupied = false;
							freeSpot = columnIndex;
						}
						columnIndex--;
					}
					column3 = column3.substring(0, freeSpot) + "X" + column3.substring(freeSpot + 1);
				}
				else if (columnNum == 4){
					while (spotOccupied){
						if (column4.substring(columnIndex, columnIndex + 1).equals(" ")){ 
							spotOccupied = false;
							freeSpot = columnIndex;
						}
						columnIndex--;
					}
					column4 = column4.substring(0, freeSpot) + "X" + column4.substring(freeSpot + 1);
				}
				else if (columnNum == 5){
					while (spotOccupied){
						if (column5.substring(columnIndex, columnIndex + 1).equals(" ")){ 
							spotOccupied = false;
							freeSpot = columnIndex;
						}
						columnIndex--;
					}
					column5 = column5.substring(0, freeSpot) + "X" + column5.substring(freeSpot + 1);
				}
				
			} 
			else { //player one moves
				if (columnNum == 1){
					while (spotOccupied){ //go through each spot in a column to see if there is a piece there
						if (column1.substring(columnIndex, columnIndex + 1).equals(" ")){ 
							spotOccupied = false;
							freeSpot = columnIndex; //if the index has nothing (has a space), that index is assigned to var. freeSpot
						}
						columnIndex--;
					}
					column1 = column1.substring(0, freeSpot) + "O" + column1.substring(freeSpot + 1); //puts a piece in the aforementioned freeSpot
				}
				else if (columnNum == 2){
					while (spotOccupied){
						if (column2.substring(columnIndex, columnIndex + 1).equals(" ")){ 
							spotOccupied = false;
							freeSpot = columnIndex;
						}
						columnIndex--;
					}
					column2 = column2.substring(0, freeSpot) + "O" + column2.substring(freeSpot + 1);
				}
				else if (columnNum == 3){
					while (spotOccupied){
						if (column3.substring(columnIndex, columnIndex + 1).equals(" ")){ 
							spotOccupied = false;
							freeSpot = columnIndex;
						}
						columnIndex--;
					}
					column3 = column3.substring(0, freeSpot) + "O" + column3.substring(freeSpot + 1);
				}
				else if (columnNum == 4){
					while (spotOccupied){
						if (column4.substring(columnIndex, columnIndex + 1).equals(" ")){ 
							spotOccupied = false;
							freeSpot = columnIndex;
						}
						columnIndex--;
					}
					column4 = column4.substring(0, freeSpot) + "O" + column4.substring(freeSpot + 1);
				}
				else if (columnNum == 5){
					while (spotOccupied){
						if (column5.substring(columnIndex, columnIndex + 1).equals(" ")){ 
							spotOccupied = false;
							freeSpot = columnIndex;
						}
						columnIndex--;
					}
					column5 = column5.substring(0, freeSpot) + "O" + column5.substring(freeSpot + 1);
				}
				
			}
			
			String board = drawBoard(column1, column2, column3, column4, column5); //after the columns are determined every turn, the rows are drawn
			if (moveCount < 5){ //in the first 4 moves, it is impossible to have a winner
				System.out.println(board + "\n" + "Next player please make your move");
				
			}
			else if (moveCount == 25){
				System.out.println(board + "\nStalemate. Restart program to play again");
		}
			else if (!(checkWinner(columnNum, freeSpot + 1, rowSpot, playerNum, column1, column2, column3, column4, column5, freeSpot)) && moveCount <= 25){
				//if no one wins, and there are still moves left (moveCount <= 25), then go on to the next move
				System.out.println(board + "\n" + "Next player please make your move");
				 
				}
			else if (checkWinner(columnNum, freeSpot + 1, rowSpot, playerNum, column1, column2, column3, column4, column5, freeSpot)){
					System.out.println((board + "\n"));
					System.out.println("Congratulations Player " + playerNum + ", you win! Restart program to play again");
					 
					winnerFound = true;
			}
			
			moveCount++;
		}
	}
	public static String drawBoard(String firstColumn, String secondColumn, String thirdColumn, String fourthColumn, String fifthColumn){
	//ROW1 is the ROW on TOP, row5 on the bottom, etc.
		String columnLabels = "\n  1   2   3   4   5"; 
		String boardRow1 = "|_" + firstColumn.substring(0, 1) + "_|" + "_" + secondColumn.substring(0, 1) + "_|" + "_" + thirdColumn.substring(0, 1) + "_|" + "_" + fourthColumn.substring(0, 1) + "_|" + "_" + fifthColumn.substring(0, 1) + "_|"; 
		String boardRow2 = "|_" + firstColumn.substring(1, 2) + "_|" + "_" + secondColumn.substring(1, 2) + "_|" + "_" + thirdColumn.substring(1, 2) + "_|" + "_" + fourthColumn.substring(1, 2) + "_|" + "_" + fifthColumn.substring(1, 2) + "_|";
		String boardRow3 = "|_" + firstColumn.substring(2, 3) + "_|" + "_" + secondColumn.substring(2, 3) + "_|" + "_" + thirdColumn.substring(2, 3) + "_|" + "_" + fourthColumn.substring(2, 3) + "_|" + "_" + fifthColumn.substring(2, 3) + "_|";
		String boardRow4 = "|_" + firstColumn.substring(3, 4) + "_|" + "_" + secondColumn.substring(3, 4) + "_|" + "_" + thirdColumn.substring(3, 4) + "_|" + "_" + fourthColumn.substring(3, 4) + "_|" + "_" + fifthColumn.substring(3, 4) + "_|";
		String boardRow5 = "|_" + firstColumn.substring(4, 5) + "_|" + "_" + secondColumn.substring(4, 5) + "_|" + "_" + thirdColumn.substring(4, 5) + "_|" + "_" + fourthColumn.substring(4, 5) + "_|" + "_" + fifthColumn.substring(4, 5) + "_|";
		return (columnLabels + "\n" + boardRow1 + "\n" + boardRow2 + "\n" +  boardRow3 + "\n" + boardRow4 + "\n" + boardRow5 + "\n");
	}
	
	public static boolean checkWinner(int columnNum, int rowNumber, int rowPosition, int playerNum, String row1, String row2, String row3, String row4, String row5, int columnPosition){ 
		
		if (checkHorizontal(columnNum, rowNumber, rowPosition, playerNum, row1, row2, row3, row4, row5) || checkVertical(columnNum, columnPosition, playerNum,row1, row2, row3, row4, row5)){
			return true;
		}
		return false;	
		
	} 

	public static boolean checkHorizontal(int columnNum, int rowNumber, int rowPosition, int playerNum, String columnOne, String columnTwo, String columnThree, String columnFour, String columnFive){	
	
		//rowNumber = freeSpot + 1!!
		boolean winnerFound = false;
		String row1 = columnOne.substring(0,1) + columnTwo.substring(0,1) + columnThree.substring(0,1) + columnFour.substring(0,1) + columnFive.substring(0,1);
		String row2 = columnOne.substring(1,2) + columnTwo.substring(1,2) + columnThree.substring(1,2) + columnFour.substring(1,2) + columnFive.substring(1,2);
		String row3 = columnOne.substring(2,3) + columnTwo.substring(2,3) + columnThree.substring(2,3) + columnFour.substring(2,3) + columnFive.substring(2,3);
		String row4 = columnOne.substring(3,4) + columnTwo.substring(3,4) + columnThree.substring(3,4) + columnFour.substring(3,4) + columnFive.substring(3,4); 
		String row5 = columnOne.substring(4,5) + columnTwo.substring(4,5) + columnThree.substring(4,5) + columnFour.substring(4,5) + columnFive.substring(4,5);
		
		if (rowNumber == 5){
			winnerFound = (goRight(playerNum, rowPosition, 0, row5) || goLeft(playerNum, rowPosition, 0, row5));
		}
		else if (rowNumber == 4){
			winnerFound = (goRight(playerNum, rowPosition, 0, row4) || goLeft(playerNum, rowPosition, 0, row4));
		}
		else if (rowNumber == 3){
			winnerFound = (goRight(playerNum, rowPosition, 0, row3) || goLeft(playerNum, rowPosition, 0, row3));
		}
		else if (rowNumber == 2){
			winnerFound = (goRight(playerNum, rowPosition, 0, row2) || goLeft(playerNum, rowPosition, 0, row2));
		}
		else if (rowNumber == 1){
			winnerFound = (goRight(playerNum, rowPosition, 0, row1) || goLeft(playerNum, rowPosition, 0, row1));
		}
		return winnerFound;
	}
	public static boolean checkVertical(int columnNum, int columnPosition, int playerNum, String columnA, String columnB, String columnC, String columnD, String columnE){
		boolean foundWinner = false;
		if (columnNum == 5){
			foundWinner = (goRight(playerNum, columnPosition, 0, columnE) || goLeft(playerNum, columnPosition, 0, columnE));
		}
		else if (columnNum == 4){
			foundWinner = (goRight(playerNum, columnPosition, 0, columnD) || goLeft(playerNum, columnPosition, 0, columnD));
		}
		else if (columnNum == 3){
			foundWinner = (goRight(playerNum, columnPosition, 0, columnC) || goLeft(playerNum, columnPosition, 0, columnC));
		}
		else if (columnNum == 2){
			foundWinner = (goRight(playerNum, columnPosition, 0, columnB) || goLeft(playerNum, columnPosition, 0, columnB));
		}
		else if (columnNum == 1){
			foundWinner = (goRight(playerNum, columnPosition, 0, columnA) || goLeft(playerNum, columnPosition, 0, columnA));
		}
		return foundWinner;
	}	
	
	public static boolean goRight(int playerNum, int index, int counter, String line ){ //takes in any string and loops to the right to find three in a row. The loop stops if no match is made
		if (playerNum == 1){
			while (index < line.length() && line.substring(index, index + 1).equals("O")){
				counter++;
				index++; //the index of the string increases = moves from left to right
			}
		}
		else{ //playerNum == 2
			while (index < line.length() && line.substring(index, index + 1).equals("X")){
				counter++;
				index++;
			}
		}
		if (counter >= 3){ // for every match, counter adds one. if the counter reaches 3 (3 in a row) then the corresponding player has won.
			return true;
		}
		return false;
	}
	public static boolean goLeft(int playerNum, int index, int counter, String line){
		if (playerNum == 1){
			while (index >= 0 && line.substring(index, index + 1).equals("O")){
				counter++;
				index--; //the index of the string decreases = moves from right to left
			}
		}
		else{ //playerNum == 2
			while (index >= 0 && line.substring(index, index + 1).equals("X")){
				counter++;
				index--;
			}
		}
		if (counter >= 3){ // for every match, counter adds one. if the counter reaches 3 (3 in a row) then the corresponding player has won.
			return true;
		}
		return false;
	}
}
