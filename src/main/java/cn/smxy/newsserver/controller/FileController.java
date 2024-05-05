package cn.smxy.newsserver.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
public class FileController {
    //  http://localhost:8089/ryansystemserver/uploadFile/
    @PostMapping("/uploadFile")
    public Map<String,Object>upload(MultipartFile file) throws IOException{
        //图片原有的名字
        String oldFileNmae = file.getOriginalFilename();
        //图片新的名字
        String newFileNmae = UUID.randomUUID().toString() + oldFileNmae;
        String fileSavePath = "D:/upload/" + newFileNmae;
        File f = new File(fileSavePath);
        file.transferTo(f);
        //  http://localhost:8089/ryansystemserver/upload/
        String imagePath = "http://localhost:8089/ryansystemserver/upload/" + newFileNmae;
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","文件上传成功");
        map.put("dataobject",imagePath);
        return map;

    }


}
