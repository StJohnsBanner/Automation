import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RunSuiteofTestForms {

	@Test
	void test() {
		int TestCount =0;
		TestLogin a = new TestLogin();
		a.test();
		TestCount++;
		TestFormFWMUSOR b = new TestFormFWMUSOR();
		b.test();
		TestCount++;
		TestFormFWMUSFN c = new TestFormFWMUSFN();
		c.test();
		TestCount++;
		TestFormFZABREC d = new TestFormFZABREC();
		d.test();
		TestCount++;
		TestFormFZMUSOR e = new TestFormFZMUSOR();
		e.test();
		TestCount++;
		TestFormGZAEMAL f = new TestFormGZAEMAL();
		f.test();
		TestCount++;
		TestFormSHATRNS h = new TestFormSHATRNS();
		h.test();
		TestCount++;
		TestFormSFAREGF I = new TestFormSFAREGF();
		I.test();
		TestCount++;
		TestFormSFWEGF J = new TestFormSFWEGF();
		J.test();
		TestCount++;
		TestFormSFWLST K = new TestFormSFWLST();
		K.test();
		TestCount++;
		TestFormSIWASGQ L = new TestFormSIWASGQ();
		L.test();
		TestCount++;
		TestFormSLAEVNT M = new TestFormSLAEVNT();
		M.test();
		TestCount++;
		TestFormSLARMAP N = new TestFormSLARMAP();
		N.test();
		TestCount++;
		TestFormSWAAFFL O = new TestFormSWAAFFL();
		O.test();
		TestCount++;
		TestFormSZACMNT P = new TestFormSZACMNT();
		P.test();
		TestCount++;
		TestFormSZAIDEN Q = new TestFormSZAIDEN();
		Q.test();
		TestCount++;
		TestFormSZVAFFL R = new TestFormSZVAFFL();
		R.test();
		TestCount++;
		TestFormSZVDEPT S = new TestFormSZVDEPT();
		S.test();
		TestCount++;
		System.out.println("# Of Test Ran ="+ TestCount);
	}

}
