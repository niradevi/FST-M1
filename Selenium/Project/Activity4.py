
# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service = service) as driver:

    # Open the browser to the URL
    driver.get("http://alchemy.hguy.co/crm")

    username_input = driver.find_element(By.ID, "user_name")
    username_input.send_keys("admin")

    password_input = driver.find_element(By.ID, "username_password")
    password_input.send_keys("pa$$w0rd")

    login_button = driver.find_element(By.ID, "bigbutton")
    login_button.click()

    recently_viewed_sidebar = WebDriverWait(driver, 10).until(
        EC.visibility_of_element_located((By.ID, "recentlyViewedSidebar"))
    )
    assert recently_viewed_sidebar.is_displayed()

    driver.quit()