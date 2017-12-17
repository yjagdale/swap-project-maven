#mvn -DbrowserType=firefox -DenvProperty=QA -DsuiteDir=regression.xml test


$ mvn -DbrowserType=firefox -DenvProperty=QA -DsuiteDir=regression.xml -DhubURL=http://192.168.0.5:4444/wd/hub test