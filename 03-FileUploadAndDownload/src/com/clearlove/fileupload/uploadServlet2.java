package com.clearlove.fileupload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author promise
 * @date 2020/12/20 - 13:39
 */
public class uploadServlet2 extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * 1.文件上传步骤
     *  1).导包(两个)
     *      commons-fileupload-1.4.jar\commons-io-2.8.0.jar
     *  2).调方法
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("servlet2");
        // 判断当前请求是否为一个文件上传请求
        boolean b = ServletFileUpload.isMultipartContent(request);
        if(b){
            // 创建一个FileItem的工厂
            FileItemFactory factory = new DiskFileItemFactory();
            // 创建一个ServletFileUpload
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 解析请求
            // 把文件上传请求解析后形成一个fileItem的list
            // 一个FileItem就是代表一个表单项的详细信息
            try {
                List<FileItem> items = upload.parseRequest(request);
                System.out.println(items.size());
                readFileItems(items);
                response.getWriter().write("ok");
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    // 解析每一个表单项的内容
    public void readFileItems(List<FileItem> items) throws IOException {
        int count = 1;
        for (FileItem item : items) {
            // 判断当前是普通表单项还是文件项
            // isFormField==true：是普通表单项
            if(item.isFormField()){
                System.out.println("解析到第"+ (count++) +"个普通表单项：");
                System.out.println("表单提交的key："+item.getFieldName());
                System.out.println("表单提交的value："+item.getString());
            }else {
                System.out.println("解析到第"+(count++)+"个文件项");
                System.out.println("表单提交的key："+item.getFieldName());
                System.out.println("上传的文件名："+item.getName());
                System.out.println("文件信息：大小["+item.getSize()+"]字节");
                // 获取到文件流并保存到某个地方
                InputStream is = item.getInputStream();
                OutputStream os = new FileOutputStream("E:\\workspace\\workspace4JavaWeb\\03-FileUploadAndDownload\\haha\\"+item.getName());
                IOUtils.copy(is,os);
                os.close();
                is.close();
            }
        }
    }
}
