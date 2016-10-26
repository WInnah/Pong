import java.applet.Applet;
import java.applet.AudioClip;

/**
 * Created by Winnah Gwen Acal on 10/23/2016.
 */
public class Sound {
    public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("Marble.wav"));
    public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("Error.wav"));
    public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("Background.wav"));
}
