package org.parser;

import lombok.extern.slf4j.Slf4j;
import org.parser.service.Processor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JavaSourceAnalyzer {

    static final String source_dir = "/Users/moon/workspace/Gogora/src/main/java";
    static final String target_dir = "/Users/moon/workspace/java-parser/result";

    public static void main(String[] args) {

        List<File> files = findFiles(new File(source_dir), "Impl.java");
        for (File file : files ) {
            Processor processor = new Processor();
            processor.parserToJava(file.getAbsolutePath(), file.getAbsolutePath().replaceAll(source_dir,target_dir));
        }

    }

    public static List<File> findFiles(File directory, String suffixName) {
        List<File> subfiles = new ArrayList<>();

        // Check if the provided file object represents a directory
        if (directory.isDirectory()) {
            // Get a list of files and directories in the current directory
            File[] files = directory.listFiles();

            // Iterate over the files and directories
            for (File file : files) {
                // If the current item is a directory, recursively search it
                if (file.isDirectory()) {
                    subfiles.addAll(findFiles(file,suffixName));
                } else {
                    if (file.getName().endsWith(suffixName)) {
                        subfiles.add(file);
                    }
                }
            }
        }

        return subfiles;
    }
}