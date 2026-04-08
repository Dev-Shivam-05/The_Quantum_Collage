DECLARE
  num_1 int := 31;
  result char;
BEGIN

  dbms_output.put_line('The Inputed Number Is :- ' || num_1);
  
  for i in 1..num_1 loop
    if mod(num_1,2)=0 then
      result := 'N';
    else 
      result := 'Y';
    END if;
  END loop;
  
  if (result = 'Y') then
   dbms_output.put_line('The Inputed Number ' || num_1 || ' Is A Prime Number');
  else
   dbms_output.put_line('The Inputed Number ' || num_1 || ' Is Not A Prime Number');
  END if;
END;
/