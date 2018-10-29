# Dashboard App - Accionese

Download image https://hub.docker.com/_/solr/

1. docker pull solr

2. docker run --name dashboard-solr -d -p 8983:8983 -t solr

3. docker exec -it --user=solr dashboard-solr bin/solr create_core -c dashboard-core

**NOTES**
* DELETE ALL DOCs

```xml
<delete>
    <query>*:*</query>
</delete>
```

**Operation Types**

* INV_ANUAL_TYPE --> year
* EV_INV_BRAND --> brand * year
* EVO_INV_BRAND_SUPPORT_TYPE --> brand * year
* INV_BY_SECTOR --> year
* INV_BY_CITY --> year
* INV_SUPPORT_TYPE --> year
* TOTAL_INV --> year
* TOP_CAMPANAS --> brand * yea
