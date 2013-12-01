package org.atrzaska.ebiznes.ps7;

import org.atrzaska.ebiznes.ps7.api.ApacheLog;
import org.atrzaska.ebiznes.ps7.api.ApacheLogParser;

public class Main {
    public static void main(String[] args) {
    	ApacheLog log = new ApacheLog(Config.logFile);
//    	log.printData();
	
    	ApacheLogParser parser = new ApacheLogParser(log);
    	parser.saveCsv(Config.outputCsv);
    }
}
