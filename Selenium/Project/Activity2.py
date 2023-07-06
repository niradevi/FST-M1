# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service = service) as driver:

    # Open the browser to the URL
    driver.get("http://alchemy.hguy.co/crm")

    pageTitle = driver.title
    print(pageTitle)
    assert (pageTitle=="SuiteCRM")
    src = driver.find_element(By.XPATH,"//img[@alt='SuiteCRM']").get_attribute("src")
    print(src)
    assert src is not None

    driver.quit()