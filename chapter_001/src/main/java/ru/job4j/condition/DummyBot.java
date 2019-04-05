package ru.job4j.condition;

/**
 * Dummy bot
 */
public class DummyBot {
    /**
     * Bot answers
     * @param question string
     * @return answer
     */
    public String answer(String question) {

        String rs1 = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот".equals(question)) {
            rs1 = "Привет, Умник.";
        } else if ("Пока".equals(question)) {
            rs1 = "До скорой встречи.";
        }
        return rs1;
    }
}
