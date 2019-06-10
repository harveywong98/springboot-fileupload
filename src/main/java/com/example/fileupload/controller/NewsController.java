package com.example.fileupload.controller;

import com.example.fileupload.common.entity.JsonResult;
import com.example.fileupload.common.utils.JsonResultGenerator;
import com.example.fileupload.model.News;
import com.example.fileupload.pojo.HtmlContent;
import com.example.fileupload.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewsController {

    @Autowired
    NewsService newsService;

    @PostMapping("/news/add")
    public JsonResult addNews(@RequestBody HtmlContent content){
        String html = content.getContent();
        String result = newsService.addNews(html);
        return JsonResultGenerator.genSuccessResult(result);
    }

    @GetMapping("/news/readone")
    public JsonResult readNews(@RequestParam Integer id){
        HtmlContent content = newsService.getOneNews(id);
        return JsonResultGenerator.genSuccessResult(content);
    }

}
