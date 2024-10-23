package org.apache.maven.archetypes.classes;

import org.apache.maven.archetypes.sort.strategySort.BusSortWithStrategy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bus extends AbstractModel<Bus> {
    {
        this.sortWithStrategy = new BusSortWithStrategy();
    }
    private Integer route;
    private String model;
    private Integer mileage;
    private Bus() {
    }
    public Integer getRoute() {
        return route;
    }

    public String getModel() {
        return model;
    }
    public Integer getMileage() {
        return mileage;
    }

    public static BusBuilder newBusBuilder() {
        return new Bus().new BusBuilder();
    }

    public BusBuilder toBusBuilder() {
        return this.new BusBuilder();
    }

    /* Для простоты визуального восприятия сравнение String полей пока что реализовано как сравнение длин этих строк */

    @Override
    public String toString() {
        return "Bus - "
                + "route: " + route
                + ", model: " + model
                + ", mileage: " + mileage;
    }

    @Override
    public int compareTo(Bus o) {
        int result = this.route - o.route;
        if (result == 0)
            result = this.model.length() - o.model.length();
        if (result == 0)
            result = this.mileage - o.mileage;
        return result;
    }

    public class BusBuilder {
        private BusBuilder() {}

        /* Валидными являются номера маршрутов с 1 по 100 */
        /* Пробрасываемые исключения - ввод типов данных, отличных от Integer
        (м.б. обработать обычным информированием в консоль о том, что объект не создан (а он не будет создан) */
        public BusBuilder setRoute(Integer route) throws NumberFormatException, InputMismatchException {
            if (route >= 1 && route <= 100)
                Bus.this.route = route;
            else {
                System.out.println("The entered value does not satisfy the following conditions:\n"
                        + "Route number should be Integer value (from 1 to 100)\n"
                        + "------------------------------------------------------------\n"
                        + "Enter the correct route number manually:");
                setRoute(new Scanner(System.in).nextInt());
            }
            return this;

        }
        /* Предварительно валидными считаем любое введенное значение, состоящее из букв */
        public BusBuilder setModel(String model) {
            boolean flag = true;
            for (int i = 0; i < model.length(); i++) {
                if (!Character.isLetter(model.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                Bus.this.model = model;
            else {
                System.out.println("The entered value does not satisfy the following conditions:\n"
                        + "Model value should contains only letters\n"
                        + "------------------------------------------------------------\n"
                        + "Enter the correct model manually:");
                setModel(new Scanner(System.in).next());
            }
            return this;
        }
        /* Валидным является пробег от 1 по 1_000_000 */
        /* Пробрасываемые исключения - ввод типов данных, отличных от Integer
        (м.б. обработать обычным информированием в консоль о том, что объект не создан (а он не будет создан)*/
        public BusBuilder setMileage(Integer mileage) throws NumberFormatException, InputMismatchException {
            if (mileage >= 1 && mileage <= 1_000_000)
                Bus.this.mileage = mileage;
            else {
                System.out.println("The entered value does not satisfy the following conditions:\n"
                        + "Mileage should be Integer value (from 1 to 1_000_000)\n"
                        + "------------------------------------------------------------\n"
                        + "Enter the correct mileage value manually:");
                setMileage(new Scanner(System.in).nextInt());
            }
            return this;
        }

        public Bus build() {
            return Bus.this;
        }
    }
}
