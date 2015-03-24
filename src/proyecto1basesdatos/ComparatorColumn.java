/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Al
 */
public class ComparatorColumn {
    
    Tabla myTable;
    ArrayList<Orders> orderBy;
    ArrayList<Tupla> toSort;
    int indexColumn;
    int typeToSort;
    ArrayList<Integer> indexSame;
    ArrayList<ArrayList<Tupla>> miTuplas;
    
    public ComparatorColumn(Tabla myTable, ArrayList<Orders> orderBy){
        this.myTable = myTable;
        this.orderBy = orderBy;
        indexSame = new ArrayList();
    }
    
    public void order(){  //------------>ESTE METODO SOLO LOS ORDENA DE FORMA ASCEDENTE PERO SOLO ES DE DARLE VUELTA CUANDO SEA DESCEDENTE Y YA :D    
        //Primero se copia toda la tabla a una nueva que sera en la que se trabaje
        Tabla tempTable = myTable;
        toSort = tempTable.tuplas;
        int low = 0;
        int high = toSort.size()-1;
        //Nombre de la columna que se debe arreglar de primero
        String columnWork = orderBy.get(0).column;
        //Se dan el typeSort y el indice de la columna
        indexColumn = tempTable.getIndiceColumna(columnWork);
        typeToSort = tempTable.columnas.get(indexColumn).tipo;
        quickSortTupla(toSort,low,high);
        //Se ve si hay mas orders a seguir
        if(orderBy.size()>=2){
            for(int i = 1; i<orderBy.size(); i++){
                lookForRepets(toSort);
                constructMiniTable();
                columnWork = orderBy.get(i).column;
                indexColumn = tempTable.getIndiceColumna(columnWork);
                typeToSort = tempTable.columnas.get(indexColumn).tipo;
                //Se recorren todas las secciones que necesitan ser reeordenas
                for(ArrayList<Tupla> mT : miTuplas){
                    int lowH = 0;
                    int highH = mT.size()-1;
                    quickSortTupla(mT,lowH,highH);
                    //Se sustituyen el mT en toSort
                    for(int j = 0; j<mT.size(); j++){
                        int toDo = indexSame.get(j);
                        toSort.set(toDo, mT.get(j));
                        indexSame.remove(j);
                    }
                }
                indexSame.clear();
            }
        }
    }
    
    public void lookForRepets(ArrayList<Tupla> toLook){
        if(indexSame != null){
            indexSame.clear();
        }
        for (int i = 0; i<toLook.size()-1; i++){
            Tupla compare1 = toLook.get(i);
            Tupla compare2 = toLook.get(i+1);
            int resultVal = giveNewOrder(typeToSort, compare1, compare2, indexColumn, "ASC");
            if (resultVal == 0){
                indexSame.add(i);
                indexSame.add(i+1);
            }
        }
    }
    
    public void constructMiniTable(){
        
        //Se recorren la lista los repetidos
        int num = 0;
        int indexB =0;
        int indexF = 0;
        ArrayList<Tupla> temp = new ArrayList();
        while (num < indexSame.size()){
            if(num == indexSame.size()-1){
                temp.add(toSort.get(num));
                miTuplas.add(temp);
                num++;
                continue;
            }
            if(temp.size() == 0){
                indexB = num;
            }
            if(indexSame.get(num)+1 == indexSame.get(num+1)){
                temp.add(toSort.get(num));
            }
            else
            {
                temp.add(toSort.get(num));
                miTuplas.add(temp);
                temp.clear();
                indexF = num;
            }
            num++;
        }
    }
    
    public void quickSortTupla(ArrayList<Tupla> toSort, int i, int j){
        
        if(toSort == null || toSort.size() == 0){
            return;
        }
        
        if(i >= j){
            return;
        }
        
        int indexLower = i;
        int indexHigher = j;
        int pivot = indexLower+(indexHigher-indexLower)/2;
        Tupla pivote = toSort.get(pivot);
        while(indexLower <= indexHigher){
            
            while(giveNewOrder(typeToSort, toSort.get(indexLower), pivote,indexColumn,"ASC") > 0){
                indexLower++;
            }
            
            while(giveNewOrder(typeToSort, pivote, toSort.get(indexHigher),indexColumn,"ASC")>0){
                indexHigher--;
            }
            if(indexLower<= indexHigher){
                Tupla temp = toSort.get(indexLower);
                toSort.set(indexLower, toSort.get(indexHigher));
                toSort.set(indexHigher, temp);
                indexLower++;
                indexHigher--;
            }  
        }
        if(i < indexHigher){
            quickSortTupla(toSort,i,indexHigher);
        }
        if(j > indexLower){
            quickSortTupla(toSort,indexLower,j);
        }
    }
    //Metodo que devuelve 1 si el orden si t1, t2 o -1 si t2,t1 o 0 si son iguales
    public int giveNewOrder(int typeToCompare, Tupla t1, Tupla t2, int numberColumnToGuide, String toFollow){
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
