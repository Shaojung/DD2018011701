package tw.com.pcschool.dd2018011701;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void test1() throws Exception {
        assertEquals(8, 2+6);
    }
    @Test
    public void test2() throws Exception {
        MyTest1 t = new MyTest1();

        assertEquals(8, t.getAdd(2,6));
    }
}