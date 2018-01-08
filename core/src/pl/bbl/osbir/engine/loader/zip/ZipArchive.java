package pl.bbl.osbir.engine.loader.zip;

import pl.bbl.osbir.engine.tools.Strings;

import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipArchive {
    private Enumeration<? extends ZipEntry> entries;

    public ZipArchive(ZipFile zipFile){
        entries = zipFile.entries();
    }

    public ZipEntry getEntry(String filePath){
        String swapedFilePath = Strings.swapSlashesToMatchZipConvetion(filePath);
        while(entries.hasMoreElements()){
            ZipEntry zipEntry = entries.nextElement();
            if(zipEntry.getName().equals(filePath)){
                return zipEntry;
            }
        }
        return null;
    }

    public void printEntries(){
        while(entries.hasMoreElements()){
            ZipEntry zipEntry = entries.nextElement();
            System.out.println(zipEntry.getName());
        }
    }
}
