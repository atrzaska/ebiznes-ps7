package org.atrzaska.ebiznes.ps7.api;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.atrzaska.ebiznes.util.FileUtils;

public final class ApacheLog {
    protected List<ApacheLogRecord> records = new ArrayList<>();

    public ApacheLog(String file) {
        this.load(file);
    }

    public void printData() {
        for (ApacheLogRecord record : records) {
            System.out.println(record);
        }
    }

    public void load(String file) {
        // clear records
        records.clear();

        // open file for reading
        String fileString = FileUtils.readFileAsString(file);

        // compile pattern for matching lines
//            Pattern pattern = Pattern.compile("(\\d+),[ ]*(.+)");
        Pattern pattern = Pattern.compile("(.+) - - \\[((\\d+)/(\\w+))/(\\d+):(\\d+):(\\d+):(\\d+) -0500] \"GET (.+) HTTP/1.\\d\" (\\d+) (.+) \"(.+)\" \"(.+)\"");
        Matcher matcher = pattern.matcher(fileString);

        // find matches
        while (matcher.find()) {
            // parse line
            String ip = matcher.group(1);
            String day = matcher.group(3);
            String month = matcher.group(4);
            String year = matcher.group(5);
            String hour = matcher.group(6);
            String minute = matcher.group(7);
            String second = matcher.group(8);
            String resource = matcher.group(9);
            String responseCode = matcher.group(10);
            String unk1 = matcher.group(11);
            String referingSite = matcher.group(12);
            String browserInfo = matcher.group(13);

            // create record
            ApacheLogRecord record = new ApacheLogRecord(ip, day, month, year, hour,
                        minute, second, resource, responseCode, unk1, referingSite, browserInfo);

            // add record
            records.add(record);
        }
    }

    public List<ApacheLogRecord> getRecords() {
        return records;
    }

    public int numRecords() {
        return records.size();
    }

    public ApacheLogRecord getRecord(int index) {
        return records.get(index);
    }
}
