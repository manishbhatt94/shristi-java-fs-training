package com.training.quest2;

public class ZipExtractor implements IExtractor {

	@Override
	public void extractFiles(String filename) {
		System.out.println(String.format("extracting from zip %s => files as .txt, as jpeg, as .doc files", filename));
	}
}
