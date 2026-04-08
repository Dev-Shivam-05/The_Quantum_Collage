DECLARE
  num_1 int := 2;
  
BEGIN

  -- dbms_output.put_line('The Inputed Number Is :- ' || num_1);
  
  for i in 1..10 loop
    case mod(i,2)
      when 0 Then dbms_output.put_line('The Inputed Number Is :- ' || i || ' Is Even.');
      when 1 Then dbms_output.put_line('The Inputed Number Is :- ' || i || ' Is Odd.');
    END case;
  END loop;
  
END;
/