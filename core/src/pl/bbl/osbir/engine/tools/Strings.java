package pl.bbl.osbir.engine.tools;

public abstract class Strings {
    public static String swapSlashesToMatchZipConvetion(String filePath){
        return filePath.replace("/", "//");
    }
}
