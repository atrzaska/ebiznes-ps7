package org.atrzaska.ebiznes.ps7;

public class Main {
    public static void main(String[] args) {
    	ApacheLog log = new ApacheLog("data/apache.log");
    	log.printData();
    }
}
