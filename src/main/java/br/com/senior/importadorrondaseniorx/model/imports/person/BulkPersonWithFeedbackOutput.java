package br.com.senior.importadorrondaseniorx.model.imports.person;

import java.util.List;

public class BulkPersonWithFeedbackOutput {
	private List<BulkPersonFeedback> feedbacks;
	
	public List<BulkPersonFeedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<BulkPersonFeedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
}
