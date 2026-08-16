public class Main {

    public static void main(String[] args) {

        // =====================================
        // MODUL SUBMISSION
        // =====================================

        SubmissionService service = new SubmissionService();

        Submission s1 = new Submission(
                "S001",
                "ST001",
                "A001",
                "10:01",
                "Jawaban A"
        );

        Submission s2 = new Submission(
                "S002",
                "ST002",
                "A001",
                "10:02",
                "Jawaban B"
        );

        Submission s3 = new Submission(
                "S003",
                "ST003",
                "A001",
                "10:03",
                "Jawaban C"
        );

        // Add submission
        service.addSubmission(s1);
        service.addSubmission(s2);
        service.addSubmission(s3);

        System.out.println();

        // Search submission
        System.out.println(
                "Search S002: "
                + service.searchSubmission("S002")
        );

        System.out.println();

        // Process submission berdasarkan FIFO
        service.processSubmission();

        System.out.println();

        // Undo submission terakhir
        service.undoSubmission();


        // =====================================
        // MODUL EXPRESSION EVALUATION
        // =====================================

        ExpressionEvaluator evaluator =
                new ExpressionEvaluator();

        String infix = "2 + 3 * 4";

        String postfix =
                evaluator.infixToPostfix(infix);

        int result =
                evaluator.evaluatePostfix(postfix);

        System.out.println();

        System.out.println("Infix   : " + infix);
        System.out.println("Postfix : " + postfix);
        System.out.println("Result  : " + result);
    }
}