package org.apache.maven.archetypes.classes;

import org.apache.maven.archetypes.sort.strategySort.BusSortWithStrategy;
import org.apache.maven.archetypes.validators.BusValidator;
import java.util.InputMismatchException;

public class Bus extends AbstractModel<Bus> {
    static {
        sortWithStrategy = new BusSortWithStrategy();
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

    /** Созданиие объекта BusBuilder (при создании объекта Bus) **/
    public static BusBuilder newBusBuilder() {
        return new Bus().new BusBuilder();
    }

    /** Получение объекта BusBuilder на объекте Bus (для редактирования объекта Bus через BusBuilder **/
    public BusBuilder toBusBuilder() {
        return this.new BusBuilder();
    }
    @Override
    public String toString() {
        return "Bus - "
                + "route: " + route
                + ", model: " + model
                + ", mileage: " + mileage;
    }

    /** Для простоты визуального восприятия сравнение String полей реализовано как сравнение длин этих строк **/
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

        public BusBuilder setRoute(Integer route) throws InputMismatchException {
            Bus.this.route = BusValidator.busRouteValidate(route);
            return this;
        }

        public BusBuilder setModel(String model) {
            Bus.this.model = BusValidator.busModelValidate(model);
            return this;
        }

        public BusBuilder setMileage(Integer mileage) throws InputMismatchException {
            Bus.this.mileage = BusValidator.busMileageValidate(mileage);
            return this;
        }

        public Bus build() {
            return Bus.this;
        }
    }
}