package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class 文件上传 {
    @ResponseBody
    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        //获取上传的文件的文件名
        String fileName = photo.getOriginalFilename();
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        //获取服务器中文件目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("imgs");
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        //实现上传功能
        photo.transferTo(new File(finalPath));
        return "OK!";
    }
}
