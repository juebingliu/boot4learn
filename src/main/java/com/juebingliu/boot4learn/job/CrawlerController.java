package com.juebingliu.boot4learn.job;

import com.juebingliu.boot4learn.domain.primary.CrawlerContent;
import com.juebingliu.boot4learn.mapper.primary.CrawlerContentMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/6/5 13:25
 * @description
 */
@RestController
public class CrawlerController {

    @Autowired
    private CrawlerContentMapper crawlerContentMapper;

    @RequestMapping("/getContent")
    public String crawler() {
        String url = "http://www.gxhz.gov.cn";

        try {
            Document doc = Jsoup.connect(url).get();
            List<CrawlerContent> list = CrawlerProcess.processCrawl(doc);
            crawlerContentMapper.insertBatch(list);
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "no";
        }
    }

}