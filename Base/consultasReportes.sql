--porcentaje de jovenes entre 18 y 30 años	NECESITA MODIFICACION
select count((extract(year from current_date) - extract(year from fecha_nac))) as candidadJovenes, 
(select count(num_dui) from padronelectoral)  as totalPersonas,
((count((extract(year from current_date) - extract(year from fecha_nac))) * 100) / (select count(num_dui) from padronelectoral)) as porcentajeJovenes
from padronelectoral 
where extract(year from fecha_nac) >= 1986

--hombres y mujeres que votaron
select pe.sexo, count(pe.sexo) as cantidad  from votanteporjrv v
inner join padronelectoral pe on v.num_dui = pe.num_dui
where v.estado = 1
group by pe.sexo

--porcentaje de personas que votaron, y personas abstenidas NECESITA MODIFICACION
select count(estado) personasVotantes, (select count(estado) from votanteporjrv where estado = 0) as personasAbstenidas from votanteporjrv
where estado = 1

--diputados por partido y votos que recibieron
select p.acronimo, vm.id_candidato, pe.num_dui, (pe.apellido || ', ' || pe.nombre) as candidato, sum(vm.valor_porcentual)as voto from votomarca vm
inner join candidato c on c.id_candidato = vm.id_candidato
inner join padronelectoral pe on pe.num_dui = c.num_dui
inner join detallepartido dp on dp.id_candidato = c.id_candidato
inner join partido p on p.id_partido = dp.id_partido
inner join departamento dep on dep.id_departamento = c.id_departamento
group by pe.num_dui, p.acronimo, vm.id_candidato
order by p.acronimo, voto desc

--diputados con mayor y menor numero de votos en un partido - ES UNA CONSULTA POR PARTIDO
select p.acronimo, dep.nombre_departamento, vm.id_candidato, pe.num_dui, (pe.apellido || ', ' || pe.nombre) as candidato, sum(vm.valor_porcentual)as voto from votomarca vm
inner join candidato c on c.id_candidato = vm.id_candidato
inner join padronelectoral pe on pe.num_dui = c.num_dui
inner join detallepartido dp on dp.id_candidato = c.id_candidato
inner join partido p on p.id_partido = dp.id_partido
inner join departamento dep on dep.id_departamento = c.id_departamento
where p.id_partido = 3
group by pe.num_dui, p.acronimo, vm.id_candidato, dep.nombre_departamento
order by p.acronimo, voto desc

--departamentos ganados por cada partido politico -- esta pendiente
select distinct dep.nombre_departamento, p.nombre, sum(vm.valor_porcentual) as votos from departamento dep
inner join candidato c on c.id_departamento = dep.id_departamento
inner join detallepartido dp on dp.id_candidato = c.id_candidato
inner join partido p on p.id_partido = dp.id_partido
inner join votomarca vm on vm.id_candidato = c.id_candidato
where dep.id_departamento = 6
group by dep.nombre_departamento, p.nombre
order by votos desc
limit 1


