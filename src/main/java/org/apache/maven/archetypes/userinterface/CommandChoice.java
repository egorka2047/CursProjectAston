package org.apache.maven.archetypes.userinterface;

import org.apache.maven.archetypes.userinterface.FillStrategy.Selectable;
import org.apache.maven.archetypes.userinterface.FillStrategy.UserInputInt;

import java.util.List;
import java.util.Optional;

public interface CommandChoice {
    static public Selectable choice(List<? extends Selectable> selectableList){
        while(true){
            Integer userInput = UserInputInt.validUserInput();
            Optional<? extends Selectable> commandOpt = selectableList.stream()
                    .filter(el -> el.getComandNumber()
                            .equals(userInput))
                    .findFirst();
            if (commandOpt.isPresent()) return commandOpt.get();
            else System.out.printf("Команды под номером %d не существует, пожалуйста, повторите ввод\n", userInput);
        }
    }
}
