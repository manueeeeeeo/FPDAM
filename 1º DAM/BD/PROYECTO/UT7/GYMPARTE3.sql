/*Ejercicio Cursores Dobles: Solicitamos el c�digo de una sala y este bloque de plsql
nos muestra todos los profesores que han dado clase en esa sala y todos los alumnos
que han tenido*/
CREATE OR REPLACE PROCEDURE verProfAl (codi SALA.COD_SALA%TYPE)
IS 
    --CREAMOS EL CURSOR 1 EN DONDE CARGAMOS SOBRETODO LA INFORMACI�N DE LA SALA Y DE LOS MONITORES
    CURSOR C1 (codigo SALA.COD_SALA%TYPE) IS SELECT
        UNIQUE(MONITORES.DNI), MONITORES.NOMBRE || ' ' || MONITORES.AP1 || ' ' || MONITORES.AP2 AS COMPLETO,
        MONITORES.ESPECIALIDAD, DAN_CLASE.COD_SALA FROM MONITORES JOIN
        DAN_CLASE ON DAN_CLASE.IDE=MONITORES.DNI WHERE COD_SALA = codigo;
    REG1 C1%ROWTYPE;
    
    --CREAMOS EL CURSOR 2 EN DONDE CARGAMOS SOBRETODO LA INFORMACI�N DE LOS ALUMNOS
    CURSOR C2 (dni2 MONITORES.DNI%TYPE) IS SELECT
        CLIENTES.DNI, CLIENTES.NOMBRE || ' ' || CLIENTES.APELLIDO1 || ' ' || CLIENTES.APELLIDO2 AS COMPLETO, EDAD, DAN_CLASE.COD_SALA,
        DAN_CLASE.IDE FROM CLIENTES JOIN DAN_CLASE ON CLIENTES.DNI=DAN_CLASE.DNI WHERE  IDE=dni2;
    REG2 C2%ROWTYPE;
    
    --CREO UNA VARIABLE EN DONDE POSTERIORMENTE CARGARE EL NOMBRE DE LA SALA
    nom VARCHAR2(80):='';
    
BEGIN
    --OBTENGO EL C�DIGO Y EL NOMBRE DE LA SALA DE DONDE QUEREMOS SACAR LA INFO
    DBMS_OUTPUT.PUT_LINE('Informaci�n sobre la clase con c�digo: ' || codi);
    SELECT NOMBRE INTO nom FROM SALA WHERE COD_SALA=codi;
    DBMS_OUTPUT.PUT_LINE('Nombre: '|| nom);
    OPEN C1 (codi);
    DBMS_OUTPUT.PUT_LINE('#####################################################');
    DBMS_OUTPUT.PUT_LINE('PROFESORES');
    DBMS_OUTPUT.PUT_LINE('#####################################################');
    LOOP
        FETCH C1 INTO REG1;
        EXIT WHEN C1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('  DNI             NOMBRE              ESPECIALIDAD');
        DBMS_OUTPUT.PUT_LINE('---------    ----------------         ------------');
        DBMS_OUTPUT.PUT_LINE(RPAD(TO_CHAR(REG1.DNI),12, ' ') || ' ' || RPAD(REG1.COMPLETO, 25, ' ') || ' ' || 
        RPAD(REG1.ESPECIALIDAD, 15, ' '));
        DBMS_OUTPUT.PUT_LINE(CHR(10) || '#####################################################');
        DBMS_OUTPUT.PUT_LINE('ALUMNOS DE ' || REG1.COMPLETO);
        DBMS_OUTPUT.PUT_LINE('#####################################################');
        DBMS_OUTPUT.PUT_LINE('  DNI             NOMBRE              EDAD');
        DBMS_OUTPUT.PUT_LINE('---------    ----------------        ------');
        OPEN C2 (REG1.DNI);
        LOOP
            FETCH C2 INTO REG2;
            EXIT WHEN C2%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE(RPAD(TO_CHAR(REG2.DNI),12, ' ') || ' ' || RPAD(REG2.COMPLETO, 25, ' ') || ' ' || 
            RPAD(REG2.EDAD, 15, ' '));
        END LOOP;
        CLOSE C2;
        DBMS_OUTPUT.PUT_LINE('#####################################################' || CHR(10));
    END LOOP;
    CLOSE C1;
--MANEJAMOS LAS EXCEPCIONES
EXCEPTION WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END;

--SET SERVEROUTPUT ON;
--SET VERIFY OFF;
ACCEPT identi PROMPT 'Digame el c�digo de la sala:';
DECLARE
    co SALA.COD_SALA%TYPE:='&identi';
BEGIN
    verProfAl(co);
END;

/*Trigger: En este trigger lo que manejamos esque no nos permita insertar
equipamiento nuevo que tenga m�s de 4 a�os.*/
CREATE OR REPLACE TRIGGER trig2 BEFORE INSERT ON EQUIPAMIENTO FOR EACH ROW
DECLARE
BEGIN
    IF :NEW.FECHA_COMPRA < (SYSDATE-1460) THEN
        RAISE_APPLICATION_ERROR(-20013, 'No podemos agregar nuevas m�quinas con m�s de 4 a�os: INSERCI�N CANCELADA');
    END IF;
END;
INSERT INTO EQUIPAMIENTO VALUES(50,1,'Piscina Doble', '14/04/2024', 'OPERATIVO');
INSERT INTO EQUIPAMIENTO VALUES(51,1,'Piscina Triple', '14/04/2019', 'OPERATIVO');
