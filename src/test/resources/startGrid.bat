start java -jar c:\Grid\selenium-server-standalone-3.9.1.jar -role hub
start java -Dwebdriver.chrome.driver=c:/bin/chromedriver.exe -jar c:\Grid\selenium-server-standalone-3.9.1.jar -role webdriver -hub http://192.168.1.7:4444/grid/register -port 5558 -browser browserName=chrome

