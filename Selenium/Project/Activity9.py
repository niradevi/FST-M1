
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

    leads_tab = driver.find_element(By.ID, "moduleTab_9_Leads")
    leads_tab.click()

    table_row = wait.until(EC.visibility_of_element_located((By.XPATH, "//tr[@class='oddListRowS1']")))
    names = driver.find_elements(By.XPATH, "//tr/td[@field='name']")
    users = driver.find_elements(By.XPATH, "//tr/td[@field='assigned_user_name']")

    for i in range(10):
        print(names[i].text+"--- "+users[i].text)

driver.quit()