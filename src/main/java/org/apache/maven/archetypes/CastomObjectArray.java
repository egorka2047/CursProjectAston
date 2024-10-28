package org.apache.maven.archetypes;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.search.InputSearchObj;
import org.apache.maven.archetypes.search.universalsearch.BinarySearch;
import org.apache.maven.archetypes.sort.NaturalSort;
import org.apache.maven.archetypes.userinterface.FillStrategy.FillStrategy;
import org.apache.maven.archetypes.userinterface.FilllSelect;
import org.apache.maven.archetypes.userinterface.SortSelect;
import org.apache.maven.archetypes.writer.SortedDataWriter;
import org.apache.maven.archetypes.writer.UserDataWriter;
import org.apache.maven.archetypes.writer.WriteSearchResult;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class CastomObjectArray {
    private final List<AbstractModel> userObjectList = new ArrayList<>();
    private final List<AbstractModel> sortedObjectList = new ArrayList<>();
    private Integer lastFoundObj;
    private String sortStrategyName = "Не отсортирован";

    public int getLastFoundObj() {
        return lastFoundObj;
    }

    public void setSortStrategyName(String sortStrategyName){
        this.sortStrategyName = sortStrategyName;
    }

    public String getSortStrategyName() {
        return sortStrategyName;
    }

    private  FillStrategy fillStrategy;


    public void fill(){
        userObjectList.clear();
        sortedObjectList.clear();
        lastFoundObj = null;
        sortStrategyName = "Не отсортирован";
        this.fillStrategy = (FillStrategy) new FilllSelect().startSelect();
        fillStrategy.runCommand(userObjectList);
    }

    public void writeUserData(){
        new UserDataWriter().write(userObjectList);
    }

    public void writeSortedData(){
        if (this.sortStrategyName.equals("Не отсортирован")) {
            System.out.println("Исходный массив ещё не отсортирован !");
            this.sort();
        }
        new SortedDataWriter().write(sortedObjectList, this.sortStrategyName);
    }

    public void writeSearchResult(){
        if (this.lastFoundObj != null && this.sortStrategyName.equals("Классическая сортировка выбором")) {
            new WriteSearchResult().write(sortedObjectList, this.lastFoundObj);
        }
        else if (this.lastFoundObj != null && !this.sortStrategyName.equals("Классическая сортировка выбором")) {
            System.out.println("Был записан последний найденный объект, но для этого массив был отсортирован в натуральном порядке!");
            this.sortStrategyName = "Классическая сортировка выбором";
            NaturalSort.sort(sortedObjectList);
            new WriteSearchResult().write(sortedObjectList, this.lastFoundObj);
        }
        else{
            System.out.println("Для начала выполните поиск элемента!");
            this.search();
        }
    }

    public void sort(){
        if(userObjectList.isEmpty()){
            System.out.println("Массив данных пуст!\nСперва выполните ввод данных!");
            return;
        }
        sortedObjectList.clear();
        sortedObjectList.addAll(userObjectList);
        SortSelect.startSelect(sortedObjectList, this);
        System.out.println("Массив успешно отсортирован.");
    }

    public boolean search(){
        if(userObjectList.isEmpty()){
            System.out.println("Массив данных пуст!\nСперва выполните ввод данных!");
            return false;
        }
        Integer foundInd;
        if (this.sortStrategyName.equals("Классическая сортировка выбором")){
            foundInd=  BinarySearch.binarySearch(sortedObjectList, InputSearchObj.input(sortedObjectList));
        }
        else{
            System.out.println("Для бинарного поиска массив был принудительно отсортирован в натуральном порядке");
            this.sortStrategyName = "Классическая сортировка выбором";
            sortedObjectList.clear();
            sortedObjectList.addAll(userObjectList);
            NaturalSort.sort(sortedObjectList);
            foundInd=  BinarySearch.binarySearch(sortedObjectList, InputSearchObj.input(sortedObjectList));
        }
        if (foundInd == -1) System.out.print("Искомый объект не найден !\n");
        for(int i = 0; i < sortedObjectList.size(); i++){
            System.out.print(String.format("%d) ", i+1));
            System.out.print(sortedObjectList.get(i).toString());

            if (i == foundInd){
                System.out.print("  <============== Искомый объект ============");
            }
            System.out.print("\n");
        }
        this.lastFoundObj = foundInd;
        return true;
    }
}
