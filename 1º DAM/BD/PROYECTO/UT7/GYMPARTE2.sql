/*EJERCICIO 2 PL SQL: Haz un bloque de pl sql al cu�l le daremos un dni (pedido al usuario que ejecute
el programa) Y nos muestre todas las salas a las que ha accedido el cliente, ten en cuenta que 
se le puede dar un dni que no est� en la base de datos o que el dni que se le de sea de un cliente que aun no ha
accedido a ninguna sala. Coloca las columnas de forma correcta*/
SET SERVEROUTPUT ON;
SET VERIFY OFF;

--ESTABLECEMOS LA FORMA EN LA QUE PEDIDOS EL DNI DEL CLIENTE
ACCEPT dni PROMPT 'Digame el DNI del Cliente que desea consultar';

--DECLARAMOS LAS VARIABLES, EL DNI QUE PEDIMOS, UN CURSOR PARA CARGAR LOS DATOS DEL CLIENTE CON ESE DNI
--OTRO CURSOR PARA CARGAR LOS DATOS DE LAS SALAS A LAS QUE HA ACCEIDO Y UN CONTADOR PARA OBTENER EL TOTAL
--DE SALAS A LAS QUE HA ACCEDIDO ESE CLIENTE
DECLARE
    dniC CLIENTES.DNI%TYPE:='&dni';
    
    CURSOR C (dniCl CLIENTES.DNI%TYPE) IS SELECT
        DNI, NOMBRE, EDAD FROM CLIENTES WHERE DNI=dniCl;
    REG1 C%ROWTYPE;
        
    CURSOR C2 (dniCli CLIENTES.DNI%TYPE) IS SELECT
        DNI, COD_SALA, NOMBRE, M2 FROM ACCEDE_CLIENTE_A_SALA JOIN SALA USING (COD_SALA) WHERE DNI=dniCli;
    REG2 C2%ROWTYPE;
    
    totalSalas NUMBER:=0;
   
