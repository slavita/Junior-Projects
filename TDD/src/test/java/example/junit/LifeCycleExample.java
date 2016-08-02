package example.junit;

import org.junit.*;

public class LifeCycleExample {
    public LifeCycleExample() {
        System.err.println("constructor()");
        }

        @BeforeClass
        public static void setUpClass() {
            System.err.println("BeforeClass");
        }

        @Before
        public void setUp() {
            System.err.println("Before");
        }

        @Test
        public void test0() {
            System.err.println("test-0");
        }

        @Test
        public void test1() {
            System.err.println("test-1");
        }

        @Test
        public void test2() {
            System.err.println("test-2");
        }

        @After
        public void tearDown() {
            System.err.println("After");
        }

        @AfterClass
        public static void tearDownClass() {
            System.err.println("AfterClass");
        }


}

