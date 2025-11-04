package com.training.quest4;

import java.util.Scanner;

public class PlayerDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter which media player to use for playing video & downloading music:");
		System.out.print("Enter media player choice ('vlc' / 'windows'): ");
		String mediaPlayerChoice = scanner.next().toLowerCase();

		scanner.close();

		IMediaPlayer mediaPlayer = null;

		switch (mediaPlayerChoice) {
		case "vlc":
			System.out.println("\nUsing VLC Media Player:");
			mediaPlayer = new VLCMediaPlayer();
			break;

		case "windows":
			System.out.println("\nUsing Windows Media Player:");
			mediaPlayer = new WindowsMediaPlayer11();
			break;

		default:
			System.out.println("Invalid choice entered. Re-run the program & try again.");
			System.exit(0);
		}

		mediaPlayer.playVideo();
		mediaPlayer.downloadMusic();
	}
}
