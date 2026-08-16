public class Submission {
    private String submissionID;
    private String studentID;
    private String assignmentID;
    private String timestamp;
    private String answer;

    public Submission(String submissionID, String studentID,
                      String assignmentID, String timestamp,
                      String answer) {
        this.submissionID = submissionID;
        this.studentID = studentID;
        this.assignmentID = assignmentID;
        this.timestamp = timestamp;
        this.answer = answer;
    }

    public String getSubmissionID() {
        return submissionID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getAssignmentID() {
        return assignmentID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Submission{" +
                "submissionID='" + submissionID + '\'' +
                ", studentID='" + studentID + '\'' +
                ", assignmentID='" + assignmentID + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}