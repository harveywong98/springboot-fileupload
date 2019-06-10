package com.example.fileupload.service;

import com.example.fileupload.model.News;
import com.example.fileupload.pojo.HtmlContent;
import com.example.fileupload.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    public String addNews(String content){
        News news = new News();
        news.setHtml(content);
        try {
            newsRepository.save(news);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    public HtmlContent getOneNews(Integer id){
        News news = newsRepository.findOne(id);
        return new HtmlContent(news.getHtml());
    }


}
