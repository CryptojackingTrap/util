package it.unitn.randomFileTest;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class FileGenerator {
    private static final String PATH = "C:\\Test\\";
    private static String fileName = "random-data.out";
    private static Integer FILE_LINE_NUMBER = 2000000;
    //todo fixed time, because it is not processed in detector
    private static String FILE_TIME_STAMP = "2022/05/18 16:57:05";
    private static Integer MIN_HEX_CHAR_COUNT = 1;
    private static Integer MAX_HEX_CHAR_COUNT = 31;


    public static void main(String[] args) throws Exception {

        Files.createFile(Paths.get(PATH + fileName));

        for (int i = 0; i <FILE_LINE_NUMBER ; i++) {
            Integer randomSize = getRandomSize(MIN_HEX_CHAR_COUNT, MAX_HEX_CHAR_COUNT);
            String randomHexStr = getRandomHexString(randomSize);
            String messageToWrite = FILE_TIME_STAMP+" 0x" + randomHexStr+"\n";

            Files.write(
                    Paths.get(PATH + fileName),
                    messageToWrite.getBytes(),
                    StandardOpenOption.APPEND);
            //Files.writeString(Paths.get(PATH + fileName), messageToWrite, StandardCharsets.ISO_8859_1);
        }
    }

    private static String getRandomHexString(int numchars) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while (sb.length() < numchars) {
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, numchars);
    }

    private static Integer getRandomSize(Integer min, Integer max){
        Random random = new Random();
        int randomNumber = random.nextInt(max + 1 - min) + min;
        return randomNumber;
    }

}
