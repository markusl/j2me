package j2me;

import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.VideoControl;

/** Utility for capturing an image from video stream. */
public class CaptureImage {
    /** Dummy canvas for video. */
    class VideoCanvas extends Canvas {
        protected void paint(Graphics g) {
        }
    }
    
    private final Player _player = Manager.createPlayer("capture://video");
    private final VideoControl videoControl;
    private final VideoCanvas _canvas = new VideoCanvas();

    /** Set up everything ready for capturing. */
    public CaptureImage() throws IOException, MediaException
    {
        _player.realize();
        videoControl = (VideoControl) _player.getControl("VideoControl");
        videoControl.initDisplayMode(VideoControl.USE_DIRECT_VIDEO, _canvas);
    }
    
    /** Get the image from current video stream as array of bytes. */
    byte[] doCapture() throws MediaException
    {
        return videoControl.getSnapshot(null);
    }
}
