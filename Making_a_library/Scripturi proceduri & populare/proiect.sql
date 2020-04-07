	CREATE TABLE Persoana(
    id_persoana INTEGER(4),
    nume VARCHAR(20),
    telefon VARCHAR(15)
    );
    CREATE TABLE Carte(
    id_carte INTEGER(4),
    titlu VARCHAR(40),
    nr_pagini INTEGER(4),
    nr_exemplare INTEGER(4),
    gen VARCHAR(20)  
    );
    CREATE TABLE Imprumut(
    id_carte INTEGER(4),
    id_imp INTEGER(4),
    datai DATE,
    datar DATE,
    nr_zile INTEGER(10)
    );    
    CREATE TABLE Autor(
    id_carte INTEGER(4),
    id_aut INTEGER(4)    
    );
    INSERT INTO Persoana(id_persoana,nume,telefon) values (5,'Lung Paula','0788890061');
	INSERT INTO Persoana(id_persoana,nume,telefon) values (4,'Dura Alexandru','0766283377');	
    INSERT INTO Persoana(id_persoana,nume,telefon) values (3,'Moldovan Alexandru','0756892217');	
    INSERT INTO Persoana(id_persoana,nume,telefon) values (2,'Campean Adelina','0740506995');	
	INSERT INTO Persoana(id_persoana,nume,telefon) values (1,'Stroia Lucian','0753894211');
    INSERT INTO Persoana(id_persoana,nume,telefon) values (6,'Paula Hawkins','0788890099');
	INSERT INTO Persoana(id_persoana,nume,telefon) values (7,'Ion Barbu','0766283311');	
    INSERT INTO Persoana(id_persoana,nume,telefon) values (8,'Moldovan Manuel','0756892242');	
    INSERT INTO Persoana(id_persoana,nume,telefon) values (9,'Vlasa Grigore','0740506924');	
	INSERT INTO Persoana(id_persoana,nume,telefon) values (10,'Elena Farago','0753894236');
	INSERT INTO Persoana(id_persoana,nume,telefon) values (11,'Nicusor Corches','0753890047');
    INSERT INTO Persoana(id_persoana,nume,telefon) values (12,'Sergiu Corches','0700890000');
    INSERT INTO Persoana(id_persoana,nume,telefon) values (13,'Vasile Andru','0723449812');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (1,'Minte de milionar',150,20,'DEZVOLTARE');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (2,'Descopera-te, ti-e cald!',254,10,'DEZVOLTARE');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (3,'In apele adanci',450,25,'BELETRISTICA');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (15,'Cana fermecata',432,100,'BELETRISTICA');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (4,'Crima in Orient Express',453,15,'POLITIST');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (5,'Fata din tren',663,12,'BELETRISTICA');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (14,'O seara tarzie',53,10,'BELETRISTICA');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (6,'In caminul 3',246,23,'DEZVOLTARE');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (7,'Olita',652,14,'AMUZAMENT');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (8,'Mama Manu',456,22,'CULINAR');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (9,'Santajul',161,8,'POLITIST');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (10,'Nota 10',1000,10,'ACADEMIC');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (11,'Retetele bunicii',500,20,'CULINAR');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (12,'Isaac Newton',200,5,'ACADEMIC');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (13,'Sergiu din Bistra',196,10,'AMUZAMENT');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (16,'India',189,10,'CULTURA');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (97,'Sterge-ma!',200,30,'SF');
    INSERT INTO Carte(id_carte,titlu,nr_pagini,nr_exemplare,gen) values (98,'Scoate-ma de aici!',114,30,'AMUZAMENT');

    INSERT INTO Autor(id_carte,id_aut) values (1,6);
    INSERT INTO Autor(id_carte,id_aut) values (10,6);
    INSERT INTO Autor(id_carte,id_aut) values (6,6);
    INSERT INTO Autor(id_carte,id_aut) values (2,7);
    INSERT INTO Autor(id_carte,id_aut) values (9,7);
    INSERT INTO Autor(id_carte,id_aut) values (3,8);
    INSERT INTO Autor(id_carte,id_aut) values (15,8);
    INSERT INTO Autor(id_carte,id_aut) values (12,8);
    INSERT INTO Autor(id_carte,id_aut) values (13,9);
    INSERT INTO Autor(id_carte,id_aut) values (4,9);
    INSERT INTO Autor(id_carte,id_aut) values (5,8);
    INSERT INTO Autor(id_carte,id_aut) values (11,7);
    INSERT INTO Autor(id_carte,id_aut) values (8,11);
    INSERT INTO Autor(id_carte,id_aut) values (7,10);
    INSERT INTO Autor(id_carte,id_aut) values (7,11);
    INSERT INTO Autor(id_carte,id_aut) values (7,8);
    INSERT INTO Autor(id_carte,id_aut) values (9,8);
    INSERT INTO Autor(id_carte,id_aut) values (14,12);
    INSERT INTO Autor(id_carte,id_aut) values (16,13);
    
    INSERT INTO Imprumut(id_carte,id_imp,datai,datar,nr_zile) values(1,1,STR_TO_DATE('28/06/2018','%d/%m/%Y'),NULL,30);
    
    INSERT INTO Imprumut(id_carte,id_imp,datai,datar,nr_zile) values(2,2,STR_TO_DATE('10/10/2018','%d/%m/%Y'),STR_TO_DATE('28/10/2018','%d/%m/%Y'),15);
    
    INSERT INTO Imprumut(id_carte,id_imp,datai,datar,nr_zile) values(8,4,STR_TO_DATE('22/11/2018','%d/%m/%Y'),STR_TO_DATE('01/12/2018','%d/%m/%Y'),30);
    
    INSERT INTO Imprumut(id_carte,id_imp,datai,datar,nr_zile) values(5,3,STR_TO_DATE('01/11/2018','%d/%m/%Y'),STR_TO_DATE('30/11/2018','%d/%m/%Y'),20);
    INSERT INTO Imprumut(id_carte,id_imp,datai,datar,nr_zile) values(5,2,STR_TO_DATE('18/10/2018','%d/%m/%Y'),NULL,31);
    
    INSERT INTO Imprumut(id_carte,id_imp,datai,datar,nr_zile) values(10,1,STR_TO_DATE('05/11/2018','%d/%m/%Y'),STR_TO_DATE('28/11/2018','%d/%m/%Y'),20);
    INSERT INTO Imprumut(id_carte,id_imp,datai,datar,nr_zile) values(10,3,STR_TO_DATE('02/11/2018','%d/%m/%Y'),STR_TO_DATE('15/11/2018','%d/%m/%Y'),20);
    INSERT INTO Imprumut(id_carte,id_imp,datai,datar,nr_zile) values(10,2,STR_TO_DATE('03/11/2018','%d/%m/%Y'),NULL,20);
	 ALTER TABLE Persoana ADD PRIMARY KEY(id_persoana);
    ALTER TABLE Carte ADD PRIMARY KEY(id_carte);
    ALTER TABLE Imprumut ADD PRIMARY KEY(datai);
   

    ALTER TABLE Imprumut ADD FOREIGN KEY(id_carte) REFERENCES Carte(id_carte);
    ALTER TABLE Imprumut ADD FOREIGN KEY(id_imp) REFERENCES Persoana(id_persoana);
    ALTER TABLE Autor ADD FOREIGN KEY(id_carte) REFERENCES Carte(id_carte);
    ALTER TABLE Carte ADD(Rezumat VARCHAR(100));
    
    ALTER TABLE Carte ADD CONSTRAINT CHK_nr_exemplare  CHECK  (nr_exemplare>1);
    ALTER TABLE Carte ADD CONSTRAINT CHK_gen  CHECK(gen<>'BELETRISTICA' OR nr_pagini>30);
