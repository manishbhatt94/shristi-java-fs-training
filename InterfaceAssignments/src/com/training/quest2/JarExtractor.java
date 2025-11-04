package com.training.quest2;

public class JarExtractor implements IExtractor {

	@Override
	public void extractFiles(String filename) {
		System.out.println(String.format("extracting from jar => files as .class files", filename));
	}
}
