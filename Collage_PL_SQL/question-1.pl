DECLARE
  num_1 int := 5;
  sum int := 0;
BEGIN 
  for i in 1..num_1 LOOP
    sum := sum + i;
  END LOOP;
  dbms_output.put_line( 'The Sum Of 1 To ' || num_1 || ' Number Is :- ' || sum);
END;
/