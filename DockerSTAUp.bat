docker pull selenium/standalone-chrome:latest
docker run -d --name ChromeTest -p 4444:4444 -p 7900:7900 --shm-size 2g selenium/standalone-chrome:latest