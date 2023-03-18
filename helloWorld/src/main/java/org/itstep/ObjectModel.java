package org.itstep;

import org.itstep.models.Category;
import org.itstep.models.Post;

public class ObjectModel implements Runnable
{
    @Override
    public void run() {
        PostByCat();
    }

    private void PostByCat(){
        Category catNews = new Category();
        catNews.setName("News");
        Category catArticle = new Category();
        catArticle.setName("Articles");

        Post pNews = new Post();
        pNews.setTitle("Microsoft открыла доступ к chatGPT v4");
        pNews.setCategory(catNews);
        catNews.getPosts().add(pNews);

        Post pArticle = new Post();
        pArticle.setTitle("Как использовать chatGPT на работе");
        pArticle.setCategory(catArticle);
        catArticle.getPosts().add(pArticle);

//        System.out.println(
//                catArticle.getPosts().get(0).getCategory().getName()
//        );
//
//        System.out.println(catArticle.getName());

        try {
            someFun(pArticle.clone());
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }

        for (Post p: catArticle.getPosts()) {
            System.out.println(p.getTitle());
        }


//        System.out.println(catArticle.getPosts().get(0).getTitle());
//        pArticle.setTitle("А теперь заголовок будет другой");
//        System.out.println(catArticle.getPosts().get(0).getTitle());
//        someFun(pArticle);
//        System.out.println(catArticle.getPosts().get(0).getTitle());

    }

    private void someFun(Post p) {
        p.setTitle("Я меняю еще раз заголовок поста");
    }

}
