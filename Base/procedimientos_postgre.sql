create or replace function entrarAdministrador(
	in _dui varchar(10),
	in _contrasenia varchar(15),
	out id_usuario int,
	out num_dui varchar(10),
	out contrasenia varchar(15),
	out confirmacion int,
	out tipo_usuario int
) returns setof record as
$body$
	declare
		id int;
		tipo int;
		texto varchar(50);
	begin
	return query select u.id_usuario, ct.num_dui, u.contrasenia, u.confirmacion, u.id_tipo_usuario 
	from usuario u inner join credencialtemporal ct
	on u.id_usuario = ct.id_usuario where id_tipo_usuario = 1 where ct.num_dui = _dui and u.contrasenia = _contrasenia
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
	out id_tipo_usuario int,
	out pais varchar(15),
	out organizacion varchar(15)
) returns setof record as
$body$
	begin
		return query select u.id_usuario, ext.identificacion, u.contrasenia, ext.nombre, ext.apellido, ext.sexo, u.confirmacion, u.id_tipo_usuario, ext.pais, ext.organizacion 
		from usuario u inner join infosupext ext on u.id_usuario = ext.id_usuario 
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
	out tipo_usuario int,
	out fecha_nac date,
	out direccion varchar(30),
	out id_municipio int, 
	out id_departamento int
) returns setof record as
$body$
	begin
		return query select u.id_usuario, ex.num_dui, u.contrasenia, ex.nombre, ex.apellido, ex.sexo, u.confirmacion, u.id_tipo_usuario, ex.fecha_nac, ex.direccion_especifica, mu.id_municipio, mu.id_departamento from usuario u 
		inner join credencialtemporal ct on u.id_usuario = ct.id_usuario
		inner join excepcionusuario ex on ex.id_usuario = u.id_usuario
		inner join municipio mu on mu.id_municipio = ex.id_municipio 
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
	out tipo_usuario int,
	out fecha_nac date,
	out direccion varchar(30),
	out id_municipio int, 
	out id_departamento int
) returns setof record as
$body$
	begin
		return query select u.id_usuario, p.num_dui, u.contrasenia, p.nombre, p.apellido, p.sexo, u.confirmacion, u.id_tipo_usuario, p.fecha_nac, p.direccion_especifica, p.id_municipio, m.id_departamento from usuario u
		inner join usuariopadron up on up.id_usuario = u.id_usuario
		inner join padronelectoral p on p.num_dui = up.num_dui
		inner join municipio m on m.id_municipio = p.id_municipio 
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
	out tipo_usuario int,
	out fecha_nac date,
	out direccion varchar(30),
	out id_municipio int, 
	out id_departamento int
) returns setof record as
$body$
	begin
		return query select u.id_usuario, p.num_dui, u.contrasenia, p.nombre, p.apellido, p.sexo, u.confirmacion, u.id_tipo_usuario, p.fecha_nac, p.direccion_especifica, p.id_municipio, m.id_departamento from usuario u
		inner join usuariopadron up on up.id_usuario = u.id_usuario
		inner join padronelectoral p on p.num_dui = up.num_dui
		inner join municipio m on m.id_municipio = p.id_municipio 
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

