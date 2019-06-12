package cn.javabs.bookstore.utils;

import java.io.File;

/**
 * 计算 文件上传的路径地址
 * @author Mryang
 */
public class SetPhotoPath {
    /**
     *  生成路径  =  文件的路径 + 文件的名称
     * @param storeDirectory
     * @param filename
     * @return
     */
    public static  String makeDir(String storeDirectory ,String filename){
        int hashCode = filename.hashCode();
        /*
         * hashCode&0xf
         * 打散哈希算法
         */

        int dir1 = hashCode&0xf;

        int dir2 = (hashCode&0xf)>>4;

        String newPath = "/"+dir1+"/"+dir2;
        File file = new File(storeDirectory, newPath);

        if(!file.exists()){
            file.mkdirs();
        }

        return newPath;
    }
}
