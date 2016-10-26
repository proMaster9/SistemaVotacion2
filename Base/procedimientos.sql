create or replace function entrarAdministrador(
	in _dui varchar(10),
	in _contrasenia varchar(15),
	out id_usuario int,
	out num_dui varchar(10),
	out contrasenia varchar(15),
	out confirmacion int,
	out tipo varchar(30),
	out tipo_usuario int
) returns setof record as
$body$
	declare
		id int;
		tipo int;
		texto varchar(50);
	begin
	return query select u.id_usuario, ct.num_dui, u.contrasenia, u.confirmacion, tu.tipo_usuario, u.id_tipo_usuario 
	from usuario u inner join credencialtemporal ct
	on u.id_usuario = ct.id_usuario 
	inner join tipousuario tu on tu.id_tipo_usuario = u.id_tipo_usuario
	where u.id_tipo_usuario = 1 and ct.num_dui = _dui and u.contrasenia = _contrasenia;
	end;
$body$
language plpgsql;



/*
	inicio de sesion de supervisor externo
*/
create or replace function entrarSupervisor(
	in _identificacion varchar(10),
	in _contrasenia varchar(15),
	out id_usuario int,
	out identificacion varchar(15),
	out contrasenia varchar(15),
	out nombre varchar(20),
	out apellido varchar(20),
	out sexo varchar(2),
	out confirmacion int,
	out tipo varchar(30),
	out id_tipo_usuario int,
	out pais varchar(15),
	out organizacion varchar(15)
) returns setof record as
$body$
	begin
		return query select u.id_usuario, ext.identificacion, u.contrasenia, ext.nombre, ext.apellido, ext.sexo, u.confirmacion, tu.tipo_usuario, u.id_tipo_usuario, ext.pais, ext.organizacion 
		from usuario u inner join infosupext ext on u.id_usuario = ext.id_usuario 
		inner join tipousuario tu on tu.id_tipo_usuario = u.id_tipo_usuario
		where ext.identificacion = _identificacion and u.contrasenia = _contrasenia;
	end;
$body$
language plpgsql;



/*
	los usuarios principales son magistrado (2), representante del CNR (3) y director de TSE (6)
	son principales, ya que el administrador es quien registra a estos usuarios, siendo necesarios
	para el funcionamiento del sistema
*/
create or replace function entrarPrincipal(
	in _dui varchar(10),
	in _contrasenia varchar(15),
	out id_usuario int,
	out num_dui varchar(10),
	out contrasenia varchar(15),
	out nombre varchar(20),
	out apellido varchar(20),
	out sexo varchar(2),
	out confirmacion int,
	out tipo varchar(30),
	out tipo_usuario int,
	out fecha_nac varchar(10),
	out direccion varchar(60),
	out id_municipio int, 
	out id_departamento int
) returns setof record as
$body$
	begin
		return query select u.id_usuario, ex.num_dui, u.contrasenia, ex.nombre, ex.apellido, ex.sexo, u.confirmacion, tu.tipo_usuario, u.id_tipo_usuario, ex.fecha_nac, ex.direccion_especifica, mu.id_municipio, mu.id_departamento from usuario u 
		inner join credencialtemporal ct on u.id_usuario = ct.id_usuario
		inner join excepcionusuario ex on ex.id_usuario = u.id_usuario
		inner join municipio mu on mu.id_municipio = ex.id_municipio 
		inner join tipousuario tu on tu.id_tipo_usuario = u.id_tipo_usuario
		where ex.num_dui = _dui and u.contrasenia = _contrasenia and (u.id_tipo_usuario = 2 or u.id_tipo_usuario = 3 or u.id_tipo_usuario = 6) ;
	end;
$body$
language plpgsql;


