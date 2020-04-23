package down;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @author Tianjin
 * @version 1.0
 * @date 2020.04.21
 * 工具类
 *
 */



public class Tools {
	
	
	
	
	
	/**
	 * 
	 * @param urlList
	 * @return String
	 *  批量保存方法
	 * 入参  下载地址url
	 * 出参   保存路径及文件名
	 *
	 */
	private static  String Download(String urlList) {
        URL url = null;
        String filepath="";
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            String newpaht ="d:\\test\\";//+"\\"+urlList.substring(urlList.lastIndexOf("/")+1, urlList.length());//+".jpg";
            try{
				File file = new File(newpaht);
				if(!file.exists()){
					file.mkdirs();					
				}
			}catch(Exception ex){
				System.out.println(ex);
			}
            filepath=newpaht+"\\"+urlList.substring(urlList.lastIndexOf("/")+1, urlList.length())+".jpg";
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filepath));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
 
            byte[] buffer = new byte[1024];
            int length;
 
            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return filepath;
    }

}
