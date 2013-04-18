package j2me;

/** Interface for those implementing actions to execute when SMS is received. */
public interface SmsAction {
    /** The method which runs when SMS arrives. */
    void doit();
}
