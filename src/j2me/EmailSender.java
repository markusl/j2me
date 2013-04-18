package j2me;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

public class EmailSender {
    //private final String _smtpAddress = "smtp.dnainternet.net";
    private final String _smtpAddress = "localhost";
    private final String _from = "<daemon@testservice.us>";
    
    EmailSender(final String _to, final byte[] image) throws IOException
    {
        final SocketConnection sc = (SocketConnection) Connector.open("socket://" + _smtpAddress + ":25");
        final InputStream is = sc.openInputStream();
        final OutputStream os = sc.openOutputStream();

        os.write(("EHLO " + _smtpAddress + "\r\n").getBytes());
        os.write(("MAIL FROM: " + _from + "\r\n").getBytes());
        os.write(("RCPT TO: " + _to + "\r\n").getBytes());
        os.write("DATA\r\n".getBytes());
        os.write(("Date: " + new Date() + "\r\n").getBytes());
        os.write(("From: " + _from + "\r\n").getBytes());
        os.write(("To: " + _to + "\r\n").getBytes());
        os.write(("Subject: " + "" + "\r\n").getBytes());
        os.write(("Content-Type: image/jpg; name=latest.jpg \r\n").getBytes());
        os.write(("Content-Transfer-Encoding: base64" + "\r\n").getBytes());
        os.write(("X-Attachment-Id: 0.1 \r\n").getBytes());
        os.write(("Content-Disposition: attachment; filename= latest.jpg" + "\r\n").getBytes());
        os.write(("\r\n").getBytes());
        os.write(StackOverflow.Base64.encode(image).toString().getBytes());
        os.write((" \r\n").getBytes());
        os.write(".\r\n".getBytes());
        os.write("QUIT\r\n".getBytes());

        StringBuffer sb = new StringBuffer();
        int c = 0;
        while (((c = is.read()) != -1)) {
            sb.append((char) c);
        }
        System.out.print(sb);
    }
}
