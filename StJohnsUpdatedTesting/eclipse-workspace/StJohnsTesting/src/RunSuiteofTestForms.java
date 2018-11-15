import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RunSuiteofTestForms {

	@Test
	void test() {
		
		TestLogin a = new TestLogin();
		a.test();
		TestFormFWMUSOR b = new TestFormFWMUSOR();
		b.test();
		TestFormFWMUSFN c = new TestFormFWMUSFN();
		c.test();
		TestFormFZABREC d = new TestFormFZABREC();
		d.test();
		TestFormFZMUSOR e = new TestFormFZMUSOR();
		e.test();
		TestFormGZAEMAL f = new TestFormGZAEMAL();
		f.test();
		TestFormSHATRNS h = new TestFormSHATRNS();
		h.test();
		
	}

}
