package org.apache.maven.archetypes.userinterface.FillStrategy;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.classes.Bus;
import org.apache.maven.archetypes.classes.Student;
import org.apache.maven.archetypes.classes.User;
import org.apache.maven.archetypes.fillingAnArray.RandomArrayFilling;
import org.apache.maven.archetypes.userinterface.FillStrategy.ManualInput.ManualBusInput;
import org.apache.maven.archetypes.userinterface.FillStrategy.ManualInput.ManualStudentInput;
import org.apache.maven.archetypes.userinterface.FillStrategy.ManualInput.ManualUserInput;

import java.util.List;

public class ManualFill extends FillStrategy{

    public ManualFill() {
        super("Ручной ввод данных", 1);
    }

    @Override
    public void runCommand(List<? super AbstractModel> list) {
        Integer objType;
        while(true){
            System.out.println("Список каких объектов хотите создать ?\n" +
                    "1) Bus\n" +
                    "2) Student\n" +
                    "3) User\n");
            objType = UserInputInt.validUserInput();
            if (List.of(1,2,3).contains(objType)) break;
            else System.out.println("Указанного номера объекта не существует, пожалуйста, повторите ввод");
        }

        switch (objType){
            case 1:
                ManualBusInput.input(list);
                break;
            case 2:
                ManualStudentInput.input(list);
                break;
            case 3:
                ManualUserInput.input(list);
                break;
        }

    }
}
