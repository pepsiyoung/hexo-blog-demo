package designModel.chain;

public class ProcessorImpl1 extends AbstractProcessor {

    public ProcessorImpl1(Processor next) {
        super(next);
    }

    @Override
    public void process(String param) {
        System.out.println("processor 1 is processing:" + param);
        if (getNextProcessor() != null) {
            getNextProcessor().process(param);
        }
    }
}
