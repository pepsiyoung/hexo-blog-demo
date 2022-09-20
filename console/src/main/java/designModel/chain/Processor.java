package designModel.chain;

public interface Processor {

    Processor getNextProcessor();

    void process(String param);
}
