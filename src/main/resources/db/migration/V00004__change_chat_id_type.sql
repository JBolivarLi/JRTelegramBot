-- Шаг 1: Удаление внешнего ключа
ALTER TABLE group_x_user DROP FOREIGN KEY group_x_user_ibfk_1;
-- Шаг 2: Изменение типа колонки chat_id в таблице tg_user
ALTER TABLE group_x_user MODIFY user_id INT;
-- Шаг 3: Изменение типа колонки user_id в таблице group_x_user
ALTER TABLE tg_user MODIFY chat_id INT;
-- Шаг 4: Восстановление внешнего ключа
ALTER TABLE group_x_user ADD CONSTRAINT group_x_user_ibfk_1 FOREIGN KEY (user_id) REFERENCES tg_user(chat_id); 