package designModel.chain;

public abstract class AbstractProcessor implements Processor {

    private final Processor next;

    public AbstractProcessor(Processor next) {
        this.next = next;
    }

    @Override
    public Processor getNextProcessor() {
        return next;
    }

    @Override
    public abstract void process(String param);
}
