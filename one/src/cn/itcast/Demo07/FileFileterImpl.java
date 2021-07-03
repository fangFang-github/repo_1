package cn.itcast.Demo07;

import java.io.File;
import java.io.FileFilter;

public class FileFileterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java");
    }
}
