/*
Zip , Unzip demo
 */
package test;

import java.io.*;
import java.nio.file.*;

import java.util.zip.*;

public class DemoZip {

    public static void main(String[] args) {
        DemoZip p = new DemoZip();
        p.zip();
        p.unzip();
    }

    private String fname = "build.xml";
    private String zipName = "BUILD.ZIP";
    private String unzipName = "BUILD_UNZIP.xml";

    private void zip() {
        try {
            ZipOutputStream zipOUT = new ZipOutputStream(new FileOutputStream(zipName));

            ZipEntry zipEntry = new ZipEntry(fname);
            zipOUT.putNextEntry(zipEntry);
            Path source = Paths.get(fname);

            zipOUT.write(Files.readAllBytes(source));

            zipOUT.close();
            System.out.println("zip OK !");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void unzip() {
        try {
            ZipInputStream zipIN = new ZipInputStream(new FileInputStream(zipName));

            ZipEntry zipEntry = new ZipEntry(zipName);
            zipIN.getNextEntry();
            Path source = Paths.get(unzipName);

            Files.write(source, zipIN.readAllBytes());
            
            zipIN.close();
            System.out.println("unzip OK !");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
