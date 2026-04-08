DECLARE
  num_1 int := 4321;
  last_digit int;
  reminder int := 0;
BEGIN 
  dbms_output.put_line('The Inputed Number Is :- ' || num_1);
  dbms_output.put_line('The Reversed Number Is :- ' );
  WHILE num_1 != 0 Loop
    last_digit := mod(num_1,10);
    reminder := last_digit + (reminder * 10);
    num_1 := num_1 / 10;
    dbms_output.put_line(last_digit);
  END Loop;
END;
/