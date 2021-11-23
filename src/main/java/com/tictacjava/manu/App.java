package com.tictacjava.manu;

// Original:
// Youtube Channel: Alex Lee
// Tic Tac Toe Java Game - Build a Tic Tac Toe Game in 30 Minutes
// https://www.youtube.com/watch?v=gQb3dE-y1S4
// Author: https://github.com/Ma-Nu-El/home

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' },
                               { '-', '+', '-', '+', '-' },
                               { ' ', '|', ' ', '|', ' ' },
                               { '-', '+', '-', '+', '-' },
                               { ' ', '|', ' ', '|', ' ' }
        };

    // core
    while(true) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your placement (1-9):");
        int playerPosition = scan.nextInt();
        while (playerPositions.contains(playerPosition) || cpuPositions.contains(playerPositions)) {
            System.out.println("Position taken! Enter an empty slot:");
            playerPosition = scan.nextInt();
        }

        placePiece(gameBoard, playerPosition, "player");
        String result = checkWinner();
        result = checkWinner();
        if (result.length() > 0) {
            System.out.println(result);
            break;
        }

        Random rand = new Random();
        int cpuPosition = rand.nextInt(9) + 1;
        while (playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPositions)) {
            cpuPosition = rand.nextInt(9) + 1;
        }

        placePiece(gameBoard, cpuPosition, "cpu");

        printGameBoard(gameBoard);

        result = checkWinner();
        if (result.length() > 0) {
            System.out.println(result);
            break;
        }

    }

    }

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    // print gameBoard
    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int position, String user) {

        char symbol = ' ';

        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(position);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(position);
        }

        switch (position) {
        case 1:
            gameBoard[0][0] = symbol;
            break;
        case 2:
            gameBoard[0][2] = symbol;
            break;
        case 3:
            gameBoard[0][4] = symbol;
            break;
        case 4:
            gameBoard[2][0] = symbol;
            break;
        case 5:
            gameBoard[2][2] = symbol;
            break;
        case 6:
            gameBoard[2][4] = symbol;
            break;
        case 7:
            gameBoard[4][0] = symbol;
            break;
        case 8:
            gameBoard[4][2] = symbol;
            break;
        case 9:
            gameBoard[4][4] = symbol;
            break;
        default:
            break;
        }
    }

    public static String checkWinner() {

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

        List lefCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rigCol = Arrays.asList(3, 6, 9);

        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);

        winning.add(lefCol);
        winning.add(midCol);
        winning.add(rigCol);

        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (playerPositions.containsAll(l)) {
                return "Congratulations you won!";
            } else if (cpuPositions.containsAll(l)) {
                return "CPU wins";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "CAT!";
            }

        }

        return "";
    }
}