/*
	login para representante de partido (5), director de centro de votaciones (8),
	publicista (9), presidente de JRV (10) y gestor de jrv (7)
	son usuarios secundarios, ya que no sus datos aparecen en los registros del cnr,
	al momento de registrar estos usuarios, solo se utiliza en numero de dui
*/
create or replace function entrarSecundario(
	in _dui varchar(10),
	in _contrasenia varchar(15),
	out id_usuario int,
	out num_dui varchar(10),
	out contrasenia varchar(15),
	out nombre varchar(20),
	out apellido varchar(20),
	out sexo varchar(2),
	out confirmacion int,
	out tipo varchar(30),
	out tipo_usuario int,
	out fecha_nac varchar(10),
	out direccion varchar(60),
	out id_municipio int, 
	out id_departamento int
) returns setof record as
$body$
	begin
		return query select u.id_usuario, p.num_dui, u.contrasenia, p.nombre, p.apellido, p.sexo, u.confirmacion, tu.tipo_usuario, u.id_tipo_usuario, p.fecha_nac, p.direccion_especifica, p.id_municipio, m.id_departamento from usuario u
		inner join usuariopadron up on up.id_usuario = u.id_usuario
		inner join padronelectoral p on p.num_dui = up.num_dui
		inner join municipio m on m.id_municipio = p.id_municipio 
		inner join tipousuario tu on tu.id_tipo_usuario = u.id_tipo_usuario
		where (u.id_tipo_usuario = 5 or (u.id_tipo_usuario >= 7 and u.id_tipo_usuario <= 10 )) and (p.num_dui = _dui and u.contrasenia = _contrasenia);


	end;
$body$
language plpgsql;


/*
	cualquier usuario que aparezca en la tabla padronelectoral, puede acceder a la papeleta de
	votaciones desde aca, sin importar el privilegio que posea en el sistema
*/
create or replace function entrarVotante(
	in _dui varchar(10),
	in _contrasenia varchar(15),
	out id_usuario int,
	out num_dui varchar(10),
	out contrasenia varchar(15),
	out nombre varchar(20),
	out apellido varchar(20),
	out sexo varchar(2),
	out confirmacion int,
	out tipo varchar(30),
	out tipo_usuario int,
	out fecha_nac varchar(10),
	out direccion varchar(60),
	out id_municipio int, 
	out id_departamento int
) returns setof record as
$body$
	begin
		return query select u.id_usuario, p.num_dui, u.contrasenia, p.nombre, p.apellido, p.sexo, u.confirmacion, tu.tipo_usuario, u.id_tipo_usuario, p.fecha_nac, p.direccion_especifica, p.id_municipio, m.id_departamento from usuario u
		inner join usuariopadron up on up.id_usuario = u.id_usuario
		inner join padronelectoral p on p.num_dui = up.num_dui
		inner join municipio m on m.id_municipio = p.id_municipio 
		inner join tipousuario tu on tu.id_tipo_usuario = u.id_tipo_usuario
		where p.num_dui = _dui and u.contrasenia = _contrasenia;


	end;
$body$
language plpgsql;


create or replace function agregarSupervisor(
	in identificacion varchar(15),
	in contrasenia varchar(15),
	in nombre varchar(20),
	in apellido varchar(20),
	in sexo varchar(2),
	in pais varchar(15),
	in organizacion varchar(15)
) returns void as
$body$
begin
	insert into usuario (id_tipo_usuario,contrasenia,confirmacion) values (4,contrasenia,0);
	insert into infosupext (id_usuario,identificacion,nombre,apellido,sexo,pais,organizacion) 
	values (lastval(),identificacion,nombre,apellido,sexo,pais,organizacion);
end;
$body$
language plpgsql;


create or replace function modificarSupervisor(
	in _id_usuario int,
	in _identificacion varchar(15),
	in _contrasenia varchar(15),
	in _nombre varchar(20),
	in _apellido varchar(20),
	in _sexo varchar(2),
	in _pais varchar(15),
	in _organizacion varchar(15)
) returns boolean as
$body$
begin
	if ((select id_tipo_usuario from usuario where id_usuario = _id_usuario) = 4) then
		update usuario  set contrasenia = _contrasenia where id_usuario = _id_usuario;
		update infosupext set identificacion = _identificacion, nombre = _nombre, apellido = _apellido, sexo = _sexo, pais = _pais, organizacion = _organizacion where id_usuario = _id_usuario;
		return true;
	else
		return false;
	end if;
