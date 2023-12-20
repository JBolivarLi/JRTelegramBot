package com.github.JBolivarLi.javarushtelegrambot.bot.javarushclient.dto;

import lombok.Data;

@Data
/**
 * Group information related to authorized user. If there is no user - will be null.
 */
public class MeGroupInfo {
    private  MeGroupInfoStatus status;
    private Integer userGroupId;
}
