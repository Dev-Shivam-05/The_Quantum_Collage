DECLARE
  num_1 int := 20;
  n int := 2;
BEGIN 
  dbms_output.put_line('The Inputed Number Is :- ' || num_1);
  dbms_output.put_line('The Subtracting Number Is :- ' || n );
  WHILE num_1 != 0 Loop
    num_1 := num_1 - n;
    dbms_output.put_line(num_1);
  exit when num_1 = 0;
  END Loop;
END;
/