package com.training.quest3;

public class ZipCompressor implements IFileCompressor {

	@Override
	public void compressFiles(String... files) {
		System.out.println("Creating a zip archive from given files");
		IFileCompressor.printCompressionProgress(files);
		System.out.println("Zip archive created.");
	}
}
