Alkalmazás sima spring-boot-ként indítható, profile nélkül.

swagger hozzá: http://localhost:8080/swagger-ui/index.html

ERP feladat az a com.example.qlm.erp package alatt található. Itt controllerben lehet megadni neki. Példa hívás: /api/classroom/seating

{
"numberOfTables": 15,
"reservedTables": [
1
]
}

Másik feladat com.example.qlm.wms alatt. Itt controllerbe állítottam be konkrét adatokat, inputként nem lehet beadni. És logban írja ki reklám megjelenéseket. Futtatni:
/api/advertisement