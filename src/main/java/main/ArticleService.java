package main;

import model.Article;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service    // what is displayed on the localhost
public class ArticleService {

    List<Article> articleList = new ArrayList<Article>(Arrays.asList(
            new Article("1", "Article 01", "Description 01"),
            new Article("2", "Article 02", "Description 02"),
            new Article("3", "Article 03", "Description 03")
    ));

    public List<Article> getAllArticles () {
        return articleList;
    }

    public Article getArticle(String id) {
        // right-clicked ArticleApplication -> Open Module Settings -> Language Level to 8 Lambdas type...
        return articleList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addArticle(Article article) {   // added from ArticleController
        articleList.add(article);
    }

    // added for PUT method from ArticleController
    public void updateArticle(Article art, String id) {         // added Article art
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);

            if (article.getId().equals(id)) {
                articleList.set(i, art);                        // adjusted arguments
            }
        }
    }

    // added for DELETE method from ArticleController
    public void deleteArticle(String id) {
        articleList.removeIf(t -> t.getId().equals(id));
    }
}
