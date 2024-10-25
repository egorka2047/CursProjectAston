package org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ObjBuilderFromString;

public interface ObjBuildFromString<ObjType> {
    ObjType buildObj(String obj);

    String getObjClass();
}
