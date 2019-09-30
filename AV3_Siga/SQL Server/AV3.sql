create database Siga_AV3
go
use Siga_AV3


select * from Aluno
select * from Disciplina
select * from Avaliacao
select * from PesoAvaliacao order by codigo_disciplina, tipo_avaliacao asc
select * from Nota
select * from Falta
select * from Aula



--table Aluno
drop table Aluno
go
create table Aluno
(
ra_aluno int not null,
nome_aluno varchar(300)
primary key (ra_aluno)
)



drop table Disciplina
go
create table Disciplina
(
codigo_disciplina varchar(8) not null,
nome_disciplina varchar(200),
sigla_disciplina varchar(10),
turno_disciplina varchar(30),
num_aulas_disciplina int
primary key (codigo_disciplina)
)



drop table AlunoDisciplina
go
create table AlunoDisciplina
(
codigo_disciplina varchar(8) not null,
ra_aluno int not null,
primary key (codigo_disciplina, ra_aluno),
foreign key (codigo_disciplina) references Disciplina(codigo_disciplina),
foreign key (ra_aluno) references Aluno(ra_aluno)
)



drop table Avaliacao
go
create table Avaliacao
(
tipo_avaliacao varchar(50)
primary key (tipo_avaliacao)
)



drop table PesoAvaliacao
go
create table PesoAvaliacao
(
codigo_disciplina varchar(8) not null,
tipo_avaliacao varchar(50) not null,
peso decimal(1,1),
primary key (tipo_avaliacao, codigo_disciplina),
foreign key (tipo_avaliacao) references Avaliacao(tipo_avaliacao),
foreign key (codigo_disciplina) references Disciplina(codigo_disciplina)
)



drop table Nota
go
create table Nota
(
ra_aluno int not null,
codigo_disciplina varchar(8) not null,
tipo_avaliacao varchar(50) not null,
nota decimal(3,1),
primary key (ra_aluno, codigo_disciplina, tipo_avaliacao),
foreign key (ra_aluno) references Aluno(ra_aluno),
foreign key (codigo_disciplina) references Disciplina(codigo_disciplina),
foreign key (tipo_avaliacao) references Avaliacao(tipo_avaliacao)
)



drop table Falta
go
create table Falta
(
ra_aluno int not null,
codigo_disciplina varchar(8) not null,
semana_aula int not null,
data_falta date,
presenca int,
primary key (ra_aluno, codigo_disciplina, semana_aula),
foreign key (ra_aluno) references Aluno(ra_aluno),
foreign key (codigo_disciplina) references Disciplina(codigo_disciplina),
foreign key (codigo_disciplina, semana_aula) references Aula(codigo_disciplina, semana_aula)
)



drop table Aula
go
create table Aula
(
codigo_disciplina varchar(8) not null,
semana_aula int not null,
data_aula date,
primary key (codigo_disciplina, semana_aula),
foreign key (codigo_disciplina) references Disciplina(codigo_disciplina)
)


select codigo_disciplina, semana_aula, CONVERT(varchar, data_aula, 103) as data_aula from Aula



select * from Nota

declare @saida varchar(max)
exec sp_CadastrarNota 1111111, '4203-010', 'P1', 10, @saida output
print @saida

drop procedure sp_CadastrarNota
go
create procedure sp_CadastrarNota(@ra_aluno int, @codigo_disciplina varchar(8), 
									@tipo_avaliacao varchar(50), @nota decimal(3,1),
										@saida varchar(max) OUTPUT)
as
	if (@nota >= 0 and @nota <= 10)
	begin
		declare @peso decimal(1,1)

		set @peso = (select peso from PesoAvaliacao 
						where codigo_disciplina = @codigo_disciplina 
						and tipo_avaliacao = @tipo_avaliacao)

		set @nota = @nota * @peso

		insert into Nota values
		(@ra_aluno, @codigo_disciplina, @tipo_avaliacao, @nota)
		set @saida = 'Nota registrada com sucesso'
	end
	else
	begin
		set @saida = 'Nota inválida'
		raiserror ('Nota inválida', 16,1)
	end





delete From Falta

select * from Aula
select * from Falta

declare @saida varchar(max)
exec sp_CadastrarFalta 1111111, '4203-010', '2019-06-22', 0, @saida output
print @saida

drop procedure sp_CadastrarFalta
go
create procedure sp_CadastrarFalta(@ra_aluno int, @codigo_disciplina varchar(8),
									@data_falta date, @presenca int,
										@saida varchar(max) OUTPUT)
