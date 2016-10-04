
/*procedimientos almacenados agregados por carlos*/

/*
cuando la credencial de administrador es correcta, se retorna el id del usuario y un mensaje de exito,
cuando las credenciales son incorrectos retorna 0 y un mensaje de error,
al igual que cuando las credenciales no exiten en el sistema
*/
create or replace function entrarAdministrador(
	in _dui varchar(10),
	in _contrasenia varchar(15),
	out idusuario int,
	out mensaje varchar(50)
) returns setof record as
$body$
	declare
		id int;
		tipo int;
		texto varchar(50);
	begin
	if exists(select * from credencialtemporal ct inner join usuario u on ct.id_usuario = u.id_usuario where ct.num_dui = _dui and u.contrasenia = _contrasenia) then
		select tp.id_tipo_usuario into tipo from tipousuario tp
		inner join usuario u on u.id_tipo_usuario = tp.id_tipo_usuario
		inner join credencialtemporal ct on ct.id_usuario = u.id_usuario
		where ct.num_dui = _dui;
		if(tipo = 1) then
			select ct.id_usuario into id from credencialtemporal ct where num_dui = _dui;
			texto = 'Bienvenido al sistema';
		else
			id = 0;
			texto = 'No tienes lo privilegios para entrar';
		end if;
		
	else
		texto = 'Credenciales incorrectas';
		id = 0;
	end if;
	return query select id, texto;
	return;
	end;
$body$
language plpgsql;


/*
este procediminto cumple la misma funcion que el anterior, pero hoy es para magistrados,
muetra ademas un mensaje de advertencia cuando no se ha activado la cuenta
*/
create or replace function entrarMagistrado(
	in _dui varchar(10),
	in _contrasenia varchar(15),
	out idusuario int,
	out mensaje varchar(60)
) returns setof record as
$body$
	declare
		id int;
		tipo int;
		texto varchar(60);
		confirmacion int;
	begin
	if exists(select * from credencialtemporal ct inner join usuario u on ct.id_usuario = u.id_usuario where ct.num_dui = _dui and u.contrasenia = _contrasenia) then
		select tp.id_tipo_usuario into tipo from tipousuario tp
		inner join usuario u on u.id_tipo_usuario = tp.id_tipo_usuario
		inner join credencialtemporal ct on ct.id_usuario = u.id_usuario
		where ct.num_dui = _dui;
		if(tipo = 2) then
			select ct.id_usuario into id from credencialtemporal ct where num_dui = _dui;
			select u.confirmacion into confirmacion from usuario u 
			inner join credencialTemporal ct on ct.id_usuario = u.id_usuario
			where ct.num_dui = _dui;
			if(confirmacion = 1) then
				texto = 'Bienvenido al sistema, Magistrado';
			else 
				texto = 'Bienvenido al sistema, Magistrado. Debes activar tu cuenta';
			end if;
		else
			id = 0;
			texto = 'No tienes lo privilegios para entrar';
		end if;
		
	else
		texto = 'Credenciales incorrectas';
		id = 0;
	end if;
	return query select id, texto;
	return;
	end;
$body$
language plpgsql;

/*
	permite o deniega la entrada para el usuario del cnr, muestra los
	mimo mensajes que el procedimiento anterior
	retorna el id del usuario y un mensaje de bienvenida
	este procedimiento no muestra el mensaje de activacion, ya que solo se ingresara una vez al sitema
	cuando las credenciales son incorrectas retorna 0 y el respectivo mensaje de error
*/
create or replace function entrarCNR(
	in _dui varchar(10),
	in _contrasenia varchar(15),
	out idusuario int,
	out mensaje varchar(60)
) returns setof record as
$body$
	declare
		id int;
		tipo int;
		texto varchar(60);
		confirmacion int;
	begin
	if exists(select * from credencialtemporal ct inner join usuario u on ct.id_usuario = u.id_usuario where ct.num_dui = _dui and u.contrasenia = _contrasenia) then
		select tp.id_tipo_usuario into tipo from tipousuario tp
		inner join usuario u on u.id_tipo_usuario = tp.id_tipo_usuario
		inner join credencialtemporal ct on ct.id_usuario = u.id_usuario
		where ct.num_dui = _dui;
		if(tipo = 3) then
			select ct.id_usuario into id from credencialtemporal ct where num_dui = _dui;
			select u.confirmacion into confirmacion from usuario u 
			inner join credencialTemporal ct on ct.id_usuario = u.id_usuario
			where ct.num_dui = _dui;
			texto = 'Bienvenido al sistema, Representante del CNR';
		else
			id = 0;
			texto = 'No tienes lo privilegios para entrar';
		end if;
		
	else
		texto = 'Credenciales incorrectas';
		id = 0;
	end if;
	return query select id, texto;
	return;
	end;
