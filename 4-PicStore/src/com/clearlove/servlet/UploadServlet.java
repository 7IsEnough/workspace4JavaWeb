package com.clearlove.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * @author promise
 * @date 2020/12/26 - 17:14
 */
@WebServlet("/uploadpic")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.导包
        //2.预解析
        FileItemFactory factory = new DiskFileItemFactory();

        //创建一个ServletFileUpload
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            // 处理文件上传
            parseFileItems(fileItems, request);
            // 文件上传完成后，还要去首页展示图片列表
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        // 重定向到首页
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    private void parseFileItems(List<FileItem> fileItems, HttpServletRequest request) throws IOException {
        for (FileItem fileItem : fileItems) {
            if(fileItem.isFormField()){

            }else {
                // 把上传的所有图片保存在当前项目的pics中
                InputStream is = fileItem.getInputStream();
                // 获取某个文件或者文件夹在服务器中真正的位置
                // 一个项目对应一个ServletContext
                ServletContext servletContext = request.getServletContext();
                // /pics/xxx.jpg
                String realPath = servletContext.getRealPath("/pics");
                System.out.println("真实路径"+realPath);

                String fileName = fileItem.getName();
                // IE下获取的文件名是带路径的
//                String[] split = fileName.split("\\\\");
//                fileName = split[split.length - 1];
                int lastIndexOf = fileName.lastIndexOf("\\");
                fileName = fileName.substring(lastIndexOf + 1);

                // 防止同名文件覆盖：给文件名加UUID
                fileName = UUID.randomUUID().toString().replace("-","") + fileName;


                FileOutputStream os = new FileOutputStream(realPath + "/" + fileName);

                IOUtils.copy(is,os);
                os.close();
                is.close();

                // 将上传的文件路径保存在域中方便获取
                ImgUtils.addImgPath("/pics/"+fileItem.getName());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
