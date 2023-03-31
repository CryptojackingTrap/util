package it.unitn.memoryAccess;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HexFormat;
import java.util.List;

/**
 * this class is a simple class to make numerous memory read access and this data is called mark data,
 * because is significantly distinguishable from other memory access content.
 */
public class AccessMarkData {
    private static final String DATE_FORMAT_PATTERN = "(yyyy/MM/dd, HH:mm:ss)";

    private static byte[] markData = HexFormat.of().parseHex("1234567890abcdef");//32 byte   - 16 char

    public static void main(String[] args) throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        List<byte[]> list = new ArrayList();
        Integer listSize = 1000;
        for (int i = 0; i < listSize; i++) {
            list.add(markData);
        }

        while (true) {
            for (byte[] data : list) {
                System.out.println(HexFormat.of().formatHex(data) + "        " + dateFormat.format(new Date()));
                Thread.sleep(1000);
            }
        }
    }
}
