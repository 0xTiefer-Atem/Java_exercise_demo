package org.wq.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupTest {
    public static void getHtmlElementValue(String URL) throws IOException {
        Document document = Jsoup.connect(URL).userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)").get();
        Element element_g_nav2 = document.getElementById("g_nav2");
        Elements elements = element_g_nav2.select("a");
        for (Element element:elements) {
            String g_nav2URL = URL+"m"+element.attr("href");
            if(g_nav2URL.contains("toplist")){
                Document document1 = Jsoup.connect(g_nav2URL).userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)").get();
                System.out.println(document1);
            }
        }
    }

    public static void jsoupTest() throws IOException {
        //获取编辑推荐页
        Document document=Jsoup.connect("https://www.zhihu.com/explore/recommendations")
                //模拟火狐浏览器
                .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                .get();
        System.out.println(document);
        Element main=document.getElementById("zh-recommend-list-full");
        Elements url=main.select("div").select("div:nth-child(2)")
                .select("h2").select("a[class=question_link]");
        for(Element question:url){
            //输出href后的值，即主页上每个关注问题的链接
            String URL="https://www.zhihu.com"+question.attr("href");
            //下载问题链接指向的页面
            Document document2=Jsoup.connect(URL)
                    .userAgent(" Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.81 Safari/537.36")
                    .get();
            //问题
            Elements title=document2.select("div").select("h1.QuestionHeader-title");
            //问题描述
            Elements detail=document2.select("div").select("div.QuestionHeader-detail")
                    .select("span");
            //回答
            Elements answer=document2.select("div")
                    .select("div.RichContent-inner")
                    .select("span");
            System.out.println("\n"+"链接："+URL
                    +"\n"+"标题："+title.text()
                    +"\n"+"问题描述："+detail.text()
                    +"\n"+"回答："+answer.text());
        }
    }
}