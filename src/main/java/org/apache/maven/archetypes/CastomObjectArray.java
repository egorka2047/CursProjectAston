package org.apache.maven.archetypes;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.userinterface.FillStrategy.FillStrategy;
import org.apache.maven.archetypes.userinterface.FilllSelect;
import org.apache.maven.archetypes.writer.SortedDataWriter;
import org.apache.maven.archetypes.writer.UserDataWriter;
import org.apache.maven.archetypes.writer.WriteSearchResult;

import java.util.List;

public class CastomObjectArray {
    private List<? extends AbstractModel<?>> userObjectList;
    private List<? extends AbstractModel<?>> sortedObjectList;

    private final FillStrategy fillStrategy;

    public CastomObjectArray(){
        this.fillStrategy = (FillStrategy) new FilllSelect().startSelect();
    }

    public void fill(){
        fillStrategy.runCommand(userObjectList);
    }

    public void writeUserData(){
        new UserDataWriter().write(userObjectList);
    }

    public void writeSortedData(String sortName){
        new SortedDataWriter().write(sortedObjectList, sortName);
    }

    public void writeSearchResult(Integer foundIndex){
        new WriteSearchResult().write(sortedObjectList, foundIndex);
    }
}
