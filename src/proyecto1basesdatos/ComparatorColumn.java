/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

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
    ArrayList<ArrayList<Integer>> indexSame;
    ArrayList<ArrayList<Tupla>> miTuplas;
    
    public ComparatorColumn(Tabla myTable, ArrayList<Orders> orderBy){
        this.myTable = myTable;
        this.orderBy = orderBy;
        indexSame = new ArrayList();
        miTuplas = new ArrayList();
        toSort = new ArrayList();
    }
    
    public void order(){  //------------>ESTE METODO SOLO LOS ORDENA DE FORMA ASCEDENTE PERO SOLO ES DE DARLE VUELTA CUANDO SEA DESCEDENTE Y YA :D    
        //Primero se copia toda la tabla a una nueva que sera en la que se trabaje
        Tabla tempTable = myTable;
        toSort = tempTable.tuplas;
        int low = 0;
        int high = toSort.size()-1;
        //Nombre de la columna que se debe arreglar de primero
        String columnWork = orderBy.get(0).column;
        String howToOrder = orderBy.get(0).order;
        //Se dan el typeSort y el indice de la columna
        indexColumn = tempTable.getIndiceColumna(columnWork);
        typeToSort = tempTable.columnas.get(indexColumn).tipo;
        quickSortTupla(toSort,low,high);
        if(howToOrder.equals("DESC")){
            Collections.reverse(toSort);
        }
        //Se ve si hay mas orders a seguir
        if(orderBy.size()>=2){
            for(int i = 1; i<orderBy.size(); i++){
                lookForRepets(toSort);
                constructMiniTable();
                columnWork = orderBy.get(i).column;
                howToOrder = orderBy.get(i).order;
                indexColumn = tempTable.getIndiceColumna(columnWork);
                typeToSort = tempTable.columnas.get(indexColumn).tipo;
                //Se recorren todas las secciones que necesitan ser reeordenas
                for(ArrayList<Tupla> mT : miTuplas){
                    int lowH = 0;
                    int highH = mT.size()-1;
                    quickSortTupla(mT,lowH,highH);
                    if(howToOrder.equals("DESC")){
                        Collections.reverse(mT);
                    }
                    //Se sustituyen el mT en toSort
                    for(int j = 0; j<mT.size(); j++){
                        int toDo = indexSame.get(0).get(j);
                        toSort.set(toDo, mT.get(j));
                        //indexSame.get(0).remove(j);
                    }
                    indexSame.remove(0);
                }
                indexSame = new ArrayList();
            }
        }
        myTable.tuplas = new ArrayList();
        myTable.tuplas.addAll(toSort);
    }
    
    
    public void lookForRepets(ArrayList<Tupla> toLook){
        if(indexSame != null){
            indexSame = new ArrayList();
        }
        ArrayList<Integer> temp = new ArrayList();
        for (int i = 0; i<toLook.size()-1; i++){
            Tupla compare1 = toLook.get(i);
            Tupla compare2 = toLook.get(i+1);
            int resultVal = giveNewOrder(typeToSort, compare1, compare2, indexColumn, "ASC");
            if (resultVal == 0){
                temp.add(i);
                temp.add(i+1);
            }
            else
            {
                if(temp.size()!=0){
                    indexSame.add(temp);
                    temp = new ArrayList();
                }
            }
        }
        if(!temp.isEmpty()){
            indexSame.add(temp);
        }
    }
    
    public void constructMiniTable(){
        
        //Se recorren la lista los repetidos
        int indexB =0;
        int indexF = 0;
        for(ArrayList<Integer> arrI : indexSame){
            ArrayList<Tupla> temp = new ArrayList();
            for(int num : arrI){
                temp.add(toSort.get(num));
            }
            miTuplas.add(temp);
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
                Integer compare1 = (Integer) t1.valores.get(numberColumnToGuide);
                Integer compare2 = (Integer) t2.valores.get(numberColumnToGuide);
                if(compare1 == null && compare2!=null)
                {
                    if(toFollow.equals("ASC")){
                        return 1;
                    }
                    else if(toFollow.equals("DESC")){
                        return -1;
                    }
                }
                else if(compare2 == null && compare1 != null){
                    if(toFollow.equals("ASC")){
                        return -1;
                    }
                    else if(toFollow.equals("DESC")){
                        return 1;
                    }
                }
                else if(compare2==null && compare1 == null){
                    return 0;
                }
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
                Float compareF1 = (Float) t1.valores.get(numberColumnToGuide);
                Float compareF2 = (Float) t2.valores.get(numberColumnToGuide);
                if(compareF1 == null && compareF2!=null)
                {
                    if(toFollow.equals("ASC")){
                        return 1;
                    }
                    else if(toFollow.equals("DESC")){
                        return -1;
                    }
                }
                else if(compareF2 == null && compareF1 != null){
                    if(toFollow.equals("ASC")){
                        return -1;
                    }
                    else if(toFollow.equals("DESC")){
                        return 1;
                    }
                }
                else if(compareF2==null && compareF1 == null){
                    return 0;
                }
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
                if(compareS1 == null && compareS2!=null)
                {
                    if(toFollow.equals("ASC")){
                        return 1;
                    }
                    else if(toFollow.equals("DESC")){
                        return -1;
                    }
                }
                else if(compareS2 == null && compareS1 != null){
                    if(toFollow.equals("ASC")){
                        return -1;
                    }
                    else if(toFollow.equals("DESC")){
                        return 1;
                    }
                }
                else if(compareS2==null && compareS1 == null){
                    return 0;
                }
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
                if(compareD1 == null && compareD2!=null)
                {
                    if(toFollow.equals("ASC")){
                        return 1;
                    }
                    else if(toFollow.equals("DESC")){
                        return -1;
                    }
                }
                else if(compareD2 == null && compareD1 != null){
                    if(toFollow.equals("ASC")){
                        return -1;
                    }
                    else if(toFollow.equals("DESC")){
                        return 1;
                    }
                }
                else if(compareD2==null && compareD1 == null){
                    return 0;
                }
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
