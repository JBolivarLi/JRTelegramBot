package com.github.JBolivarLi.javarushtelegrambot.bot.command.annotation;


import com.github.JBolivarLi.javarushtelegrambot.bot.command.Command;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Mark if {@link Command} can be viewed only by admins.
 */
@Retention(RUNTIME)
public @interface AdminCommand {
}