CREATE PROCEDURE Procedura2(IN auxiliar VARCHAR(300))
BEGIN
DECLARE titlul1 VARCHAR(100);
DECLARE titlul2 VARCHAR(100);
DECLARE stop INT DEFAULT 0;
DECLARE cursorul CURSOR FOR
SELECT c.titlu,d.titlu FROM Carte as c join Autor AS a ON(c.id_carte=a.id_carte) join Autor AS a2 ON( a.id_aut=a2.id_aut) join Carte AS d on(a2.id_carte=d.id_carte) WHERE c.gen=auxiliar and d.gen=auxiliar and c.titlu<d.titlu;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET stop=1;
OPEN cursorul;
CREATE TEMPORARY TABLE tabelul(t_titlul1 VARCHAR(100),
                               t_titlul2 VARCHAR(100));
repeta: LOOP
FETCH cursorul INTO titlul1,titlul2;
IF stop=1 then leave repeta;
end if;
insert into tabelul(t_titlul1,t_titlul2) VALUES(titlul1,titlul2);
end LOOP repeta;
select* from tabelul;
drop TEMPORARY TABLE IF exists tabelul;
end;