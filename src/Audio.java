import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Audio {
    private Clip clip;
    private AudioInputStream song;
    private boolean isWorking;

    private void setVolume() {
        FloatControl gainControl = (FloatControl) this.clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-8.f);
    }

    public void setFile(String filePath) {
        try {
            File songFile = new File(filePath);
            this.song = AudioSystem.getAudioInputStream(songFile);
            this.clip = AudioSystem.getClip();
            this.clip.open(this.song);

            System.out.println("The song was loaded!");
            isWorking = true;
        } catch(Exception e) {
            System.out.println("Song player couldn't be loaded!\n" + e);
            isWorking = false;
        }
    }

    public void play() {
        if(!isWorking) return;
        this.setVolume();
        this.clip.start();
        this.clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() throws IOException {
        if(!isWorking) return;
        this.song.close();
        this.clip.close();
        this.clip.stop();
    }
}
