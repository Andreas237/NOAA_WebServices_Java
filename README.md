# NOAA_WebServices_Java

**Genesis:**
I have always been interested in weather.  I started a project working with E*TRADE's API to create a robo-trader.  After hitting hurdles even using the API I figured analyzing weather would be a better start, and [NOAA's APIs](https://www.ncdc.noaa.gov/cdo-web/webservices/v2#data) were an easy thing to use.

**Summary:**
I learned how to:
-open a connection passing headers
-receive a response
-process a variety of responses
-allow a user to interact with the API in real time

**//TO DO:**
My goal is to store the data in MongoDB and Derby DB and open those connection everytime the app starts, and only read in new data.  They are redundant, but using different connections is always fun.
I would also like to host the app.
