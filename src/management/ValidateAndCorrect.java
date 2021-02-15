package management;

public class ValidateAndCorrect {

	public Result validateAndCorrect(String rec) {
		String[] split = rec.split(",");
		Long id = Long.valueOf(split[0]);
		String number = split[1];
		Result validatorDetailed = validatorDetailed(number);
		validatorDetailed.setId(id);
		return validatorDetailed;
	}
	
	public Result validatorDetailed(String number) {
		switch (number.length()) {
		case 9:
			try {
				Long.valueOf(number);
				return new Result("27"+number, State.CORRECTED);
			} catch (Exception e) {
				return new Result(number, State.DISCARDED_NOT_NUMBER);
			}
		case 11:
			try {
				Long.valueOf(number);
				if(number.startsWith("27")) {
					return new Result(number,State.ACCEPTED);
				}else {
					return new Result(number, State.DISCARDED_NOT_SOUTH_AFRICAN);
				}
			} catch (Exception e) {
				return new Result(number, State.DISCARDED_NOT_NUMBER);
			}
		default:
			return new Result(number, State.DISCARDED);
		}
	}
}
