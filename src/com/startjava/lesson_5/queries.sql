-- вывести всю таблицу в отсортированном по именам порядке.
select *
  from jaegers
 order by model_name;

-- вывести только не уничтоженных роботов
select *
  from jaegers
 where status != 'Destroyed'
 order by model_name;

-- вывести только роботов серии Mark-1 и Mark-4
select *
  from jaegers
 where mark in ('Mark-1', 'Mark-4')
 order by model_name;

-- вывести всех роботов кроме Mark-1 и Mark-4 отсортировав таблицу по убыванию по столбцу mark
select *
  from jaegers
 where mark not in ('Mark-1', 'Mark-4')
 order by mark desc;

-- вывести информацию о самых старых работах
select *
  from jaegers
 where launch = (select min(launch)
                   from jaegers);

-- вывести информацию из столбцов model_name, mark, launch, kaiju_kill тех роботов, которые уничтожили больше всех kaiju
select model_name, mark, launch, kaiju_kill
  from jaegers
 where kaiju_kill = (select max(kaiju_kill)
                       from jaegers)
 order by model_name;

-- вывести средний вес роботов округлённый до трёх знаков после запятой
select round(avg(weight), 3) as avg_weight
  from jaegers;

-- увеличить на единицу kaiju_kill у неразрушенных роботов
update jaegers
   set kaiju_kill = kaiju_kill + 1
 where status != 'Destroyed';

-- удалить уничтоженных роботов, а затем отобразить оставшихся
delete from jaegers
 where status = 'Destroyed';

select *
  from jaegers
 order by model_name;