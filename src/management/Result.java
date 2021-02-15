package management;

public class Result {

	private Long id;
	private String number;
	private String result;

	public Result(Long id, String number, String result) {
		this.id = id;
		this.number = number;
		this.result = result;
	}
	
	public Result(String number, String result) {
		this.number = number;
		this.result = result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