$body$
language plpgsql;

/*
	permite o deniega la entrada al sistema a lo ciudadado,
	cuando la credenciales con correctas retorna el id del usuario, y un mensaje de bienvenida, pidiendole que active
	su cuenta, en caso que se encuentre desactivada
	si las credenciales con incorrectas o no existen, retorna 0 y el respectivo mensaje
*/
create or replace function entrarVotante(
	in _dui varchar(10),
	in _contrasenia varchar(15),
	out idusuario int,
	out mensaje varchar(60)
) returns setof record as
$body$
	declare
		id int;
		texto varchar(60);
		confirmacion int;
	begin
	/*se comprueba que el ciudadano este regitrado en el sistema y tenga un usuario*/
	if exists(select * from padronelectoral p inner join usuariopadron up on up.num_dui = p.num_dui inner join usuario u on u.id_usuario = up.id_usuario where p.num_dui = _dui and u.contrasenia = _contrasenia) then
			/*se verifica si la cuenta esta activada*/
			select u.confirmacion into confirmacion from usuario u 
			inner join usuariopadron up on up.id_usuario = u.id_usuario
			inner join padronelectoral p on p.num_dui = up.num_dui
			where p.num_dui = _dui;
			/*se selecciona el id del votante*/
			select u.id_usuario into id from usuario u 
			inner join usuariopadron up on up.id_usuario = u.id_usuario
			inner join padronelectoral p on p.num_dui = up.num_dui;	
			/*en caso de que la cuenta este activada*/
			if (confirmacion = 1) then
				texto = 'Bienvenido al sistema';
			else
				texto = 'Bienvenido al sistema, aun no ha activado tu cuenta';
			end if;	
	else
		texto = 'Credenciales incorrectas';
		id = 0;
	end if;
	return query select id, texto;
	return;
	end;
$body$
language plpgsql;


/*
	los datos de un magistrado deben aparecen en muchas tablas
	cuando se ingresa un magistrado correctamente retorna 1 y un mensaje de exito
	cuando el dui se repite, retorna 0 y el mensaje de error
*/
create or replace function agregarMagistrado(
	in _num_dui varchar(10),
	in _contrasenia varchar(15),
	in _nombre varchar(20),
	in _apellido varchar(20),
	in _fecha_nac date,
	in _sexo varchar(2),
	in _direccion varchar(30),
	in _municipio int,
	out estado int,
	out mensaje varchar(60)
) returns setof record as
$body$
declare
	idgenerado int;
	texto varchar(60);
	numero int;
begin
	if not exists(select * from credencialtemporal where num_dui = _num_dui) then
		insert into usuario(id_tipo_usuario,contrasenia,confirmacion) values (2,'12345',0);
		idgenerado = lastval();
		insert into credencialtemporal(id_usuario,num_dui) values (idgenerado,_num_dui);
		insert into excepcionusuario(id_usuario,num_dui,nombre,apellido,fecha_nac,sexo,direccion_especifica,id_municipio) values (idgenerado,_num_dui,_nombre,_apellido,_fecha_nac,_sexo,_direccion,_municipio);
		texto = 'Magistrado registrado correctamente';
		numero = 1;
	else
		texto = 'El numero de Dui ya esta registrado';
		numero = 0;
	end if;
	return query select numero,texto;
	return;
