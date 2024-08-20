package org.exemple.tests.pagetests;
import org.exemple.pages.FoodPage;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddFoodTests extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("Добавление неэкзотического овощя в список товаров")
    public void addNotExoticVegetable() {
        FoodPage foodPage = new FoodPage();
        foodPage.checkFoodPageTitleIsVisible("Список товаров")
                .clickToAddBtn()
                .checkAddFormTitleIsVisible("Добавление товара")
                .fillNameField("Лук")
                .selectVegetableFromDropdownList("Овощ")
                .clickToSaveBtn()
                .checkFoodIsAdded("5", "Лук", "Овощ", "false");
    }

    @Test
    @Order(2)
    @DisplayName("Добавление неэкзотического фрукта в список товаров")
    public void addNotExoticFruit() {
        FoodPage foodPage = new FoodPage();
        foodPage.checkFoodPageTitleIsVisible( "Список товаров")
                .clickToAddBtn()
                .checkAddFormTitleIsVisible("Добавление товара")
                .fillNameField("Банан")
                .selectVegetableFromDropdownList("Фрукт")
                .clickToSaveBtn()
                .checkFoodIsAdded("5", "Банан", "Фрукт", "false");
    }

    @Test
    @Order(3)
    @DisplayName("Добавление экзотического овощя в список товаров")
    public void addExoticVegetable() {
        FoodPage foodPage = new FoodPage();
        foodPage.checkFoodPageTitleIsVisible( "Список товаров")
                .clickToAddBtn()
                .checkAddFormTitleIsVisible("Добавление товара")
                .fillNameField("Кивано")
                .selectVegetableFromDropdownList("Овощ")
                .enableExoticCheckbox()
                .clickToSaveBtn()
                .checkFoodIsAdded("5", "Кивано", "Овощ", "true");
    }

    @Test
    @Order(4)
    @DisplayName("Добавление экзотического фрукта в список товаров")
    public void addExoticFruit() {
        FoodPage foodPage = new FoodPage();
        foodPage.checkFoodPageTitleIsVisible( "Список товаров")
                .clickToAddBtn()
                .checkAddFormTitleIsVisible("Добавление товара")
                .fillNameField("Чили")
                .selectVegetableFromDropdownList("Овощ")
                .enableExoticCheckbox()
                .clickToSaveBtn()
                .checkFoodIsAdded("5", "Чили", "Овощ", "true");
    }

}
