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
IdArea int not null references Area(IdArea),
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
Primary Key(Cedula, IdArea)
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
Fin date,
Primary key(Id)
);

-- *************************ALTA DE REGISTROS DE PRUEBA*******************************
-- Empresa
insert into Empresa values(123456789, 'Empresa 1', 'Direccion Empresa 1', '11111111');
insert into Empresa values(12345666, 'Empresa 2', 'Direccion Empresa 2', '22222222');
insert into Empresa values(78954623, 'Empresa 3', 'Direccion Empresa 3', '33333333');
insert into Empresa values(147852369, 'Empresa 4', 'Direccion Empresa 4', '44444444');

-- Area
insert into Area(DescArea) values('Administracion');
insert into Area(DescArea) values('Informatica');
insert into Area(DescArea) values('Tecnologias de la Informacion');
insert into Area(DescArea) values('Contabilidad');
insert into Area(DescArea) values('Limpieza');

-- Ofertas
insert into Oferta(DescCargo,Puestos,Titulo,Requerimientos,Empresa,IdArea) values('Oferta numero 1', 1, 'Oferta 1', 'Requerimientos Oferta 1', 123456789, 1);
insert into Oferta(DescCargo,Puestos,Titulo,Requerimientos,Empresa,IdArea) values('Oferta numero 2', 2, 'Oferta 2', 'Requerimientos Oferta 2', 12345666, 2);
insert into Oferta(DescCargo,Puestos,Titulo,Requerimientos,Empresa,IdArea) values('Oferta numero 3', 1, 'Oferta 3', 'Requerimientos Oferta 3', 78954623, 3);
insert into Oferta(DescCargo,Puestos,Titulo,Requerimientos,Empresa,IdArea) values('Oferta numero 4', 4, 'Oferta 4', 'Requerimientos Oferta 4', 147852369, 4);
insert into Oferta(DescCargo,Puestos,Titulo,Requerimientos,Empresa,IdArea) values('Oferta numero 6', 3, 'Oferta 5', 'Requerimientos Oferta 5', 123456789, 5);
insert into Oferta(DescCargo,Puestos,Titulo,Requerimientos,Empresa,IdArea) values('Oferta numero 6', 2, 'Oferta 6', 'Requerimientos Oferta 6', 12345666, 1);
insert into Oferta(DescCargo,Puestos,Titulo,Requerimientos,Empresa,IdArea) values('Oferta numero 7', 1, 'Oferta 7', 'Requerimientos Oferta 7', 78954623, 2);
insert into Oferta(DescCargo,Puestos,Titulo,Requerimientos,Empresa,IdArea) values('Oferta numero 8', 2, 'Oferta 8', 'Requerimientos Oferta 7', 147852369, 3);

-- Aspirantes
insert into Aspirante(Cedula,Nombre,Apellido,Edad,Cv) values('11111111', 'Nombre1', 'Apellido1', 18, 'Apellido1, Nombre1');
insert into Aspirante(Cedula,Nombre,Apellido,Edad,Cv) values('22222222', 'Nombre2', 'Apellido2', 19, 'Apellido2, Nombre2');
insert into Aspirante(Cedula,Nombre,Apellido,Edad,Cv) values('33333333', 'Nombre3', 'Apellido3', 20, 'Apellido3, Nombre3');
insert into Aspirante(Cedula,Nombre,Apellido,Edad,Cv) values('44444444', 'Nombre4', 'Apellido4', 21, 'Apellido4, Nombre4');
insert into Aspirante(Cedula,Nombre,Apellido,Edad,Cv) values('55555555', 'Nombre5', 'Apellido5', 22, 'Apellido5, Nombre5');

-- Areas de Interes
insert into AreaAspirante(Cedula,IdArea) values('11111111', 1);
insert into AreaAspirante(Cedula,IdArea) values('22222222', 2);
insert into AreaAspirante(Cedula,IdArea) values('33333333', 1);
insert into AreaAspirante(Cedula,IdArea) values('44444444', 2);
insert into AreaAspirante(Cedula,IdArea) values('55555555', 3);
insert into AreaAspirante(Cedula,IdArea) values('11111111', 4);
insert into AreaAspirante(Cedula,IdArea) values('22222222', 3);
insert into AreaAspirante(Cedula,IdArea) values('33333333', 4);
insert into AreaAspirante(Cedula,IdArea) values('44444444', 5);
insert into AreaAspirante(Cedula,IdArea) values('55555555', 5);

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
IN _Rut int
)
BEGIN
delete from empresa where Rut = _Rut;
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
update empresa set Nombre = _Nombre, Direccion = _Direccion , Telefono = _Telefono where Rut = _Rut;
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
Insert into Aspirante(Cedula,Nombre,Apellido,Edad,Cv) values(_Cedula,_Nombre,_Apellido,_Edad,_Cv);	
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


-- listar Aspirante
DROP PROCEDURE IF EXISTS listarAspirante;

DELIMITER $$

CREATE PROCEDURE listarAspirante()
BEGIN
Select * from Aspirante;
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
Insert into AreaAspirante values(_Cedula,_IdArea);
END $$

DELIMITER ;

-- Dar de baja relacion entre Area y Aspirante

DROP PROCEDURE IF EXISTS bajaAreaAspirante;

DELIMITER $$

CREATE PROCEDURE bajaAreaAspirante(
_Cedula char(10))
BEGIN
Delete from AreaAspirante where Cedula=_Cedula;
END $$

DELIMITER ;


-- Buscar Areas para un Aspirante dado

DROP PROCEDURE IF EXISTS buscarAreaAspirante;

