package com.github.JBolivarLi.javarushtelegrambot.bot.service;


/**
 * Service for finding new articles.
 */
public interface FindNewArticleService {

    /**
     * Find new articles and notify subscribers about it.
     */
    void findNewArticles();
}