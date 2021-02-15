package management;

import java.util.List;

public class Results {
	
	private List<Result> accepted;
	private List<Result> corrected;
	private List<Result> discarded;

	public Results(List<Result> accepted, List<Result> corrected, List<Result> discarded) {
		this.accepted = accepted;
		this.corrected = corrected;
		this.discarded = discarded;
	}

	public List<Result> getAccepted() {
		return accepted;
	}

	public void setAccepted(List<Result> accepted) {
		this.accepted = accepted;
	}

	public List<Result> getCorrected() {
		return corrected;
	}

	public void setCorrected(List<Result> corrected) {
		this.corrected = corrected;
	}

	public List<Result> getDiscarded() {
		return discarded;
	}

	public void setDiscarded(List<Result> discarded) {
		this.discarded = discarded;
	}

	
}
