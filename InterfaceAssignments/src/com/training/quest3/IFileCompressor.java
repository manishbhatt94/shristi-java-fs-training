package com.training.quest3;

public interface IFileCompressor {

	void compressFiles(String... files);

	static void printCompressionProgress(String[] files) {
		System.out.println("Adding files to archive...");
		for (String file : files) {
			System.out.println("\t" + file + "added");
		}
	}
}