end;
$body$
language plpgsql;


/*
	al igual que con el magistrado, los datos del representante del cnr van en 
	varias tablas, retorna los mismos valores que la funcion anterior
*/
create or replace function agregarRepresentanteCNR(
	in _num_dui varchar(10),
	in _contrasenia varchar(15),
	in _nombre varchar(20),
	in _apellido varchar(20),
	in _fecha_nac date,
	in _sexo varchar(2),
	in _direccion varchar(30),
	in _municipio int,
	out estado int,
	out mensaje varchar(60)
) returns setof record as
$body$
declare
	idgenerado int;
	texto varchar(60);
	numero int;
begin
	if not exists(select * from credencialtemporal where num_dui = _num_dui) then
		insert into usuario(id_tipo_usuario,contrasenia,confirmacion) values (3,'12345',0);
		idgenerado = lastval();
		insert into credencialtemporal(id_usuario,num_dui) values (idgenerado,_num_dui);
		insert into excepcionusuario(id_usuario,num_dui,nombre,apellido,fecha_nac,sexo,direccion_especifica,id_municipio) values (idgenerado,_num_dui,_nombre,_apellido,_fecha_nac,_sexo,_direccion,_municipio);
		texto = 'Representante CNR registrado correctamente';
		numero = 1;
	else
		texto = 'El numero de Dui ya esta registrado';
		numero = 0;
	end if;
	return query select numero,texto;
	return;
end;
$body$
language plpgsql;


/*
	procedimiento para agregar cuidadados votantes
	este procedimiento se usará cuando se vacien lo registros del cnr
	se agrega un ciudadano a la tabla padron y se creara una cuenta de usuario para este ciudadano
	la contraseña por defecto sera el numero de dui
*/
create or replace function agregarVotante(
	in _num_dui varchar(10),
	in _nombre varchar(20),
	in _apellido varchar(20),
	in _fecha_nac date,
	in _sexo varchar(2),
	in _direccion varchar(30),
	in _municipio int,
	out estado int,
	out mensaje varchar(60)
) returns setof record as
$body$
declare
	idgenerado int;
	texto varchar(60);
	numero int;
begin
	if not exists(select * from padronelectoral where num_dui = _num_dui) then
		insert into usuario(id_tipo_usuario,contrasenia,confirmacion) values (3,_num_dui,0);
		idgenerado = lastval();
		insert into padronelectoral(num_dui,nombre,apellido,fecha_nac,sexo,direccion_especifica,id_municipio) values (_num_dui,_nombre,_apellido,_fecha_nac,_sexo,_direccion,_municipio);
		insert into usuariopadron values (idgenerado,_num_dui);
		texto = 'Ciudadano regitrado';
		numero = 1;
	else
		texto = 'El numero de Dui ya esta registrado';
		numero = 0;
	end if;
	return query select numero,texto;
	return;
end;
$body$
language plpgsql;

/*
	registro de supervisores externos, ellos incian sesion con su identificacion,
	su contraseña por defecto es 12345
	retorna 1 y un mensaje de exito cuando se inserto correctamente
	retorna 0 y un mensaje de error cuando no se inserto
*/
create or replace function agregarSupervisorExt(
	in _identificacion varchar(15),
	in _contrasenia varchar(15),
	in _nombre varchar(20),
	in _apellido varchar(20),
	in _sexo varchar(2),
	in _pais varchar(15),
	in _organizacion varchar(15),
	out estado int,
	out mensaje varchar(60)
) returns setof record as
$body$
declare
	numero int;
	texto varchar(60);
begin
	if not exists(select * from infosupext where identificacion = _identificacion) then
		insert into usuario(id_tipo_usuario,contrasenia,confirmacion) values (4,_contrasenia,0);
		numero = lastval();
		insert into infosupext (id_usuario,identificacion,nombre,apellido,sexo,pais,organizacion) values (numero,_identificacion,_nombre,_apellido,_sexo,_pais,_organizacion);
		texto = 'Supervisor externo registrado correctamente';
		return query select 1,texto;
	else 
		texto = 'La identificacion ya existe';
		return query select 0,texto;
	end if;
	return;
