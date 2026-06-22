import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

@pytest.fixture
def driver():
    driver = webdriver.Edge()
    driver.maximize_window()
    yield driver
    driver.quit()

def test_add_items_to_basket(driver):

    wait = WebDriverWait(driver, timeout=10)

    driver.get('https://sweetshop.vivrichards.co.uk/')
    browse_sweets = wait.until(EC.element_to_be_clickable((By.LINK_TEXT, "Browse Sweets")))
    browse_sweets.click()

    wait.until(EC.visibility_of_element_located((By.CLASS_NAME, "display-3")))

    chocolate_cups_button = wait.until(EC.element_to_be_clickable((By.XPATH, "//a[@class='btn btn-success btn-block addItem' and @data-name='Chocolate Cups']")))
    chocolate_cups_button.click()

    nerds_button = wait.until(EC.element_to_be_clickable((By.XPATH, "//a[@class='btn btn-success btn-block addItem' and @data-name='Nerds']")))
    nerds_button.click()
    wham_bar_button = wait.until(EC.element_to_be_clickable((By.XPATH, "//a[@class='btn btn-success btn-block addItem' and @data-name='Wham Bar']")))
    wham_bar_button.click()

    basket_link = wait.until(EC.element_to_be_clickable((By.XPATH, "//a[@href='/basket']")))
    basket_link.click()

    wait.until(EC.visibility_of_element_located((By.CLASS_NAME, 'display-3')))

    basket_page = driver.page_source

    assert "Chocolate Cups" in basket_page
    assert "Nerds" in basket_page
    assert "Wham Bar" in basket_page







