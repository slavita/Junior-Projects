package com.test.inject;

/** С помощью класса Field(поле) можно получить имя поля, тип и модификаторы */
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

class FieldReflector {
    /**
     * Собирает поля от класса @param clazz до @param upperBound.
     * @return List полей.
     */
    static List<Field> collectUpTo(Class<?> clazz, Class<?> upperBound) {
        ArrayList<Field> result = new ArrayList<>();
        Class<?> current = clazz;
        while (current != upperBound) {
            /**  получаем все поля данного класса */
            result.addAll(asList(current.getDeclaredFields()));
            /** рекурсивно поднимаеся вверх по иерархии */
            current = current.getSuperclass();
        }
        return result;
    }

    /**
     * Получает List полей и фильтрует, оставляя только те, который отмарканые аннотацией Inject
     * @return List отфильтрованых полей
     */
    static List<Field> filterInject(List<Field> allFields) {
        ArrayList<Field> result = new ArrayList<>();
        for (Field field : allFields) {
            /** Возвращает аннотацию этого элемента указанного типа,
             *  если такая аннотация присутствует, или null */
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                result.add(field);
            }
        }
        return result;
    }
}
