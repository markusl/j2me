package j2me;

import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

/** Utility for saving image to local storage. */
public class ImageSave {
    private final String _latestImage = "file:///root1/latest.jpeg";
    
    /** Saves the image to latest.jpeg. */
    ImageSave(final byte[] img) throws IOException
    {
        final FileConnection fc = (FileConnection) Connector.open(_latestImage, Connector.READ_WRITE);
        if(!fc.exists())
            fc.create();
        
        final DataOutputStream dos = new DataOutputStream(fc.openDataOutputStream());
        dos.write(img);
        dos.close();
        fc.close();
        System.out.println("Image saved to " + _latestImage);
    }
}
