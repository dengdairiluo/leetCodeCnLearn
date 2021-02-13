update salary
set sex = (
    case sex when 'm' then 'f' else 'm' end
    );

update salary set sex = if(sex='m','f','m');

update salary set sex = char(ascii('m') + ascii('f') - ascii(sex));