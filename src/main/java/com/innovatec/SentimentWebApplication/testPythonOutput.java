package com.innovatec.SentimentWebApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testPythonOutput {

    public String userInput;
    public String category;
    public String ret;
    // TODO set character encoding to UTF-8

    public void readPythonScript() throws IOException {
        String pathToCondaEnv = "/opt/conda/bin/python3";
        String path = "/home/kari_eriksen/src/python/run_sentiment.py";
        ProcessBuilder pb = new ProcessBuilder(pathToCondaEnv, path, userInput, category);
        pb.redirectErrorStream(true);
        // TODO Correct python path

        Process process = pb.start();
        //InputStream results = process.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        ret = in.readLine();
        long length = 0;
        String line;
        while ((line = in.readLine()) != null) {
            length += line.length();
            System.out.println(line);
        }
        System.out.println("Read length: " + length);
        System.out.println(ret);
    }

    public static void main(String[] argv) throws IOException {
        testPythonOutput myobj = new testPythonOutput();
        myobj.userInput = "dette var veldig bra";
        myobj.readPythonScript();
    }
}