end;
$body$
language plpgsql;


/*
	director del tse, es quien registra a los gestores de jrv por departmento y demas usuarios 
	que los requiera el sistema
*/

create or replace function agregarDirectorTse(
	in _num_dui varchar(10),
	in _contrasenia varchar(15),
	in _nombre varchar(20),
	in _apellido varchar(20),
	in _fecha_nac date,
	in _sexo varchar(2),
	in _direccion varchar(30),
	in _municipio int,
	out estado int,
	out mensaje varchar(60)
) returns setof record as
$body$
declare
	idgenerado int;
	texto varchar(60);
	numero int;
begin
	if not exists(select * from credencialtemporal where num_dui = _num_dui) then
		insert into usuario(id_tipo_usuario,contrasenia,confirmacion) values (6,'12345',0);
		idgenerado = lastval();
		insert into credencialtemporal(id_usuario,num_dui) values (idgenerado,_num_dui);
		insert into excepcionusuario(id_usuario,num_dui,nombre,apellido,fecha_nac,sexo,direccion_especifica,id_municipio) values (idgenerado,_num_dui,_nombre,_apellido,_fecha_nac,_sexo,_direccion,_municipio);
		texto = 'Director de TSE registrado correctamente';
		numero = 1;
	else
		texto = 'El numero de Dui ya esta registrado';
		numero = 0;
	end if;
	return query select numero,texto;
	return;
end;
$body$
language plpgsql;

/*
	creacion de los demas usuarios del sistema, que no sean administrador, usuario del cnr, votante, magistrado o supervisor externo
	los demas usuarios tienen caracteristicas en comun, el procedimiento recibe 2 parametros, el numero de dui y el tipo de usuario
	para que un usuario de este tipo se pueda crear debe estar previamente registrado en la tabla padronelectoral, en caso contrario retorna 0 y muestra
	un mensaje de alerta
	el procedimiento solo permite la creacion de tipos de usuario 5, 6, 7, 8 y 9 que son
	4.supervisor externo, 5.representante de partido, 6.gestor de informacion, 7.director de centro de votacion, 8.publicista, 9.presidente de jrv

*/
create or replace function agregarUsuario(
	in _num_dui varchar(10),
	in _tipo int,
	out estado int,
	out mensaje varchar(60)
) returns setof record as
$body$
declare
	id int;
	texto varchar(60);
	numero int;
begin
	if exists(select * from padronelectoral where num_dui = _num_dui) then
		if (_tipo >= 5 and _tipo <=9 and _tipo != 6) then
			select u.id_usuario into id from padronelectoral p 
			inner join usuariopadron up on up.num_dui = p.num_dui
			inner join usuario u on u.id_usuario = up.id_usuario
			where p.num_dui = _num_dui;
			update usuario set id_tipo_usuario = _tipo where id_usuario = id;
			texto = 'Usuario agregado';
			numero = 1;
		else
			texto = 'No tienes los privilegios para crear ese tipo de usuario';
			numero = 0;
		end if;
	else
		texto = 'El usuario no existe en el padron electoral';
		numero = 0;
	end if;
	return query select numero, texto;
	return;
end;
$body$
language plpgsql;

/*
	procedimiento de login compartido por administrador, usuario cnr, magistrados, y director del tse
	retorna el tipo de usuario y el dui
*/

create or replace function entrar(
	in _dui varchar(10),
	in _contrasenia varchar(15),
	out tipo int,
	out tipo_usuario varchar(30),
	out dui varchar(25)
) returns setof record as
$body$
declare 
	_tipousuario int;
	_claseusuario varchar(30);
	texto varchar(25);
