package com.training.quest3;

public class RarCompressor implements IFileCompressor {

	@Override
	public void compressFiles(String... files) {
		System.out.println("Creating a rar archive from given files");
		IFileCompressor.printCompressionProgress(files);
		System.out.println("Rar archive created.");
	}
}
