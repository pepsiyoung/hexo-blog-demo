
import org.junit.Test;


public class MockTest {

    private TestableMock testableMock = new TestableMock();

    @Test
    public void commonMethodTest() {
        testableMock.execute();
    }
}