as
	if (@presenca >= 0 and @presenca <= 4)
	begin
		declare @semana_aula int

		set @semana_aula = (select semana_aula from Aula where data_aula = @data_falta and codigo_disciplina = @codigo_disciplina)
		
		insert into Falta values
		(@ra_aluno, @codigo_disciplina, @semana_aula, @data_falta, @presenca)
--		set @saida = 'Chamada realizada com sucesso'
	end
	else
	begin
		set @saida = 'Valor inválido'
		raiserror ('Valor inválido', 16,1)
	end






select convert (varchar(10), DATEADD(WEEK,2,GETDATE()), 103) as WeekAdd

select * from Aula
delete from Aula

declare @saida varchar(max)
exec sp_InicioAula '4203-020', '15/06/2019', @saida output
print @saida

drop procedure sp_InicioAula
go
create procedure sp_InicioAula(@codigo_disciplina varchar(8), @data_aula varchar(10),
									@saida varchar(max) OUTPUT)
as
	declare @semanas int

	set @semanas = 0

	while (@semanas < 20)
	begin
		insert into Aula values
		(@codigo_disciplina, @semanas + 1, (select convert (varchar(10), DATEADD(WEEK, @semanas, @data_aula), 103) as WeekAdd))

		set @semanas = @semanas + 1
	end

	set @saida = 'Calendário de aulas realizado'
	




select * from Avaliacao
select * from PesoAvaliacao order by codigo_disciplina, tipo_avaliacao asc

declare @saida varchar(max)
exec sp_PesoAvaliacao '4203-010', 'P3', 0.3, @saida output
print @saida

drop procedure sp_PesoAvaliacao
go
create procedure sp_PesoAvaliacao(@codigo_disciplina varchar(8), @tipo_avaliacao varchar(50), @peso decimal(1,1),
										@saida varchar(max) OUTPUT)
as
	if not exists (select peso from PesoAvaliacao where codigo_disciplina = @codigo_disciplina and tipo_avaliacao = @tipo_avaliacao)
	begin
		insert into PesoAvaliacao values
		(@codigo_disciplina, @tipo_avaliacao, @peso)
	end
	else
	begin
		update PesoAvaliacao
		set peso = @peso
		where codigo_disciplina = @codigo_disciplina and tipo_avaliacao = @tipo_avaliacao
	end






select d.nome_disciplina, f.ra_aluno, f.nome_aluno, f.media, f.situacao_final
from Disciplina d
cross join f_MostrarNota('4203-010') f
where d.codigo_disciplina = f.codigo_disciplina

drop function f_MostrarNota
go
create function f_MostrarNota(@codigo_disciplina varchar(8))
returns @tabela Table
(
codigo_disciplina varchar(8),
ra_aluno int,
nome_aluno varchar(300),
media decimal (3,1),
situacao_final varchar(20)
)
as
begin
declare @ra_aluno int,
		@nome_aluno varchar(300),
		@media decimal (3,1),
		@situacao_final varchar(20)

	declare buscarAluno_cursor cursor for
	select distinct ra_aluno from AlunoDisciplina where codigo_disciplina = @codigo_disciplina

	open buscarAluno_cursor
	fetch next from buscarAluno_cursor
	into @ra_aluno

	while @@FETCH_STATUS = 0
	begin
		set @nome_aluno = (select nome_aluno from Aluno where ra_aluno = @ra_aluno)
		set @media = (select sum(nota) from Nota where ra_aluno = @ra_aluno and codigo_disciplina = @codigo_disciplina)
		
		if (@media >= 6)
		begin
			set @situacao_final = 'Aprovado por nota'
		end
		else
		begin
			set @situacao_final = 'Reprovado por nota'
		end

		insert into @tabela values
		(@codigo_disciplina, @ra_aluno, @nome_aluno, @media, @situacao_final)

		fetch next from buscarAluno_cursor
		into @ra_aluno
	end

	close buscarAluno_cursor
	deallocate buscarAluno_cursor

	return
end






select d.nome_disciplina, f.ra_aluno, f.nome_aluno, f.data_aula, f.falta, f.total_falta
from Disciplina d
cross join f_MostrarFalta('4203-010') f
where d.codigo_disciplina = f.codigo_disciplina

