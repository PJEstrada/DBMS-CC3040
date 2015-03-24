/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.time.LocalDate;

/**
 *
 * @author Al
 */
public class ComparatorDB {
    int typeToCompare;
    /*
    0 = int
    1 = float
    2 = char
    3 = date
    */
    Tupla t1;
    Tupla t2;
    int numberColumnToGuide;
    String toFollow;
    
    public ComparatorDB(int typeToCompare, Tupla t1, Tupla t2, int numberColumnToGuide, String toFollow){
        this.typeToCompare = typeToCompare;
        this.t1 = t1;
        this.t2 = t2;
        this.numberColumnToGuide = numberColumnToGuide;
        this.toFollow = toFollow;
    }
    
    //Metodo que devuelve 1 si el orden si t1, t2 o -1 si t2,t1 o 0 si son iguales
    public int giveNewOrder(){
        switch(typeToCompare){
            case(0):
                int compare1 = (int) t1.valores.get(numberColumnToGuide);
                int compare2 = (int) t2.valores.get(numberColumnToGuide);
                int result = compare1 - compare2;
                if (toFollow.equals("ASC")){
                    if(result > 0){
                        return -1;
                    }
                    else if(result < 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(toFollow.equals("DESC")){
                    if(result < 0){
                        return -1;
                    }
                    else if(result > 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                break;
            case (1):
                float compareF1 = (float) t1.valores.get(numberColumnToGuide);
                float compareF2 = (float) t2.valores.get(numberColumnToGuide);
                float resultF = compareF1 - compareF2;
                if (toFollow.equals("ASC")){
                    if(resultF > 0){
                        return -1;
                    }
                    else if(resultF < 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(toFollow.equals("DESC")){
                    if(resultF < 0){
                        return -1;
                    }
                    else if(resultF > 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                break;
            case (2):
                String compareS1 = (String) t1.valores.get(numberColumnToGuide);
                String compareS2 = (String) t2.valores.get(numberColumnToGuide);
                int resultS = compareS1.compareTo(compareS2);
                if (toFollow.equals("ASC")){
                    if(resultS > 0){
                        return -1;
                    }
                    else if(resultS < 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(toFollow.equals("DESC")){
                    if(resultS < 0){
                        return -1;
                    }
                    else if(resultS > 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                break;
            case(3):
                LocalDate compareD1 = (LocalDate) t1.valores.get(numberColumnToGuide);
                LocalDate compareD2 = (LocalDate) t2.valores.get(numberColumnToGuide);
                int resultD = compareD1.compareTo(compareD2);
                if (toFollow.equals("ASC")){
                    if(resultD > 0){
                        return -1;
                    }
                    else if(resultD < 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(toFollow.equals("DESC")){
                    if(resultD < 0){
                        return -1;
                    }
                    else if(resultD > 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                break;
            default:
                break;
        }
        return 1000000000;
    }
}
