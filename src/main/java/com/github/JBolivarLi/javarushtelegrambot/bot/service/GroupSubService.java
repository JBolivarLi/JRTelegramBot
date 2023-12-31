package com.github.JBolivarLi.javarushtelegrambot.bot.service;

import com.github.JBolivarLi.javarushtelegrambot.bot.javarushclient.dto.GroupDiscussionInfo;
import com.github.JBolivarLi.javarushtelegrambot.bot.repository.entity.GroupSub;

import java.util.List;
import java.util.Optional;

/**
 * Service for manipulating with {@link GroupSub}.
 */
/**
 * Service for manipulating with {@link GroupSub}.
 */
public interface GroupSubService {

    GroupSub save(Long chatId, GroupDiscussionInfo groupDiscussionInfo);

    GroupSub save(GroupSub groupSub);

    Optional<GroupSub> findById(Integer id);
    List<GroupSub> findAll();

}