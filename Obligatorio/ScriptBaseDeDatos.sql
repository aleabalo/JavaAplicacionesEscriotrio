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
IdArea smallint not null references Area(IdArea),
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
insert into Empresa (Rut, Nombre,Direccion,Telefono) values (_Rut,_Nombre,_Direccion,Telefono);
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


-- Procedimientos para el Aspirante
-- Crear Aspirante nuevo

DROP PROCEDURE IF EXISTS altaAspirante;

DELIMITER $$

CREATE PROCEDURE altaAspirante(
_Cedula char(10), 
_Nombre char(50),
_Apellido char(50),
_Edad smallint,
_Cv char(150)
)
BEGIN
-- consultar si no hay que verificar perviamente como en sql server que no exista ya  un regostro con esa clave????????
-- if exists(select * from Aspirante where Cedula=_Cedula)
	-- return -1;
Insert into Aspirante(Cedula,Nombre,Apellido,Edad,Cv) values(_Cedula,_Nombre,_Apellido,_Edad,_Cv);
	-- return 1;
END $$

DELIMITER ;

-- Buscar Aspirante
DROP PROCEDURE IF EXISTS buscarAspirante;

DELIMITER $$

CREATE PROCEDURE buscarAspirante(
_Cedula char(10)
)
BEGIN
Select * from Aspirante where Cedula = _Cedula;
END $$

DELIMITER ;

-- Modificar Aspirante
DROP PROCEDURE IF EXISTS modAspirante;

DELIMITER $$

CREATE PROCEDURE modAspirante(
_Cedula char(10), 
_Nombre char(50),
_Apellido char(50),
_Edad smallint,
_Cv char(150)
)
BEGIN
-- consultar si no hay que verificar perviamente como en sql server que no exista ya  un regostro con esa clave????????
Update Aspirante set Nombre=_Nombre, Apellido=_Apellido, Edad=_Edad, Cv=_Cv where Cedula=_Cedula;
END $$

DELIMITER ;

-- Eliminar Aspirante

DROP PROCEDURE IF EXISTS eliminarAspirante;

DELIMITER $$

CREATE PROCEDURE eliminarAspirante(
_Cedula char(10))
BEGIN
-- consultar si no hay que verificar perviamente como en sql server que no exista ya  un regostro con esa clave????????
Delete from AreaAspirante where Cedula=_Cedula;
Delete from Aspirante where Cedula=_Cedula;
END $$

DELIMITER ;


-- Dar de alta las relaciones entre Asoirante y Area

DROP PROCEDURE IF EXISTS AltaAreaAspirante;

DELIMITER $$

CREATE PROCEDURE AltaAreaAspirante(
_Cedula char(10),
_IdArea int)
BEGIN
-- consultar si no hay que verificar perviamente como en sql server que no exista ya  un regostro con esa clave????????
Insert into AreaAspirante values(_Cedula,_IdArea);
END $$

DELIMITER ;

-- Dar de baja relacion entre Area y Aspirante

DROP PROCEDURE IF EXISTS bajaAreaAspirante;

DELIMITER $$

CREATE PROCEDURE bajaAreaAspirante(
_Cedula char(10),
_IdArea int)
BEGIN
-- consultar si no hay que verificar perviamente como en sql server que no exista ya  un regostro con esa clave????????
Delete from AreaAspirante where Cedula=_Cedula and IdArea=_IdArea;
END $$

DELIMITER ;


-- Buscar Areas para un Aspirante dado

DROP PROCEDURE IF EXISTS buscarAreaAspirante;

DELIMITER $$

CREATE PROCEDURE buscarAreaAspirante(
_Cedula char(10))
BEGIN
-- consultar si no hay que verificar perviamente como en sql server que no exista ya  un regostro con esa clave????????
Select * from Area where IdArea in (Select IdArea from AreaAspirante where Cedula=_Cedula);
END $$

DELIMITER ;


-- Procedimientos para el ABM de Area
-- Alta de Area
DROP PROCEDURE IF EXISTS altaArea;

DELIMITER $$

CREATE PROCEDURE altaArea(
_Descripcion char(100))
BEGIN
Insert into Area values(_Descripcion);
END $$

DELIMITER ;

-- Modificacion de Area
DROP PROCEDURE IF EXISTS modArea;

DELIMITER $$

CREATE PROCEDURE modArea(
_IdArea int,
_Descripcion char(100))
BEGIN
Update Area set DescArea=_Descripcion where IdArea=_IdArea;
END $$

DELIMITER ;


-- Eliminar Area
DROP PROCEDURE IF EXISTS eliminarArea;

DELIMITER $$

CREATE PROCEDURE eliminarArea(
_IdArea int)
BEGIN
Delete from Area where IdArea=_IdArea;
END $$

DELIMITER ;

-- Listar Areas
DROP PROCEDURE IF EXISTS listarArea;

DELIMITER $$

CREATE PROCEDURE listarArea()
BEGIN
Select * from Area;
END $$

DELIMITER ;


