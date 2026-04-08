DECLARE
  num_1 int := 2;
  result int;
BEGIN 
  for i in 1..5 Loop
    for j in 1..10 Loop
      result := i * j;
      dbms_output.put_line(i || ' X '|| j || ' = ' || result);
    END Loop;
    dbms_output.put_line('-----------');
  END Loop;
END;
/