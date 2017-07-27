# JavaWebApp_Shop

0. Download AppacheTomcat, extract somewhere

1. Open project in Eclipse
2. Properties -> Project Facets. Check [Dynamic Web Module]=[3.1], Check [Java]=[1.8]
3. Run As -> Run on Server
4. Add AppacheTomcat, select path to AppacheTomcat (see 0.)
5. App start "http://localhost:8080/memVideo" by default

Probably work on other server (*), and can be opened from another IDE (if you can configure Project Facets)

* I try on glassfish, but can't configure JDBC connection pool.

P.S.
a. App create "%USER_PROFILE%/devDb.mv.db" database file, don't forget delete it.
b. H2 console is available at http://localhost:8080/memVideo/console
