package designModel.observer;

import java.util.ArrayList;
import java.util.List;

public interface NewSubject {
    List<NewObserver> list = new ArrayList<>();

    default void register(NewObserver o) {
        list.add(o);
    }

    default void notify(String orderNo) {
        list.forEach(c -> c.notify(orderNo));
    }
}