end;
$body$
language plpgsql;


/*
	solo se pueden eliminar los usuarios que aun no han activado sus cuentas
	y no hayan ingresado registros al sistema, este procedimiento se usa solo
	en caso de que se haya cometido un error al momento de ingresar usuarios, y se quiere
	corregir eliminandolo
*/
create or replace function eliminarSupervisor(
	in _id_usuario int
) returns void as
$body$
begin
	delete from credencialtemporal where id_usuario = _id_usuario;
	delete from infosupext where id_usuario = _id_usuario;
	delete from usuario where id_usuario = _id_usuario;
end;
$body$
language plpgsql;



/*
	solo para magistrados, representante cnr y director de tse
	no es necesario que sus datos aparezcan en los registros del 
	cnr para que puedan tener una cuent de usuario
	el parametro tipo solo acepta el 2, 3 o 6 
	que representas a los 3 usuarios mencionados al principio
*/
create or replace function agregarPrincipal(
	in _num_dui varchar(10),
	in _contrasenia varchar(15),
	in _nombre varchar(20),
	in _apellido varchar(20),
	in _fecha_nac varchar(10),
	in _sexo varchar(2),
	in _direccion varchar(60),
	in _municipio int,
	in tipo int
) returns boolean as
$body$
begin
	if(tipo = 2 or tipo = 3 or tipo = 6) then
		insert into usuario (id_tipo_usuario, contrasenia, confirmacion) values (tipo, _contrasenia, 0);
		insert into credencialtemporal (id_usuario, num_dui) values (lastval(), _num_dui);
		insert into excepcionUsuario (id_usuario,num_dui, nombre, apellido, fecha_nac, sexo, direccion_especifica, id_municipio)
		values (lastval(),_num_dui,_nombre,_apellido,_fecha_nac,_sexo,_direccion,_municipio);
		return true;
	else
		return false;
	end if;
	
end;
$body$
language plpgsql;


/*
	procedimiento para agregar Representante de partido (5),Gestor de jrv (7),
	director de centro de votaciones (8), publicista (9) y presidente de jrv (10)
	estos usuarios necesitar estar entre los registros del cnr para poder tener 
	una cuenta de este tipo
*/
create or replace function agregarSecundario(
	in _num_dui varchar(10),
	in _contrasenia varchar(15),
	in tipo int
) returns boolean as
$body$
declare
	id int;
begin
	if(tipo = 5 or (tipo >= 7 and tipo <= 11 )) then
		/*se comprueba que el dui exista en los registros del cnr*/	
		if exists(select * from padronelectoral where num_dui = _num_dui) then
			select u.id_usuario into id from usuariopadron u where u.num_dui = _num_dui;
			update usuario set id_tipo_usuario = tipo, contrasenia = _contrasenia where id_usuario = id;
			return true;
		else
			return false;
		end if;
	else
		return false;
	end if;
	
end;
$body$
language plpgsql;

/*
se modifica la informacin de un usuario principal 
el procedimiento retorna un true cuando la modificacion es exitosa, retorna false
cuando hubo un error, una causa de error puede ser que se le intenta asignar un
tipo de usuario no permitido
*/
create or replace function modificarPrincipal(
	in _id int,
	in _num_dui varchar(10),
	in _contrasenia varchar(15),
	in _nombre varchar(20),
	in _apellido varchar(20),
	in _fecha_nac varchar(10),
	in _sexo varchar(2),
	in _direccion varchar(60),
	in _municipio int,
	in tipo int
) returns boolean as
$body$
begin
	if(tipo = 2 or tipo = 3 or tipo = 6) then
		update usuario set id_tipo_usuario = tipo, contrasenia = _contrasenia where id_usuario = _id;
		update credencialtemporal set num_dui = _num_dui where id_usuario = _id;
		update excepcionUsuario set num_dui = _num_dui, nombre = _nombre, apellido = _apellido, fecha_nac = _fecha_nac, sexo = _sexo, direccion_especifica = _direccion, id_municipio = _municipio where id_usuario = _id;
		return true;
	else
		return false;
	end if;
	
