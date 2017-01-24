package view;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SokobanSounds {
	MediaPlayer mediaPlayer;
	public void backGroundSound(){
		Media sound = new Media(new File("sounds/backgroundmusic.mp3").toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			
			@Override
			public void run() {
				mediaPlayer.seek(Duration.ZERO);
				
			}
		});
		mediaPlayer.play();
	}

}
