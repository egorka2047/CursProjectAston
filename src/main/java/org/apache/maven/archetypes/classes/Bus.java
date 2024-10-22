package org.apache.maven.archetypes.classes;

public class Bus implements AbstractModel<Bus>, Comparable<Bus> {
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

        public BusBuilder setRoute(Integer route) {
            Bus.this.route = route;
            return this;
        }

        public BusBuilder setModel(String model) {
            Bus.this.model = model;
            return this;
        }

        public BusBuilder setMileage(Integer mileage) {
            Bus.this.mileage = mileage;
            return this;
        }

        public Bus build() {
            return Bus.this;
        }
    }
}