DELIMITER $$

CREATE PROCEDURE buscarAreaAspirante(
_Cedula char(10))
BEGIN
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
Insert into Area (DescArea) values(_Descripcion);
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


-- buscar de Area
DROP PROCEDURE IF EXISTS buscarArea;

DELIMITER $$

CREATE PROCEDURE buscarArea(
_IdArea int)
BEGIN
select * from area where area.IdArea = _Idarea;
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

-- Alta de Oferta
DROP PROCEDURE IF EXISTS altaOferta;

DELIMITER $$

CREATE PROCEDURE altaOferta(
_Descrip char(200),
_Puestos int,
_Titulo char(100),
_Req char(200),
_Empresa int,
_Area int)
BEGIN
Insert into Oferta (DescCargo,Puestos,Titulo,Requerimientos, Activo, Empresa, IdArea)values(_Descrip,_Puestos,_Titulo,_Req,true,_Empresa,_Area);
END $$

DELIMITER ;


-- Lista de ofertas activas
DROP PROCEDURE IF EXISTS listaOferta;

DELIMITER $$

CREATE PROCEDURE listaOferta()
BEGIN
Select * from Oferta where Activo=true;
END $$

DELIMITER ;


-- Modificacion de Oferta
DROP PROCEDURE IF EXISTS modOferta;

DELIMITER $$

CREATE PROCEDURE modOferta(
_Id int,
_Descrip char(200),
_Puestos int,
_Titulo char(100),
_Req char(200),
_Empresa int,
_Area int)
BEGIN
Update Oferta set DescCargo=_Descrip, Puestos=_Puestos, Titulo=_Titulo, Requerimientos=_Req, Empresa=_Empresa, IdArea=_Area 
where IdOferta=_Id;
END $$

DELIMITER ;


-- Buscar Oferta

DROP PROCEDURE IF EXISTS buscarOferta;

DELIMITER $$

CREATE PROCEDURE buscarOferta(
_Id int
)
BEGIN 
Select * from Oferta where IdOferta=_Id and Activo=1;
END $$

DELIMITER ;


-- Desactivar Oferta
DROP PROCEDURE IF EXISTS desactivarOferta;

DELIMITER $$

CREATE PROCEDURE desactivarOferta(
_Id int)
BEGIN
Update Oferta set Activo=0 
where IdOferta=_Id;
END $$

DELIMITER ;


-- Solicitar Entrevista
DROP PROCEDURE IF EXISTS solicitarEntrevista;

DELIMITER $$

CREATE PROCEDURE solicitarEntrevista(
_IdOferta int,
_Aspirante char(10))
BEGIN
Insert into SolicitudEntrevista values(_IdOferta, _Aspirante);
END $$

DELIMITER ;

-- Lista de Solicitudes de Entrevista para Oferta Dada
DROP PROCEDURE IF EXISTS listarSolicitudesOferta;

DELIMITER $$

CREATE PROCEDURE listarSolicitudesOferta(
_IdOferta int)
BEGIN
Select * from SolicitudEntrevista where Oferta=_IdOferta;
END $$

DELIMITER ;

-- Dar de baja solicitud de entrevista para cuando la empresa decide no realizar la entrevista al candidato
-- De esta forma se puede volver a postular si lo desea
DROP PROCEDURE IF EXISTS bajaSolicitudEntrevista;

DELIMITER $$

CREATE PROCEDURE bajaSolicitudEntrevista(
_IdOferta int,
_Aspirante char(10))
BEGIN
Delete from SolicitudEntrevista where Oferta=_IdOferta and Aspirante=_Aspirante;
END $$

DELIMITER ;

-- Listar Solicitudes de Entrevista para una empresa dada
DROP PROCEDURE IF EXISTS listarSolicitudesEmpresa;

DELIMITER $$

CREATE PROCEDURE listarSolicitudesEmpresa(
_Rut int)
BEGIN
Select * from SolicitudEntrevista where Oferta in (Select IdOferta from Oferta where Empresa=_Rut);
END $$

DELIMITER ;


-- Agendar Entrevista
DROP PROCEDURE IF EXISTS agendarEntrevista;

DELIMITER $$

CREATE PROCEDURE agendarEntrevista(
_IdOferta int,
_Aspirante char(10),
_Fecha date)
BEGIN
Insert into Entrevista values(_IdOferta,_Aspirante,_Fecha);
END $$

DELIMITER ;

-- Alta de contrato
DROP PROCEDURE IF EXISTS altaContrato;

DELIMITER $$

CREATE PROCEDURE altaContrato(
_IdEntrevista int,
_Sueldo double,
_Inicio date,
_Tipo char(10),
_Fin date)
BEGIN
Insert into Contrato values(_IdEntrevista,_Sueldo,_Inicio,_Tipo,_Fin);
END $$

DELIMITER ;

-- Listar entrevistas para un candidato
DROP PROCEDURE IF EXISTS entrevistasCandidato;

DELIMITER $$

CREATE PROCEDURE entrevistasCandidato(
_Cedula char(10)
)
BEGIN
Select * from Entrevista where Aspirante = _Cedula;
END $$

DELIMITER ;

-- Buscar entrevista para un candidato a una Oferta, se usa para verificar existencia
DROP PROCEDURE IF EXISTS buscarEntrevista;

DELIMITER $$

CREATE PROCEDURE buscarEntrevista(
_IdOferta int,
_Cedula char(10)
)
BEGIN
select * from Entrevista where Oferta = _IdOferta and Aspirante = _Cedula;
END $$

DELIMITER ;