begin
	if exists(select * from usuario u inner join credencialtemporal ct on u.id_usuario = ct.id_usuario inner join tipousuario tp on tp.id_tipo_usuario = u.id_tipo_usuario where contrasenia = _contrasenia and num_dui = _dui) then
		select tp.id_tipo_usuario into _tipousuario from usuario u inner join credencialtemporal ct
		on u.id_usuario = ct.id_usuario
		inner join tipousuario tp on tp.id_tipo_usuario = u.id_tipo_usuario
		where contrasenia = _contrasenia and num_dui = _dui;
		
		select tp.tipo_usuario into _claseusuario from usuario u inner join credencialtemporal ct
		on u.id_usuario = ct.id_usuario
		inner join tipousuario tp on tp.id_tipo_usuario = u.id_tipo_usuario
		where contrasenia = _contrasenia and num_dui = _dui;
		return query select _tipousuario,_claseusuario, _dui;
	else 
		texto = 'credenciales incorrectas';
		return query select 0, 'Error', texto;
	end if;
end;
$body$
language plpgsql;

/*creacion de cuenta de administrador
*/
insert into usuario (id_tipo_usuario,contrasenia,confirmacion) values(1,'12345',0);
insert into credencialTemporal (id_usuario, num_dui) values (1,'00000000-0');

/*uso de los procedimiento almacenados*/
/*los parametros de entrada son numero de dui y contraseña*/
select * from agregarMagistrado('00000001-0','12345','Carlos','Menjivar','1976-09-12','m','Avenida las amapolas',1);
select * from agregarMagistrado('00000002-0','12345','Orlando','Menjivar','1976-08-12','m','Direccion 2',2);
select * from agregarMagistrado('00000003-0','12345','Dayana','Guzman','1987-09-12','f','Calle #12, Escalon',3);
select * from agregarMagistrado('00000004-0','12345','Flor','Fernandez','1976-12-05','f','Colonia enrique araujo',6);
select * from agregarMagistrado('00000005-0','12345','Patricio','roque','1976-09-01','m','Avenida montreal',10);

select * from agregarRepresentanteCNR('00000006-0','12345','Beatriz','Cocar','1996-06-12','f','Canton el espino, #12',2);

select * from agregarDirectorTse('00000000-1','12345','Mario','Ayala','1987-09-11','m','Calle el matazano',13);

select * from agregarSupervisorExt('053315-0980','12345','Will','Smith','m','Estados Unidos','OEA');
select * from agregarSupervisorExt('6656-0-0.09','12345','Robert','Lewandowski','m','Rusia','UEFA');
select * from agregarSupervisorExt('090-AED-B6E-2','12345','Mijail','Black','m','Croacia','ONU');

select * from agregarVotante('00000007-0','Maria','Flores','1994-05-10','f','kernel informatico $5',2);
select * from agregarVotante('00000008-0','Sara','Benitez','1994-05-10','f','Direcion falsa',2);
select * from agregarVotante('00000009-0','Jorge','Anne','1994-05-10','m','Direccion postisa',22);
select * from agregarVotante('00000010-0','Isaac','Ponce','1994-05-10','m','Direccion postisa',30);
select * from agregarVotante('00000011-0','Jonh','Mendoza','1994-05-10','m','Direccion postisa',9);
select * from agregarVotante('00000012-0','Magdalena','De Ramirez','1994-05-10','f','Direccion postisa',6);
select * from agregarVotante('00000013-0','Fernanda','Olivares','1994-05-10','f','Direccion postisa',10);
select * from agregarVotante('00000013-0','Melvin','Dagoberto','1994-05-10','m','Direccion postisa',8);
select * from agregarVotante('00000015-0','Fredy','Mendoza','1994-05-10','m','Direccion postisa',24);
select * from agregarVotante('00000016-0','Faustino','Asprilla','1994-05-10','m','Calle el matazano',25);

select * from agregarUsuario('00000007-0',5);
select * from agregarUsuario('00000008-0',6);
select * from agregarUsuario('00000009-0',7);
select * from agregarUsuario('00000010-0',8);
select * from agregarUsuario('00000011-0',9);



select * from entrarAdministrador('00000000-0','12345');
select * from entrarMagistrado('00000001-0','12345');
select * from entrarCNR('00000006-0','12345');
select * from entrarVotante('00000007-0','00000007-0');

select * from entrar('00000000-1','12345');