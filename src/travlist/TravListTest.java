package travlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TravListTest {

    private TravList<String> stk_s00;
    private TravList<String> stk_s01;
    private TravList<String> stk_s10;
    private TravList<String> stk_s11;

    private TravList<String> lst_s00;
    private TravList<String> lst_s01;
    private TravList<String> lst_s10;
    private TravList<String> lst_s11;

    @Before
    public void setUp() throws Exception {

        stk_s00 = new StackTravList<>();
        stk_s01 = new StackTravList<>();
        stk_s01.insert("B");
        stk_s10 = new StackTravList<>();
        stk_s10.insert("A");
        stk_s10.advance();
        stk_s11 = new StackTravList<>();
        stk_s11.insert("B");
        stk_s11.insert("A");
        stk_s11.advance();

        lst_s00 = new StackTravList<>();
        lst_s01 = new StackTravList<>();
        lst_s01.insert("B");
        lst_s10 = new StackTravList<>();
        lst_s10.insert("A");
        lst_s10.advance();
        lst_s11 = new StackTravList<>();
        lst_s11.insert("B");
        lst_s11.insert("A");
        lst_s11.advance();
    }

    // ==========================================================
    // Tests for StackTravList
    // ==========================================================

    @Test
    public void testStk00() {
        assertEquals(0, stk_s00.leftLength());
        assertEquals(0, stk_s00.rightLength());
    }

    @Test
    public void testStk01() {
        assertEquals(0, stk_s01.leftLength());
        assertEquals(1, stk_s01.rightLength());
    }

    @Test
    public void testStk10() {
        assertEquals(1, stk_s10.leftLength());
        assertEquals(0, stk_s10.rightLength());
    }

    @Test
    public void testStk11() {
        assertEquals(1, stk_s11.leftLength());
        assertEquals(1, stk_s11.rightLength());
    }

    @Test(expected = NullPointerException.class)
    public void testInsertNull_Stk() {
        stk_s00.insert(null);
    }

    // ==========================================================
    // Tests for ListTravList
    // ==========================================================

    @Test
    public void testLst00() {
        assertEquals(0, lst_s00.leftLength());
        assertEquals(0, lst_s00.rightLength());
    }

    @Test
    public void testLst01() {
        assertEquals(0, lst_s01.leftLength());
        assertEquals(1, lst_s01.rightLength());
    }

    @Test
    public void testLst10() {
        assertEquals(1, lst_s10.leftLength());
        assertEquals(0, lst_s10.rightLength());
    }

    @Test
    public void testLst11() {
        assertEquals(1, lst_s11.leftLength());
        assertEquals(1, lst_s11.rightLength());
    }

    @Test(expected = NullPointerException.class)
    public void testInsertNull_Lst() {
        lst_s00.insert(null);
    }

}