drop function f_MostrarFalta
go
create function f_MostrarFalta(@codigo_disciplina varchar(8))
returns @tabela Table
(
codigo_disciplina varchar(8),
ra_aluno int,
nome_aluno varchar(300),
data_aula date,
falta varchar(4),
total_falta int
)
as
begin
declare @ra_aluno int,
		@nome_aluno varchar(300),
		@semana int,
		@data_aula date,
		@falta varchar(4),
		@total_falta int

	set @total_falta = 0

	declare buscarFalta_cursor cursor for
	select distinct ra_aluno, semana_aula from Falta where codigo_disciplina = @codigo_disciplina

	open buscarFalta_cursor
	fetch next from buscarFalta_cursor
	into @ra_aluno, @semana

	while @@FETCH_STATUS = 0
	begin
		set @nome_aluno = (select nome_aluno from Aluno where ra_aluno = @ra_aluno)
		set @data_aula = (select data_falta from Falta where semana_aula = @semana and codigo_disciplina = @codigo_disciplina)
		set @falta = (select presenca from Falta where semana_aula = @semana and codigo_disciplina = @codigo_disciplina)
		set @total_falta = @falta + @total_falta

		if (@falta = 0)
		begin
			set @falta = 'PPPP'
		end
		else if (@falta = 1)
		begin
			set @falta = 'PPPF'
		end
		else if (@falta = 2)
		begin
			set @falta = 'PPFF'
		end
		else if (@falta = 3)
		begin
			set @falta = 'PFFF'
		end
		else
		begin
			set @falta = 'FFFF'
		end

		insert into @tabela values
		(@codigo_disciplina, @ra_aluno, @nome_aluno, @data_aula, @falta, @total_falta)

		fetch next from buscarFalta_cursor
		into @ra_aluno, @semana
	end

	close buscarFalta_cursor
	deallocate buscarFalta_cursor

	return
end











insert into Aluno values
(1111111,'Darth Vader'),
(2222222,'Gandalf the Grey'),
(3333333,'Bilbo Boseiro')


insert into Disciplina values
('4203-010','Arquitetura e Organização de Computadores','AOC',	'Tarde',4),
('4203-020','Arquitetura e Organização de Computadores','AOC',	'Noite',4),
('4208-010','Laboratório de Hardware',					'LABH',	'Tarde',2),
('4226-004','Banco de Dados',							'BD',	'Tarde',4),
('4213-003','Sistemas Operacionais I',					'SO1',	'Tarde',4),
('4213-013','Sistemas Operacionais I',					'SO1',	'Noite',4),
('4233-005','Laboratório de Banco de Dados',			'LABBD','Noite',4),
('5005-220','Métodos Para a Produção do Conhecimento',	'MPC',	'Manhã',4)



insert into AlunoDisciplina values
('4203-010', 1111111),
('4203-010', 2222222),
('4203-010', 3333333)


insert into Avaliacao values
('P1'),
('P2'),
('P3'),
('P4'),
('T'),
('Monografia Completa'),
('Monografia Resumida')


insert into PesoAvaliacao values
--Arquitetura e Organização de Computadores			Tarde
('4203-010',	'P1'	,	0.3),
('4203-010',	'P2'	,	0.5),
('4203-010',	'T'		,	0.2),

--Arquitetura e Organização de Computadores			Noite
('4203-020',	'P1'	,	0.3),
('4203-020',	'P2'	,	0.5),
('4203-020',	'T'		,	0.2),

--Banco de Dados									Tarde
('4226-004',	'P1'	,	0.3),
('4226-004',	'P2'	,	0.5),
('4226-004',	'T'		,	0.2),

--Sistemas Operacionais I							Tarde
('4213-003',	'P1'	,	0.35),
('4213-003',	'P2'	,	0.35),
('4213-003',	'T'		,	0.3),

--Sistemas Operacionais I							Noite
('4213-013',	'P1'	,	0.35),
('4213-013',	'P2'	,	0.35),
('4213-013',	'T'		,	0.3),

--Laboratório de Banco de Dados						Noite
('4233-005',	'P1'	,	0.333),
('4233-005',	'P2'	,	0.333),
('4233-005',	'P3'	,	0.333),

--Métodos Para a Produção do Conhecimento			Manhã
('5005-220',	'Monografia Completa',  0.8),
('5005-220',	'Monografia Resumida',  0.2)




--	BACKUP CODE AND OLDER VERSIONS
/**
select convert (varchar(10), DATEADD(WEEK,20,'01/06/2019'), 103) as WeekAdd		--working


select getdate(),
DATEADD(WEEK,20,GETDATE())as WeekAdd

select convert (varchar(10), getdate(), 103),
DATEADD(WEEK,20,GETDATE())as WeekAdd




select d.codigo_disciplina, d.nome_disciplina as disc, p.tipo_avaliacao
from Disciplina d
inner join PesoAvaliacao p
on d.codigo_disciplina = p.codigo_disciplina
group by d.codigo_disciplina, d.nome_disciplina, p.tipo_avaliacao
order by codigo_disciplina, tipo_avaliacao asc




set @presenca = (select presenca from Falta where ra_aluno = @ra_aluno and codigo_disciplina = @codigo_disciplina and semana_aula = @semana)
**/