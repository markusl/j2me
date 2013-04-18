package j2me;

import java.io.IOException;
import javax.microedition.media.MediaException;

/** The default action which captures the image from video canvas,
 * stores it onto the device locally, and sends it via SMTP to the receiver. */
public class CaptureImageSaveAndSendInEmailAction implements SmsAction {
    
    /** Executes the action. */
    public void doit() {
        try {
            final byte[] i = new CaptureImage().doCapture();
            new ImageSave(i);
            new EmailSender("<ml@testservice.ug>", i);
        } catch (MediaException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
