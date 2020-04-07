CREATE PROCEDURE Procedura1()
BEGIN
declare p_titlu VARCHAR(100);
declare p_gen VARCHAR(100);
declare p_nr_pagini INT;
declare stop int default 0;
declare cursorul CURSOR FOR
SELECT titlu,gen,nr_pagini FROM carte WHERE MOD(nr_pagini,2)=0 ORDER BY nr_pagini,gen;
declare continue handler
for not found set stop=1;
open cursorul;

CREATE TEMPORARY TABLE tabelul(
    t_titlu VARCHAR(100),
    t_gen VARCHAR(100),
    t_nr_pagini INT(5)
    );
  repeta: LOOP
  FETCH cursorul INTO p_titlu,p_gen,p_nr_pagini;
  IF stop then 
  LEAVE repeta;
  end if;
  INSERT INTO tabelul(t_titlu,t_gen,t_nr_pagini) VALUES(p_titlu,p_gen,p_nr_pagini);
  end loop repeta;
  SELECT * FROM tabelul;
  drop TEMPORARY TABLE if EXISTS tabelul;
  end;
