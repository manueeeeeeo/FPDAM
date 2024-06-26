/*1º*/
SELECT * FROM PRODUCTOS WHERE
TRIM(TIPO) LIKE 'A' AND PVP>20
ORDER BY codproducto;

/*2º*/
SELECT TIPO, COUNT(*)"Nº DE TIPOS" FROM PRODUCTOS 
GROUP BY TIPO;

/*3º*/
SELECT CODPRODUCTO, DENOMINACION FROM PRODUCTOS
WHERE CODPRODUCTO NOT IN (SELECT CODPRODUCTO FROM DETCOMPRAS);

/*4º*/
SELECT CODCLIENTE, NOMBRE FROM CLIENTES
WHERE CODCLIENTE IN (SELECT CODCLIENTE FROM DETCOMPRAS WHERE
CODPRODUCTO IN (SELECT CODPRODUCTO FROM PRODUCTOS WHERE TRIM(TIPO) LIKE 'A'))
AND POBLACION LIKE 'MADRID'
GROUP BY CODCLIENTE, NOMBRE
ORDER BY CODCLIENTE;

/*5º*/
SELECT * FROM PRODUCTOS 
WHERE PVP>=30 AND CODPRODUCTO IN (SELECT CODPRODUCTO FROM DETCOMPRAS
WHERE NUMCOMPRA IN (SELECT NUMCOMPRA FROM COMPRAS WHERE CODCLIENTE
IN (SELECT CODCLIENTE FROM CLIENTES WHERE POBLACION LIKE 'TALAVERA')))
ORDER BY CODPRODUCTO;

/*6º Salen repetidos, pero como no pone en el enunciado nada de que no tienen que 
salir repetidos, por eso no los he quitado*/
SELECT NUMCOMPRA, FECHA, CODCLIENTE, NOMBRE FROM COMPRAS JOIN
CLIENTES USING(CODCLIENTE)
where (months_between(sysdate,fecha))<=3 AND POBLACION LIKE 'MADRID'
ORDER BY NUMCOMPRA, CODCLIENTE;

/*7º*/
SELECT CODCLIENTE, NOMBRE, COUNT (NUMCOMPRA) "Nº COMPRAS",  TO_CHAR(pvp*SUM(UNIDADES),'999G999L') "TOTAL COMPRAS"
FROM CLIENTES LEFT JOIN compras USING (CODCLIENTE) JOIN detcompras USING(NUMCOMPRA) JOIN PRODUCTOS USING(CODPRODUCTO)
GROUP BY CODCLIENTE, NOMBRE,PVP
ORDER BY CODCLIENTE;

/*8º*/
SELECT CODPRODUCTO, DENOMINACION, TIPO, PVP, SUM(UNIDADES)"SUMA UNIDADES", TO_CHAR(trunc(pvp*SUM(UNIDADES)),'999G999L')"IMPORTE TOTAL",
(STOCK - SUM(UNIDADES)) "STOCK ACTUAL" FROM PRODUCTOS JOIN
DETCOMPRAS USING (CODPRODUCTO)
GROUP BY CODPRODUCTO, DENOMINACION, TIPO, PVP, STOCK
ORDER BY CODPRODUCTO;

/*9º*/
SELECT CODPRODUCTO, DENOMINACION, TIPO, PVP, (STOCK - SUM(UNIDADES)) "STOCK ACTUAL" FROM PRODUCTOS JOIN
DETCOMPRAS USING (CODPRODUCTO)
GROUP BY CODPRODUCTO, DENOMINACION, TIPO, PVP, STOCK
HAVING (STOCK - SUM(UNIDADES))<0
ORDER BY CODPRODUCTO;

/*10º DETERMINO QUE SOLO HAY UN PRODUCTO CON UN PRECIO MAS BAJO*/
SELECT c.CODCLIENTE, NOMBRE, p.CODPRODUCTO, DENOMINACION FROM CLIENTES c, DETCOMPRAS d, COMPRAS s, PRODUCTOS p
WHERE (p.codproducto=d.codproducto) and (d.numcompra=s.numcompra) and (s.codcliente=c.codcliente) and
p.pvp = (SELECT MIN(pvp) from PRODUCTOS)
GROUP BY c.CODCLIENTE, NOMBRE, p.CODPRODUCTO, DENOMINACION
ORDER BY NOMBRE;

