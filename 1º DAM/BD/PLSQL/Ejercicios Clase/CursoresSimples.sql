SET SERVEROUTPUT ON;
SET VERIFY OFF;

/* Ejercicio 1 */
DECLARE 
    nume EMPLE.DEPT_NO%TYPE;
    nemple NUMBER(3);
    mediasal EMPLE.SALARIO%TYPE;
    sueldomax EMPLE.SALARIO%TYPE;
    sueldomin EMPLE.SALARIO%TYPE;
    sumasal EMPLE.SALARIO%TYPE;
    CURSOR ejem IS SELECT DEPT_NO, COUNT(*) NEMPLEADOS, AVG(SALARIO) MEDIA_SALARIO, MAX(SALARIO) SALARIO_MAX
    , MIN(SALARIO) SALARIO_MIN, SUM(SALARIO) SUMA_SALARIOS
    FROM EMPLE
    GROUP BY DEPT_NO;
    R_EJEM EJEM% ROWTYPE; --REGISTRO PARA PROCESAR ELEMENTOS DEL CURSOR
    totalemple NUMBER(4):=0;
    totalmedia NUMBER(13):=0;
    totalmax NUMBER(13):=0;
    totalmin NUMBER(13):=0;
    totalsuma NUMBER(13):=0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('DEPT_NO   NUM EMPLES   MEDIA SALARIO   SALARIO MAX   SALARIO MIN  SUMA SALARIO');
    DBMS_OUTPUT.PUT_LINE('-------   ----------- -------------- --------------- ------------  -----------');
    OPEN ejem;
    LOOP
        FETCH ejem INTO nume, nemple, mediasal, sueldomax, sueldomin, sumasal;
        EXIT WHEN ejem%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(RPAD(TO_CHAR(nume), 10, ' ') || RPAD(TO_CHAR(nemple), 12, ' ') ||
        RPAD(TO_CHAR(mediasal, '9G999D99'), 15, ' ') || RPAD(TO_CHAR(sueldomax, '9G999D99'),16,' ') ||
        RPAD(TO_CHAR(sueldomin, '9G999D99'),14, ' ') || RPAD(TO_CHAR(sumasal, '99G999D99'),11, ' '));
        --ACUMULAMOS TOTALES
        totalemple:=totalemple+nemple;
        totalmedia:=totalmedia+mediasal;
        totalmax:=totalmax+sueldomax;
        totalmin:=totalmin+sueldomin;
        totalsuma:=totalsuma+sumasal;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('-------   ----------- -------------- --------------- ------------  -----------');
    DBMS_OUTPUT.PUT_LINE(RPAD('TOTAL: ',10,' ') || RPAD(TO_CHAR(totalemple), 12, ' ') ||
        RPAD(TO_CHAR(totalmedia, '9G999D99'), 14, ' ') || RPAD(TO_CHAR(totalmax, '999G999D99'),16,' ') ||
        RPAD(TO_CHAR(totalmin, '99G999D99'),14, ' ') || RPAD(TO_CHAR(totalsuma, '999G999D99'),11, ' '));
        --ACUMULAMOS TOTALES
    CLOSE ejem;
END;

/* Ejercicio 2 */

ACCEPT nombre PROMPT 'Digame el nombre del departamento';
DECLARE
    nom DEPART.DNOMBRE%TYPE:='&nombre';
    numem EMPLE.EMP_NO%TYPE;
    ape EMPLE.APELLIDO%TYPE;
    sal EMPLE.SALARIO%TYPE;
    fech EMPLE.FECHA_ALT%TYPE;
    comi EMPLE.COMISION%TYPE;
    salcomi NUMBER(15):=0;
    totalsal NUMBER(15):=0;
    totalsalcomi NUMBER(15):=0;
    CURSOR info is SELECT EMP_NO, APELLIDO, SALARIO, FECHA_ALT, COMISION, SUM(SALARIO+COMISION) SALMASCOMI FROM
    EMPLE WHERE DEPT_NO = (SELECT DEPT_NO FROM DEPART WHERE UPPER(DNOMBRE)=UPPER(nom)) group by EMP_NO, APELLIDO, SALARIO, FECHA_ALT, COMISION ORDER BY EMP_NO;
