DECLARE
  num_1 int := 2;
  result int;
BEGIN 
  -- dbms_output.put_line('The Inputed Number Is :- ' || num_1);
  
  for i in 1..15 Loop
    if mod(i,3)=0 then
      continue;
    else
      dbms_output.put_line(i);
    END if;
  END Loop;
END;
/