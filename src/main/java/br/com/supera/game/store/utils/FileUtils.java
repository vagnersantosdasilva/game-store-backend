package br.com.supera.game.store.utils;

import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class FileUtils {

    public byte[] getImage(String file) throws Exception{

        //byte[] bytes = getClass().getResourceAsStream("/fifa-18.png").readAllBytes();
        byte[] bytes = getClass().getResourceAsStream(file).readAllBytes();
        return bytes;

    }
}
