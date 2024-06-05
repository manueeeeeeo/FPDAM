/* Bloque 1: En este bloque vamos a elegir la tabla de taquilla y vamos
a procceder a realizar inserciones de datos mediante pedidos de variables
por la pantalla, deberemos de tener en cuenta los fallos, que no existan las
taquillas con el mismo c�digo, que la fecha se� mayor al dia de hoy y
que el tipo de taquilla est� dentro de el check de Peque�a, Mediana y Grande*/

--SET SERVEROUTPUT ON
--SET VERIFY OFF

--RESTABLECEMOS LA FORMA DE PEDIR LOS DATOS
ACCEPT cod PROMPT 'Indiqueme el c�digo de la taquilla:';
ACCEPT tipot PROMPT 'Indiqueme el tipo de taquilla:';
ACCEPT fec PROMPT 'indiqueme la fecha de asignaci�n:';

--DECLARAMOS LAS VARIABLES NECESARIAS
DECLARE
cod_taq NUMBER(4):='&cod';
tipo VARCHAR(20):=UPPER('&tipot');
fecha DATE:='&fec';

--COMENZAMOS CON EL PROGRAMA
BEGIN

    --USAMOS UN CONDICIONAL PARA ASEGURARNOS DE QUE EL C�DIGO SEA MAYOR DE 0
    IF cod_taq <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('El c�digo no puede ser negatio');
    ELSE
        --USAMOS UN CONDICIONAL PARA ASEGURARNOS QUE EL TIPO EST� DENTRO DEL CHECK
        IF tipo NOT IN ('PEQUE�A', 'MEDIANA', 'GRADNE') THEN
            DBMS_OUTPUT.PUT_LINE('El tipo que usted ha indicado no est� dentro de las posibilidades');
        ELSE
            --USAMOS UN CONDICIONAL PARA ASEGURARNOS DE QUE LA FECHA ES CORRECTA
            IF fecha < SYSDATE THEN
                DBMS_OUTPUT.PUT_LINE('No puede ser una fecha menor a hoy');
            ELSE
                --INSERTAMOS LOS DATOS Y LOS CONFIRMAMOS
                Insert into TAQUILLA values(cod_taq, INITCAP(LOWER(tipo)), fecha);
                COMMIT;
                DBMS_OUTPUT.PUT_LINE('Datos introducidos correctamente');
            END IF;
        END IF;
    END IF;
    --MANEJAMOS LAS POSIBLES EXCEPCIONES
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);

END;

/* Bloque 2: En este bloque deberemos de editar alg�n objeto ya
subido a la tabla que eligamos que en este caso va a ser la tabla
de Equipamiento, solicitaremos saber el c�digo de la sala en donde est�
por otro lado, el c�digo del equipamiento y el estado al que le queremos
cambiar (recordamos que es OPERATIVO o NO OPERATIVO), deberemos de comprobar
si la sala y el equipamiento existe*/

--RESTABLECEMOS LA FORMA DE PEDIR LOS DATOS
ACCEPT cod PROMPT 'Digame el c�digo de la sala: ';
ACCEPT cod2 PROMPT 'Digame el c�digo del equipamiento de esa sala: ';
ACCEPT esta PROMPT 'Digame el estado al que lo quiere cambiar: ';

--DECLARAMOS LAS VARIABLES NECESARIAS
DECLARE 
    cod_sal SALA.COD_SALA%TYPE:='&cod';
    cod_mat EQUIPAMIENTO.COD_EQUIPAMIENTO%TYPE:='&cod2';
    estad EQUIPAMIENTO.ESTADO%TYPE:='&esta';
    act NUMBER(10):=0;
    act2 NUMBER(10):=0;
    
--COMENZAMOS CON EL PROGRAMA
BEGIN
    --CONTAMOS LAS VECES QUE EXISTE EL CODIGO DE LA SALA Y EN CASO DE QUE NO EXISTA PARAMOS EL PROGRAMA
    SELECT COUNT(*) INTO act2 FROM SALA WHERE COD_SALA = cod_sal;
    IF act2 = 0 THEN
        DBMS_OUTPUT.PUT_LINE('El c�digo de sala ingresado no es v�lido');
        RETURN;
    END IF;
    
    --CONTAMOS LAS VECES QUE EXISTE EL CODIGO DEL EQUIPAMIENTO Y EN CASO DE QUE NO EXISTA PARAMOS EL PROGRAMA
    SELECT COUNT(*) INTO act2 FROM EQUIPAMIENTO WHERE COD_EQUIPAMIENTO = cod_mat;
    IF act2 = 0 THEN
        DBMS_OUTPUT.PUT_LINE('El c�digo de equipamiento ingresado no es v�lido');
        RETURN;
    END IF;
    
    --ACTUALIZAMOS EL CAMPO Y CONTAMOS LAS FILAS ACTUALIZADAS
    UPDATE EQUIPAMIENTO SET ESTADO = UPPER(estad) WHERE COD_EQUIPAMIENTO=cod_mat AND COD_SALA=cod_sal;
    act:=SQL%ROWCOUNT;
    
    --CONFIRMAMOS LOS CAMBIOS Y SE�ALAMOS QUE TODO HA SALIDO BIEN Y CUANTAS FILAS SE HAN ACTUALIZADO
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Se han actualizado los datos correctamente');
    DBMS_OUTPUT.PUT_LINE('Se han actualizado ' || act || ' fila/s');
    
--MANEJAMOS LAS POSIBLES EXCEPCIONES
EXCEPTION
WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Ha ocurrido un error: ' || SQLERRM);
END;