BEGIN
    DBMS_OUTPUT.PUT_LINE('NOMBRE DE DEPARTAMENTO: ' || nom);
    DBMS_OUTPUT.PUT_LINE('EMPNO     APELLIDO     SALARIO        FECHA_ALTA      COMISION    SALARIO+COMISION ');
    DBMS_OUTPUT.PUT_LINE('-------   ----------- -------------- --------------- ------------  ------------');
    OPEN info;
    LOOP
        FETCH info INTO numem, ape, sal, fech, comi, salcomi;
        EXIT WHEN info %NOTFOUND;
        salcomi:=0;
        salcomi:=sal+comi;
        totalsalcomi:=totalsalcomi+NVL(salcomi, 0);
        DBMS_OUTPUT.PUT_LINE(RPAD(TO_CHAR(numem),12, ' ') || RPAD(TO_CHAR(ape),12, ' ')
        || RPAD(TO_CHAR(sal, '99G999D99'),15, ' ') || RPAD(TO_CHAR(fech),13,' ') || RPAD(TO_CHAR(comi,'99G999D99'),15,' ')
        || RPAD(TO_CHAR(salcomi, '999G999D99'), 15, ' '));
        totalsal:=totalsal+sal;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('-------   ----------- -------------- --------------- ------------  ------------');
    DBMS_OUTPUT.PUT_LINE('TOTAL SALARIO: ' || TO_CHAR(totalsal, '999G999D99L'));
    DBMS_OUTPUT.PUT_LINE('TOTAL SALARIO+comision: ' || TO_CHAR(totalsalcomi, '999G999D99L'));
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('El departamento con el nombre ' || nom || ' no existe en la base de datos.');
        -- Aqu� puedes manejar el caso en el que el departamento no existe
END;

/*Ejercicio 3*/
DECLARE
    CURSOR C IS SELECT NUM_COMPRA, CODARTI, DENOMINACION,
    CATEGORIA, UNIDADES, PVP, (PVP*UNIDADES) IMPORTE,
    (STOCK-UNIDADES) STOCK_ACTUAL FROM DET_COMPRAS
    JOIN ARTICULOS USING(CODARTI); 
    REG C%ROWTYPE;
    totalunidades NUMBER(7):=0;
    totalimporte NUMBER(8):=0;
BEGIN
    OPEN C;
    DBMS_OUTPUT.PUT_LINE('NUM_COMPRA  CODARTI   DENOMINACION  CATEGORIA  UNIDADES  PVP  IMPORTE  STOCK-ACTUAL');
    DBMS_OUTPUT.PUT_LINE('----------  -------  -------------- ---------  --------  ---- ------- -------------');
    LOOP
        FETCH C INTO REG;
        DBMS_OUTPUT.PUT_LINE(RPAD(TO_CHAR(REG.NUM_COMPRA), 12, ' ') || RPAD(TO_CHAR(REG.CODARTI), 10, ' ') || RPAD(TO_CHAR(REG.DENOMINACION), 14, ' ') ||
        RPAD(TO_CHAR(REG.CATEGORIA), 11, ' ') || RPAD(TO_CHAR(REG.UNIDADES), 10, ' ') || RPAD(TO_CHAR(REG.PVP) ||'�', 7, ' ') ||
        RPAD(TO_CHAR(REG.IMPORTE) ||'�', 9, ' ') || RPAD(TO_CHAR(REG.STOCK_ACTUAL), 6, ' '));
        totalunidades:= totalunidades + REG.UNIDADES;
        totalimporte:= totalimporte + REG.IMPORTE;
        EXIT WHEN C%NOTFOUND;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('----------  -------  -------------- ---------  --------  ---- ------- -------------');
    DBMS_OUTPUT.PUT_LINE('TOTAL DE UNIDADES ' || totalunidades);
    DBMS_OUTPUT.PUT_LINE('TOTAL DE IMPORTE '|| totalimporte || '�');
END;

/*Ejercicio 4*/
DECLARE
    CURSOR C IS SELECT CODALMA, NOMBRE, COUNT (*) NUM_COMPRAS,
    SUM(PVP*UNIDADES)TOTAL_IMPORTE FROM ALMACENES JOIN COMPRAS
    USING (CODALMA) JOIN DET_COMPRAS USING(NUM_COMPRA)
    JOIN ARTICULOS USING (CODARTI) GROUP BY CODALMA, NOMBRE;
    REG C%ROWTYPE;
BEGIN
    OPEN C;
    DBMS_OUTPUT.PUT_LINE('COD_ALMACEN	  NOMBRE	    NUM_COMPRAS 	TOTAL IMPORTE');
    DBMS_OUTPUT.PUT_LINE('-----------    ----------      -------------    -------------');
    LOOP
        FETCH C INTO REG;
        DBMS_OUTPUT.PUT_LINE(RPAD(TO_CHAR(REG.CODALMA),14, ' ') || RPAD(TO_CHAR(REG.NOMBRE),12, ' ') ||
        RPAD(TO_CHAR(REG.NUM_COMPRAS),13, ' ') || RPAD(TO_CHAR(REG.TOTAL_IMPORTE),15, ' '));
        EXIT WHEN C%NOTFOUND;
    END LOOP;
    CLOSE C;
END;
