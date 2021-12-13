package basic.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Java SPI
 * 在resources/META-INF/services/下建接口全限定名的文件 basic.spi.Search
 */
public class SPIDemo {
    public static void main(String[] args) {
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = s.iterator();
        while (iterator.hasNext()) {
            Search search =  iterator.next();
            search.searchDoc("hello world");
        }
    }
}
