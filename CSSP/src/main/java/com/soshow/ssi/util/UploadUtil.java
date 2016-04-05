package com.soshow.ssi.util; 

import java.io.File; 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile; 

import sun.misc.BASE64Decoder;
/** 
* 文件上传工具类 
* @author xieb 
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
      String path="D:\\image";   
       
      if(!file.isEmpty()&&file.getSize()>0){ 
         String fileName=System.currentTimeMillis()+file.getOriginalFilename();
         File pathFile =new File(path); 
         if(!pathFile.exists()){ 
            pathFile.mkdirs(); 
         } 
          
         File saveFile=new File(path, fileName); 
         try{ 
            file.transferTo(saveFile); 
            
//          return path+"\\"+fileName;
            return GetImageStr(path+"\\"+fileName);
         }catch(Exception e){ 
            logger.info("保存文件出错",e); 
         } 
      }else{ 
         logger.error("文件不存在！"); 
          
      } 
      return null;
   } 
   
   /**
    * 根据路径获取图片的base64编码
    * @return
    */
   public static String GetImageStr(String imgFile)
   {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
//     String imgFile = "d:\\images\\4.jpg";//待处理的图片
       InputStream in = null;
       byte[] data = null;
       //读取图片字节数组
       try 
       {
           in = new FileInputStream(imgFile);        
           data = new byte[in.available()];
           in.read(data);
           in.close();
       } 
       catch (IOException e) 
       {
           e.printStackTrace();
       }
//       //对字节数组Base64编码
//       BASE64Encoder encoder = new BASE64Encoder();
//       return encoder.encode(data);//返回Base64编码过的字节数组字符串
       Base64 base64 = new Base64();
       return base64.encodeToString(data);
   }
   
   /**
    * 根据图片的base64编码转换成图片
    * @param imgStr
    * @return
    */
   public static boolean GenerateImage(String imgStr)
   {//对字节数组字符串进行Base64解码并生成图片
       if (imgStr == null) //图像数据为空
           return false;
       BASE64Decoder decoder = new BASE64Decoder();
       try 
       {
           //Base64解码
           byte[] b = decoder.decodeBuffer(imgStr);
           for(int i=0;i<b.length;++i)
           {
               if(b[i]<0)
               {//调整异常数据
                   b[i]+=256;
               }
           }
           //生成jpeg图片
           String imgFilePath = "d:\\images\\8.gif";//新生成的图片
           OutputStream out = new FileOutputStream(imgFilePath);    
           out.write(b);
           out.flush();
           out.close();
           return true;
       } 
       catch (Exception e) 
       {
           return false;
       }
   }
   
   public static void main(String[] args)
   {
       String strImg = GetImageStr("d:\\images\\4.jpg");
       System.out.println(strImg);
       GenerateImage(strImg);
   }
}