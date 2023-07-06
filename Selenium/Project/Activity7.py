
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
    wait = WebDriverWait(driver, 10)

    username_input = driver.find_element(By.ID, "user_name")
    username_input.send_keys("admin")

    password_input = driver.find_element(By.ID, "username_password")
    password_input.send_keys("pa$$w0rd")

    login_button = driver.find_element(By.ID, "bigbutton")
    login_button.click()

    sales_link = wait.until(EC.visibility_of_element_located((By.XPATH, "//a[text()='Sales']")))
    sales_link.click()

    leads_tab = wait.until(EC.visibility_of_element_located((By.ID, "moduleTab_9_Leads")))
    leads_tab.click()

    additional_details = wait.until(EC.visibility_of_element_located((By.XPATH, "//span[@title='Additional Details'][1]")))
    additional_details.click()

    driver.implicitly_wait(20)  # Wait for 20 seconds for elements to be present

    phone_number = driver.find_element(By.XPATH, "//span[@class='phone']").text
    print(phone_number)

driver.quit()