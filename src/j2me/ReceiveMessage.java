package j2me;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.wireless.messaging.Message;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.MessageListener;
import javax.wireless.messaging.TextMessage;

/** Utility for receiving SMS's at port 8000. Reports received messages using given SmsAction. */
class ReceiveMessage implements MessageListener {
    private final String _smsPort = "sms://:8000";
    private final MessageConnection _receiver = (MessageConnection) Connector.open(_smsPort);
    private final SmsAction _action;

    /** The constructor. */
    public ReceiveMessage(final SmsAction action) throws IOException {
        _action = action;
        _receiver.setMessageListener(this);
    }

    /** Notifies about incoming stuff.. */
    public void notifyIncomingMessage(final MessageConnection mc) {
        try {
            final Message m = mc.receive();
            if(m instanceof TextMessage)
            {
                final TextMessage tm = (TextMessage)m;
                System.out.println(tm.getPayloadText());
                _action.doit();
            }
        } catch (IOException ex) {
            System.out.println("Error happened :-( " + ex.toString());
        }
    }
}
