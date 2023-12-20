package com.github.JBolivarLi.javarushtelegrambot.bot.service;

import com.github.JBolivarLi.javarushtelegrambot.bot.javarushclient.dto.GroupDiscussionInfo;
import com.github.JBolivarLi.javarushtelegrambot.bot.repository.entity.GroupSub;

/**
 * Service for manipulating with {@link GroupSub}.
 */
/**
 * Service for manipulating with {@link GroupSub}.
 */
public interface GroupSubService {

    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);

}