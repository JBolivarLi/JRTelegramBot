package com.github.JBolivarLi.javarushtelegrambot.bot.job;


import com.github.JBolivarLi.javarushtelegrambot.bot.service.FindNewPostsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Job for finding new posts.
 */
@Slf4j
@Component
public class FindNewPostsJob {

    private final FindNewPostsService findNewPostsService;

    @Autowired
    public FindNewPostsJob(FindNewPostsService findNewPostsService) {
        this.findNewPostsService = findNewPostsService;
    }

    @Scheduled(fixedRateString = "${bot.recountNewPostsFixedRate}")
    public void findNewPosts() {
        LocalDateTime start = LocalDateTime.now();

        log.info("Find new post job started.");

        findNewPostsService.findNewPosts();

        LocalDateTime end = LocalDateTime.now();

        log.info("Find new posts job finished. Took seconds: {}",
                end.toEpochSecond(ZoneOffset.UTC) - start.toEpochSecond(ZoneOffset.UTC));
    }
}

