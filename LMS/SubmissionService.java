import java.util.*;

public class SubmissionService {

    // Queue untuk memproses submission berdasarkan urutan kedatangan
    private Queue<Submission> submissionQueue;

    // Stack untuk menyimpan submission yang dapat di-undo
    private Deque<Submission> undoStack;

    // HashMap untuk pencarian berdasarkan submissionID
    private Map<String, Submission> submissionMap;

    public SubmissionService() {
        submissionQueue = new ArrayDeque<>();
        undoStack = new ArrayDeque<>();
        submissionMap = new HashMap<>();
    }

    // Menambahkan submission
    public void addSubmission(Submission submission) {

        submissionQueue.offer(submission);
        undoStack.push(submission);
        submissionMap.put(submission.getSubmissionID(), submission);

        System.out.println(
                "Submission " + submission.getSubmissionID()
                + " berhasil ditambahkan."
        );
    }

    // Membatalkan submission terakhir
    public Submission undoSubmission() {

        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada submission yang dapat di-undo.");
            return null;
        }

        Submission submission = undoStack.pop();

        // Menghapus dari queue
        submissionQueue.remove(submission);

        // Menghapus dari HashMap
        submissionMap.remove(submission.getSubmissionID());

        System.out.println(
                "Submission " + submission.getSubmissionID()
                + " berhasil di-undo."
        );

        return submission;
    }

    // Memproses submission berdasarkan FIFO
    public Submission processSubmission() {

        if (submissionQueue.isEmpty()) {
            System.out.println("Tidak ada submission untuk diproses.");
            return null;
        }

        Submission submission = submissionQueue.poll();

        System.out.println(
                "Memproses submission: "
                + submission.getSubmissionID()
        );

        return submission;
    }

    // Mencari submission berdasarkan submissionID
    public Submission searchSubmission(String submissionID) {

        return submissionMap.get(submissionID);
    }
}