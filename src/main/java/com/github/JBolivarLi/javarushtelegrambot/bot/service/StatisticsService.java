package com.github.JBolivarLi.javarushtelegrambot.bot.service;


import com.github.JBolivarLi.javarushtelegrambot.bot.dto.StatisticDTO;

/**
 * Service for getting bot statistics.
 */
public interface StatisticsService {
    StatisticDTO countBotStatistic();
}