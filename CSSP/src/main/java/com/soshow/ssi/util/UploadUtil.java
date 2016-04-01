package com.soshow.ssi.util; 

import java.io.File; 
import java.io.FileInputStream; 
import java.io.InputStream; 

import org.apache.log4j.Logger; 
import org.springframework.web.multipart.MultipartFile; 

import Decoder.BASE64Encoder; 

/** 
* 文件上传工具类 
* @author wangjq 
* 
*/ 
public class UploadUtil { 
   //获取项目的class根目录 
   private final static  Logger logger=Logger.getLogger(UploadUtil.class); 
   /** 
    * 保存文件到本地 
    * @param file 
    * @return 
    */ 
   public static String saveFile(MultipartFile file){ 
      String path="D:\\images";   
       
      if(!file.isEmpty()&&file.getSize()>0){ 
         String fileName=file.getOriginalFilename(); 
         System.out.println("****"+path); 
         File pathFile =new File(path); 
         if(!pathFile.exists()){ 
            pathFile.mkdirs(); 
         } 
          
         File saveFile=new File(path, fileName); 
         try{ 
            file.transferTo(saveFile); 
            return path+"\\"+fileName; 
             
         }catch(Exception e){ 
            logger.info("保存文件出错",e); 
         } 
      }else{ 
         logger.error("文件不存在！"); 
          
      } 
      return null; 
       
   } 
   /** 
    * 将图片转化为base64格式 
    * @param url 
    * @return 
    */ 
   public static String getImgBase64(String url){ 
       
      InputStream is=null; 
      byte[] data=null; 
      try{ 
         is=new FileInputStream(url); 
         data=new byte[is.available()]; 
         is.read(data); 
         is.close(); 
      }catch(Exception e ){ 
         logger.info("读取文件错误", e); 
      } 
      BASE64Encoder encoder=new BASE64Encoder(); 
      return encoder.encode(data); 
       
   } 
    
    
   public static void main(String[] args) { 
      String url="D:\\images\\1.png"; 
      String base64=getImgBase64(url); 
      System.out.println(base64); 
   } 
    

}