end;
$body$
language plpgsql;


/*----procedimientos agregados octubre 25, 2016----*/
/*
se registra una accion en la bitacora, incluyendo las credenciales de los 3 magistrados
que autorizaron la accion
*/
create or replace function agregarBitacora(
	in _accion varchar(60),
	in _magistrado1 varchar(10),
	in _magistrado2 varchar(10),
	in _magistrado3 varchar(10)
) returns void as
$body$
declare 
	id int;
	horas float;
	minutos float;
begin
	horas = extract(hour from current_time);
	minutos = extract(minute from current_time) as minutos;
	insert into bitacoraacciones (fecha,hora,accion) values (current_date, horas || ':' || minutos || ':00' ,_accion);
	id = lastval();
	insert into detallebitacora (id_bitacora,num_dui) values (id, _magistrado1);
	insert into detallebitacora (id_bitacora,num_dui) values (id, _magistrado2);
	insert into detallebitacora (id_bitacora,num_dui) values (id, _magistrado3);
	
end;
$body$
language plpgsql;

/*creacion de trigger para la creacion de cuentas de usuario a los ciudadanos*/
create or replace function agregarVotante_trigger() returns trigger as
$insertar$
declare begin
	insert into usuario (id_tipo_usuario, contrasenia, confirmacion) values (11,'12345',0);
	insert into usuariopadron (id_usuario,num_dui) values (lastval(),new.num_dui); 
	return null;
end;
$insertar$
language plpgsql;

create trigger agregarVotante_trigger after insert
on padronelectoral for each row
execute procedure agregarVotante_trigger();

/*insercion de datos*/

/*cuenta de administrador*/
insert into usuario (id_tipo_usuario,contrasenia,confirmacion) values(1,'12345',0);
insert into credencialTemporal (id_usuario, num_dui) values (lastval(),'00000000-0');

/*cuenta de magistrados*/
select agregarPrincipal('00000001-0','12345','Teresa','Ramirez','2016-12-12','f','Cerca de la ues',28,2);
select agregarPrincipal('00000002-0','12345','Orlando','Menjivar','1976-08-12','m','Direccion 2',2, 2);
select agregarPrincipal('00000003-0','12345','Dayana','Guzman','1987-09-12','f','Calle #12, Escalon',3, 2);
select agregarPrincipal('00000004-0','12345','Flor','Fernandez','1976-12-05','f','Colonia enrique arau, 2jo',6, 2);
select agregarPrincipal('00000005-0','12345','Patricio','roque','1976-09-01','m','Avenida montreal',10, 2);

/*cuenta para usuario del cnr*/
select agregarPrincipal('00000006-0','12345','Beatriz','Cocar','1996-06-12','f','Canton el espino, #12',2, 3);

/*cuenta para director del tse*/
select agregarPrincipal('00000007-0','12345','Mario','Ayala','1987-09-11','m','Calle el matazano',13, 6);

/*cuentas para supervisores externos*/
select agregarSupervisor('00-00-00','12345','Fernando','Ayala','m','Dinamarca','OEA');
select agregarSupervisor('00-00-01','12345','Manuel','Mendoza','m','Alemania','UNICEF');
select agregarSupervisor('00-00-02','12345','Orlando','Bolaños','m','Alemania','UNICEF');
select agregarSupervisor('00-00-03','12345','Adonay','Ayala','m','Dinamarca','OEA');
select agregarSupervisor('00-00-04','12345','Edith','Argueta','f','Alemania','UNICEF');
select agregarSupervisor('00-00-05','12345','Javier','Ayala','m','Dinamarca','OEA');
select agregarSupervisor('00-00-06','12345','Dinora','Arquera','f','Corea','JUVEO');
select agregarSupervisor('00-00-07','12345','Ariel','Guzman','m','Corea','JUVEO');
select agregarSupervisor('00-00-08','12345','Job','Flores','m','Dinamarca','OEA');
select agregarSupervisor('00-00-09','12345','Chabelo','Sandoval','m','Corea','JUVEO');

