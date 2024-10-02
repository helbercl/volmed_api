alter table public.tb_medico add column telefone varchar(20) ;
update public.tb_medico SET telefone = '0000000000' WHERE telefone IS NULL;