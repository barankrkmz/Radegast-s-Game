//Baran Korkmaz
//Student no: 2021400090
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Reading the text file and adding all lines as string into to a "tempLines" arraylist.
        String fileName = "input3.txt";
        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);
        ArrayList<String> tempLines = new ArrayList<>();
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (inputFile.hasNextLine()) {
                tempLines.add(inputFile.nextLine());
            } else {
                break;
            }
        }
        inputFile.close();

        // Setting the row and column number.
        int row = 0;
        int column = 0;
        for(int i = 0; i<1; i++){
            String[] row_column = tempLines.get(i).split(" ");
            row = Integer.parseInt(row_column[1]);
            column = Integer.parseInt(row_column[0]);
        }


        //Creating a terrain ArrayList that contains all the terrain with each of the row as an ArrayList.
        ArrayList<ArrayList<Integer>> terrain = new ArrayList<>();
        for(int i = 1; i<row+1; i++){
            String[] lineSplit = tempLines.get(i).split(" ");
            ArrayList<Integer> tempSplit = new ArrayList<>();
            for(int j = 0; j<lineSplit.length; j++){
                tempSplit.add(Integer.parseInt(lineSplit[j]));
            }
            terrain.add(tempSplit);
        }

        //Adding row numbers into rowNumbers ArrayList.
        ArrayList<Integer> rowNumbers = new ArrayList<>();
        for(int i = 0; i<row; i++){
            rowNumbers.add(i);
        }


        //All lowercase letters in an ArrayList.
        ArrayList<String> lowerCaseLetters = new ArrayList<>();
        for(int i = 0; i<26; i++){
            String character = String.valueOf(Character.toChars(i+97));
            lowerCaseLetters.add(character);
        }


        //Using the allCombinations method to get all possible column names.
        ArrayList<String> allPossibleColumnNames = allCombinations(lowerCaseLetters);



        //Getting all column names for terrain.
        ArrayList<String> columnNames = new ArrayList<>();
        for(int i = 0; i<column; i++){
            columnNames.add(allPossibleColumnNames.get(i));
        }




        //All valid movements list.
        ArrayList<String> valid = new ArrayList<>();
        for(int i = 0; i<columnNames.size(); i++){
            for(int j = 0; j<rowNumbers.size(); j++){
                String parseStr = Integer.toString(rowNumbers.get(j));
                String move = columnNames.get(i) + parseStr;
                valid.add(move);
            }
        }




        //Loop that gets 10 coordinates.
        int successfulMoves = 0;
        while(successfulMoves<=10){
            //Printing the terrain row by row
            if(successfulMoves==10){
                for(int i = 0; i<rowNumbers.size(); i++){
                    if ((i+"").length() > 1){
                        System.out.print(" ");
                    }else {
                        System.out.print("  ");
                    }
                    System.out.print(rowNumbers.get(i));
                    for(int j =0; j<terrain.get(i).size(); j++){
                        if(terrain.get(i).get(j)>=10){
                            if(j== terrain.get(i).size()-1){
                                System.out.print(" ");
                                System.out.println(terrain.get(i).get(j));
                            }else{
                                System.out.print(" ");
                                System.out.print(terrain.get(i).get(j));
                            }
                        }else{
                            if(j== terrain.get(i).size()-1){
                                System.out.print("  ");
                                System.out.println(terrain.get(i).get(j));
                            }else{
                                System.out.print("  ");
                                System.out.print(terrain.get(i).get(j));
                            }
                        }
                    }
                }
                System.out.print("   ");
                for(int i = 0;i<columnNames.size(); i++){
                    if(i<26){
                        if(i == columnNames.size()-1){
                            System.out.print("  ");
                            System.out.println(columnNames.get(i));
                        }else{
                            System.out.print("  ");
                            System.out.print(columnNames.get(i));
                        }
                    }else{
                        if(i == columnNames.size()-1){
                            System.out.print(" ");
                            System.out.println(columnNames.get(i));
                        }else{
                            System.out.print(" ");
                            System.out.print(columnNames.get(i));
                        }
                    }
                }
                System.out.println("---------------");
                break;
            }
            for(int i = 0; i<rowNumbers.size(); i++){
                if ((i+"").length() > 1){
                    System.out.print(" ");
                }else {
                    System.out.print("  ");
                }
                System.out.print(rowNumbers.get(i));
                for(int j =0; j<terrain.get(i).size(); j++){
                    if(terrain.get(i).get(j)>=10){
                        if(j== terrain.get(i).size()-1){
                            System.out.print(" ");
                            System.out.println(terrain.get(i).get(j));
                        }else{
                            System.out.print(" ");
                            System.out.print(terrain.get(i).get(j));
                        }
                    }else{
                        if(j== terrain.get(i).size()-1){
                            System.out.print("  ");
                            System.out.println(terrain.get(i).get(j));
                        }else{
                            System.out.print("  ");
                            System.out.print(terrain.get(i).get(j));
                        }
                    }
                }
            }
            System.out.print("   ");
            for(int i = 0;i<columnNames.size(); i++){
                if(i<26){
                    if(i == columnNames.size()-1){
                        System.out.print("  ");
                        System.out.println(columnNames.get(i));
                    }else{
                        System.out.print("  ");
                        System.out.print(columnNames.get(i));
                    }
                }else{
                    if(i == columnNames.size()-1){
                        System.out.print(" ");
                        System.out.println(columnNames.get(i));
                    }else{
                        System.out.print(" ");
                        System.out.print(columnNames.get(i));
                    }
                }
            }
            if(successfulMoves != 0){
                System.out.println("---------------");
            }
            System.out.println("Add stone " + (successfulMoves+1) + " / 10 to coordinate:");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            while(true){
                if(valid.contains(userInput)){
                    break;
                }else{
                    System.out.println("Not a valid step!");
                    System.out.println("Add stone " + (successfulMoves+1) + " / 10 to coordinate:");
                    userInput = scanner.nextLine();
                }
            }
            ArrayList<String> columnMoveLetters = new ArrayList<>();
            ArrayList<String> rowMoveDigitsAsLetters = new ArrayList<>();
            for(int i = 0; i<userInput.length(); i++){
                Boolean check = Character.isDigit(userInput.charAt(i));
                if(check){
                    rowMoveDigitsAsLetters.add(Character.toString(userInput.charAt(i)));
                }else{
                    columnMoveLetters.add(Character.toString(userInput.charAt(i)));
                }
            }
            String columnMove = String.join("",columnMoveLetters);
            String rowMoveString = String.join("",rowMoveDigitsAsLetters);
            int rowMove = Integer.parseInt(rowMoveString);


            int columnMoveIndex = columnNames.indexOf(columnMove);
            int rowMoveIndex = rowNumbers.indexOf(rowMove);

            int x = terrain.get(rowMoveIndex).get(columnMoveIndex);
            x+=1;
            terrain.get(rowMoveIndex).set(columnMoveIndex,x);

            successfulMoves+=1;
        }



        //terrain arrayList to terrain array.
        int[][] terrainAr = new int[rowNumbers.size()][columnNames.size()];
        for(int i = 0; i< terrain.size(); i++){
            for(int j = 0; j< terrain.get(i).size(); j++){
                terrainAr[i][j] = terrain.get(i).get(j);
            }
        }


        //directions for checking neighbor cells.
        int[][] directions = {{0,-1},{0,1},{-1,-1},{-1,0},{-1,1},{1,-1},{1,0},{1,1}};


        //using lakeCalculator method to calculate the lakes.
        ArrayList<ArrayList<int[]>> allPuddles = lakeCalculator(terrainAr);


        //finding lake depth.
        ArrayList<Integer> lakeDepth = new ArrayList<>();
        for (ArrayList<int[]> puddle : allPuddles){
            int min = 500000;
            for (int[] coord : puddle){
                int x = coord[0];
                int y = coord[1];
                for (int [] direction: directions){
                    int[] friend = {x+direction[0],y+direction[1]};
                    if(!isContains(puddle,friend)){
                        if (terrainAr[friend[0]][friend[1]]<= min){
                            min = terrainAr[friend[0]][friend[1]];
                        }
                    }
                }
            }
            lakeDepth.add(min);
        }


        //finding the final score.
        double score = 0;
        for (int i =0 ; i<allPuddles.size(); i++){
            double sum = 0;
            for (int[] coord : allPuddles.get(i)){
                sum += lakeDepth.get(i)-terrainAr[coord[0]][coord[1]];
            }
            score+= Math.sqrt(sum);
        }



        for (int i =0 ; i<allPuddles.size(); i++){
            for (int[] coord : allPuddles.get(i)){
                terrainAr[coord[0]][coord[1]] = -1*(i+1);
            }
        }


        //Printing the final terrain with lake labels.
        for(int i = 0; i<rowNumbers.size(); i++){
            if ((i+"").length() > 1){
                System.out.print(" ");
            }else {
                System.out.print("  ");
            }
            System.out.print(rowNumbers.get(i));
            for(int j =0; j<terrain.get(i).size(); j++){
                if (terrainAr[i][j] < 0){
                    int realValue = (-1*terrainAr[i][j]) -1;
                    if(realValue<26){
                        char first = (char) (realValue+65);
                        System.out.print("  "+first);
                    }else{
                        char first = (char) (realValue/26 +64);
                        char second = (char) (realValue%26 + 65 );
                        System.out.print(" " + first + second);
                    }
                }
                else if(terrain.get(i).get(j)>=10){
                    if(j== terrain.get(i).size()-1){
                        System.out.print(" ");
                        System.out.println(terrain.get(i).get(j));
                    }else{
                        System.out.print(" ");
                        System.out.print(terrain.get(i).get(j));
                    }
                }else{
                    if(j== terrain.get(i).size()-1){
                        System.out.print("  ");
                        System.out.println(terrain.get(i).get(j));
                    }else{
                        System.out.print("  ");
                        System.out.print(terrain.get(i).get(j));
                    }
                }
            }
        }
        System.out.print("   ");
        for(int i = 0;i<columnNames.size(); i++){
            if(i<26){
                if(i == columnNames.size()-1){
                    System.out.print("  ");
                    System.out.println(columnNames.get(i));
                }else{
                    System.out.print("  ");
                    System.out.print(columnNames.get(i));
                }
            }else{
                if(i == columnNames.size()-1){
                    System.out.print(" ");
                    System.out.println(columnNames.get(i));
                }else{
                    System.out.print(" ");
                    System.out.print(columnNames.get(i));
                }
            }
        }

        //Printing the final score.
        System.out.printf("Final score: %.2f", score);





















    }
    //Method to get all possible single-double column names.
    public static ArrayList<String> allCombinations(ArrayList<String> lowerCaseLetters){
        ArrayList<String> newComb = new ArrayList<>();
        for(String chr : lowerCaseLetters){
            newComb.add(chr);
        }
        for(int i = 0; i<lowerCaseLetters.size(); i++){
            for(int j = 0; j<lowerCaseLetters.size(); j++){
                String dual = lowerCaseLetters.get(i)+lowerCaseLetters.get(j);
                newComb.add(dual);
            }
        }
        return newComb;
    }

    //Method to check if an Arraylist of integer arrays contains an array of integers.
    public static boolean isContains(ArrayList<int[]> arrayList, int[] array){
        for(int[] i : arrayList){
            if(Arrays.equals(array,i)){
                return true;
            }
        }
        return false;
    }

    // Method to check if all elements of an Arraylist of int array contains another one.
    public static boolean isContainsAllElements(ArrayList<int[]> arrayOne, ArrayList<int[]> arrayTwo){
        for(int[] each : arrayTwo){
            if(!isContains(arrayOne,each)){
                return false;
            }
        }return true;
    }


    //The method that calculates the lakes.
    public static ArrayList<ArrayList<int[]>> lakeCalculator(int[][] terrainAr){
        int[][] directions = {{0,-1},{0,1},{-1,-1},{-1,0},{-1,1},{1,-1},{1,0},{1,1}};
        ArrayList<int[]> leakages = new ArrayList<>();
        ArrayList<ArrayList<int[]>> puddles = new ArrayList<>();
        ArrayList<int[]> allPuddles = new ArrayList<>();
        boolean isSeparate = true;
        for(int i = 1; i< terrainAr.length-1; i++){
            for(int j = 1; j<terrainAr[i].length-1; j++){
                ArrayList<int[]> puddleMember = new ArrayList<>();
                int[] coordinate = {i,j};
                if (!isContains(allPuddles,coordinate)) {
                    puddleMember.add(coordinate);
                    leakages.add(coordinate);
                }
                while(leakages.size()>0){
                    int[] current_coord = leakages.remove(0);
                    int x = current_coord[0];
                    int y = current_coord[1];
                    if(x == 0 || x == terrainAr.length-1 || y == 0 || y == terrainAr[0].length-1){
                        leakages.clear();
                        puddleMember.clear();
                        break;
                    }
                    for(int[] coor : directions){
                        if(terrainAr[i][j] >= terrainAr[current_coord[0]+coor[0]][current_coord[1]+coor[1]]){
                            int[] leak = {current_coord[0]+coor[0], current_coord[1]+coor[1]};
                            if(!isContains(puddleMember,leak)){
                                puddleMember.add(leak);
                                leakages.add(leak);
                            }
                        }
                    }
                }if (puddleMember.size() > 0){
                    ArrayList<int[]> copy_puddleMember = new ArrayList<>(puddleMember);
                    ArrayList<ArrayList<int[]>> copy_puddles = new ArrayList<>(puddles);
                    if(puddles.isEmpty()){
                        puddles.add(copy_puddleMember);
                        copy_puddles.add(copy_puddleMember);
                    }
                    isSeparate = true;
                    for(ArrayList<int[]> a: copy_puddles){
                        if(isContainsAllElements(a,puddleMember)){
                            isSeparate = false;
                            break;
                        }else if(isContainsAllElements(puddleMember,a)){
                            isSeparate = false;
                            puddles.remove(a);
                            puddles.add(copy_puddleMember);
                            break;
                        }
                    }
                    if (isSeparate){
                        puddles.add(copy_puddleMember);
                    }
                    allPuddles.addAll(copy_puddleMember);
                    puddleMember.clear();
                }

            }
        }
        return puddles;
    }
}