/*11º*/
SELECT CODPRODUCTO, DENOMINACION,TIPO, PVP, SUM(UNIDADES) "TOTAL DE UNIDADES" FROM PRODUCTOS JOIN
DETCOMPRAS USING(CODPRODUCTO)
GROUP BY CODPRODUCTO, DENOMINACION, TIPO, PVP
HAVING MAX(UNIDADES) IN (SELECT MAX(UNIDADES) FROM DETCOMPRAS)
ORDER BY CODPRODUCTO;

/*12º*/
SELECT CODPRODUCTO, DENOMINACION, TIPO, PVP, (DECODE(TIPO, 'A', 21, 'B', 10, 'C',4))/100"IVA A APLICAR", 
PVP*(DECODE(TIPO, 'A', 21, 'B', 10, 'C',4))/100"IVA CALCULADO", TO_CHAR(PVP+
PVP*(DECODE(TIPO, 'A', 21, 'B', 10, 'C',4))/100,'999G999D99L')"PRECIO MAS IVA" FROM PRODUCTOS
GROUP BY CODPRODUCTO, DENOMINACION, TIPO, PVP
ORDER BY CODPRODUCTO;

/*13º*/
SELECT CODCLIENTE, NOMBRE, NUMCOMPRA, FECHA, CODPRODUCTO, DENOMINACION, PVP, (DECODE(TIPO, 'A', 21, 'B', 10, 'C',4))/100"IVA A APLICAR", 
PVP*(DECODE(TIPO, 'A', 21, 'B', 10, 'C',4))/100"IVA CALCULADO", TO_CHAR(PVP+
PVP*(DECODE(TIPO, 'A', 21, 'B', 10, 'C',4))/100,'999G999D99L')"PRECIO CON IVA"FROM CLIENTES
JOIN COMPRAS USING(CODCLIENTE) JOIN DETCOMPRAS USING(NUMCOMPRA) JOIN PRODUCTOS USING (CODPRODUCTO)
ORDER BY CODCLIENTE, NUMCOMPRA, CODPRODUCTO;

/*14º*/
SELECT CODCLIENTE, NOMBRE, COUNT(NUMCOMPRA) "Nº COMPRAS" FROM CLIENTES JOIN COMPRAS USING (CODCLIENTE)
GROUP BY CODCLIENTE, NOMBRE
HAVING COUNT(NUMCOMPRA) IN (SELECT NUMCOMPRA FROM COMPRAS);

/*15º*/
SELECT NUMCOMPRA, FECHA, CODCLIENTE, TO_CHAR((SUM(UNIDADES)*PVP),'999G999L') "TOTAL SIN IVA", SUM(UNIDADES)*PVP*(DECODE(TIPO, 'A', 21, 'B', 10, 'C',4))/100
"SUMA DEL IVA", TO_CHAR(PVP+
SUM(UNIDADES)*PVP*(DECODE(TIPO, 'A', 21, 'B', 10, 'C',4))/100,'999G999D99L')"TOTAL CON IVA"  FROM CLIENTES JOIN
COMPRAS USING (CODCLIENTE) JOIN DETCOMPRAS USING(NUMCOMPRA) JOIN PRODUCTOS USING (CODPRODUCTO)
GROUP BY NUMCOMPRA, CODCLIENTE, FECHA, PVP, TIPO
ORDER BY NUMCOMPRA, CODCLIENTE;

/*16º*/
SELECT AVG(DISTINCT CODPRODUCTO) "MEDIA DE PRODUCTOS DIFERENTES" FROM PRODUCTOS JOIN
DETCOMPRAS USING (CODPRODUCTO) JOIN COMPRAS USING (NUMCOMPRA) JOIN
CLIENTES USING(CODCLIENTE) WHERE POBLACION LIKE 'TALAVERA';
