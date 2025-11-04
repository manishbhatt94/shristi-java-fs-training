package com.training.quest2;

public class RarExtractor implements IExtractor {

	@Override
	public void extractFiles(String filename) {
		System.out.println(String.format("extracting from zip => files as .txt files from linux os", filename));
	}
}
