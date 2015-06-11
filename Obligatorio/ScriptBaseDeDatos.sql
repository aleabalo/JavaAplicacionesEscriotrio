drop database if exists Obli_RRHH;
create database if not exists Obli_RRHH;

use Obli_RRHH;

Create table Empresa(
Rut int not null, 
Nombre char(40) not null,
Direccion char(50) not null,
Telefono char(12) not null,
Primary Key(Rut)
);

Create table Area( 
IdArea smallint not null auto_increment, 
DescArea char(100) not null,
Primary Key(IdArea)
);

Create table Oferta( 
IdOferta smallint not null auto_increment, 
DescCargo char(200) not null,
Puestos smallint not null,
Titulo char(100) not null,
Requerimientos char(200) not null,
Activo binary not null default 1,
Empresa int not null references Empresa(Rut),
Area int not null references Area(IdArea),
Primary Key(IdOferta)
);

Create table Aspirante( 
Cedula char(10) not null, 
Nombre char(50) not null,
Apellido char(50) not null,
Edad smallint not null,
Cv char(150) not null,
Primary Key(Cedula)
);

Create table AreaAspirante( 
Cedula char(10) not null references Aspirante(Cedula), 
Area smallint not null references Area(IdArea),
Primary Key(Cedula, Area)
);

Create table SolicitudEntrevista( 
Oferta smallint not null references Oferta(IdOferta), 
Aspirante char(10) not null references Aspirante(Cedula),
Primary Key(Oferta, Aspirante)
);

Create table Entrevista( 
Id smallint not null auto_increment, 
Oferta smallint not null references Oferta(IdOferta),
Aspirante char(10) not null references Aspirante(Cedula),
Fecha date not null,
Primary Key(Id)
);

Create table Contrato(
Id smallint not null auto_increment,
Entrevista smallint not null references Entrevista(Id),
Sueldo double not null,
Inicio date not null,
Tipo char(10) not null,
Primary key(Id)
);



DROP PROCEDURE IF EXISTS altaEmpresa;

DELIMITER $$

CREATE PROCEDURE altaEmpresa(
IN _Rut int ,
IN _Nombre char(40),
IN _Direccion char(50),
IN Telefono char(12))
BEGIN
insert into empresa (Rut, Nombre,Direccion,Telefono) values (_Rut,_Nombre,_Direccion,Telefono);
END $$


DELIMITER ;


DROP PROCEDURE IF EXISTS buscarEmpresa;

DELIMITER $$

CREATE PROCEDURE buscarEmpresa(
IN _Rut int)
BEGIN
select Nombre,Direccion,Telefono from empresa where Rut = _Rut;
END $$


DELIMITER ;


DROP PROCEDURE IF EXISTS borrarEmpresa;

DELIMITER $$

CREATE PROCEDURE borrarEmpresa(
IN _Rut int)
BEGIN
delete empresa where Rut = _Rut;
END $$


DELIMITER ;



DROP PROCEDURE IF EXISTS modificarEmpresa;

DELIMITER $$

CREATE PROCEDURE modificarEmpresa(
IN _Rut int ,
IN _Nombre char(40),
IN _Direccion char(50),
IN _Telefono char(12))
BEGIN
update empresa set Nombre = _Nombre,Direccion = _Direccion, Telefono = _Telefono where Rut = _Rut;
END $$


DELIMITER ;


DROP PROCEDURE IF EXISTS listarEmpresa;

DELIMITER $$

CREATE PROCEDURE listarEmpresa()
BEGIN
select * from empresa;
END $$


DELIMITER ;
