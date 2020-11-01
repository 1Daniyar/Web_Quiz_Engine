package engine.models;

public class Response {

    public static final Response CORRECT = new Response(true, "Congratulations, you're right!");
    public static final Response INCORRECT = new Response(false, "Wrong answer! Please, try again.");

    private boolean success;
    private String feedback;

    public Response(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getFeedback() {
        return feedback;
    }
}
