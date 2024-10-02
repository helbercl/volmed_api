ALTER TABLE public.tb_medico ADD COLUMN status boolean NULL;
update public.tb_medico SET status = TRUE WHERE status IS NULL;
ALTER TABLE public.tb_medico ALTER COLUMN status SET NOT NULL;
