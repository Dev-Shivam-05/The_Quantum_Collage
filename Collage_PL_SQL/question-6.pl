DECLARE
  num_1 int := 12345;
  result int;
  i Int := 0;
BEGIN 
  dbms_output.put_line('The Inputed Number Is :- ' || num_1);
  
  WHILE num_1 != 0 Loop
    num_1 := num_1 / 10;
    i := i + 1;
  END Loop;
  dbms_output.put_line( 'The Length Of Inputed Number Is :- ' || i);
END;
/