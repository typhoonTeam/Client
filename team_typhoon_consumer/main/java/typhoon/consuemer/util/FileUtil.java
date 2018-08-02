package typhoon.consuemer.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
/**
 * 
 * @author Dunn
 *
 */
public class FileUtil {
	public void FileStore(HttpServletRequest request, String fileUploadPath)
			throws IOException, FileNotFoundException {
			FileUpload fileUpload = new FileUpload(new DiskFileItemFactory());
			    List<FileItem> fileItems = null;
			    try {
			fileItems = fileUpload.parseRequest(new ServletRequestContext(request));
			} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			    for(FileItem item : fileItems) {	
			     if(item.isFormField()){
			     System.out.println(item.getFieldName()+"\t"+item.getString());
			     }
			    else {
			     InputStream in = item.getInputStream();
			     byte[] buf = item.get();
			     String fileName = item.getName();
			     OutputStream out = new FileOutputStream(fileUploadPath+"/"+fileName);
			     out.flush();
			     out.close();
			    }}
			}
	
	public InputStream returnFileInput(HttpServletRequest request, String fileUploadPath)
			throws IOException, FileNotFoundException {
			FileUpload fileUpload = new FileUpload(new DiskFileItemFactory());
			    List<FileItem> fileItems = null;
			    InputStream in = null;
			    try {
			fileItems = fileUpload.parseRequest(new ServletRequestContext(request));
			} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			    for(FileItem item : fileItems) {	
			     if(item.isFormField()){
			     System.out.println(item.getFieldName()+"\t"+item.getString());
			     }
			    else {
			     in = item.getInputStream();
			     return in;
			    }}
				 return in;
		}
}
