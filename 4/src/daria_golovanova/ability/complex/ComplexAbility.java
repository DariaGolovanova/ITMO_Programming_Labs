package daria_golovanova.ability.complex;

public interface ComplexAbility<T, R> {
//    Statistic statistic = Statistic.instance;
//    default void executeWithStatistic(T t, R r){
//        statistic.register();
//        execute(t, r);
//    }

    void execute(T t, R r);
}

