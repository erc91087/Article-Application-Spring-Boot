package main;


import model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/articles")        // allows localhost to display List in ArticleService ex: http://localhost:8080/articles
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    // had to add <build> in pom due to error in target bytecode
    @RequestMapping("/articles/{id}")          // ex: http://localhost:8080/articles/1
    public Article getArticles(@PathVariable String id) {
        return articleService.getArticle(id);
    }

    // allowed us to add articles
    @RequestMapping(method = RequestMethod.POST, value = "/articles")
    public void addArticle(@RequestBody Article article) {
        articleService.addArticle(article);
    }

    // allowed us to change the article #'s
    @RequestMapping(method = RequestMethod.PUT, value = "/articles/{id}")
    public void updateArticle(@RequestBody Article article, @PathVariable String id) {
        articleService.updateArticle(article, id);   // automated method for updateArticle in ArticleService
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/articles/{id}")
    public void deleteArticle(@PathVariable String id) {
        articleService.deleteArticle(id);   // automated method for deleteArticle in ArticleService
    }
}
