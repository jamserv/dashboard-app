# dashboard-app

Download image https://hub.docker.com/_/solr/

1. docker pull solr

2. docker run --name dashboard-solr -d -p 8983:8983 -t solr

3. docker exec -it --user=solr dashboard-solr bin/solr create_core -c dashboard-core

4. npm run serve
