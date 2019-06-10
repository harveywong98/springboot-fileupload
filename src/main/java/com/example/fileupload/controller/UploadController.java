package com.example.fileupload.controller;

import com.example.fileupload.common.entity.JsonResult;
import com.example.fileupload.service.UploadService;
import com.example.fileupload.common.utils.JsonResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@ResponseBody
public class UploadController {
    @Autowired
    private UploadService uploadService;

    /**
     * 上传图片功能
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public JsonResult uploadImage(@RequestParam("file") MultipartFile file) {
        System.out.println(file);
        String url = this.uploadService.upload(file);
        if (url==null) {
            // url为空，证明上传失败
            return JsonResultGenerator.genFailResult("上传失败");

        }
        // 返回200，并且携带url路径
        System.out.println(url);
        return JsonResultGenerator.genSuccessResult(url);
    }


}