/*datos del cnr*/
insert into padronelectoral values('00000008-0','Sara','Benitez','1994-05-10','f','Direcion falsa',1);
insert into padronelectoral values('00000009-0','Jorge','Anne','1995-02-10','m','Direccion postisa',2);
insert into padronelectoral values('00000010-0','Isaac','Ponce','1992-02-10','m','Direccion postisa',3);
insert into padronelectoral values('00000011-0','Jonh','Mendoza','1995-05-20','m','Direccion postisa',4);
insert into padronelectoral values('00000012-0','Magdalena','De Ramirez','1994-05-12','f','Direccion postisa',5);
insert into padronelectoral values('00000013-0','Fernanda','Olivares','1994-05-10','f','Direccion postisa',6);
insert into padronelectoral values('00000014-0','Melvin','Dagoberto','1994-05-10','m','Direccion postisa',7);
insert into padronelectoral values('00000015-0','Fredy','Mendoza','1995-05-10','m','Direccion postisa',8);
insert into padronelectoral values('00000016-0','Faustino','Asprilla','1994-05-10','m','Calle el matazano',9);
insert into padronelectoral values('00000017-0','Maria','Flores','1992-03-10','f','kernel informatico $5',10);
insert into padronelectoral values('00000018-0','Carlos','Benitez','1994-05-10','f','Direcion falsa',1);
insert into padronelectoral values('00000019-0','Mario','Anne','1994-05-10','m','Direccion postisa',12);

/*cuenta para representante de partido*/
select agregarSecundario('00000008-0','12345',5);

/*cuenta para director de centro de votaciones*/
select agregarSecundario('00000009-0','12345',8);

/*cuenta para publicista*/
select agregarSecundario('00000010-0','12345',9);

/*cuenta para presidente de jrv*/
select agregarSecundario('00000011-0','12345',10);

/*cuenta para gestor de jrv*/
select agregarSecundario('00000012-0','12345',7);
select agregarSecundario('00000013-0','12345',7);
select agregarSecundario('00000014-0','12345',7);
select agregarSecundario('00000015-0','12345',7);

/*inicios de sesion*/
select * from entrarAdministrador('00000000-0','12345');
select * from entrarSupervisor('00-00-00','12345'); 
select * from entrarPrincipal('00000001-0','12345'); /*magistrado*/
select * from entrarPrincipal('00000006-0','12345'); /*representante crn*/
select * from entrarPrincipal('00000007-0','12345'); /*director tse*/

select * from entrarSecundario('00000008-0','12345'); /*representante de partido*/
select * from entrarSecundario('00000009-0','12345'); /*director de centro de votaciones*/
select * from entrarSecundario('00000010-0','12345'); /*publicista*/
select * from entrarSecundario('00000011-0','12345'); /*presidente de jrv*/
select * from entrarSecundario('00000012-0','12345'); /*gestor de jrv*/

/*
cuando un usuario secundario accede desde aca, se convierte en un votante 
con acceso a la papeleta de votaciones, tambien puede acceder cualquier usuario 
que este registrado en la tabla padronelectoral
*/
select * from entrarVotante('00000008-0','12345'); 


/*registros para partidos*/
insert into partido (nombre,acronimo,num_dui,imagen) values ('Gran Alianza Nacional','GANA','00000017-0','img/imagen1.png');
insert into partido (nombre,acronimo,num_dui,imagen) values ('Alianza Republicana Nacionalista', 'ARENA','00000018-0','img/imagen2.png');
