package management;

public class State {

	public static final String CORRECTED = "CORRECTED - Added south african prefix";
	
	public static final String DISCARDED = "DISCARDED - The number is not formally corrected";
	
	public static final String ACCEPTED = "ACCEPTED - The number is formally corrected";

	public static final String DISCARDED_NOT_NUMBER = "DISCARDED - The input contains not numeric characters";

	public static final String DISCARDED_NOT_SOUTH_AFRICAN = "DISCARDED - The input number inserted is not south african";

	public static final String DISCARDED_NUMBER_LENGTH = "DISCARDED - Not correct number length";

}
