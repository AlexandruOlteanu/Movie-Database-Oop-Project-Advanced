package main;

import checker.Checkstyle;
import checker.Checker;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Constants;
import database.Database;
import writer.Writer;
import org.json.simple.JSONArray;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * The entry point to this homework. It runs the checker that tests your implentation.
 */
public final class Main {
    /**
     * for coding style
     */
    private Main() {
    }

    /**
     * Call the main checker and the coding style checker
     * @param args from command line
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File(Constants.TESTS_PATH);
        Path path = Paths.get(Constants.RESULT_PATH);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        File outputDirectory = new File(Constants.RESULT_PATH);

        Checker checker = new Checker();
        checker.deleteFiles(outputDirectory.listFiles());

        for (File file : Objects.requireNonNull(directory.listFiles())) {

            String filepath = Constants.OUT_PATH + file.getName();
            File out = new File(filepath);
            boolean isCreated = out.createNewFile();
            if (isCreated) {
                action(file.getAbsolutePath(), filepath);
            }
        }

        checker.iterateFiles(Constants.RESULT_PATH, Constants.REF_PATH, Constants.TESTS_PATH);
        Checkstyle test = new Checkstyle();
        test.testCheckstyle();
    }

    /**
     * @param inputFilePath for input file
     * @param outputFilePath for output file
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void action(final String inputFilePath,
                              final String outputFilePath) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Database database = objectMapper.readValue(new File(inputFilePath), Database.class);

        Writer fileWriter = new Writer(outputFilePath);

        Solver solver = new Solver(database);

        JSONArray arrayResult = solver.solveActions();

        fileWriter.closeJSON(arrayResult);
    }
}
