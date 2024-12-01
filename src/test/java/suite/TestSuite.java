package suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ClassATest.class, ClassBTest.class, ClassCTest.class})
public class TestSuite {
    // This class is empty because it is only used as a holder for the above annotations.
    // The annotations are used to include the test classes in the test suite.
}
