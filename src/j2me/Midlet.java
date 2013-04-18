package j2me;

import java.io.IOException;
import javax.microedition.midlet.*;

public class Midlet extends MIDlet {
    private final ReceiveMessage _receive = new ReceiveMessage(new CaptureImageSaveAndSendInEmailAction());
    
    Midlet() throws IOException
    {
    }
    
    public void startApp() {
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
