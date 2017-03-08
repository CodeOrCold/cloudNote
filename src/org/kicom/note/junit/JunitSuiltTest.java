package org.kicom.note.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)  //该类是一个junit套件，可以调用多个test
@SuiteClasses({JunitDemoTest.class,JunitDemoTest2.class})
public class JunitSuiltTest {
                 
}
