/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Carlos
 */
public class ZipBuilder {

    List<String> files = new ArrayList<String>();
    private String sourceFolder;

    public String getSourceFolder() {
        return sourceFolder;
    }

    public void setSourceFolder(String sourceFolder) {
        this.sourceFolder = sourceFolder;
    }

    private String generateZipEntry(String file){
        return file.substring(sourceFolder.length()+1, file.length());
    }

    private void generateFileList(File node){
        if(node.isFile()){
            files.add(generateZipEntry(node.getAbsoluteFile().toString()));
        }
        if(node.isDirectory()){
            String[] subNode = node.list();
            for(String fileName : subNode){
                generateFileList(new File(node, fileName));
            }
        }
    }

    public boolean zip(String fileName){
        byte[] buffer = new byte[1024];
        try{
            generateFileList(new File(sourceFolder));

            FileOutputStream fos = new FileOutputStream(new File(fileName));
            ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(fos));

            for(String file : files){
                ZipEntry ze = new ZipEntry(file);
                zos.putNextEntry(ze);
                FileInputStream in = new FileInputStream(sourceFolder + File.separator + file);
                int len;
                while((len=in.read(buffer)) > 0){
                    zos.write(buffer, 0, len);
                }
                in.close();
                zos.closeEntry();
            }
            zos.flush();
            zos.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