--EMPEZAMOS CON EL PROGRAMA
BEGIN
    --ABRIMOS EL CURSOR Y LE DAMOS EL PARAMETRO QUE VAMOS A INTRODUCIR
    OPEN C(dniC);
    FETCH C INTO REG1;
    --CONDICIONAL PARA SABER SI EL DNI INTRODUCIDO EST� ASOCIADO A UN CLIENTE DE LA BD O NO
    IF C%FOUND THEN
        DBMS_OUTPUT.PUT_LINE('DNI: ' || REG1.DNI || ' Nombre: ' || REG1.NOMBRE || ' Edad: ' || REG1.EDAD || CHR(10));
        DBMS_OUTPUT.PUT_LINE('TODAS LAS SALAS A LAS QUE HA ACCEDIDO ' || REG1.NOMBRE || CHR(10));
        DBMS_OUTPUT.PUT_LINE('COD SALA       NOMBRE           M2');
        DBMS_OUTPUT.PUT_LINE('--------       -------         ----');
        
        --ABRIMOS EL CURSOR C2 Y EMPEZAMOS CON EL LOOP PARA IMPRIMIR TODAS LAS SALAS A LAS QUE HA ACCEDIDO
        OPEN C2(dniC);
        LOOP
            FETCH C2 INTO REG2;
            EXIT WHEN C2%NOTFOUND;
            totalSalas := totalSalas + 1;
            DBMS_OUTPUT.PUT_LINE(RPAD(TO_CHAR(REG2.COD_SALA), 15, ' ') || RPAD(TO_CHAR(REG2.NOMBRE), 16, ' ') || 
            RPAD(TO_CHAR(REG2.M2)||'m2', 9, ' '));
        END LOOP;
        CLOSE C2;
        --CONDICIONAL PARA VER SI HA ESTADO EN ALGUNA SALA O NO
        IF totalSalas = 0 THEN
            DBMS_OUTPUT.PUT_LINE('El cliente con DNI ' || dniC || ' no ha accedido a ninguna sala.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('HA ACCEDIDO A UN TOTAL DE ' || totalSalas || ' SALAS');
        END IF;
    ELSE
        DBMS_OUTPUT.PUT_LINE('El cliente con DNI ' || dniC || ' no ha accedido a nuestro GYM todavia.');
    END IF;
    CLOSE C;
    
--MANEJAMOS LAS EXCEPCIONES
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END;


--CASOS DE PRUEBA

/*CASO DE USO 1: En este caso vamos a realizar una prueba con el DNI de cliente 00011100J que es el cliente que ha m�s
salas ha accedido. Al introducir su Dni deber� de salirnos las 5 salas a las que ha accedido*/
DECLARE
    dniC CLIENTES.DNI%TYPE:='00011100J';
    
    CURSOR C (dniCl CLIENTES.DNI%TYPE) IS SELECT
        DNI, NOMBRE, EDAD FROM CLIENTES WHERE DNI=dniCl;
    REG1 C%ROWTYPE;
        
    CURSOR C2 (dniCli CLIENTES.DNI%TYPE) IS SELECT
        DNI, COD_SALA, NOMBRE, M2 FROM ACCEDE_CLIENTE_A_SALA JOIN SALA USING (COD_SALA) WHERE DNI=dniCli;
    REG2 C2%ROWTYPE;
    
    totalSalas NUMBER:=0;
   
BEGIN
    OPEN C(dniC);
    FETCH C INTO REG1;
    IF C%FOUND THEN
        DBMS_OUTPUT.PUT_LINE('DNI: ' || REG1.DNI || ' Nombre: ' || REG1.NOMBRE || ' Edad: ' || REG1.EDAD || CHR(10));
        DBMS_OUTPUT.PUT_LINE('TODAS LAS SALAS A LAS QUE HA ACCEDIDO ' || REG1.NOMBRE || CHR(10));
        DBMS_OUTPUT.PUT_LINE('COD SALA       NOMBRE           M2');
        DBMS_OUTPUT.PUT_LINE('--------       -------         ----');
        
        OPEN C2(dniC);
        LOOP
            FETCH C2 INTO REG2;
            EXIT WHEN C2%NOTFOUND;
            totalSalas := totalSalas + 1;
            DBMS_OUTPUT.PUT_LINE(RPAD(TO_CHAR(REG2.COD_SALA), 15, ' ') || RPAD(TO_CHAR(REG2.NOMBRE), 16, ' ') || 
            RPAD(TO_CHAR(REG2.M2)||'m2', 9, ' '));
        END LOOP;
        CLOSE C2;
        IF totalSalas = 0 THEN
            DBMS_OUTPUT.PUT_LINE(CHR(10) || 'El cliente con DNI ' || dniC || ' no ha accedido a ninguna sala.');
        ELSE
            DBMS_OUTPUT.PUT_LINE(CHR(10) || 'HA ACCEDIDO A UN TOTAL DE ' || totalSalas || ' SALAS');
        END IF;
    ELSE
        DBMS_OUTPUT.PUT_LINE(CHR(10) || 'El cliente con DNI ' || dniC || ' no ha accedido a nuestro GYM todavia.');
    END IF;
    CLOSE C;
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END;


/*CASO DE USO 2: En este caso vamos a realizar una prueba con el DNI de cliente 'poner dni' que es un cliente
que aun no ha accedido a ninguna sala, aqu� estamos poniendo a prueba que el cliente si que existe, pero
no ha accedido a ninguna sala*/
DECLARE
    dniC CLIENTES.DNI%TYPE:='88888888H';
    
    CURSOR C (dniCl CLIENTES.DNI%TYPE) IS SELECT
        DNI, NOMBRE, EDAD FROM CLIENTES WHERE DNI=dniCl;
    REG1 C%ROWTYPE;
        
    CURSOR C2 (dniCli CLIENTES.DNI%TYPE) IS SELECT
        DNI, COD_SALA, NOMBRE, M2 FROM ACCEDE_CLIENTE_A_SALA JOIN SALA USING (COD_SALA) WHERE DNI=dniCli;
    REG2 C2%ROWTYPE;
    
    totalSalas NUMBER:=0;
   
BEGIN
    OPEN C(dniC);
    FETCH C INTO REG1;
    IF C%FOUND THEN
        DBMS_OUTPUT.PUT_LINE('DNI: ' || REG1.DNI || ' Nombre: ' || REG1.NOMBRE || ' Edad: ' || REG1.EDAD || CHR(10));
        DBMS_OUTPUT.PUT_LINE('TODAS LAS SALAS A LAS QUE HA ACCEDIDO ' || REG1.NOMBRE || CHR(10));
        DBMS_OUTPUT.PUT_LINE('COD SALA       NOMBRE           M2');
        DBMS_OUTPUT.PUT_LINE('--------       -------         ----');
        
        OPEN C2(dniC);
        LOOP
            FETCH C2 INTO REG2;
            EXIT WHEN C2%NOTFOUND;
            totalSalas := totalSalas + 1;
            DBMS_OUTPUT.PUT_LINE(RPAD(TO_CHAR(REG2.COD_SALA), 15, ' ') || RPAD(TO_CHAR(REG2.NOMBRE), 16, ' ') || 
            RPAD(TO_CHAR(REG2.M2)||'m2', 9, ' '));
        END LOOP;
        CLOSE C2;
        IF totalSalas = 0 THEN
            DBMS_OUTPUT.PUT_LINE(CHR(10) || 'El cliente con DNI ' || dniC || ' no ha accedido a ninguna sala.');
        ELSE
            DBMS_OUTPUT.PUT_LINE(CHR(10) || 'HA ACCEDIDO A UN TOTAL DE ' || totalSalas || ' SALAS');
        END IF;
    ELSE
        DBMS_OUTPUT.PUT_LINE(CHR(10) || 'El cliente con DNI ' || dniC || ' no ha accedido a nuestro GYM todavia.');
    END IF;
    CLOSE C;
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END;


/*CASO DE USO 3: En este caso vamos a realizar una prueba con el DNI de cliente 12345678M que un dni que no est�
registrado en nuestra base de datos. En este caso, ponemos a prueba el condicional principal en donde vemos
si ese cliente est� o no, en caso que no, que es lo que pasa nos manda un mensaje de que no est� en la 
base de datos*/
DECLARE
    dniC CLIENTES.DNI%TYPE:='12345678M';
    
    CURSOR C (dniCl CLIENTES.DNI%TYPE) IS SELECT
        DNI, NOMBRE, EDAD FROM CLIENTES WHERE DNI=dniCl;
    REG1 C%ROWTYPE;
        
    CURSOR C2 (dniCli CLIENTES.DNI%TYPE) IS SELECT
        DNI, COD_SALA, NOMBRE, M2 FROM ACCEDE_CLIENTE_A_SALA JOIN SALA USING (COD_SALA) WHERE DNI=dniCli;
    REG2 C2%ROWTYPE;
    
    totalSalas NUMBER:=0;
   
BEGIN
    OPEN C(dniC);
    FETCH C INTO REG1;
    IF C%FOUND THEN
        DBMS_OUTPUT.PUT_LINE('DNI: ' || REG1.DNI || ' Nombre: ' || REG1.NOMBRE || ' Edad: ' || REG1.EDAD || CHR(10));
        DBMS_OUTPUT.PUT_LINE('TODAS LAS SALAS A LAS QUE HA ACCEDIDO ' || REG1.NOMBRE || CHR(10));
        DBMS_OUTPUT.PUT_LINE('COD SALA       NOMBRE           M2');
        DBMS_OUTPUT.PUT_LINE('--------       -------         ----');
        
        OPEN C2(dniC);
        LOOP
            FETCH C2 INTO REG2;
            EXIT WHEN C2%NOTFOUND;
            totalSalas := totalSalas + 1;
            DBMS_OUTPUT.PUT_LINE(RPAD(TO_CHAR(REG2.COD_SALA), 15, ' ') || RPAD(TO_CHAR(REG2.NOMBRE), 16, ' ') || 
            RPAD(TO_CHAR(REG2.M2)||'m2', 9, ' '));
        END LOOP;
        CLOSE C2;
        IF totalSalas = 0 THEN
            DBMS_OUTPUT.PUT_LINE(CHR(10) || 'El cliente con DNI ' || dniC || ' no ha accedido a ninguna sala.');
        ELSE
            DBMS_OUTPUT.PUT_LINE(CHR(10) || 'HA ACCEDIDO A UN TOTAL DE ' || totalSalas || ' SALAS');
        END IF;
    ELSE
        DBMS_OUTPUT.PUT_LINE(CHR(10) || 'El cliente con DNI ' || dniC || ' no ha accedido a nuestro GYM todavia.');
    END IF;
    CLOSE C;
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END;
