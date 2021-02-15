package management.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import management.Result;
import management.State;
import management.ValidateAndCorrect;

class ValidateAndCorrectTest {

	@Test
	void testValidateAndCorrect() {
		ValidateAndCorrect v = new ValidateAndCorrect();
 		Result result = v.validateAndCorrect("648732164,27345234567");
 		assertTrue(true, result.getNumber());
	}
	
	
	@Test
	void testValidateAndCorrect_2() {
		ValidateAndCorrect v = new ValidateAndCorrect();
 		Result result = v.validatorDetailed("43543543");
 		assertFalse(false, result.getNumber());
	}
	
	@Test
	void testValidateAndCorrect_3() {
		ValidateAndCorrect v = new ValidateAndCorrect();
 		Result result = v.validatorDetailed("435435434");
 		assertTrue(true, result.getNumber());
	}
	
	@Test
	void testValidateAndCorrect_4() {
		ValidateAndCorrect v = new ValidateAndCorrect();
 		Result result = v.validatorDetailed("4354e3543");
 		assertFalse(false, result.getNumber());
	}
	
	@Test
	void testValidateAndCorrect_5() {
		ValidateAndCorrect v = new ValidateAndCorrect();
 		Result result = v.validatorDetailed("4354e3543");
 		assertEquals(State.DISCARDED_NOT_NUMBER, result.getResult());
	}
	
	@Test
	void testValidateAndCorrect_6() {
		ValidateAndCorrect v = new ValidateAndCorrect();
 		Result result = v.validatorDetailed("4354e43");
 		assertEquals(State.DISCARDED, result.getResult());
	}
	
	@Test
	void testValidateAndCorrect_7() {
		ValidateAndCorrect v = new ValidateAndCorrect();
 		Result result = v.validatorDetailed("26123456789");
 		assertEquals(State.DISCARDED_NOT_SOUTH_AFRICAN, result.getResult());
	}

}
