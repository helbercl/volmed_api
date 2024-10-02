ALTER TABLE public.tb_paciente ADD COLUMN status boolean NULL;
update public.tb_paciente SET status = TRUE WHERE status IS NULL;
ALTER TABLE public.tb_paciente ALTER COLUMN status SET NOT NULL;
