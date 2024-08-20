package org.exemple.tests.databasetests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTests extends BaseDbTest{

    @Test
    @DisplayName("Проверка записи в БД при добавлении нового товара")
    public void checkAddFood() throws SQLException {

        String addNotExoticVegetable = "INSERT INTO food VALUES(5, 'Лук', 'VEGETABLE', false)";
        String selectQuery = "SELECT * FROM food WHERE food_name = 'Лук'";
        String deleteQuery = "DELETE FROM food WHERE food_name = 'Лук'";
        statement.executeUpdate(addNotExoticVegetable);
        ResultSet resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()) {
            int foodId = resultSet.getInt(1);
            String foodName = resultSet.getString(2);
            String foodType = resultSet.getString(3);
            boolean foodIsExotic = resultSet.getBoolean(4);
            System.out.println(foodId + " " + foodName + " " + foodType + " " + foodIsExotic);
            assertAll("Прповерка добавления товара в БД",
                    () -> assertEquals(5, foodId, "Неверный id при записи в БД"),
                    () -> assertEquals("Лук", foodName, "Неверный name при записи в БД"),
                    () -> assertEquals("VEGETABLE", foodType, "Неверный type при записи в БД"),
                    () -> assertEquals(false, foodIsExotic, "Неверный type при записи в БД"));
        }

        statement.executeUpdate(deleteQuery);
    }



//    }


}
