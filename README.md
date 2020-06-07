# shorturl
shorturl service converts original urls to short urls \
contains two method\
    1. converts original urls  to short urls\
    2. fetches original url from short url
    
  Tech stack : Spring boot , Apache redis , and Google Guava library
  
   1 . http://localhost:8080/api/shorturl  with Raw body {https://www.linkedin.com/in/sreedhar-babu-puttu-837a55101/} =Returns==> a549aec5 \
   2.  http://localhost:8080/api/shorturl/a549aec5 =Returns==> https://www.linkedin.com/in/sreedhar-babu-puttu-837a55101
