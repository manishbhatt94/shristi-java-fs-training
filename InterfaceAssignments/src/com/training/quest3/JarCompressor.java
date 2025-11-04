package com.training.quest3;

public class JarCompressor implements IFileCompressor {

	@Override
	public void compressFiles(String... files) {
		System.out.println("Creating a jar archive from given files");
		IFileCompressor.printCompressionProgress(files);
		System.out.println("Jar archive created.");
	}
}
