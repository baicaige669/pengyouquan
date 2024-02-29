package com.feng.Controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.feng.Mybatis.mapper.BaseuserMapper;
import com.feng.Mybatis.mapper.filesMapper;
import com.feng.Mybatis.pojo.Baseuser;
import com.feng.Mybatis.pojo.files;
import com.feng.common.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@Controller
@ResponseBody
public class FilesController {
    @Value("${file.upload.path}")
    private String fileUploadPath;
    //配置文件中的文件保存路径

    @Autowired
    private BaseuserMapper baseuserMapper;
    @Autowired
    private filesMapper filesMapper;
    @PostMapping("upload")
    Result upload(MultipartFile file) throws IOException {
        //从post接口接收file文件
        String originalFilename = file.getOriginalFilename();
        //获取文件名称
        String type = FileUtil.extName(originalFilename);
        //获取文件类型
        long size = file.getSize();
        //获取文件大小
        File file1 = new File(fileUploadPath);
        if(!file1.exists()){
            file1.mkdirs();
            //判断上传路径是否存在，不存在的话创建目录
        }
        String uuid = IdUtil.fastSimpleUUID();
        //uuid是文件的唯一标识符，用于区分不同的文件
        File file2 = new File(fileUploadPath + uuid + StrUtil.DOT + type);
        //fileUploadPath 后需要加一个 '/' 文件才能放到他的下一级目录
        file.transferTo(file2);
        //把文件上传到指定的本地目录


        String url="http://47.117.175.240:8082/files/"+uuid +StrUtil.DOT+ type;
        //文件在服务器上放到了一个单独的tomcat的目录下，放在springboot下无法实时更新图片，需要重启服务器，所以出此下策

        //String url="http://localhost:2003/imgs/"+uuid +StrUtil.DOT+ type;
        files DBfile = new files(file2.getName(),type,size,url);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String id = request.getAttribute("ID").toString();
        DBfile.setEnable(Integer.valueOf(id));
        int insert = filesMapper.insert(DBfile);
        //把文件信息添加到数据库
        int findnewurl = baseuserMapper.findnewurl(id);
        Baseuser baseuser = new Baseuser();
        baseuser.setId(Integer.valueOf(id));
        baseuser.setPhone(String.valueOf(findnewurl));
        int i = baseuserMapper.updateByPrimaryKeySelective(baseuser);
        //把上传用户的头像改为此上传头像
        return Result.ok("");
    }

    @GetMapping("findall")
    Result findallfiles(){
        List<files> findall = filesMapper.findall();
        return Result.ok(findall);
    }
}
