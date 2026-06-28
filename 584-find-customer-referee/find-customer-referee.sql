# Write your MySQL query statement below
select c.name from
Customer c left join Customer r
on c.referee_id=r.id
where r.id !=2 or r.id is null;
