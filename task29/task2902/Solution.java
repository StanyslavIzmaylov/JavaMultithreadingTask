package com.javarush.task.task29.task2902;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Рефакторинг в соответствии с Naming and Code Convention 2
*/

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        Solution solution = new Solution();
        String nameOfFileToBeOpenedByNotepad = Solution.getAbsolutePathToDefaultTxtFile().toString();
        Process notepad = Solution.getStartNotepadProcess(nameOfFileToBeOpenedByNotepad);
        notepad.waitFor();
    }

    public static Process getStartNotepadProcess(String fileName) throws IOException {
        String[] cmdArray = new String[]{"notepad.exe", fileName};
        return Runtime.getRuntime().exec(cmdArray);
    }

    public static Path getAbsolutePathToDefaultTxtFile() throws URISyntaxException {
        URI uri = Solution.class.getResource("file.txt").toURI();
        return Paths.get(uri);
    }
}
