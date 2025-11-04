package com.training.quest4;

public class VLCMediaPlayer implements IMediaPlayer {

	@Override
	public void playVideo() {
		System.out.println("play mkv files - vlc media player");
	}

	@Override
	public void downloadMusic() {
		System.out.println("download files as mp3 - vlc media player");
	}
}
