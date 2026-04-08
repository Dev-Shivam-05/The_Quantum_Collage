DECLARE
  salary int := 50000;
  insurance_cut int := 5000;
BEGIN

  dbms_output.put_line('The Inputed salary Is :- ' || salary);
  
  for i in 1..12 loop
    salary := salary - insurance_cut;
    if (salary < 20000) then
      exit;
    END if;
    dbms_output.put_line('The Salary In ' || i || ' Month Will  :- ' || salary);
  END loop;
END;
/